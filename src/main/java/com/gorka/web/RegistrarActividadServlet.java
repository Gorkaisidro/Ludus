/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.service.iActividadService;
import com.gorka.dominio.Actividad;
import com.gorka.dominio.Usuario;
import java.io.IOException;
import java.util.Date;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gorka
 */
public class RegistrarActividadServlet extends HttpServlet {

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

        // Obtener el Id del usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        String tipoDeporte = request.getParameter("tipoDeporte");
        String tipoActividad = request.getParameter("tipoActividad");
        String ubicacion = request.getParameter("ubicacion");

        // Datos de la fecha de actividad
        int dia = Integer.parseInt(request.getParameter("dia"));
        int mes = Integer.parseInt(request.getParameter("mes"));
        int anio = Integer.parseInt(request.getParameter("anio"));
        int hora = Integer.parseInt(request.getParameter("hora"));
        int minuto = Integer.parseInt(request.getParameter("minuto"));

        // Funcion para crear la fecha para la base de datos
        Date fechaHoraInicio = actividadService.obtenerFechaHoraInicio(anio, mes, dia, hora, minuto);

        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String distanciaStr = request.getParameter("distancia");
        double distancia = Double.parseDouble(distanciaStr);

        // Datos de la duracion de la actividad
        int horaDuracion = Integer.parseInt(request.getParameter("horaDuracion"));
        int minutoDuracion = Integer.parseInt(request.getParameter("minutoDuracion"));
        int segundoDuracion = Integer.parseInt(request.getParameter("minutoDuracion"));

        // Función para pasarlo a segundos
        int duracion = actividadService.obtenerDuracionSegundos(horaDuracion, minutoDuracion, segundoDuracion);

        String desnivelStr = request.getParameter("desnivel");
        int desnivel;
        if (desnivelStr != null && !desnivelStr.isEmpty()) {
            desnivel = Integer.parseInt(desnivelStr);
        } else {
            desnivel = 0;
        }

        // Función para sacar el ritmo de carrera
        int ritmo = actividadService.obtenerRitmo(distancia, duracion);

        Actividad nuevaActividad = new Actividad(tipoDeporte, titulo, descripcion, ubicacion, distancia, duracion, desnivel, fechaHoraInicio, tipoActividad, ritmo, idUsuario);

        actividadService.registrarActividad(nuevaActividad);

        System.out.println("Redirigiendo a inicio.jsp"); // Agrega este mensaje para verificar si llega a este punto

        response.sendRedirect("Inicio");

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
