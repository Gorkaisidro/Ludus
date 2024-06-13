<%-- 
    Document   : miRed
    Created on : 24-ene-2024, 20:41:28
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sessionScope" uri="http://java.sun.com/jsp/jstl/core"%>

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
                        <h3>Mi red</h3>
                        <div class="mt-5">
                            <a class="p-m fw-bold text-decoration-none me-4 ${seccionSeleccionada eq 'explorar' ? ' active marcador-miperfil' : ''}" href="Red?seccion=explorar">Explorar</a>
                            <a class="p-m fw-bold text-decoration-none me-4 ${seccionSeleccionada eq 'siguiendo' ? ' active marcador-miperfil' : ''}" href="Red?seccion=siguiendo">Siguiendo</a>
                            <a class="p-m fw-bold text-decoration-none ${seccionSeleccionada eq 'seguidores' ? ' active marcador-miperfil' : ''}" href="Red?seccion=seguidores">Seguidores</a>
                        </div>                        
                        <div class="mt-3 containerPrincipal">
                            <c:forEach items="${usuarios}" var="usuario" varStatus="loop">
                                <div class="mt-3 containerPrincipal">
                                    <div class="row w-100 d-flex justify-content-center align-items-center">
                                        <div class="col-7">
                                            <label class="p-lg fw-bold" for="nombre">${usuario.nombre} ${usuario.apellidos}</label>
                                        </div>
                                        <div class="col-3">
                                            <c:choose>
                                                <c:when test="${seccionSeleccionada eq 'explorar'}">
                                                    <!-- Mostrar botón Seguir en la sección Explorar -->
                                                    <form class="w-100" name="seguirUsuario" action="Red" method="POST">
                                                        <input type="hidden" name="seccion" value="explorar">
                                                        <input type="hidden" name="idUsuarioNoSigo" value="${usuario.idUsuario}" />
                                                        <input type="submit" value="Seguir" class="btn btn-sm-secondary w-100">
                                                    </form>
                                                </c:when>
                                                <c:when test="${seccionSeleccionada eq 'siguiendo'}">
                                                    <!-- Mostrar botón Dejar de seguir en la sección Siguiendo -->
                                                    <form class="w-100" name="noSeguirUsuario" action="Red" method="POST">
                                                        <input type="hidden" name="seccion" value="siguiendo">
                                                        <input type="hidden" name="idUsuarioSiguiendo" value="${usuario.idUsuario}" />
                                                        <input type="submit" value="Dejar de seguir" class="btn btn-sm-secondary w-100">
                                                    </form>
                                                </c:when>
                                                <c:when test="${seccionSeleccionada eq 'seguidores'}">
                                                    <c:choose>
                                                        <c:when test="${sigueLista[loop.index] eq true}">
                                                            <!-- Mostrar botón Dejar de seguir si el usuario logueado sigue a este seguidor -->
                                                            <form class="w-100" name="noSeguirUsuario" action="Red" method="POST">
                                                                <input type="hidden" name="seccion" value="seguidores">
                                                                <input type="hidden" name="idUsuarioSeguidor" value="${usuario.idUsuario}" />
                                                                <input type="submit" value="Dejar de seguir" class="btn btn-sm-secondary w-100">
                                                            </form>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <!-- Mostrar botón Seguir si el usuario logueado no sigue a este seguidor -->
                                                            <form class="w-100" name="seguirUsuario" action="Red" method="POST">
                                                                <input type="hidden" name="seccion" value="seguidores">
                                                                <input type="hidden" name="idUsuarioSeguidor" value="${usuario.idUsuario}" />
                                                                <input type="submit" value="Seguir" class="btn btn-sm-secondary w-100">
                                                            </form>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:when>
                                            </c:choose>
                                        </div>
                                        <div class="col-2">
                                            <form class="w-100" name="verPerfil" action="Usuario" method="GET">
                                                <input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>
                                                <input type="hidden" name="url" value="Red?seccion=${seccionSeleccionada}"/>
                                                <input type="submit" value="Ver perfil" class="btn btn-sm-primary w-100">
                                            </form>
                                        </div>     
                                    </div>
                                </div>
                            </c:forEach>
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

