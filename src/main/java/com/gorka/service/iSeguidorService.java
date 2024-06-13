/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.dominio.Seguidor;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iSeguidorService {

    // Función que lista todas los usuarios de mi BBDD
    public List<Seguidor> listarSeguidores();

    // Función que me devuelve un usuario en base a su Id
    public Seguidor encontrarSeguidorPorId(Seguidor seguidor);

    // Método que me registra unusuario
    public void registrarSeguidor(Seguidor seguidor);

    // Método que me actualiza un usuario
    public void actualizarSeguidor(Seguidor seguidor);

    // Método que me borra un usuario
    public void borrarSeguidor(Seguidor seguidor);
    
    // Función que me devuelve los seguidores en base a su IdSeguidor
    public Seguidor encontrarSeguidorPorIdSeguidor(int idSeguidor);
    
    // Función que me devuelve el seguidor en base a su IdSeguidor
    public Seguidor encontrarSeguidorPorIdUsuarioYidSiguiendo(int usuario_idusuario, int usuario_idSiguidor);
    
    // Función que me devuelve la cantidad de los que sigo
    public int contarSiguiendoPorIdUSuario(int idUsuario);
    
    // Función que me devuelve la cantidad de mis seguidores
    public int contarSeguidoresPorIdUSuario(int idUsuario);

}
