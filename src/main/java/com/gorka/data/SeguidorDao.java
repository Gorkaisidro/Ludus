/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Seguidor;
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
public class SeguidorDao implements iSeguidorDao {

    // Instanciamos nuestra unidad de persistencia
    @PersistenceContext(unitName = "LudusPU")
    EntityManager em;

    @Override
    public List<Seguidor> findAllSeguidor() {
        return em.createNamedQuery("Seguidor.findAll").getResultList();
    }

    @Override
    public Seguidor findSeguidorById(Seguidor seguidor) {
        return em.find(Seguidor.class, seguidor.getSeguidorPK().getIdSeguidor());
    }

    @Override
    public void insertarSeguidor(Seguidor seguidor) {
        em.persist(seguidor);
    }

    @Override
    public void actualizarSeguidor(Seguidor seguidor) {
        em.merge(seguidor);
    }

    @Override
    public void borrarSeguidor(Seguidor seguidor) {
        em.remove(em.merge(seguidor));
    }

    @Override
    public Seguidor findSeguidorByIdSeguidor(int idSeguidor) {
        TypedQuery<Seguidor> query = em.createNamedQuery("Seguidor.findByIdSeguidor", Seguidor.class);
        query.setParameter("idSeguidor", idSeguidor);

        List<Seguidor> resultados = query.getResultList();

        if (resultados.isEmpty()) {
            return null;  // O devuelve lo que consideres apropiado en caso de no encontrar resultados
        } else {
            return resultados.get(0);
        }
    }

    @Override
    public Seguidor findSegudorByIdUsuarioAndIdSiguiendo(int usuario_idUsuario, int usuario_idSeguidor) {
        Query query = em.createQuery("SELECT s FROM Seguidor s WHERE s.seguidorPK.usuarioidUsuario = :usuario_idUsuario AND s.seguidorPK.usuarioidSeguidor = :usuario_idSeguidor");
        query.setParameter("usuario_idUsuario", usuario_idUsuario);
        query.setParameter("usuario_idSeguidor", usuario_idSeguidor);

        try {
            return (Seguidor) query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Manejar el caso cuando no se encuentra ninguna coincidencia
        }
    }

    @Override
    public int countSiguiendoByIdUsuario(int idUsuario) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(s) FROM Seguidor s WHERE s.seguidorPK.usuarioidUsuario = :idUsuario",
                Long.class
        );
        query.setParameter("idUsuario", idUsuario);
        Long resultado = query.getSingleResult();

        return resultado != null ? resultado.intValue() : 0;
    }

    @Override
    public int countSeguidoresByIdUsuario(int idUsuario) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(s) FROM Seguidor s WHERE s.seguidorPK.usuarioidSeguidor = :idUsuario",
                Long.class
        );
        query.setParameter("idUsuario", idUsuario);
        Long resultado = query.getSingleResult();

        return resultado != null ? resultado.intValue() : 0;
    }

}
