/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.data.iComentarioDao;
import com.gorka.dominio.Comentario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Gorka
 */
@Stateless
public class ComentarioService implements iComentarioService{
    
    @Inject
    private iComentarioDao comentarioDao;

    @Override
    public List<Comentario> listarComentario() {
        return comentarioDao.findAllComentario();
    }

    @Override
    public Comentario encontrarComentarioPorId(Comentario comentario) {
        return comentarioDao.findComentarioById(comentario);
    }

    @Override
    public Comentario encontrarComentarioPorUsuario(Comentario comentario) {
        return comentarioDao.findComentariosByUsuario(comentario);
    }

    @Override
    public List<Comentario> encontrarComentarioPorActividad(int idActividad) {
        return comentarioDao.findComentariosByActividad(idActividad);
    }

    @Override
    public void registrarComentario(Comentario comentario) {
        comentarioDao.insertarComentario(comentario);
    }

    @Override
    public void actualizarComentario(Comentario comentario) {
        comentarioDao.actualizarComentario(comentario);
    }

    @Override
    public void borrarComentario(Comentario comentario) {
        comentarioDao.borrarComentario(comentario);
    }

    @Override
    public int contarComentariosPorIdActividad(int idActividad) {
        return comentarioDao.countComentarioByIdActividad(idActividad);
    }
    
}
