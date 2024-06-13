/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gorka
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.idComentario = :idComentario"),
    @NamedQuery(name = "Comentario.findByUsuarioidUsuario", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.usuarioidUsuario = :usuarioidUsuario"),
    @NamedQuery(name = "Comentario.findByActividadidActividad", query = "SELECT c FROM Comentario c WHERE c.comentarioPK.actividadidActividad = :actividadidActividad"),
    @NamedQuery(name = "Comentario.findByComentario", query = "SELECT c FROM Comentario c WHERE c.comentario = :comentario"),
    @NamedQuery(name = "Comentario.findByFechaCreacion", query = "SELECT c FROM Comentario c WHERE c.fechaCreacion = :fechaCreacion")})
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComentarioPK comentarioPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumns({
        @JoinColumn(name = "actividad_idActividad", referencedColumnName = "idActividad", insertable = false, updatable = false),
        @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "usuario_idUsuario", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false)
    private Actividad actividad;
    @JoinColumns({
        @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false),
    })
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Comentario() {
    }

    public Comentario(ComentarioPK comentarioPK) {
        this.comentarioPK = comentarioPK;
    }

    public Comentario(ComentarioPK comentarioPK, String comentario, Date fechaCreacion) {
        this.comentarioPK = comentarioPK;
        this.comentario = comentario;
        this.fechaCreacion = fechaCreacion;
    }
    
    public Comentario (int usuarioidUsuario, int actividadidActividad, String comentario, Date fecha) {
        this.comentarioPK = new ComentarioPK();
        this.comentarioPK.setUsuarioidUsuario(usuarioidUsuario);
        this.comentarioPK.setActividadidActividad(actividadidActividad);
        this.comentario = comentario;
        this.fechaCreacion = fecha;
    }

    public Comentario(int idComentario, int usuarioidUsuario, int actividadidActividad) {
        this.comentarioPK = new ComentarioPK(idComentario, usuarioidUsuario, actividadidActividad);
    }

    public ComentarioPK getComentarioPK() {
        return comentarioPK;
    }

    public void setComentarioPK(ComentarioPK comentarioPK) {
        this.comentarioPK = comentarioPK;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
        hash += (comentarioPK != null ? comentarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioPK == null && other.comentarioPK != null) || (this.comentarioPK != null && !this.comentarioPK.equals(other.comentarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.Comentario[ comentarioPK=" + comentarioPK + " ]";
    }
    
}
