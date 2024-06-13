/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.dominio.Actividad;
import com.gorka.dominio.Usuario;
import com.gorka.service.iActividadService;
import com.gorka.service.iSeguidorService;
import com.gorka.service.iUsuarioService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gorka
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {

    @Inject
    iActividadService actividadService;
    @Inject
    iUsuarioService usuarioService;
    @Inject
    iSeguidorService seguidorService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener el idUsuario de la URL
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        Usuario usuario = usuarioService.encontrarUsuarioPorId(idUsuario);

        // Obtener la url de la pagina
        String url = request.getParameter("url");

        System.out.println("id usuarios: " + usuario);
        request.setAttribute("usuario", usuario);

        int numActividad = actividadService.contarActividadesPorIdUSuario(idUsuario);
        request.setAttribute("numActividad", numActividad);

        // Obtener los parámetros de la solicitud
        String accion = request.getParameter("accion");

        // Obtener todas las actividades por defecto
        List<Actividad> actividades = actividadService.encontrarActividadesPorUsuario(idUsuario);

        // Verificar la acción solicitada
        if ("verDetalle".equals(accion)) {
            String idActividadStr = request.getParameter("idActividad");
            System.out.println(idActividadStr);
            // Mostrar la actividad detallada
            int idActividad = Integer.parseInt(idActividadStr);
            Actividad actividadDetalle = actividadService.encontrarActividadPorIdActividad(idActividad); // Método ficticio para obtener la actividad por ID
            request.setAttribute("actividadDetalle", actividadDetalle);
            System.out.println(actividadDetalle);

            // Mostrar la vista detallada
            request.getRequestDispatcher("actividad.jsp").forward(request, response);
            return; // Importante para evitar que se ejecute el resto del código después de mostrar la vista detallada
        }

        // Enviar las actividades filtradas a la vista
        request.setAttribute("actividades", actividades);

        request.setAttribute("url", url);
        System.out.println("Este es el url: " + url);

        request.getRequestDispatcher("usuario.jsp").forward(request, response);

        processRequest(request, response);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
