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
public class EquipamientoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idEquipamiento")
    private int idEquipamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;

    public EquipamientoPK() {
    }

    public EquipamientoPK(int idEquipamiento, int usuarioidUsuario) {
        this.idEquipamiento = idEquipamiento;
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getIdEquipamiento() {
        return idEquipamiento;
    }

    public void setIdEquipamiento(int idEquipamiento) {
        this.idEquipamiento = idEquipamiento;
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
        hash += (int) idEquipamiento;
        hash += (int) usuarioidUsuario;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipamientoPK)) {
            return false;
        }
        EquipamientoPK other = (EquipamientoPK) object;
        if (this.idEquipamiento != other.idEquipamiento) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.EquipamientoPK[ idEquipamiento=" + idEquipamiento + ", usuarioidUsuario=" + usuarioidUsuario + " ]";
    }
    
}
