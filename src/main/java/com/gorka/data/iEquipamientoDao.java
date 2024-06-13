/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Equipamiento;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iEquipamientoDao {
    
    // Funcion que me devuelve todas las equipamiento
    public List<Equipamiento> findAllEquipamiento();
    
    // Función que me devuelve los equipamientos por usuario
    public List<Equipamiento> findEquipamientosByUsuario(int idUsuario);
    
    // Función que me devuelve los equipamientos por id
    public Equipamiento findEquipamientosByIdEquipamiento(int idEquipamiento);
    
    // Método que me añade un objeto de equipamiento a la base de datos
    public void insertarEquipamiento (Equipamiento equipamiento);
    
    // Método que nos permite actualizar un equipamineto
    public void actualizarEquipamiento(Equipamiento equipamiento);
    
    // Método que elimina un objeto de equipamiento
    public void borrarEquipamiento (Equipamiento equipamiento);
    
}
