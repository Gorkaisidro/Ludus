package com.gorka.web;

import com.gorka.service.iActividadService;
import com.gorka.dominio.Actividad;
import com.gorka.dominio.Comentario;
import com.gorka.dominio.Reaccion;
import com.gorka.dominio.Usuario;
import com.gorka.service.iComentarioService;
import com.gorka.service.iReaccionService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
@WebServlet(name = "ActividadServlet", urlPatterns = {"/Actividad"})
public class ActividadServlet extends HttpServlet {

    @Inject
    iActividadService actividadService;

    @Inject
    iReaccionService reaccionService;

    @Inject
    iComentarioService comentarioService;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        int idUsuario = usuario.getIdUsuario();

        // Obtener la url de la pagina
        String url = request.getParameter("url");

        // Obtener el parámetro de categoría
        String categoria = request.getParameter("categoria");
        String query = request.getParameter("busqueda");

        // Obtener los parámetros de la solicitud
        String accion = request.getParameter("accion");
        String idActividadStr = request.getParameter("idActividad");
        System.out.println(idActividadStr);

        // Obtener todas las actividades por defecto
        List<Actividad> actividades = actividadService.encontrarActividadesPorUsuario(idUsuario);

        // Realizar filtrado por categoría si se proporciona
        if (categoria != null) {
            actividades = actividades.stream()
                    .filter(a -> a.getTipoDeporte().equalsIgnoreCase(categoria))
                    .collect(Collectors.toList());
        }

        // Realizar filtrado adicional por búsqueda dentro de la categoría seleccionada
        if (query != null && !query.isEmpty()) {
            String lowerCaseQuery = query.toLowerCase();
            actividades = actividades.stream()
                    .filter(a -> a.getTitulo().toLowerCase().contains(lowerCaseQuery)
                    || String.valueOf(a.getDistancia()).toLowerCase().contains(lowerCaseQuery))
                    .collect(Collectors.toList());
        }

        // Verificar la acción solicitada
        if ("verDetalle".equals(accion) && idActividadStr != null) {
            // Mostrar la actividad detallada
            int idActividad = Integer.parseInt(idActividadStr);
            Actividad actividadDetalle = actividadService.encontrarActividadPorIdActividad(idActividad); // Método ficticio para obtener la actividad por ID
            request.setAttribute("actividadDetalle", actividadDetalle);
            System.out.println(actividadDetalle);

            // Contar reacciones
            int countReacciones = reaccionService.contarReaccionesPorIdActividad(idActividad);

            // Contar comentarios
            int countComentarios = comentarioService.contarComentariosPorIdActividad(idActividad);

            boolean reaccion = reaccionService.verificarReaccion(idUsuario, idActividad);
            request.setAttribute("reaccion", reaccion);

            List<Comentario> comentariosActividad = comentarioService.encontrarComentarioPorActividad(idActividad);

            // Agregar las cantidades a las listas paralelas
            request.setAttribute("countReacciones", countReacciones);
            request.setAttribute("countComentarios", countComentarios);
            request.setAttribute("comentariosActividad", comentariosActividad);

            System.out.println("Este es el url: " + url);

            System.out.println("Estamos en el Get");
            String urlNuevo = "Usuario?idUsuario=" + actividadDetalle.getActividadPK().getUsuarioidUsuario();
            System.out.println("Este es el nuevo url: " + urlNuevo);
            System.out.println(actividadDetalle.getActividadPK().getUsuarioidUsuario());

            String urlDireccion = "Usuario?idUsuario=" + actividadDetalle.getActividadPK().getUsuarioidUsuario() + "&url=Inicio";

            if (urlNuevo.equals(url)) {
                System.out.println("Dentro del If");
                System.out.println(urlDireccion);
                System.out.println(actividadDetalle.getActividadPK().getUsuarioidUsuario());
                request.setAttribute("url", urlDireccion);
            } else {
                request.setAttribute("url", url);
            }
            // Mostrar la vista detallada
            request.getRequestDispatcher("actividad.jsp").forward(request, response);
            return; // Importante para evitar que se ejecute el resto del código después de mostrar la vista detallada
        }

        // Enviar las actividades filtradas a la vista
        request.setAttribute("actividades", actividades);

        // Envía el atributo de la categoría seleccionada a la vista para resaltarla
        request.setAttribute("categoriaSeleccionada", categoria);

        request.getRequestDispatcher("miActividad.jsp").forward(request, response);
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el Id del usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();

        int idActividad = Integer.parseInt(request.getParameter("idActividad"));

        // Obtener la url de la pagina
        String url = request.getParameter("url");

        boolean verificarReaccion = reaccionService.verificarReaccion(idUsuario, idActividad);
        System.out.println("¿Tiene Reaccion? " + verificarReaccion);

        String accion = request.getParameter("accion");
        Date fechaActual = new Date();

        if (verificarReaccion) {
            Reaccion borrarReaccion = reaccionService.encontrarReaccionPorIdUsuarioYIdActividad(idUsuario, idActividad);
            reaccionService.borrarReaccion(borrarReaccion);
            System.out.println("Reaccion eliminada: " + borrarReaccion);
        } else {
            Reaccion nuevaReaccion = new Reaccion(idUsuario, idActividad, fechaActual);

            reaccionService.registrarReaccion(nuevaReaccion);
            System.out.println("Reaccion creada: " + nuevaReaccion);
        }

        if ("comentarioActividad".equals(accion)) {
            String comentario = request.getParameter("comentario");

            Comentario comentarioNuevo = new Comentario(idUsuario, idActividad, comentario, fechaActual);
            comentarioService.registrarComentario(comentarioNuevo);

            // Redirigir de nuevo a la página de detalle de la actividad
            response.sendRedirect(request.getContextPath() + "/Actividad?accion=verDetalle&idActividad=" + idActividad + "&url=" + url);
            return; // Importante para evitar que se ejecute el resto del código después de la redirección
        }

        System.out.println("Estamos en el post");
        String urlNuevo = "Usuario?idUsuario" + idUsuario;
        System.out.println("Este es el nuevo url: " + urlNuevo);

        if (urlNuevo.equals(url)) {
            // Redirigir de nuevo a la página de inicio después de procesar el "Me gusta"
            response.sendRedirect(request.getContextPath() + "/Actividad?accion=verDetalle&idActividad=" + idActividad + "&url=Inicio");
        } else {
            // Redirigir de nuevo a la página correspondiente
            response.sendRedirect(request.getContextPath() + "/Actividad?accion=verDetalle&idActividad=" + idActividad + "&url=" + url);
        }

        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public String duracionFormateada(long duracionEnSegundos) {
        long horas = duracionEnSegundos / 3600;
        long minutos = (duracionEnSegundos % 3600) / 60;
        long segundos = duracionEnSegundos % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

}
