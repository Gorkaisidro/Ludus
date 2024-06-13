/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Seguidor;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iSeguidorDao {
    
    // Funcion que me devuelve todos los seguidores
    public List<Seguidor> findAllSeguidor();
    
    // Función que me busca seguidores por Id
    public Seguidor findSeguidorById(Seguidor seguidor);
    
    // Función que me devuelve los seguidores por id
    public Seguidor findSeguidorByIdSeguidor(int idSeguidor);
    
    // Método que me añade un objeto de seguidor a la base de datos
    public void insertarSeguidor (Seguidor seguidor);
    
    // Método que nos permite actualizar un seguidor
    public void actualizarSeguidor(Seguidor seguidor);
    
    // Método que elimina un objeto de seguidor
    public void borrarSeguidor (Seguidor seguidor);
    
    // Función que me devuelva los seguidor segun idUsuario y idSiguiendo
    public Seguidor findSegudorByIdUsuarioAndIdSiguiendo(int usuario_idUsuario, int usuario_idSiguidor);
    
    // Función que me devuelve la cantidad de los usuarios que sigo
    public int countSiguiendoByIdUsuario (int idUsuario);
    
    // Función que me devuelve la cantidad de mis seguidores
    public int countSeguidoresByIdUsuario (int idUsuario);
}
