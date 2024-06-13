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

    <body>
        <header>
            <a class="logo"><img src="img/logo-ludus.png" alt="Logo de tu sitio web"></a>
        </header>
        <main class="d-flex justify-content-center">
            <section class="tarjeta-inicio">
                <div class="d-flex justify-content-start p-2">
                    <a class="btn p-lg fw-bold" href="index.jsp">Volver</a>
                </div>
                <div class="tarjeta-inicio-formulario mt-4">
                    <h2 class="text-center w-100 mb-5">Iniciar Sesión</h2>
                    <form class="w-100" name="iniciarSesion" action="IniciarSesion" method="POST">
                        <div class="input">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="email" placeholder="Introduce tu dirección de email" required>
                        </div>
                        <div class="input">
                            <label for="password">Contraseña</label>
                            <input type="password" id="password" name="password" placeholder="Escribe tu contraseña" required>
                        </div>
                        <input type="submit" value="Iniciar sesión" class="btn btn-m-primary w-100 mt-5">
                        <c:choose>
                            <c:when test="${not empty requestScope.error}">
                                <p class="mt-3" style="color: red">${requestScope.error}</p>
                            </c:when>
                        </c:choose>
                    </form>
                    <div class="w-100">
                        <p class="p-sm-c mt-4 text-center">¿Ya tienes cuenta? <a class="text-decoration-none" href="registrarUsuario.jsp">Registrate</a></p>
                    </div>

                </div>
            </section>
        </main>
        <footer>

        </footer>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>
</html>
