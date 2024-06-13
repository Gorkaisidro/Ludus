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
@WebServlet(name = "EquipamientoServlet", urlPatterns = {"/Equipamiento"})
public class EquipamientoServlet extends HttpServlet {

    @Inject
    iEquipamientoService equipamientoService;

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
        if (usuario != null) {
            int idUsuario = usuario.getIdUsuario();
            
            System.out.println(idUsuario);

            List<Equipamiento> equipamientos = equipamientoService.encontrarEquipamientosPorUsuario(idUsuario);

            request.setAttribute("equipamientos", equipamientos);
            
            System.out.println("Usuario en la sesión: " + usuario.getNombre());

            request.getRequestDispatcher("equipamiento.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Usuario no encontrado");
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }

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
