/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.service.iUsuarioService;
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
@WebServlet(name = "IniciarSesionServlet", urlPatterns = {"/IniciarSesion"})
public class IniciarSesionServlet extends HttpServlet {
    
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
        
        // Llama al servicio para insertar el nuevo cliente en la base de datos
        String email = request.getParameter("email");
        String clave = request.getParameter("password");

        // Llama al servicio para verificar las credenciales del cliente recién registrado
        Usuario usuarioLogueado = usuarioService.verificarUsuario(email, clave);
        

        if (usuarioLogueado != null) {
            
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioLogueado);
            
            System.out.println("Redirigiendo a inicio.jsp"); // Agrega este mensaje para verificar si llega a este punto
            
            response.sendRedirect(request.getContextPath() + "/Inicio");

        } else {
            // Las credenciales son incorrectas, muestra un mensaje de error o realiza alguna acción adicional
            request.setAttribute("error", "Email o contraseña incorrectos");
            request.getRequestDispatcher("iniciarSesion.jsp").forward(request, response);
        }
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
