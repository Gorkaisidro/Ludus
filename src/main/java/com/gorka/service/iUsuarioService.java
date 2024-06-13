/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.dominio.Usuario;
import java.util.List;

/**
 *
 * @author Gorka
 */

public interface iUsuarioService {

    // Función que lista todas los usuarios de mi BBDD
    public List<Usuario> listarUsuarios();

    // Función que me devuelve un usuario en base a su Id
    public Usuario encontrarUsuarioPorId(int idUsuario);

    // Método que verifica si existe un usuario con el correo electrónico dado
    public boolean existeUsuarioPorEmail(String email);

    // Función que encuentra el usuario por email
    public Usuario verificarUsuario(String email, String clave);

    // Método que me registra unusuario
    public void registrarUsuario(Usuario usuario);

    // Método que me actualiza un usuario
    public void actualizarUsuario(Usuario usuario);

    // Método que me borra un usuario
    public void borrarUsuario(Usuario usuario);

    // Función que me devuelve usuarios que no sigo
    public List<Usuario> encontrarUsuarioNoSigo(Usuario usuario);
    
    // Función que me devuelve usuarios que sigo
    public List<Usuario> encontrarUsuarioSiguiendo(Usuario usuario);
    
    // Función que me devuelve usuarios que me siguen
    public List<Usuario> encontrarUsuarioSiguiendome(Usuario usuario);
    
    // Funcion para saber si yo sigo al usuario
    public boolean sigoAlUsuario(int idUsuario, int idSeguidor);

}
