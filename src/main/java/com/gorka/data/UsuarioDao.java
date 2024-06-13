/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.data;

import com.gorka.dominio.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Gorka
 */
@Stateless
public class UsuarioDao implements iUsuarioDao {

    // Instanciamos nuestra unidad de persistencia
    @PersistenceContext(unitName = "LudusPU")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuario() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(int idUsuario) {
        Query query = em.createNamedQuery("Usuario.findByIdUsuario");
        query.setParameter("idUsuario", idUsuario);
        List<Usuario> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null; // O podrías lanzar una excepción si lo prefieres
        }
    }

    @Override
    public boolean existeUsuarioPorEmail(String email) {
        Long count = (Long) em.createNamedQuery("Usuario.countByEmail")
                .setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public Usuario findUsuarioByEmail(Usuario usuario) {
        try {
            Query query = em.createQuery("FROM Usuario u WHERE u.email = :email");
            query.setParameter("email", usuario.getEmail());
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void borrarUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }

    @Override
    public List<Usuario> findAllUsuarioNoSigo(Usuario usuario) {
        Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario NOT IN (SELECT s.seguidorPK.usuarioidSeguidor FROM Seguidor s WHERE s.seguidorPK.usuarioidUsuario = :usuario_idUsuario)");
        query.setParameter("usuario_idUsuario", usuario.getIdUsuario());
        return query.getResultList();
    }

    @Override
    public List<Usuario> findAllUsuarioSiguiendo(Usuario usuario) {
        Query query = em.createQuery("SELECT u FROM Usuario u JOIN Seguidor s ON u.idUsuario = s.seguidorPK.usuarioidSeguidor WHERE s.seguidorPK.usuarioidUsuario = :usuario_idUsuario");
        query.setParameter("usuario_idUsuario", usuario.getIdUsuario());
        return query.getResultList();
    }

    @Override
    public List<Usuario> findAllUsuarioSiguiendome(Usuario usuario) {
        Query query = em.createQuery("SELECT u FROM Usuario u JOIN Seguidor s ON u.idUsuario = s.seguidorPK.usuarioidUsuario WHERE s.seguidorPK.usuarioidSeguidor = :usuario_idUsuario");
        query.setParameter("usuario_idUsuario", usuario.getIdUsuario());
        return query.getResultList();
    }

    @Override
    public boolean sigueAlUsuario(int idUsuario, int idSeguidor) {
        Query query = em.createQuery("SELECT COUNT(s) FROM Seguidor s WHERE s.seguidorPK.usuarioidUsuario = :usuario_idUsuario AND s.seguidorPK.usuarioidSeguidor = :usuario_idSeguidor", Long.class);
        query.setParameter("usuario_idUsuario", idUsuario);
        query.setParameter("usuario_idSeguidor", idSeguidor);

        // Obtener el número de resultados
        long total = (Long) query.getSingleResult();

        // Verificar si el total es mayor que cero y devolver true, de lo contrario, devolver false
        return total > 0;
    }

}
