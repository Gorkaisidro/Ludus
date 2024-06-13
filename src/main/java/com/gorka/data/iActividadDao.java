/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Actividad;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iActividadDao {
    
    // Función que me devuelve todas las actividades
    public List<Actividad> findAllActividad();
    
    // Función que me devuelve todas las actividades ordenadas de la mas reciente
    public List<Actividad> findByDate();
    
    // Función que me devuelve las actividades por usuario
    public List<Actividad> findActividadesByUsuario(int idUsuario);
    
    // Método que me añade un objeto actividad a la base de datos
    public void insertarActividad(Actividad actividad);
    
    // Método que nos permite actualizar una actividad
    public void actualizarActividad(Actividad actividad);
    
    // Método que elimina un objeto de actividad
    public void borrarActividad(Actividad actividad);
    
    // Función que me devuelve todas las actividades de mis seguidores
    public List<Actividad> findActividadBySeguidores(int idUsuario);
    
    // Función que me devuelve la cantidad de mis actividades
    public int countActividadByIdUsuario(int idUsuario);
    
    // Función que me devuelve la actividad por idActividad
    public Actividad findActividadByIdActividad(int idActividad);
    
    // Función que me devuelve los resultados de mis metricas por año
    public Object[] resultadosMetricasPorAnio(int idUsuario, int anio);
    
    // Función que me devuelve los resultados de mis metricas por año y deporte
    public Object[] resultadosMetricasPorAnioYDeporte(int idUsuario, int anio, String tipoDeporte);
    
    // Función que me devuelve el año de la primera actividad
    public int findPrimerAnioRegistrado(int idUsuario);
    
}
