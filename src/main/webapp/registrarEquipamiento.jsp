<%-- 
    Document   : registrarEquipamiento
    Created on : 21-ene-2024, 18:36:30
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar equipamiento</title>
    </head>
    <body>
        <h1>Registrar equipamiento</h1>
        <form name="registrarEquipamiento" action="RegistrarEquipamiento" method="post">
            <label>Tipo de equipamiento:</label>
            <select for="tipoEquipamiento" id="tipoEquipamiento" name="tipoEquipamiento" required>
                <option value="" disabled selected>Seleccionar</option>
                <option value="Reloj">Reloj</option>
                <option value="Zapatilla">Zapatilla</option>
                <option value="Bicicleta">Bicicleta</option>
            </select><br>
            
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" required><br>
            
            <label for="marca">Marca:</label>
            <input type="text" id="marca" name="marca" required><br>
            
            <label for="modelo">Modelo:</label>
            <input type="text" id="modelo" name="modelo" required><br>
            
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
