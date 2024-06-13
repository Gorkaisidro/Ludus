/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.dominio.Comentario;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iComentarioService {
    
    // Función que lista todas las comentario de mi BBDD
    public List<Comentario> listarComentario();
    
    // Función que me devuelve una comentario en base a su Id
    public Comentario encontrarComentarioPorId(Comentario comentario);
    
    // Función que me devuelve los comentarios en base a su IdUsuario(FK)
    public Comentario encontrarComentarioPorUsuario(Comentario comentario);
    
    // Función que me devuelve los comentarios en base a su IdActividad(FK)
    public List<Comentario> encontrarComentarioPorActividad(int idActividad);
        
    // Método que me registra comentario
    public void registrarComentario(Comentario comentario);
    
    // Método que me actualiza un comentario
    public void actualizarComentario(Comentario comentario);
    
    // Método que me borra un comentario
    public void borrarComentario(Comentario comentario);
    
    // Función que me da la cantidad de comentarios de la actividad
    public int contarComentariosPorIdActividad(int idActividad);
    
}
