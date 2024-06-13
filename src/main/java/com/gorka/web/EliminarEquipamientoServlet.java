/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.service.iEquipamientoService;
import com.gorka.dominio.Equipamiento;
import java.io.IOException;
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
@WebServlet(name = "EliminarEquipamientoServlet", urlPatterns = {"/EliminarEquipamiento"})
public class EliminarEquipamientoServlet extends HttpServlet {
    
    @Inject
    iEquipamientoService equipamientoService;

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
        int idEquipamiento = Integer.parseInt(request.getParameter("idEquipamiento"));
        
        Equipamiento equipamiento = equipamientoService.encontrarEquipamientosPorId(idEquipamiento);

        equipamientoService.borrarEquipamiento(equipamiento);
        
        System.out.println("Redirigiendo a equipamiento.jsp"); // Agrega este mensaje para verificar si llega a este punto

        response.sendRedirect("Equipamiento");
        
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
