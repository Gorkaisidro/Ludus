/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.dominio.Actividad;
import com.gorka.service.iActividadService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gorka
 */
public class EliminarActividadServlet extends HttpServlet {

    @Inject
    iActividadService actividadService;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        System.out.println(idActividad);
        
        Actividad actividad = actividadService.encontrarActividadPorIdActividad(idActividad);
        
        actividadService.borrarActividad(actividad);
        
        System.out.println("Redirigiendo a miActividad.jsp");
        
        response.sendRedirect("Actividad");
        
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
