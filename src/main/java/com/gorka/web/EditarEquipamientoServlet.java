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
@WebServlet(name = "EditarEquipamientoServlet", urlPatterns = {"/EditarEquipamiento"})
public class EditarEquipamientoServlet extends HttpServlet {

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

        // Obtener el Id del usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        int idEquipamiento = Integer.parseInt(request.getParameter("idEquipamiento"));
        String tipoEquipamiento = request.getParameter("tipoEquipamiento");
        String nombre = request.getParameter("nombre");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");

        System.out.println("tipoEquipamiento: " + tipoEquipamiento);
        System.out.println("nombre: " + nombre);
        System.out.println("marca: " + marca);
        System.out.println("modelo: " + modelo);

        Equipamiento equipamientoActualizado = new Equipamiento(idEquipamiento, tipoEquipamiento, nombre, marca, modelo, idUsuario);

        equipamientoService.actualizarEquipamiento(equipamientoActualizado);

        System.out.println("Redirigiendo a equipamiento.jsp"); // Agrega este mensaje para verificar si llega a este punto

        response.sendRedirect("Equipamiento");

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
