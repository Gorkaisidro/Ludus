/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Actividad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gorka
 */
@Stateless
public class ActividadDao implements iActividadDao {

    @PersistenceContext(unitName = "LudusPU")
    EntityManager em;

    @Override
    public List<Actividad> findAllActividad() {
        return em.createNamedQuery("Actividad.findAll").getResultList();
    }

    @Override
    public List<Actividad> findByDate() {
        return em.createNamedQuery("Actividad.findByDate").getResultList();
    }

    @Override
    public void insertarActividad(Actividad actividad) {
        em.persist(actividad);
    }

    @Override
    public void actualizarActividad(Actividad actividad) {
        em.merge(actividad);
    }

    @Override
    public void borrarActividad(Actividad actividad) {
        em.remove(em.merge(actividad));
    }

    @Override
    public List<Actividad> findActividadesByUsuario(int idUsuario) {
        TypedQuery<Actividad> query = em.createNamedQuery("Actividad.findByUsuarioidUsuario", Actividad.class);
        query.setParameter("usuario_idUsuario", idUsuario);
        List<Actividad> resultados = query.getResultList();
        return resultados;
    }

    @Override
    public List<Actividad> findActividadBySeguidores(int idUsuario) {
        return em.createQuery("SELECT a FROM Actividad a WHERE a.actividadPK.usuarioidUsuario IN "
                + "(SELECT s.seguidorPK.usuarioidSeguidor FROM Seguidor s WHERE s.seguidorPK.usuarioidUsuario = :idUsuario AND s.seguidorPK.usuarioidSeguidor <> :idUsuario) "
                + "ORDER BY a.fechaHoraInicio DESC", Actividad.class)
                .setParameter("idUsuario", idUsuario)
                .getResultList();
    }

    @Override
    public int countActividadByIdUsuario(int idUsuario) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(a) FROM Actividad a WHERE a.actividadPK.usuarioidUsuario = :idUsuario",
                Long.class
        );
        query.setParameter("idUsuario", idUsuario);
        Long resultado = query.getSingleResult();

        return resultado != null ? resultado.intValue() : 0;
    }

    @Override
    public Actividad findActividadByIdActividad(int idActividad) {
        TypedQuery<Actividad> query = em.createNamedQuery("Actividad.findByIdActividad", Actividad.class);
        query.setParameter("idActividad", idActividad);
        return query.getSingleResult();
    }

    @Override
    public Object[] resultadosMetricasPorAnio(int idUsuario, int anio) {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT COUNT(a), SUM(a.distancia), SUM(a.duracion) "
                + "FROM Actividad a "
                + "WHERE a.actividadPK.usuarioidUsuario = :idUsuario AND FUNCTION('YEAR', a.fechaHoraInicio) = :anio",
                Object[].class
        );
        query.setParameter("idUsuario", idUsuario);
        query.setParameter("anio", anio);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return new Object[]{0L, 0.0, 0.0}; // Valores por defecto si no hay resultados
        }
    }

    @Override
    public Object[] resultadosMetricasPorAnioYDeporte(int idUsuario, int anio, String tipoDeporte) {
        TypedQuery<Object[]> query = em.createQuery(
                "SELECT COUNT(a), SUM(a.distancia), SUM(a.duracion) "
                + "FROM Actividad a "
                + "WHERE a.actividadPK.usuarioidUsuario = :idUsuario AND FUNCTION('YEAR', a.fechaHoraInicio) = :anio AND a.tipoDeporte = :tipoDeporte",
                Object[].class
        );
        query.setParameter("idUsuario", idUsuario);
        query.setParameter("anio", anio);
        query.setParameter("tipoDeporte", tipoDeporte);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return new Object[]{0L, 0.0, 0.0}; // Valores por defecto si no hay resultados
        }
    }

    @Override
    public int findPrimerAnioRegistrado(int idUsuario) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT MIN(FUNCTION('YEAR', a.fechaHoraInicio)) "
                + "FROM Actividad a "
                + "WHERE a.actividadPK.usuarioidUsuario = :idUsuario",
                Long.class
        );
        query.setParameter("idUsuario", idUsuario);
        Long primerAnio = query.getSingleResult();
        return primerAnio != null ? primerAnio.intValue() : 0;
    }

}
