/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Equipamiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gorka
 */
@Stateless
public class EquipamientoDao implements iEquipamientoDao {

    // Instanciamos nuestra unidad de persistencia
    @PersistenceContext(unitName = "LudusPU")
    EntityManager em;

    @Override
    public List<Equipamiento> findAllEquipamiento() {
        return em.createNamedQuery("Equipamiento.findAll").getResultList();
    }

    @Override
    public List<Equipamiento> findEquipamientosByUsuario(int idUsuario) {
        TypedQuery<Equipamiento> query = em.createNamedQuery("Equipamiento.findByUsuarioidUsuario", Equipamiento.class);
        query.setParameter("usuario_idUsuario", idUsuario);
        List<Equipamiento> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public void insertarEquipamiento(Equipamiento equipamiento) {
        em.persist(equipamiento);
    }

    @Override
    public void actualizarEquipamiento(Equipamiento equipamiento) {
        em.merge(equipamiento);
    }

    @Override
    public void borrarEquipamiento(Equipamiento equipamiento) {
        em.remove(em.merge(equipamiento));
    }

    @Override
    public Equipamiento findEquipamientosByIdEquipamiento(int idEquipamiento) {
        TypedQuery<Equipamiento> query = em.createNamedQuery("Equipamiento.findByIdEquipamiento", Equipamiento.class);
        query.setParameter("idEquipamiento", idEquipamiento);

        List<Equipamiento> resultados = query.getResultList();

        if (resultados.isEmpty()) {
            return null;  // O devuelve lo que consideres apropiado en caso de no encontrar resultados
        } else {
            return resultados.get(0);
        }
    }

}
