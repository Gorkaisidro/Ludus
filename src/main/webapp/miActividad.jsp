<%-- 
    Document   : miActividad
    Created on : 29-ene-2024, 20:08:53
    Author     : Gorka
--%>


<%@ page import="com.gorka.dominio.Actividad" %>
<%@ page import="com.gorka.web.ActividadServlet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="actividadServlet" class="com.gorka.web.ActividadServlet" scope="application" />

<!DOCTYPE html>
<html>
    <jsp:include page="componentes/head.jsp"/>

    <body class="containerGeneral">
        <div class="row">
            <jsp:include page="componentes/navBar.jsp"/>
            <div class="col-sm-12 col-lg-10 col-md-8">
                <main>
                    <jsp:include page="componentes/topBar.jsp"/>
                    <div class="d-flex flex-column align-items-start containerActividadesTabla mt-4">
                        <h3>Mis actividades</h3>
                        <div class="mt-5">
                            <a class="p-m fw-bold text-decoration-none me-4 ${empty categoriaSeleccionada || categoriaSeleccionada eq 'actividades' ? ' active marcador-miperfil' : ''}" href="Actividad">Actividades</a>
                            <a class="p-m fw-bold text-decoration-none me-4 ${categoriaSeleccionada eq 'Correr' ? ' active marcador-miperfil' : ''}" href="Actividad?categoria=Correr">Correr</a>
                            <a class="p-m fw-bold text-decoration-none me-4 ${categoriaSeleccionada eq 'Ciclismo' ? ' active marcador-miperfil' : ''}" href="Actividad?categoria=Ciclismo">Ciclismo</a>
                            <a class="p-m fw-bold text-decoration-none me-4 ${categoriaSeleccionada eq 'Natacion' ? ' active marcador-miperfil' : ''}" href="Actividad?categoria=Natacion">Natación</a>
                            <form class="d-flex mt-3" role="search" action="Actividad" method="GET">
                                <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search" name="busqueda">
                                <button class="btn btn-sm-primary " type="submit">Buscar</button>
                            </form>
                        </div>
                        <div class="mt-3 containerPrincipal">
                            <table class="table">
                                <thead class="fondoCabeceraTabla">
                                    <tr>
                                        <th scope="col">Deporte</th>
                                        <th scope="col">Tipo</th>
                                        <th scope="col">Ubicación</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Titulo</th>
                                        <th scope="col">Duración</th>
                                        <th scope="col">Distancia</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>

                                <c:forEach items="${actividades}" var="actividad" varStatus="loop">
                                    <tr>
                                        <td scope="row">${actividad.tipoDeporte}</td>
                                        <td>${actividad.tipoActividad}</td>
                                        <td>${actividad.ubicacion}</td>
                                        <td><fmt:formatDate value="${actividad.fechaHoraInicio}" pattern="dd/MM/yyyy"/></td>
                                        <td><a href="Actividad?accion=verDetalle&idActividad=${actividad.actividadPK.idActividad}&url=Actividad?categoria=${categoriaSeleccionada}" class="text-decoration-none p-m fw-bold">${actividad.titulo}</a></td>
                                        <td>${actividad.duracion}s</td>
                                        <td>${actividad.distancia}km</td>
                                        <td><!-- Modal para eliminar equipamiento -->
                                            <button type="button" class="btn-actividad-eliminar w-100" data-bs-toggle="modal"
                                                    data-bs-target="#eliminarActividadModal${loop.index}" onclick="setActividadId('${actividad.actividadPK.idActividad}')"">
                                                Eliminar
                                            </button>

                                            <!-- Modal -->
                                            <div class="modal fade" id="eliminarActividadModal${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel"
                                                 aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h3 class="modal-title" id="exampleModalLabel">Eliminar actividad</h3><br>
                                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                                    aria-label="Close"></button>
                                                        </div>
                                                        <div class=" mt-3 d-flex justify-content-center align-items-center">
                                                            <label class="p-lg">¿Estas seguro que quieres eliminar la actividad?</label>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form class="w-100" name="eliminarActividad" action="EliminarActividad" method="POST">
                                                                <input type="hidden" id="idActividad${loop.index}" name="idActividad"
                                                                       value="${actividad.actividadPK.idActividad}" />
                                                                <input type="submit" value="Eliminar" class="btn btn-m-primary w-100 mt-2">
                                                            </form>
                                                            <a class="btn btn-m-secondary w-100 mt-2" data-bs-dismiss="modal"
                                                               aria-label="Close" href="Actividad" role="button">Cancelar</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>
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
