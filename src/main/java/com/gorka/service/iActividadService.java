/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.dominio.Actividad;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iActividadService {
    
    // Función que lista todas las actividades
    public List<Actividad> listarActividad();
    
    // Función que lista todas las actividades por recientes
    public List<Actividad> listarActividadDate();
    
    // Función que me devuelve las actividades en base a su IdUsuario(FK)
    public List<Actividad> encontrarActividadesPorUsuario(int idUsuario);
    
    // Método que me registra una actividad
    public void registrarActividad(Actividad actividad);
    
    // Método que me actualiza una actividad
    public void actualizarActividad(Actividad actividad);
    
    // Método que me borra una actividad
    public void borrarActividad(Actividad actividad);
    
    // Función que me devuelve la fecha y hora de inicio de la actividad
    public Date obtenerFechaHoraInicio(int anio, int mes, int dia, int hora, int minuto);
    
    // Función que me pasa la duracion a segundos
    public int obtenerDuracionSegundos(int hora, int minuto, int segundo);
    
    // Función que me devuelve el ritmo en segundos
    public int obtenerRitmo(double distancia, int duracion);
    
    // Función que me devuelve las actividades de mis seguidores
    public List<Actividad> encontrarActividadesPorSeguidores(int idUsuario);
    
    // Función que me devuelve la cantidad de mis actividades
    public int contarActividadesPorIdUSuario(int idUsuario);
    
    // Función que me devuelve la actividad en base a su Id
    public Actividad encontrarActividadPorIdActividad(int idActividad);
    
    // Función que me devuelve la suma de todos los atributos de distancia y duracion de las actividades por año
    public Object[] resultadosMetricasPorAnio(int idUsuario, int anio);
    
    // Función que me devuelve la suma de todos los atributos de distancia y duracion de las actividades por año y deporte
    public Object[] resultadosMetricasPorAnioYDeporte(int idUsuario, int anio, String tipoDeporte);
    
    // Función que me devuelve el año de la primera actividad
    public int obtenerPrimerAnioRegistrado(int idUsuario);
}
