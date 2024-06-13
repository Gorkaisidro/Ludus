<%-- 
    Document   : listadoActividades
    Created on : 18-ene-2024, 18:06:57
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista actividades</title>
    </head>
    <body>
        <h1>Lista actividades por ID</h1>
        <table>
            <thead>
                <tr>
                    <th>Deporte</th>
                    <th>Tipo</th>
                    <th>Ubicación</th>
                    <th>Fecha</th>
                    <th>Título</th>
                    <th>Duración</th>
                    <th>Distancia</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${actividades}" var="actividad">
                    <tr>
                        <td>${actividad.tipoDeporte}</td>
                        <td>${actividad.tipoActividad}</td>
                        <td>${actividad.ubicacion}</td>
                        <td>${actividad.fechaHoraInicio}</td>
                        <td>${actividad.titulo}</td>
                        <td>${actividad.duracion}</td>
                        <td>${actividad.distancia}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>

