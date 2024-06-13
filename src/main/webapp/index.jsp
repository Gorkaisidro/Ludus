<%-- 
    Document   : iniciarSesion
    Created on : 21-ene-2024, 18:28:45
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="componentes/head.jsp"/>
    <header>
        <a class="logo"><img src="img/logo-ludus.png" alt="logoLudus"></a>
    </header>
    <main>
        <div class="container px-5 pb-5">
            <div class="text-center text-xxl-center mt-5">
                <h1 class="display-3 fw-bolder mb-5"><span class="text-gradient d-inline">Bienvenido a tu
                        comunidad de registro de actividad física </span></h1>
                <div class="fs-6 mb-5">Registra tus actividades físicas (carreras, bici o natación), compártelas
                    con tu red y haz seguimiento de tus métricas.</div>
                <div class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xxl-center tmb-3">
                    <a class="btn btn-lg-primary" href="iniciarSesion.jsp" role="button">Iniciar sesión</a>
                    <a class="btn btn-lg-secondary" href="registrarUsuario.jsp" role="button">Registrarse</a>
                </div>
            </div>
        </div>
    </main>
    <footer>

    </footer>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
