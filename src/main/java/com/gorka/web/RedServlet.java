/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.service.iSeguidorService;
import com.gorka.service.iUsuarioService;
import com.gorka.dominio.Seguidor;
import com.gorka.dominio.Usuario;
import com.gorka.service.iActividadService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gorka
 */
@WebServlet(name = "RedServlet", urlPatterns = {"/Red"})
public class RedServlet extends HttpServlet {

    @Inject
    iSeguidorService seguidorService;
    @Inject
    iUsuarioService usuarioService;
    @Inject
    iActividadService actividadService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el Id del usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        // Obtener la sección seleccionada
        String seccionSeleccionada = request.getParameter("seccion");

        // Contador de actividades
        int numeroActividades = actividadService.contarActividadesPorIdUSuario(idUsuario);
        session.setAttribute("numeroActividades", numeroActividades);

        // Contador de usuarios que sigo
        int numeroSiguiendo = seguidorService.contarSiguiendoPorIdUSuario(idUsuario);
        session.setAttribute("numeroSiguiendo", numeroSiguiendo);

        // Contador de seguidores
        int numeroSeguidores = seguidorService.contarSeguidoresPorIdUSuario(idUsuario);
        session.setAttribute("numeroSeguidores", numeroSeguidores);

        if (seccionSeleccionada == null) {
            seccionSeleccionada = "explorar"; // Sección predeterminada
        }

        switch (seccionSeleccionada) {
            case "explorar":
                List<Usuario> usuariosNoSigo = usuarioService.encontrarUsuarioNoSigo(usuario);
                request.setAttribute("usuarios", usuariosNoSigo);
                System.out.println(usuariosNoSigo);
                break;
            case "siguiendo":
                List<Usuario> usuariosSiguiendo = usuarioService.encontrarUsuarioSiguiendo(usuario);
                request.setAttribute("usuarios", usuariosSiguiendo);
                System.out.println(usuariosSiguiendo);
                break;
            case "seguidores":
                // Recuperar la lista de seguidores
                List<Usuario> seguidores = usuarioService.encontrarUsuarioSiguiendome(usuario);

                // Crear una lista adicional para almacenar información sobre si el usuario logueado sigue a cada seguidor
                List<Boolean> sigueLista = new ArrayList<>();

                // Iterar sobre los seguidores para determinar si el usuario logueado sigue a cada uno
                for (Usuario seguidor : seguidores) {
                    sigueLista.add(usuarioService.sigoAlUsuario(idUsuario, seguidor.getIdUsuario()));
                }
                System.out.println(sigueLista);

                // Pasar ambas listas al JSP
                request.setAttribute("usuarios", seguidores);
                request.setAttribute("sigueLista", sigueLista);
                break;
            default:
                // Manejar el caso predeterminado o mostrar un mensaje de error
                break;
        }

        request.setAttribute("seccionSeleccionada", seccionSeleccionada);

        request.getRequestDispatcher("miRed.jsp").forward(request, response);

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener el Id del usuario de la sesión
            HttpSession session = request.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            int idUsuario = usuario.getIdUsuario();

            String seccion = request.getParameter("seccion");

            if ("explorar".equals(seccion)) {
                // Botón "Seguir" en la sección de explorar
                int idUsuarioNoSigo = Integer.parseInt(request.getParameter("idUsuarioNoSigo"));
                Date fechaSeguimiento = new Date();
                Seguidor nuevoSeguidor = new Seguidor(idUsuario, idUsuarioNoSigo, fechaSeguimiento);
                seguidorService.registrarSeguidor(nuevoSeguidor);
                System.out.println("Seguimiento creado: " + nuevoSeguidor);

            } else if ("siguiendo".equals(seccion)) {
                // Botón "Dejar de seguir" en la sección de siguiendo
                int idUsuarioSiguiendo = Integer.parseInt(request.getParameter("idUsuarioSiguiendo"));
                Seguidor borrarSeguidor = seguidorService.encontrarSeguidorPorIdUsuarioYidSiguiendo(idUsuario, idUsuarioSiguiendo);
                seguidorService.borrarSeguidor(borrarSeguidor);
                System.out.println("Seguimiento eliminado: " + borrarSeguidor);

            } else if ("seguidores".equals(seccion)) {
                // Lógica para gestionar seguidores
                int idUsuarioSeguidor = Integer.parseInt(request.getParameter("idUsuarioSeguidor"));

                // Verificar si el usuario actual sigue al usuario representado por idUsuarioSeguidor
                boolean sigueAlUsuario = usuarioService.sigoAlUsuario(idUsuario, idUsuarioSeguidor);
                System.out.println("¿Sigue al usuario? " + sigueAlUsuario);

                if (sigueAlUsuario) {
                    // Si ya sigue al usuario, dejar de seguir
                    Seguidor borrarSeguidor = seguidorService.encontrarSeguidorPorIdUsuarioYidSiguiendo(idUsuario, idUsuarioSeguidor);
                    seguidorService.borrarSeguidor(borrarSeguidor);
                    System.out.println("Seguimiento eliminado: " + borrarSeguidor);
                } else {
                    // Si no sigue al usuario, seguir
                    Date fechaSeguimiento = new Date();
                    Seguidor nuevoSeguidor = new Seguidor(idUsuario, idUsuarioSeguidor, fechaSeguimiento);
                    seguidorService.registrarSeguidor(nuevoSeguidor);
                    System.out.println("Seguimiento creado: " + nuevoSeguidor);
                }
            }
            response.sendRedirect("Red?seccion=" + seccion);

        } catch (Exception e) {
            e.printStackTrace();

            response.getWriter().write("{\"error\": \"Ha ocurrido un error durante el registro.\"}");
        }

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
