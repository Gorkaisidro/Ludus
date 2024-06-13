<%-- 
    Document   : equipamiento
    Created on : 21-ene-2024, 17:39:29
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                            <a class="p-m fw-bold text-decoration-none me-4" href="miPerfil.jsp">Mis datos
                                personales</a>
                            <a class="p-m fw-bold text-decoration-none marcador-miperfil" href="Equipamiento">Equipamiento</a>
                        </div>                        
                        <div class="mt-3 containerPrincipal">
                            <c:forEach items="${equipamientos}" var="equipamiento">
                                <div class="containerEquipamiento mb-3">
                                    <p class="p-lg fw-bold mb-3">${equipamiento.tipoEquipamiento}</p>
                                    <div class="input w-50">
                                        <label for="nombre">Nombre</label>
                                        <label class="label1">
                                            <p class="p-m">${equipamiento.nombre}</p>
                                        </label>
                                    </div>
                                    <div class="row w-100 mb-3">
                                        <div class="input w-50">
                                            <label for="marca">Marca</label>
                                            <label class="label1">
                                                <p class="p-m">${equipamiento.marca}</p>
                                            </label>
                                        </div>
                                        <div class="input w-50">
                                            <label for="modelo">Modelo</label>
                                            <label class="label1">
                                                <p class="p-m">${equipamiento.modelo}</p>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="d-flex justify-content-end w-100">
                                        <!-- Modal para editar equipamiento -->
                                        <button type="button" class="btn btn-sm-primary w-25 me-2" data-bs-toggle="modal"
                                                data-bs-target="#editarEquipamientoModal">
                                            Editar
                                        </button>

                                        <!-- Modal -->
                                        <div class="modal fade" id="editarEquipamientoModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                             aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h3 class="modal-title" id="exampleModalLabel">Editar equipamiento</h3><br>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                                aria-label="Close"></button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form class="w-100" name="editarEquipamiento" action="EditarEquipamiento" method="POST">
                                                            <input type="hidden" name="tipoEquipamiento" value="${equipamiento.tipoEquipamiento}" />
                                                            <div class="input">
                                                                <label for="nombre">Nombre</label>
                                                                <input type="text" id="nombre" name="nombre" value="${equipamiento.nombre}" required>
                                                            </div>
                                                            <div class="input">
                                                                <label for="marca">Marca</label>
                                                                <input type="text" id="marca" name="marca" value="${equipamiento.marca}" required>
                                                            </div>
                                                            <div class="input">
                                                                <label for="modelo">Modelo</label>
                                                                <input type="text" id="modelo" name="modelo" value="${equipamiento.modelo}" required>
                                                            </div>
                                                            <input type="hidden" name="idEquipamiento" value="${equipamiento.equipamientoPK.idEquipamiento}" />
                                                            <input type="submit" value="Editar" class="btn btn-m-primary w-100 mt-5">
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Modal para eliminar equipamiento -->
                                        <button type="button" class="btn btn-sm-primary w-25 me-2" data-bs-toggle="modal"
                                                data-bs-target="#eliminarEquipamientoModal">
                                            Eliminar
                                        </button>

                                        <!-- Modal -->
                                        <div class="modal fade" id="eliminarEquipamientoModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                             aria-hidden="true">
                                            <div class="modal-dialog">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h3 class="modal-title" id="exampleModalLabel">Eliminar equipamiento</h3><br>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                                aria-label="Close"></button>
                                                    </div>
                                                    <div class=" mt-3 d-flex justify-content-center align-items-center">
                                                        <label class="p-lg">¿Estas seguro que quieres eliminar el equipamiento?</label>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form class="w-100" name="eliminarEquipamiento" action="EliminarEquipamiento" method="POST">
                                                            <input type="hidden" name="idEquipamiento"
                                                                   value="${equipamiento.equipamientoPK.idEquipamiento}" />
                                                            <input type="submit" value="Eliminar" class="btn btn-m-primary w-100 mt-2">
                                                        </form>
                                                        <a class="btn btn-m-secondary w-100 mt-2" data-bs-dismiss="modal"
                                                                aria-label="Close" href="Equipamiento" role="button">Cancelar</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </c:forEach>
                            <div class="d-flex justify-content-end w-100 mt-3">
                                <!-- Modal para añadir equipamiento -->
                                <button type="button" class="btn btn-m-secondary w-25" data-bs-toggle="modal"
                                        data-bs-target="#añadirEquipamientoModal">
                                    Añadir
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="añadirEquipamientoModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h3 class="modal-title" id="exampleModalLabel">Añadir equipamiento</h3><br>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                        aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form class="w-100" name="registrarEquipamiento" action="RegistrarEquipamiento" method="POST">
                                                    <div class="input">
                                                        <label for="genero">Tipo de equipamiento</label>
                                                        <select class="w-50" id="tipoEquipamiento" name="tipoEquipamiento" required>
                                                            <option value="" disabled selected>Seleccionar</option>
                                                            <option value="Reloj">Reloj</option>
                                                            <option value="Zapatilla">Zapatilla</option>
                                                            <option value="Bicicleta">Bicicleta</option>
                                                        </select>
                                                    </div>
                                                    <div class="input">
                                                        <label for="nombre">Nombre</label>
                                                        <input type="text" id="nombre" name="nombre" placeholder="Escribe el nombre del equipamiento" required>
                                                    </div>
                                                    <div class="input">
                                                        <label for="marca">Marca</label>
                                                        <input type="text" id="marca" name="marca" placeholder="Introduce la marca" required>
                                                    </div>
                                                    <div class="input">
                                                        <label for="modelo">Modelo</label>
                                                        <input type="text" id="modelo" name="modelo" placeholder="Introduce el modelo" required>
                                                    </div>
                                                    <input type="submit" value="Guardar" class="btn btn-m-primary w-100 mt-5">
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
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
