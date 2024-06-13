/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.dominio.Reaccion;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iReaccionService {
    
    // Función que lista todas las reacciones de mi BBDD
    public List<Reaccion> listarReaccion();
    
    // Función que me devuelve una reacción en base a su Id
    public Reaccion encontrarReaccionPorId(Reaccion reaccion);
        
    // Método que me registra una reacción
    public void registrarReaccion(Reaccion reaccion);
    
    // Método que me actualiza una reacción
    public void actualizarReaccion(Reaccion reaccion);
    
    // Método que me borra una reacción
    public void borrarReaccion(Reaccion reaccion);
    
    // Función que me da cantidad de reacciones de la actividad
    public int contarReaccionesPorIdActividad(int idActividad);
    
    // Funcion para saber si he reaccionado a la actividad
    public boolean verificarReaccion(int idUsuario, int idActividad);
    
    // Función que devuelve la reaccion segun idUsuario y idActividadç
    public Reaccion encontrarReaccionPorIdUsuarioYIdActividad(int idUsuario, int idActividad);
    
}
