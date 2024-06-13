/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Comentario;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iComentarioDao {
    
    // Funcion que me devuelve todos los comentarios
    public List<Comentario> findAllComentario();
    
    // Función que me busca comentario por Id
    public Comentario findComentarioById(Comentario comentario);
    
    // Función que me devuelve los comentarios por usuario
    public Comentario findComentariosByUsuario(Comentario comentario);
    
    // Función que me devuelve los cometarios por actividad
    public List<Comentario> findComentariosByActividad(int idActividad);
    
    // Método que me añade un objeto de comentario a la base de datos
    public void insertarComentario (Comentario comentario);
    
    // Método que nos permite actualizar un comentario
    public void actualizarComentario(Comentario comentario);
    
    // Método que elimina un objeto de comentario
    public void borrarComentario (Comentario comentario);
    
    // Función que me devuelve la cantidad de comentarios de la actividad
    public int countComentarioByIdActividad(int idActividad);
    
}
