/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Gorka
 */
public interface iUsuarioDao {

    // Funcion que me devuelve todos los usuarios
    public List<Usuario> findAllUsuario();
    
    // Función que me busca usuario por Id
    public Usuario findUsuarioById(int idUsuario);
    
    // Método que verifica si existe un usuario con el correo electrónico dado
    public boolean existeUsuarioPorEmail(String email);
    
    // Función que me devuelve el usuario por email
    public Usuario findUsuarioByEmail(Usuario usuario);
    
    // Método que me añade un objeto de usuario a la base de datos
    public void insertarUsuario (Usuario usuario);
    
    // Método que nos permite actualizar un usuario
    public void actualizarUsuario(Usuario usuario);
    
    // Método que elimina un objeto de usuario
    public void borrarUsuario (Usuario usuario);
    
    // Función que me busca todos los usuario menos los que sigo
    public List<Usuario> findAllUsuarioNoSigo(Usuario usuario);
    
    // Función que me busca todos los usuario que sigo
    public List<Usuario> findAllUsuarioSiguiendo(Usuario usuario);
    
    // Función que me busca todos los usuario que me siguen
    public List<Usuario> findAllUsuarioSiguiendome(Usuario usuario);
    
    // Funcion que me dice si sigo al usuario que me sigue
    public boolean sigueAlUsuario(int idUsuario, int idSeguidor);
    
    
}
