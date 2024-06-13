<%-- 
    Document   : registrarUsuario
    Created on : 21-ene-2024, 15:45:50
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <jsp:include page="componentes/head.jsp"/>
    
    <header>
        <a class="logo"><img src="img/logo-ludus.png" alt="Logo de tu sitio web"></a>
    </header>
    <main class="d-flex justify-content-center">
        <section class="tarjeta-inicio">
            <div class="d-flex justify-content-start p-2">
                <a class="btn p-lg fw-bold" href="index.jsp">Volver</a>
            </div>
            <div class="tarjeta-inicio-formulario mt-4">
                <h2 class="text-center w-100">Registrarse</h2>
                <p class="p-lg text-md-center mb-5">El registro es gratuito, rellena los campos para poder empezar a
                    registrar tus actividades y ver las de tus amigos</p>
                <form class="w-100" name="registrarUsuario" action="RegistrarUsuario" method="POST">
                    <div class="input">
                        <label for="nombre">Nombre</label>
                        <input type="text" id="nombre" name="nombre" placeholder="Escribe tu nombre" required>
                    </div>
                    <div class="input">
                        <label for="apellidos">Apellidos</label>
                        <input type="text" id="apellidos" name="apellidos" placeholder="Escribe tus apellidos" required>
                    </div>
                    <div class="input">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" placeholder="Introduce tu dirección de email" required>
                    </div>
                    <div class="input">
                        <label for="password">Contraseña</label>
                        <input type="password" id="password" name="password" placeholder="Escribe tu contraseña" required>
                    </div>
                    <div class="registro-perfil">
                        <p class="fw-bold p-lg">Perfil</p>
                        <p class="p-lg">Pera ofrecerte una experiencia personalizada necesitamos que rellenes los
                            siguientes
                            datos personales:</p>
                    </div>
                    <div class="input">
                        <label for="ubicacion">Ciudad</label>
                        <input type="text" id="ubicacion" name="ubicacion" placeholder="Escribe tu ubicación habitual" required>
                    </div>
                    <div class="input">
                        <label for="fechaNacimiento">Fecha de nacimiento</label>
                        <input class="w-50" type="date" id="fechaNacimiento" name="fechaNacimiento" required>
                    </div>
                    <div class="input">
                        <label for="genero">Género</label>
                        <select class="w-50" id="genero" name="genero" required>
                            <option value="" disabled selected>Seleccionar</option>
                            <option value="Hombre">Hombre</option>
                            <option value="Mujer">Mujer</option>
                            <option value="Otro">Otro</option>
                        </select>
                    </div>
                    <div class="input">
                        <label for="peso">Peso</label>
                        <input class="w-50" type="text" id="peso" name="peso" placeholder="ej. 71,5" required>
                    </div>

                    <input type="submit" value="Continuar" class="btn btn-m-primary w-100 mt-5">
                </form>
                <div class="w-100">
                    <p class="p-sm-c mt-4 text-center">¿No tienes cuenta aún?<a class="text-decoration-none" href="iniciarSesion.jsp">Inicia
                            sesión</a></p>
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
