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
public class SeguidorPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idSeguidor")
    private int idSeguidor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idUsuario")
    private int usuarioidUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_idSeguidor")
    private int usuarioidSeguidor;

    public SeguidorPK() {
    }

    public SeguidorPK(int idSeguidor, int usuarioidUsuario, int usuarioidSeguidor) {
        this.idSeguidor = idSeguidor;
        this.usuarioidUsuario = usuarioidUsuario;
        this.usuarioidSeguidor = usuarioidSeguidor;
    }

    public int getIdSeguidor() {
        return idSeguidor;
    }

    public void setIdSeguidor(int idSeguidor) {
        this.idSeguidor = idSeguidor;
    }

    public int getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(int usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public int getUsuarioidSeguidor() {
        return usuarioidSeguidor;
    }

    public void setUsuarioidSeguidor(int usuarioidSeguidor) {
        this.usuarioidSeguidor = usuarioidSeguidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSeguidor;
        hash += (int) usuarioidUsuario;
        hash += (int) usuarioidSeguidor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguidorPK)) {
            return false;
        }
        SeguidorPK other = (SeguidorPK) object;
        if (this.idSeguidor != other.idSeguidor) {
            return false;
        }
        if (this.usuarioidUsuario != other.usuarioidUsuario) {
            return false;
        }
        if (this.usuarioidSeguidor != other.usuarioidSeguidor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.SeguidorPK[ idSeguidor=" + idSeguidor + ", usuarioidUsuario=" + usuarioidUsuario + ", usuarioidSeguidor=" + usuarioidSeguidor + " ]";
    }
    
}
