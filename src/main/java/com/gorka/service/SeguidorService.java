/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.data.iSeguidorDao;
import com.gorka.dominio.Seguidor;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Gorka
 */
@Stateless
public class SeguidorService implements iSeguidorService {

    @Inject
    private iSeguidorDao seguidorDao;

    @Override
    public List<Seguidor> listarSeguidores() {
        return seguidorDao.findAllSeguidor();
    }

    @Override
    public Seguidor encontrarSeguidorPorId(Seguidor seguidor) {
        return seguidorDao.findSeguidorById(seguidor);
    }

    @Override
    public void registrarSeguidor(Seguidor seguidor) {
        seguidorDao.insertarSeguidor(seguidor);
    }

    @Override
    public void actualizarSeguidor(Seguidor seguidor) {
        seguidorDao.actualizarSeguidor(seguidor);
    }

    @Override
    public void borrarSeguidor(Seguidor seguidor) {
        seguidorDao.borrarSeguidor(seguidor);
    }

    @Override
    public Seguidor encontrarSeguidorPorIdSeguidor(int idSeguidor) {
        return seguidorDao.findSeguidorByIdSeguidor(idSeguidor);
    }

    @Override
    public Seguidor encontrarSeguidorPorIdUsuarioYidSiguiendo(int usuario_idUsuario, int usuario_idSeguidor) {
        return seguidorDao.findSegudorByIdUsuarioAndIdSiguiendo(usuario_idUsuario, usuario_idSeguidor);
    }

    @Override
    public int contarSiguiendoPorIdUSuario(int idUsuario) {
        return seguidorDao.countSiguiendoByIdUsuario(idUsuario);
    }

    @Override
    public int contarSeguidoresPorIdUSuario(int idUsuario) {
        return seguidorDao.countSeguidoresByIdUsuario(idUsuario);
    }

}
