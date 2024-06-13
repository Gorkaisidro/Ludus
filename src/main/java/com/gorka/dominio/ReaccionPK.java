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
public class ReaccionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idReaccion")
    private int idReaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actividad_idActividad")
    private int actividadidActividad;

    public ReaccionPK() {
    }

    public ReaccionPK(int idReaccion, int usuarioidUsuario, int actividadidActividad) {
        this.idReaccion = idReaccion;
        this.usuarioidUsuario = usuarioidUsuario;
        this.actividadidActividad = actividadidActividad;
    }

    public int getIdReaccion() {
        return idReaccion;
    }

    public void setIdReaccion(int idReaccion) {
        this.idReaccion = idReaccion;
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
        hash += (int) idReaccion;
        hash += (int) usuarioidUsuario;
        hash += (int) actividadidActividad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReaccionPK)) {
            return false;
        }
        ReaccionPK other = (ReaccionPK) object;
        if (this.idReaccion != other.idReaccion) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        return this.actividadidActividad == other.actividadidActividad;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.ReaccionPK[ idReaccion=" + idReaccion + ", usuarioidUsuario=" + usuarioidUsuario + ", actividadidActividad=" + actividadidActividad + " ]";
    }
    
}
