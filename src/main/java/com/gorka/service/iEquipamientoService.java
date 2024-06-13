/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.dominio.Equipamiento;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iEquipamientoService {
    
    // Función que lista todas las equipamiento de mi BBDD
    public List<Equipamiento> listarEquipamientos();
    
    // Función que me devuelve los equipaminetos en base a su IdUsuario(FK)
    public List<Equipamiento> encontrarEquipamientosPorUsuario(int idUsuario);
    
    // Función que me devuelve los equipaminetos en base a su IdEquipamiento
    public Equipamiento encontrarEquipamientosPorId(int idEquipamiento);
        
    // Método que me registra equipamiento
    public void registrarEquipamiento(Equipamiento equipamiento);
    
    // Método que me actualiza un equipamiento
    public void actualizarEquipamiento(Equipamiento equipamiento);
    
    // Método que me borra un equipamiento
    public void borrarEquipamiento(Equipamiento equipamiento);
    
}
