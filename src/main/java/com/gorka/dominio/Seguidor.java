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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gorka
 */
@Entity
@Table(name = "seguidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguidor.findAll", query = "SELECT s FROM Seguidor s"),
    @NamedQuery(name = "Seguidor.findByIdSeguidor", query = "SELECT s FROM Seguidor s WHERE s.seguidorPK.idSeguidor = :idSeguidor"),
    @NamedQuery(name = "Seguidor.findByUsuarioidUsuario", query = "SELECT s FROM Seguidor s WHERE s.seguidorPK.usuarioidUsuario = :usuario_idUsuario"),
    @NamedQuery(name = "Seguidor.findByUsuarioidSeguidor", query = "SELECT s FROM Seguidor s WHERE s.seguidorPK.usuarioidSeguidor = :usuario_idSeguidor"),
    @NamedQuery(name = "Seguidor.findByFechaSeguimiento", query = "SELECT s FROM Seguidor s WHERE s.fechaSeguimiento = :fechaSeguimiento")})
public class Seguidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguidorPK seguidorPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSeguimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSeguimiento;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "usuario_idSeguidor", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario seguidor;

    public Seguidor() {
    }

    public Seguidor(SeguidorPK seguidorPK) {
        this.seguidorPK = seguidorPK;
    }

    public Seguidor(SeguidorPK seguidorPK, Date fechaSeguimiento) {
        this.seguidorPK = seguidorPK;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Seguidor(int usuarioidUsuario, int usuarioidSeguidor, Date fechaSeguimiento) {
        this.seguidorPK = new SeguidorPK();
        this.seguidorPK.setUsuarioidUsuario(usuarioidUsuario);
        this.seguidorPK.setUsuarioidSeguidor(usuarioidSeguidor);
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public SeguidorPK getSeguidorPK() {
        return seguidorPK;
    }

    public void setSeguidorPK(SeguidorPK seguidorPK) {
        this.seguidorPK = seguidorPK;
    }

    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getSeguidor() {
        return seguidor;
    }

    public void setseguidor(Usuario seguidor) {
        this.seguidor = seguidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguidorPK != null ? seguidorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguidor)) {
            return false;
        }
        Seguidor other = (Seguidor) object;
        if ((this.seguidorPK == null && other.seguidorPK != null) || (this.seguidorPK != null && !this.seguidorPK.equals(other.seguidorPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.Seguidor[ seguidorPK=" + seguidorPK + " ]";
    }
    
}
