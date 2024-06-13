<%-- 
    Document   : topBar
    Created on : 26-ene-2024, 13:34:00
    Author     : Gorka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.StringTokenizer"%>
<!DOCTYPE html>
<div class="d-flex justify-content-end align-items-center mt-2">
    <!--Boton para añadir actividad-->
    <div>
        <!-- Modal para añadir equipamiento -->
        <button type="button" class="btn btn-m-secondary me-2" data-bs-toggle="modal"
                data-bs-target="#añadirActividadModal">
            Añadir actividad
        </button>

        <!-- Modal -->
        <div class="modal fade" id="añadirActividadModal" tabindex="-1"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog tamaño-modal-actividad">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLabel">Añadir actividad</h3><br>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="ms-3 mt-3">
                        <p class="p-m">Rellena los campos para añadir actividad</p>
                    </div>
                    <div class="modal-body">
                        <form class="w-100" name="registrarActividad" action="RegistrarActividad"
                              method="POST">
                            <div class="row w-100">
                                <div class="col-4">
                                    <div class="input">
                                        <label for="deporte">Deporte</label>
                                        <select class="w-100" id="tipoDeporte" name="tipoDeporte"
                                                required>
                                            <option value="" disabled selected>Seleccionar</option>
                                            <option value="Correr">Carrer</option>
                                            <option value="Ciclismo">Ciclismo</option>
                                            <option value="Natación">Natación</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="input">
                                        <label for="tipo">Tipo</label>
                                        <select class="w-100" name="tipoActividad"
                                                required>
                                            <option value="" disabled selected>Seleccionar</option>
                                            <option value="Entrenamiento">Entrenamiento</option>
                                            <option value="Competición">Competición</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-4"></div>
                                <div class="col-4"><div class="input">
                                        <label for="duracion">Fecha de la actividad</label>
                                    </div></div>
                                <div class="col-4"></div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <div class="input">
                                        <label for="ubicacion">Ubicación</label>
                                        <input type="text" name="ubicacion"
                                               placeholder="Localidad, municipio..." required>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="row">
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="dia">Dia</label>
                                                <input type="number" name="dia" placeholder="9"
                                                       required min="1" max="31">
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="mes">Mes</label>
                                                <input type="number" name="mes" placeholder="4"
                                                       required min="1" max="12">
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="año">Año</label>
                                                <input type="number" name="anio"
                                                       placeholder="2023" required min="1900" max="2024">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="row">
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="hora">Hora</label>
                                                <input type="number" name="hora"
                                                       placeholder="17" required min="0" max="24">
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="minuto">Minuto</label>
                                                <input type="number" name="minuto"
                                                       placeholder="30" required min="0" max="59">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="input">
                                <label for="titulo">Título</label>
                                <input type="text" name="titulo"
                                       placeholder="Nombre de la actividad" required>
                            </div>
                            <div class="input">
                                <label for="descripcion">Descripción</label>
                                <input type="text" name="descripcion"
                                       placeholder="¿Cómo ha ido? Añade los comentarios sobre tu actividad">
                            </div>
                            <div class="row">
                                <div class="col-4"></div>
                                <div class="col-4"><div class="input">
                                        <label for="duracion">Duración</label>
                                    </div></div>
                                <div class="col-4"></div>
                            </div>
                            <div class="row">
                                <div class="col-4">
                                    <div class="input">
                                        <label for="distancia">Distancia (en km)</label>
                                        <input type="text" name="distancia" placeholder="ej. 6.6" required>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="row">
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="horaDuracion">Horas</label>
                                                <input type="number" name="horaDuracion" placeholder="1" required
                                                       min="0">
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="minutoDuracion">Minutos</label>
                                                <input type="number" name="minutoDuracion" placeholder="40" required
                                                       min="0" max="59">
                                            </div>
                                        </div>
                                        <div class="col-4">
                                            <div class="input">
                                                <label for="segundoDuracion">Segundo</label>
                                                <input type="number" name="segundoDuracion" placeholder="45" required
                                                       min="0" max="59">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-4">
                                    <div class="input">
                                        <label for="desnivel">Desnivel (en m)</label>
                                        <input type="text" name="desnivel" placeholder="ej. 250" min="0">
                                    </div>
                                </div>
                            </div>
                            <div class="d-flex justify-content-end mt-5">
                                <a class="btn btn-m-secondary w-25 me-2" data-bs-dismiss="modal"
                                   aria-label="Close" href="inicio.jsp" role="button">Cancelar</a>
                                <input type="submit" value="Guardar" class="btn btn-m-primary w-25"> 
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--Boton para cerrar sesion-->
    <div>
        <!-- Modal para cerrar sesion -->
        <button type="button" class="btn" data-bs-toggle="modal"
                data-bs-target="#cerrarSesionModal">
            Salir
        </button>

        <!-- Modal -->
        <div class="modal fade" id="cerrarSesionModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h3 class="modal-title" id="exampleModalLabel">Cerrar sesión</h3><br>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class=" mt-3 d-flex justify-content-center align-items-center">
                        <label class="p-lg">¿Estas seguro que quieres salir?</label>
                    </div>
                    <div class="modal-body">
                        <a class="btn btn-m-primary w-100 mt-2" href="CerrarSesion">Aceptar</a>
                        <a class="btn btn-m-secondary w-100 mt-2" data-bs-dismiss="modal"
                           aria-label="Close" href="Inicio" role="button">Cancelar</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
