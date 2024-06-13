/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Gorka
 */
@Embeddable
public class ComentarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idComentario")
    private int idComentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actividad_idActividad")
    private int actividadidActividad;

    public ComentarioPK() {
    }

    public ComentarioPK(int idComentario, int usuarioidUsuario, int actividadidActividad) {
        this.idComentario = idComentario;
        this.usuarioidUsuario = usuarioidUsuario;
        this.actividadidActividad = actividadidActividad;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getActividadidActividad() {
        return actividadidActividad;
    }

    public void setActividadidActividad(int actividadidActividad) {
        this.actividadidActividad = actividadidActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idComentario;
        hash += (int) usuarioidUsuario;
        hash += (int) actividadidActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComentarioPK)) {
            return false;
        }
        ComentarioPK other = (ComentarioPK) object;
        if (this.idComentario != other.idComentario) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.actividadidActividad != other.actividadidActividad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.ComentarioPK[ idComentario=" + idComentario + ", usuarioidUsuario=" + usuarioidUsuario + ", actividadidActividad=" + actividadidActividad + " ]";
    }
    
}
