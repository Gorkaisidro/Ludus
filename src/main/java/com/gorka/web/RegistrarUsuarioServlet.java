/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.service.iUsuarioService;
import com.gorka.dominio.Usuario;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
@WebServlet(name = "RegistrarUsuarioServlet", urlPatterns = {"/RegistrarUsuario"})
public class RegistrarUsuarioServlet extends HttpServlet {

    @Inject
    iUsuarioService usuarioService;

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
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            String clave = request.getParameter("password");
            String ubicacion = request.getParameter("ubicacion");
            String fechaNacimientoStr = request.getParameter("fechaNacimiento");
            String genero = request.getParameter("genero");
            String pesoStr = request.getParameter("peso");
            String foto = request.getParameter("foto");

            LocalDate fechaDeNacimiento = LocalDate.parse(fechaNacimientoStr); // Parsea la fecha de nacimiento de String a LocalDate
            Date fechaNacimiento = Date.from(fechaDeNacimiento.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            // Convertir peso a Double
            double peso = Double.parseDouble(pesoStr);
            
            // Verificar si el usuario ya existe por su email
            if (usuarioService.existeUsuarioPorEmail(email)) {
                // El email ya existe, enviar un mensaje de error
                response.getWriter().write("{\"error\": \"El correo electrónico ya está registrado. Por favor, elige otro.\"}");
                return; // Sale del método para evitar la redirección
            }

            Usuario nuevoUsuario = new Usuario(nombre, apellidos, email, clave, ubicacion, fechaNacimiento, genero, peso);

            System.out.println(nuevoUsuario);

            usuarioService.registrarUsuario(nuevoUsuario);
            
            HttpSession session = request.getSession();
            session.setAttribute("usuario", nuevoUsuario);

            response.sendRedirect(request.getContextPath() + "/Inicio");

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
