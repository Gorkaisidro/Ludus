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
public class ActividadPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idActividad")
    private int idActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;

    public ActividadPK() {
    }

    public ActividadPK(int idActividad, int usuarioidUsuario) {
        this.idActividad = idActividad;
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idActividad;
        hash += (int) usuarioidUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadPK)) {
            return false;
        }
        ActividadPK other = (ActividadPK) object;
        if (this.idActividad != other.idActividad) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.ActividadPK[ idActividad=" + idActividad + ", usuarioidUsuario=" + usuarioidUsuario + " ]";
    }
    
    
}
