<%-- 
    Document   : miMetrica
    Created on : 07-jun-2024, 9:50:01
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
                        <h3>Mis métricas</h3>
                        <div class="mt-5 containerPrincipal">
                            <form id="verPerfilForm" action="Metrica" method="GET">
                                <div class="input w-25">
                                    <select id="tipoDeporte" name="anio" required onchange="this.form.submit()">
                                        <option value="2024" ${param.anio == '2024' ? 'selected' : ''}>2024</option>
                                        <option value="2023" ${param.anio == '2023' ? 'selected' : ''}>2023</option>
                                        <option value="2022" ${param.anio == '2022' ? 'selected' : ''}>2022</option>
                                        <option value="2021" ${param.anio == '2021' ? 'selected' : ''}>2021</option>
                                    </select>
                                </div>
                            </form>
                            <div class="containerMetrica-principal mt-1">
                                <div class="row w-100">
                                    <div class="col-4 containerMetrica-secundario">
                                        <div>
                                            <p class="p-m-c no-margin-botton">Actividades</p>
                                        </div>
                                        <div>
                                            <h4 class="no-margin-botton">${estadisticasAnio[0]}</h4>
                                        </div>
                                    </div>
                                    <div class="col-4 containerMetrica-secundario">
                                        <div>
                                            <p class="p-m-c no-margin-botton">Distancia</p>
                                        </div>
                                        <div>
                                            <h4 class="no-margin-botton">${estadisticasAnio[1]} km</h4>
                                        </div>
                                    </div>
                                </div>
                                <div class="row w-50 mt-4">
                                    <div class="col-4 containerMetrica-secundario">
                                        <div>
                                            <p class="p-m-c no-margin-botton">Tiempo</p>
                                        </div>
                                        <div>
                                            <h4 class="no-margin-botton">${estadisticasAnio[2]} s</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="mt-4">
                            <h4>Mis estadísticas</h4>
                        </div>
                        <div class="w-100 mt-1">
                            <h5>Correr</h5>
                            <div class="mt-2 containerPrincipal">
                                <div class="containerMetrica-principal">
                                    <div class="row w-100">
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Actividades</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasCorrer[0]}</h4>
                                            </div>
                                        </div>
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Distancia</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasCorrer[1]} km</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row w-50 mt-4">
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Tiempo</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasCorrer[2]} s</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="w-100 mt-3">
                            <h5>Ciclismo</h5>
                            <div class="mt-2 containerPrincipal">
                                <div class="containerMetrica-principal">
                                    <div class="row w-100">
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Actividades</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasCiclismo[0]}</h4>
                                            </div>
                                        </div>
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Distancia</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasCiclismo[1]} km</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row w-50 mt-4">
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Tiempo</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasCiclismo[2]} s</h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="w-100 mt-3">
                            <h5>Natación</h5>

                            <div class="mt-2 containerPrincipal">
                                <div class="containerMetrica-principal">
                                    <div class="row w-100">
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Actividades</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasNatacion[0]}</h4>
                                            </div>
                                        </div>
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Distancia</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasNatacion[1]} km</h4>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row w-50 mt-4">
                                        <div class="col-4 containerMetrica-secundario">
                                            <div>
                                                <p class="p-m-c no-margin-botton">Tiempo</p>
                                            </div>
                                            <div>
                                                <h4 class="no-margin-botton">${estadisticasNatacion[2]} s</h4>
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
        <script>
                                        function submitForm() {
                                            document.getElementById("verPerfilForm").submit();
                                        }
        </script>
    </body>
</html>
