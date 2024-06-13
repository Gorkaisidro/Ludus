/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.service.iEquipamientoService;
import com.gorka.dominio.Equipamiento;
import com.gorka.dominio.Usuario;
import java.io.IOException;
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
@WebServlet(name = "RegistrarEquipamientoServlet", urlPatterns = {"/RegistrarEquipamiento"})
public class RegistrarEquipamientoServlet extends HttpServlet {

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
        try {

            // Obtener el Id del usuario de la sesión
            HttpSession session = request.getSession();
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            int idUsuario = usuario.getIdUsuario();

            String tipoEquipamiento = request.getParameter("tipoEquipamiento");
            String nombre = request.getParameter("nombre");
            String marca = request.getParameter("marca");
            String modelo = request.getParameter("modelo");

            Equipamiento nuevoEquipamiento = new Equipamiento(tipoEquipamiento, nombre, marca, modelo, idUsuario);

            equipamientoService.registrarEquipamiento(nuevoEquipamiento);
            
            System.out.println("Redirigiendo a equipamiento.jsp"); // Agrega este mensaje para verificar si llega a este punto

            response.sendRedirect("Equipamiento");

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
