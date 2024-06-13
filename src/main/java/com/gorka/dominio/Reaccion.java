/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gorka
 */
@Entity
@Table(name = "reaccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reaccion.findAll", query = "SELECT r FROM Reaccion r"),
    @NamedQuery(name = "Reaccion.findByIdReaccion", query = "SELECT r FROM Reaccion r WHERE r.reaccionPK.idReaccion = :idReaccion"),
    @NamedQuery(name = "Reaccion.findByUsuarioidUsuario", query = "SELECT r FROM Reaccion r WHERE r.reaccionPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "Reaccion.findByActividadidActividad", query = "SELECT r FROM Reaccion r WHERE r.reaccionPK.actividadidActividad = :actividadidActividad"),
    @NamedQuery(name = "Reaccion.findByFechaCreacion", query = "SELECT r FROM Reaccion r WHERE r.fechaCreacion = :fechaCreacion")})
public class Reaccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReaccionPK reaccionPK;
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @ManyToOne(optional = false)
    @JoinColumns({
        @JoinColumn(name = "actividad_idActividad", referencedColumnName = "idActividad", insertable = false, updatable = false),
        @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "usuario_idUsuario", insertable = false, updatable = false)
    })
    private Actividad actividad;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    private Usuario usuario;

    public Reaccion() {
    }

    public Reaccion(ReaccionPK reaccionPK) {
        this.reaccionPK = reaccionPK;
    }

    public Reaccion(int idReaccion, int usuarioidUsuario, int actividadidActividad) {
        this.reaccionPK = new ReaccionPK(idReaccion, usuarioidUsuario, actividadidActividad);
    }

    public Reaccion(int usuarioidUsuario, int actividadidActividad, Date fecha) {
        this.reaccionPK = new ReaccionPK();
        this.reaccionPK.setUsuarioidUsuario(usuarioidUsuario);
        this.reaccionPK.setActividadidActividad(actividadidActividad);
        this.fechaCreacion = fecha;
    }

    public ReaccionPK getReaccionPK() {
        return reaccionPK;
    }

    public void setReaccionPK(ReaccionPK reaccionPK) {
        this.reaccionPK = reaccionPK;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reaccionPK != null ? reaccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reaccion)) {
            return false;
        }
        Reaccion other = (Reaccion) object;
        if ((this.reaccionPK == null && other.reaccionPK != null) || (this.reaccionPK != null && !this.reaccionPK.equals(other.reaccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.Reaccion[ reaccionPK=" + reaccionPK + " ]";
    }

}
