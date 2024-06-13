<%-- 
    Document   : inicio
    Created on : 21-ene-2024, 16:34:20
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
                        <h3>Actividad de tu red</h3>
                        <c:forEach items="${actividadesSeguidores}" var="actividadesSeguidores" varStatus="loop">
                            <div class="mt-3 containerPrincipal">
                                <div class="row d-flex align-items-center mb-2">
                                    <div>
                                        <!-- Enlace que dirige directamente a la página del usuario -->
                                        <a href="Usuario?idUsuario=${actividadesSeguidores.usuario.idUsuario}&url=Inicio" class="text-decoration-none">
                                            <!-- Párrafo con el nombre del usuario -->
                                            <p class="p-sm fw-bold no-margin-botton cursor-pointer">
                                                ${actividadesSeguidores.usuario.nombre} ${actividadesSeguidores.usuario.apellidos}
                                            </p>
                                        </a>
                                    </div>
                                    <div>
                                        <p class="p-xsm no-margin-botton"><fmt:formatDate value="${actividadesSeguidores.fechaHoraInicio}" pattern="dd/MM/yyyy HH:mm"/></p>
                                    </div>
                                </div>
                                <div>
                                    <p class="filtro-actividad">${actividadesSeguidores.tipoDeporte}</p>
                                </div>
                                <div>
                                    <p class="p-sm fw-bold">${actividadesSeguidores.tipoActividad}</p>
                                </div>
                                <div class="containerActividad-principal">
                                    <div>
                                        <a href="Actividad?accion=verDetalle&idActividad=${actividadesSeguidores.actividadPK.idActividad}&url=Inicio" class="text-decoration-none"><h5>${actividadesSeguidores.titulo}</h5></a>
                                    </div>
                                    <div>
                                        <p class="p-m">${actividadesSeguidores.descripcion}</p>
                                    </div>
                                    <div class="row w-100">
                                        <div class="col-4 containerActividad-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Distancia</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${actividadesSeguidores.distancia}km</h4>
                                            </div>
                                        </div>
                                        <div class="col-4 containerActividad-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Duración</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${actividadesSeguidores.duracion}s</h4>
                                            </div>
                                        </div>
                                        <div class="col-4 containerActividad-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Desnivel</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${actividadesSeguidores.desnivel}m</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="mt-3">
                                    <c:choose>
                                        <c:when test="${countReaccionList[loop.index] eq true}">
                                            <form id="formMeGusta" action="Inicio" method="POST" class="d-inline-block align-middle">
                                                <input type="hidden" name="accion" value="meGusta">
                                                <input type="hidden" name="idActividad" value="${actividadesSeguidores.actividadPK.idActividad}">
                                                <button class="botonReaccion" type="submit">
                                                    <i class="fa-solid fa-heart me-2" style="color: #ff0000;"> ${countReaccionesList[loop.index]}</i>
                                                </button>
                                            </form>
                                        </c:when>
                                        <c:otherwise>
                                            <form id="formMeGusta" action="Inicio" method="POST" class="d-inline-block align-middle">
                                                <input type="hidden" name="accion" value="meGusta">
                                                <input type="hidden" name="idActividad" value="${actividadesSeguidores.actividadPK.idActividad}">
                                                <button class="botonReaccion" type="submit">
                                                    <i class="fa-regular fa-heart me-2"> ${countReaccionesList[loop.index]}</i>
                                                </button>
                                            </form>
                                        </c:otherwise>
                                    </c:choose>
                                    <!-- Boton de comentarios -->
                                    <button type="submit" class="botonReaccion" data-bs-toggle="modal" data-bs-target="#mostrarCometariosModal_${actividadesSeguidores.actividadPK.idActividad}">
                                        <i class="fa-regular fa-comments align-middle"> ${countComentariosList[loop.index]}</i> 
                                    </button>
                                    <!-- Modal -->
                                    <div class="modal fade" id="mostrarCometariosModal_${actividadesSeguidores.actividadPK.idActividad}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h3 class="modal-title" id="exampleModalLabel">Comentarios</h3>
                                                    <br>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <!-- Iterar sobre la lista de comentarios de esta actividad -->
                                                    <c:forEach items="${comentariosActividadList[loop.index]}" var="comentario" varStatus="commentLoop">
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
                                        <input type="hidden" name="idActividad" value="${actividadesSeguidores.actividadPK.idActividad}">
                                        <input type="hidden" name="accion" value="Comentario">
                                        <input type="hidden" name="pagina" value="Inicio">
                                        <input type="text" id="comentario" name="comentario" placeholder="Escribe tu comentario"
                                               class="form-control mb-3">
                                        <button class="btn btn-sm-primary " type="submit">Enviar comentario</button>
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </main>
            </div>
        </div>


        <footer>

        </footer>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
        <!-- Script para enviar el formulario cuando se hace clic en el párrafo -->
        <script>
            function submitForm() {
                document.getElementById("verPerfilForm").submit();
            }
        </script>
    </body>
</html>
