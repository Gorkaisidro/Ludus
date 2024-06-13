/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Reaccion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gorka
 */
@Stateless
public class ReaccionDao implements iReaccionDao {

    // Instanciamos nuestra unidad de persistencia
    @PersistenceContext(unitName = "LudusPU")
    EntityManager em;

    @Override
    public List<Reaccion> findAllReaccion() {
        return em.createNamedQuery("Reaccion.findAll").getResultList();
    }

    @Override
    public Reaccion findReaccionById(Reaccion reaccion) {
        return em.find(Reaccion.class, reaccion.getReaccionPK().getIdReaccion());
    }

    @Override
    public void insertarReaccion(Reaccion reaccion) {
        em.persist(reaccion);
    }

    @Override
    public void actualizarReaccion(Reaccion reaccion) {
        em.merge(reaccion);
    }

    @Override
    public void borrarReaccion(Reaccion reaccion) {
        em.remove(em.merge(reaccion));
    }

    @Override
    public int countReaccionByIdActividad(int idActividad) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(r) FROM Reaccion r WHERE r.reaccionPK.actividadidActividad = :idActividad",
                Long.class
        );
        query.setParameter("idActividad", idActividad);
        Long resultado = query.getSingleResult();

        return resultado != null ? resultado.intValue() : 0;
    }

    @Override
    public boolean verificarReaccion(int idUsuario, int idActividad) {
        Query query = em.createQuery("SELECT COUNT(r) FROM Reaccion r WHERE r.reaccionPK.usuarioidUsuario = :usuario_idUsuario AND r.reaccionPK.actividadidActividad = :actividad_idActividad", Long.class);
        query.setParameter("usuario_idUsuario", idUsuario);
        query.setParameter("actividad_idActividad", idActividad);

        // Obtener el número de resultados
        long total = (Long) query.getSingleResult();

        // Verificar si el total es mayor que cero y devolver true, de lo contrario, devolver false
        return total > 0;
    }

    @Override
    public Reaccion findReaccionByIdUsuarioAndIdActividad(int idUsuario, int idActividad) {
        Query query = em.createQuery("SELECT r FROM Reaccion r WHERE r.reaccionPK.usuarioidUsuario = :usuario_idUsuario AND r.reaccionPK.actividadidActividad = :actividad_idActividad");
        query.setParameter("usuario_idUsuario", idUsuario);
        query.setParameter("actividad_idActividad", idActividad);

        try {
            return (Reaccion) query.getSingleResult();
        } catch (NoResultException e) {
            // Manejar la excepción si no se encuentra ninguna reacción
            return null;
        }
    }

}
