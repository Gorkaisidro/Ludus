/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.service;

import com.gorka.data.iEquipamientoDao;
import com.gorka.dominio.Equipamiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Gorka
 */
@Stateless
public class EquipamientoService implements iEquipamientoService {

    @Inject
    private iEquipamientoDao equipamientoDao;

    @Override
    public List<Equipamiento> listarEquipamientos() {
        return equipamientoDao.findAllEquipamiento();
    }

    @Override
    public List<Equipamiento> encontrarEquipamientosPorUsuario(int idUsuario) {
        return equipamientoDao.findEquipamientosByUsuario(idUsuario);
    }

    @Override
    public void registrarEquipamiento(Equipamiento equipamiento) {
        equipamientoDao.insertarEquipamiento(equipamiento);
    }

    @Override
    public void actualizarEquipamiento(Equipamiento equipamiento) {
        equipamientoDao.actualizarEquipamiento(equipamiento);
    }

    @Override
    public void borrarEquipamiento(Equipamiento equipamiento) {
        equipamientoDao.borrarEquipamiento(equipamiento);
    }

    @Override
    public Equipamiento encontrarEquipamientosPorId(int idEquipamiento) {
        return equipamientoDao.findEquipamientosByIdEquipamiento(idEquipamiento);
    }

}
