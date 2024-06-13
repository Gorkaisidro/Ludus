<%-- 
    Document   : navBar
    Created on : 24-ene-2024, 10:55:34
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.StringTokenizer"%>
<!DOCTYPE html>
<div class="col-sm-12 col-lg-2 col-md-4 d-flex justify-content-center align-items-start seccion-navbar">
    <nav class="navbar navbar-expand-lg navbar-expand-md navbar-light">
        <div class="container-fluid flex-md-column flex-lg-column mt-2">
            <a class="navbar-brand logo mt-3"><img src="img/logo-ludus.png" alt="logoLudus" width="180"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse flex-column mt-2 w-100" id="navbarNav">
                <div class="d-flex flex-column align-items-center w-100">
                    <div class="mt-3">
                        <img src="img/avatar.png" alt="Logo de la aplicación" width="90">
                        <p class="p-m fw-bold mt-3">${sessionScope.usuario.nombre} ${sessionScope.usuario.apellidos}</p>
                    </div>
                    <div class="navbar-user-stats w-100 mt-3">
                        <div><a class="p-m text-decoration-none" href="Actividad">Act. completas</a><span class="numero">${sessionScope.numeroActividades}</span></div>
                        <div><a class="p-m text-decoration-none" href="Red?seccion=siguiendo">Siguiendo</a><span class="numero">${sessionScope.numeroSiguiendo}</span></div>
                        <div><a class="p-m text-decoration-none" href="Red?seccion=seguidores"">Seguidores</a><span class="numero">${sessionScope.numeroSeguidores}</span></div>
                    </div>
                </div>
                <ul class="navbar-nav flex-column text-start mt-4 w-100 menu-lista">
                    <li class="nav-item">
                        <a class="nav-link p-lg" aria-current="page" href="Inicio">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link p-lg" href="Perfil">Mi perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link p-lg" href="Actividad">Mis actividades</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link p-lg" href="Metrica">Mis métricas</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link p-lg" href="Red">Mi red</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
