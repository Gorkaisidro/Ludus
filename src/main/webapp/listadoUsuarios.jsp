<%-- 
    Document   : listadoUsuarios
    Created on : 17-ene-2024, 11:37:22
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado usuarios</title>
    </head>
    <body>
        <h1>Listado usuarios</h1>
        <table>
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Ubicación</th>
                    <th>Fecha Nacimeinto</th>
                    <th>Género</th>
                    <th>Peso</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td>${usuario.nombre}</td>
                        <td>${usuario.apellidos}</td>
                        <td>${usuario.ubicacion}</td>
                        <td>${usuario.fechaNacimiento}</td>
                        <td>${usuario.genero}</td>
                        <td>${usuario.peso}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
