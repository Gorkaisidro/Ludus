<%-- 
    Document   : actividad
    Created on : 05-feb-2024, 20:38:04
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.StringTokenizer"%>
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
                        <a class="ms-3 p-lg fw-bold text-decoration-none" href="${url}">Volver</a>
                        <div class="mt-3 containerPrincipal">
                            <div class="mb-2">
                                <p class="p-xsm no-margin-botton d-inline me-1"><fmt:formatDate value="${actividadDetalle.fechaHoraInicio}" pattern="dd/MM/yyyy HH:mm"/> - </p>
                                <p class="p-xsm no-margin-botton d-inline">${actividadDetalle.ubicacion}</p>
                            </div>
                            <div>
                                <h4>${actividadDetalle.titulo}</h4>
                            </div>
                            <div>
                                <p class="p-lg">${actividadDetalle.descripcion}</p>
                            </div>
                            <div class="mb-2">
                                <p class="filtro-actividad d-inline me-1">${actividadDetalle.tipoDeporte}</p>
                                <p class="filtro-actividad d-inline">${actividadDetalle.tipoActividad}</p>
                            </div>
                            <div class="containerActividad-principal">
                                <div>
                                    <p class="p-m fw-bold">Datos</p>
                                </div>
                                <div class="row w-100 mb-3">
                                    <div class="col-6 containerActividad-secundario">
                                        <div>
                                            <p class="p-m-c no-margin-botton">Distancia</p>
                                        </div>
                                        <div>
                                            <h4 class="no-margin-botton">${actividadDetalle.distancia}km</h4>
                                        </div>
                                    </div>
                                    <div class="col-6 containerActividad-secundario">
                                        <div>
                                            <p class="p-m-c no-margin-botton">Duración</p>
                                        </div>
                                        <div>
                                            <h4 class="no-margin-botton">${actividadDetalle.duracion}s</h4>
                                        </div>
                                    </div>

                                </div>
                                <div class="row w-100">
                                    <div class="col-6 containerActividad-secundario">
                                        <div>
                                            <p class="p-m-c no-margin-botton">Desnivel</p>
                                        </div>
                                        <div>
                                            <h4 class="no-margin-botton">${actividadDetalle.desnivel}m</h4>
                                        </div>
                                    </div>
                                    <div class="col-6 containerActividad-secundario">
                                        <div>
                                            <p class="p-m-c no-margin-botton">Ritmo</p>
                                        </div>
                                        <div>
                                            <h4 class="no-margin-botton">${actividadDetalle.ritmo}s/km</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-3">
                                <c:choose>
                                    <c:when test="${reaccion eq true}">
                                        <form id="formMeGusta" action="Actividad" method="POST" class="d-inline-block align-middle">
                                            <input type="hidden" name="accion" value="meGusta">
                                            <input type="hidden" name="url" value="${url}">
                                            <input type="hidden" name="idActividad" value="${actividadDetalle.actividadPK.idActividad}">
                                            <button class="botonReaccion" type="submit">
                                                <i class="fa-solid fa-heart me-2" style="color: #ff0000;"> ${countReacciones}</i>
                                            </button>
                                        </form>
                                    </c:when>
                                    <c:otherwise>
                                        <form id="formMeGusta" action="Actividad" method="POST" class="d-inline-block align-middle">
                                            <input type="hidden" name="accion" value="meGusta">
                                            <input type="hidden" name="url" value="${url}">
                                            <input type="hidden" name="idActividad" value="${actividadDetalle.actividadPK.idActividad}">
                                            <button class="botonReaccion" type="submit">
                                                <i class="fa-regular fa-heart me-2"> ${countReacciones}</i>
                                            </button>
                                        </form>
                                    </c:otherwise>
                                </c:choose>
                                <!-- Boton de comentarios -->
                                <button type="submit" class="botonReaccion" data-bs-toggle="modal" data-bs-target="#mostrarCometariosModal_${actividadDetalle.actividadPK.idActividad}">
                                    <i class="fa-regular fa-comments align-middle"> ${countComentarios}</i> 
                                </button>
                                <!-- Modal -->
                                <div class="modal fade" id="mostrarCometariosModal_${actividadDetalle.actividadPK.idActividad}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h3 class="modal-title" id="exampleModalLabel">Comentarios</h3>
                                                <br>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <!-- Iterar sobre la lista de comentarios de esta actividad -->
                                                <c:forEach items="${comentariosActividad}" var="comentario" varStatus="commentLoop">
                                                    <p class="p-m fw-bold">${comentario.usuario.nombre} ${comentario.usuario.apellidos} - <fmt:formatDate value="${comentario.fechaCreacion}" pattern="dd/MM/yyyy HH:mm"/></p>
                                                    <p>${comentario.comentario}</p>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="inputComentario mt-1 d-flex">
                                <form id="formComentario" action="Inicio" method="POST" class="d-inline-block">
                                    <input type="hidden" name="idActividad" value="${actividadDetalle.actividadPK.idActividad}">
                                    <input type="hidden" name="accion" value="comentarioActividad">
                                    <input type="text" id="comentario" name="comentario" placeholder="Escribe tu comentario"
                                           class="form-control mb-3">
                                    <button class="btn btn-sm-primary " type="submit">Enviar comentario</button>
                                </form>
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
