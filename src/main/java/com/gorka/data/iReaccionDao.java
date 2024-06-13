/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Reaccion;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iReaccionDao {
    
    // Funcion que me devuelve todos las reacciones
    public List<Reaccion> findAllReaccion();
    
    // Función que me busca reacciones por Id
    public Reaccion findReaccionById(Reaccion reaccion);
    
    // Método que me añade un objeto de reaccion a la base de datos
    public void insertarReaccion(Reaccion reaccion);
    
    // Método que nos permite actualizar una reaccion
    public void actualizarReaccion(Reaccion reaccion);
    
    // Método que elimina un objeto de reaccion
    public void borrarReaccion (Reaccion reaccion);
    
    // Función que me devuelve la cantidad de reacciones de la actividad
    public int countReaccionByIdActividad(int idActividad);
    
    // Función que me devuelve si le he dado me gusta a la actividad
    public boolean verificarReaccion (int idUsuario, int idActividad);
    
    // Función que me devuelve reaccion segun idUsuario y idActividad
    public Reaccion findReaccionByIdUsuarioAndIdActividad(int idUsuario, int idActividad);
}
