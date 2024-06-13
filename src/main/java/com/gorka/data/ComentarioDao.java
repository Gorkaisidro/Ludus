/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Comentario;
import java.util.ArrayList;
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
public class ComentarioDao implements iComentarioDao {

    // Instanciamos nuestra unidad de persistencia
    @PersistenceContext(unitName = "LudusPU")
    EntityManager em;

    @Override
    public List<Comentario> findAllComentario() {
        return em.createNamedQuery("Comentario.findAll").getResultList();
    }

    @Override
    public Comentario findComentarioById(Comentario comentario) {
        return em.find(Comentario.class, comentario.getComentarioPK().getIdComentario());
    }

    @Override
    public Comentario findComentariosByUsuario(Comentario comentario) {
        try {
            Query query = em.createQuery("FROM Comentario c WHERE c.comentarioPK.usuarioidUsuario = :usuarioidUsuario");
            query.setParameter("usuarioidUsuario", comentario.getComentarioPK().getUsuarioidUsuario());
            return (Comentario) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Comentario> findComentariosByActividad(int idActividad) {
        Query query = em.createQuery("SELECT c FROM Comentario c WHERE c.comentarioPK.actividadidActividad = :actividadidActividad");
        query.setParameter("actividadidActividad", idActividad);
        return query.getResultList();

    }

    @Override
    public void insertarComentario(Comentario comentario) {
        em.persist(comentario);
    }

    @Override
    public void actualizarComentario(Comentario comentario) {
        em.merge(comentario);
    }

    @Override
    public void borrarComentario(Comentario comentario) {
        em.remove(em.merge(comentario));
    }

    @Override
    public int countComentarioByIdActividad(int idActividad) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(c) FROM Comentario c WHERE c.comentarioPK.actividadidActividad = :idActividad",
                Long.class
        );
        query.setParameter("idActividad", idActividad);
        Long resultado = query.getSingleResult();

        return resultado != null ? resultado.intValue() : 0;
    }

}
