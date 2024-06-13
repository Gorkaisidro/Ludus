<%-- 
    Document   : usuario
    Created on : 06-feb-2024, 19:34:00
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
                        <div class="mt-3 containerPrincipal-usuario">
                            <div class="row d-flex w-100">
                                <h3 class="text-center m-auto">${usuario.nombre} ${usuario.apellidos}</h3>
                                <p class="p-lg text-center m-auto mt-1">
                                    ${numActividad} 
                                    ${numActividad == 1 ? 'actividad' : 'actividades'}
                                </p>
                                <p class="p-m text-center m-auto">${usuario.ubicacion}</p>
                                <div class="mt-5">
                                    <a class="p-m fw-bold text-decoration-none marcador-miperfil me-4" href="#">Actividades</a>
                                    <a class="p-m fw-bold text-decoration-none me-4" href="#">Seguidores</a>
                                    <a class="p-m fw-bold text-decoration-none me-4" href="#">Siguiendo</a>
                                </div>
                            </div>
                        </div>
                        <c:forEach items="${actividades}" var="actividad">
                            <div class="mt-3 containerPrincipal">
                                <div class="row d-flex align-items-center mb-2">
                                    <div>
                                        <p class="p-sm fw-bold no-margin-botton">${actividad.usuario.nombre} ${actividad.usuario.apellidos}</p>
                                    </div>
                                    <div>
                                        <p class="p-xsm no-margin-botton"><fmt:formatDate value="${actividad.fechaHoraInicio}" pattern="dd/MM/yyyy HH:mm"/></p>
                                    </div>
                                </div>
                                <div>
                                    <p class="filtro-actividad">${actividad.tipoDeporte}</p>
                                </div>
                                <div>
                                    <p class="p-sm fw-bold">${actividad.tipoActividad}</p>
                                </div>
                                <div class="containerActividad-principal">
                                    <div>
                                        <h5><a href="Actividad?accion=verDetalle&idActividad=${actividad.actividadPK.idActividad}&url=Usuario?idUsuario=${actividad.usuario.idUsuario}" class="text-decoration-none p-xlg fw-bold">${actividad.titulo}</a></h5>
                                    </div>
                                    <div>
                                        <p class="p-m">${actividad.descripcion}</p>
                                    </div>
                                    <div class="row w-100">
                                        <div class="col-4 containerActividad-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Distancia</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${actividad.distancia}km</h4>
                                            </div>
                                        </div>
                                        <div class="col-4 containerActividad-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Duración</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${actividad.duracion}s</h4>
                                            </div>
                                        </div>
                                        <div class="col-4 containerActividad-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Desnivel</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${actividad.desnivel}m</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div>

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
    </body>
</html>
