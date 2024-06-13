<%-- 
    Document   : miPerfil
    Created on : 24-ene-2024, 11:39:04
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <jsp:include page="componentes/head.jsp"/>

    <body class="containerGeneral">
        <div class="row">
            <jsp:include page="componentes/navBar.jsp"/>
            <div class="col-sm-12 col-lg-10 col-md-8">
                <main>
                    <jsp:include page="componentes/topBar.jsp"/>
                    <div class="d-flex flex-column align-items-start containerCuerpo mt-4">
                        <h3>Mi perfil</h3>
                        <div class="mt-5">
                            <a class="p-m fw-bold text-decoration-none marcador-miperfil me-4" href="miPerfil.jsp">Mis datos
                                personales</a>
                            <a class="p-m fw-bold text-decoration-none" href="Equipamiento">Equipamiento</a>
                        </div>
                        <div class="mt-3 containerPrincipal">
                            <div class="input">
                                <label for="nombre">Nombre</label>
                                <label class="label1">
                                    <p class="p-m">${usuario.nombre}</p>
                                </label>
                            </div>
                            <div class="input">
                                <label for="apellido">Apellidos</label>
                                <label class="label1">
                                    <p class="p-m">${usuario.apellidos}</p>
                                </label>
                            </div>
                            <div class="input">
                                <label for="email">Email</label>
                                <label class="label1">
                                    <p class="p-m">${usuario.email}</p>
                                </label>
                            </div>
                            <div class="input">
                                <label for="ubicacion">Ciudad</label>
                                <label class="label1">
                                    <p class="p-m">${usuario.ubicacion}</p>
                                </label>
                            </div>
                            <div class="input w-50">
                                <label for="fechaNacimiento">Fecha de nacimiento</label>
                                <label class="label1">
                                    <p class="p-m"><fmt:formatDate value="${usuario.fechaNacimiento}" pattern="dd/MM/yyyy"/></p>
                                </label>
                            </div>
                            <div class="input w-50">
                                <label for="genero">Género</label>
                                <label class="label1">
                                    <p class="p-m">${usuario.genero}</p>
                                </label>
                            </div>
                            <div class="input w-50">
                                <label for="peso">Peso</label>
                                <label class="label1">
                                    <p class="p-m">${usuario.peso}</p>
                                </label>
                            </div>
                            <div class="d-flex justify-content-end w-100 mt-5">
                                <!-- Modal para editar equipamiento -->
                                <button type="button" class="btn btn-m-primary w-25 me-2" data-bs-toggle="modal"
                                        data-bs-target="#editarUsuarioModal">
                                    Editar
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="editarUsuarioModal" tabindex="-1"
                                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h3 class="modal-title" id="exampleModalLabel">Editar usuario</h3>
                                                <br>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form class="w-100" name="editarUsuario" action="EditarUsuario"
                                                      method="POST">
                                                    <div class="input">
                                                        <label for="nombre">Nombre</label>
                                                        <input type="text" id="nombre" name="nombre"
                                                               value="${usuario.nombre}">
                                                    </div>
                                                    <div class="input">
                                                        <label for="apellidos">Apellidos</label>
                                                        <input type="text" id="apellidos" name="apellidos"
                                                               value="${usuario.apellidos}">
                                                    </div>
                                                    <div class="input">
                                                        <label for="email">Email:</label>
                                                        <input type="email" id="email" name="email"
                                                               value="${usuario.email}">
                                                    </div>
                                                    <div class="input">
                                                        <label for="password">Contraseña</label>
                                                        <input type="text" id="password" name="password"
                                                               value="${usuario.clave}">
                                                    </div>
                                                    <div class="input">
                                                        <label for="ubicacion">Ciudad</label>
                                                        <input type="text" id="ubicacion" name="ubicacion"
                                                               value="${usuario.ubicacion}">
                                                    </div>
                                                    <div class="input">
                                                        <label for="fechaNacimiento">Fecha de nacimiento</label>
                                                        <input class="w-50" type="date" id="fechaNacimiento"
                                                               name="fechaNacimiento" required>
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
                                                        <input class="w-50" type="number" id="peso" name="peso"
                                                               value="${usuario.peso}">
                                                    </div>
                                                    <input type="submit" value="Editar" class="btn btn-m-primary w-100 mt-5">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <input type="submit" value="Eliminar" class="btn btn-m-primary w-25">
                            </div>
                        </div>
                    </div>     
                </main>
            </div>
        </div>


        <footer>

        </footer>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    </body>
</html>
