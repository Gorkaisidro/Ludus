/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.data.iUsuarioDao;
import com.gorka.dominio.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

/**
 *
 * @author Gorka
 */
@Stateless
public class UsuarioService implements iUsuarioService {

    @Inject
    private iUsuarioDao usuarioDao;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuario();
    }

    @Override
    public Usuario encontrarUsuarioPorId(int idUsuario) {
        return usuarioDao.findUsuarioById(idUsuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioDao.actualizarUsuario(usuario);
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        usuarioDao.borrarUsuario(usuario);
    }

    @Override
    public boolean existeUsuarioPorEmail(String email) {
        return usuarioDao.existeUsuarioPorEmail(email);
    }

    @Override
    public Usuario verificarUsuario(String email, String clave) {
        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        try {
            Usuario usuarioInicio = usuarioDao.findUsuarioByEmail(usuario);
            if (usuarioInicio != null && usuarioInicio.getClave().equals(clave)) {
                return usuarioInicio;
            }
        } catch (NoResultException e) {

        }
        return null;
    }

    @Override
    public List<Usuario> encontrarUsuarioNoSigo(Usuario usuario) {
        List<Usuario> usuariosNoSigo = usuarioDao.findAllUsuarioNoSigo(usuario);

        // Eliminar el propio usuario de la lista
        usuariosNoSigo.remove(usuario);

        return usuariosNoSigo;
    }

    @Override
    public List<Usuario> encontrarUsuarioSiguiendo(Usuario usuario) {
        return usuarioDao.findAllUsuarioSiguiendo(usuario);
    }

    @Override
    public List<Usuario> encontrarUsuarioSiguiendome(Usuario usuario) {
        return usuarioDao.findAllUsuarioSiguiendome(usuario);
    }

    @Override
    public boolean sigoAlUsuario(int idUsuario, int idSeguidor) {
        System.out.println("Estamos en el UsuarioService");
        System.out.println("Valor de idUsuario recibido: " + idUsuario);
        System.out.println("Valor de idSeguidor recibido: " + idSeguidor);

        return usuarioDao.sigueAlUsuario(idUsuario, idSeguidor);
    }
}
