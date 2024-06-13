/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.data.iReaccionDao;
import com.gorka.dominio.Reaccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Gorka
 */
@Stateless
public class ReaccionService implements iReaccionService {

    @Inject
    private iReaccionDao reaccionDao;

    @Override
    public List<Reaccion> listarReaccion() {
        return reaccionDao.findAllReaccion();
    }

    @Override
    public Reaccion encontrarReaccionPorId(Reaccion reaccion) {
        return reaccionDao.findReaccionById(reaccion);
    }

    @Override
    public void registrarReaccion(Reaccion reaccion) {
        reaccionDao.insertarReaccion(reaccion);
    }

    @Override
    public void actualizarReaccion(Reaccion reaccion) {
        reaccionDao.actualizarReaccion(reaccion);
    }

    @Override
    public void borrarReaccion(Reaccion reaccion) {
        reaccionDao.borrarReaccion(reaccion);
    }

    @Override
    public int contarReaccionesPorIdActividad(int idActividad) {
        return reaccionDao.countReaccionByIdActividad(idActividad);
    }

    @Override
    public boolean verificarReaccion(int idUsuario, int idActividad) {
        return reaccionDao.verificarReaccion(idUsuario, idActividad);
    }

    @Override
    public Reaccion encontrarReaccionPorIdUsuarioYIdActividad(int idUsuario, int idActividad) {
        return reaccionDao.findReaccionByIdUsuarioAndIdActividad(idUsuario, idActividad);
    }
    
}
