/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.service.iActividadService;
import com.gorka.service.iSeguidorService;
import com.gorka.dominio.Actividad;
import com.gorka.dominio.Comentario;
import com.gorka.dominio.Reaccion;
import com.gorka.dominio.Usuario;
import com.gorka.service.iComentarioService;
import com.gorka.service.iReaccionService;
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
@WebServlet(name = "InicioServlet", urlPatterns = {"/Inicio"})
public class InicioServlet extends HttpServlet {

    @Inject
    iActividadService actividadService;

    @Inject
    iSeguidorService seguidorService;

    @Inject
    iReaccionService reaccionService;

    @Inject
    iComentarioService comentarioService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        // Obtener los parámetros de la solicitud
        String accion = request.getParameter("accion");
        String idActividadStr = request.getParameter("idActividad");
        System.out.println(idActividadStr);

        // Busqueda de todas las actividades de mis seguidores
        List<Actividad> actividadesSeguidores = actividadService.encontrarActividadesPorSeguidores(idUsuario);
        System.out.println("actividades por ID: " + actividadesSeguidores);

        // Crear listas para almacenar las cantidades de reacciones y comentarios
        List<Integer> countReaccionesList = new ArrayList<>();
        List<Integer> countComentariosList = new ArrayList<>();
        List<Boolean> countReaccionList = new ArrayList<>();
        List<List<Comentario>> comentariosActividadList = new ArrayList<>();

        // Obtener las reacciones y comentarios para cada actividad
        for (Actividad actividad : actividadesSeguidores) {
            int idActividad = actividad.actividadPK.getIdActividad();

            // Contar reacciones
            int countReacciones = reaccionService.contarReaccionesPorIdActividad(idActividad);

            // Contar comentarios
            int countComentarios = comentarioService.contarComentariosPorIdActividad(idActividad);

            // verificador de reacciones
            boolean countReaccion = reaccionService.verificarReaccion(idUsuario, idActividad);
            System.out.println("Inicio servlet: " + countReaccion);

            List<Comentario> comentariosActividad = comentarioService.encontrarComentarioPorActividad(idActividad);

            // Agregar las cantidades a las listas paralelas
            countReaccionesList.add(countReacciones);
            countComentariosList.add(countComentarios);
            countReaccionList.add(countReaccion);
            comentariosActividadList.add(comentariosActividad);

        }

        // Pasar las listas paralelas al JSP
        request.setAttribute("countReaccionList", countReaccionList);
        request.setAttribute("countReaccionesList", countReaccionesList);
        request.setAttribute("countComentariosList", countComentariosList);

        request.setAttribute("actividadesSeguidores", actividadesSeguidores);
        request.setAttribute("comentariosActividadList", comentariosActividadList);

        // Contador de actividades
        int numeroActividades = actividadService.contarActividadesPorIdUSuario(idUsuario);
        session.setAttribute("numeroActividades", numeroActividades);

        // Contador de usuarios que sigo
        int numeroSiguiendo = seguidorService.contarSiguiendoPorIdUSuario(idUsuario);
        session.setAttribute("numeroSiguiendo", numeroSiguiendo);

        // Contador de seguidores
        int numeroSeguidores = seguidorService.contarSeguidoresPorIdUSuario(idUsuario);
        session.setAttribute("numeroSeguidores", numeroSeguidores);

        // Verificar la acción solicitada
        if ("verDetalle".equals(accion) && idActividadStr != null) {
            // Mostrar la actividad detallada
            int idActividad = Integer.parseInt(idActividadStr);
            Actividad actividadDetalle = actividadService.encontrarActividadPorIdActividad(idActividad); // Método ficticio para obtener la actividad por ID
            request.setAttribute("actividadDetalle", actividadDetalle);
            System.out.println(actividadDetalle);

            // Mostrar la vista detallada
            request.getRequestDispatcher("actividad.jsp").forward(request, response);
            return; // Importante para evitar que se ejecute el resto del código después de mostrar la vista detallada
        }

        request.getRequestDispatcher("/inicio.jsp").forward(request, response);

        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el Id del usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        int idActividad = Integer.parseInt(request.getParameter("idActividad"));

        String accion = request.getParameter("accion");
        Date fechaActual = new Date();
        String pagina = request.getParameter("pagina");

        if ("meGusta".equals(accion)) {
            boolean verificarReaccion = reaccionService.verificarReaccion(idUsuario, idActividad);
            System.out.println("¿Tiene Reaccion? " + verificarReaccion);

            if (verificarReaccion) {
                Reaccion borrarReaccion = reaccionService.encontrarReaccionPorIdUsuarioYIdActividad(idUsuario, idActividad);
                reaccionService.borrarReaccion(borrarReaccion);
                System.out.println("Reaccion eliminada: " + borrarReaccion);
            } else {

                Reaccion nuevaReaccion = new Reaccion(idUsuario, idActividad, fechaActual);

                reaccionService.registrarReaccion(nuevaReaccion);
                System.out.println("Reaccion creada: " + nuevaReaccion);
            }
            // Redirigir de nuevo a la página de inicio después de procesar el "Me gusta"
            response.sendRedirect(request.getContextPath() + "/Inicio");
        } else if ("Comentario".equals(accion)) {
            String comentario = request.getParameter("comentario");

            Comentario comentarioNuevo = new Comentario(idUsuario, idActividad, comentario, fechaActual);
            comentarioService.registrarComentario(comentarioNuevo);
               if ("Inicio".equals(pagina)) {
                   response.sendRedirect(request.getContextPath() + "/Inicio");
               } else {
                   response.sendRedirect(request.getContextPath() + "/Actividad?accion=verDetalle&idActividad=" + idActividad + "&url=Inicio");
               }       
        } else {

            // Redirigir de nuevo a la página de inicio después de procesar el "Me gusta"
            response.sendRedirect(request.getContextPath() + "/Inicio?idActividad=" + idActividad);
        }
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
