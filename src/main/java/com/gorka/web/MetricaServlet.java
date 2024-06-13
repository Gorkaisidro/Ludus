/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.web;

import com.gorka.dominio.Usuario;
import com.gorka.service.iActividadService;
import java.io.IOException;
import java.util.Calendar;
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
@WebServlet(name = "MetricaServlet", urlPatterns = {"/Metrica"})
public class MetricaServlet extends HttpServlet {

    @Inject
    iActividadService actividadService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener el usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        // Obtener el año seleccionado del parámetro del formulario
        String anioString = request.getParameter("anio");
        int anio;
        if (anioString != null && !anioString.isEmpty()) {
            anio = Integer.parseInt(anioString);
        } else {
            // Proporciona un valor predeterminado si el parámetro "anio" no está presente
            anio = 2024; // Por ejemplo, usar el año actual o un valor por defecto
        }

        int primerAnio = actividadService.obtenerPrimerAnioRegistrado(idUsuario);
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);

        // Obtener las estadísticas según el año y el deporte
        Object[] estadisticasAnio = actividadService.resultadosMetricasPorAnio(idUsuario, anio);
        Object[] estadisticasCorrer = actividadService.resultadosMetricasPorAnioYDeporte(idUsuario, anio, "correr");
        Object[] estadisticasCiclismo = actividadService.resultadosMetricasPorAnioYDeporte(idUsuario, anio, "ciclismo");
        Object[] estadisticasNatacion = actividadService.resultadosMetricasPorAnioYDeporte(idUsuario, anio, "natacion");

        // Enviar las estadísticas a la vista
        request.setAttribute("estadisticasAnio", estadisticasAnio);
        request.setAttribute("estadisticasCorrer", estadisticasCorrer);
        request.setAttribute("estadisticasCiclismo", estadisticasCiclismo);
        request.setAttribute("estadisticasNatacion", estadisticasNatacion);

        // Enviar el año seleccionado a la vista
        request.setAttribute("anioSeleccionado", anio);

        // Enviar los años a la vista
        request.setAttribute("primerAnio", primerAnio);
        request.setAttribute("anioActual", anioActual);

        // Redirigir a la página JSP
        request.getRequestDispatcher("miMetrica.jsp").forward(request, response);

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
