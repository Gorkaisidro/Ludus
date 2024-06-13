/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gorka
 */
@Entity
@Table(name = "equipamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipamiento.findAll", query = "SELECT e FROM Equipamiento e"),
    @NamedQuery(name = "Equipamiento.findByIdEquipamiento", query = "SELECT e FROM Equipamiento e WHERE e.equipamientoPK.idEquipamiento = :idEquipamiento"),
    @NamedQuery(name = "Equipamiento.findByTipoEquipamiento", query = "SELECT e FROM Equipamiento e WHERE e.tipoEquipamiento = :tipoEquipamiento"),
    @NamedQuery(name = "Equipamiento.findByNombre", query = "SELECT e FROM Equipamiento e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Equipamiento.findByMarca", query = "SELECT e FROM Equipamiento e WHERE e.marca = :marca"),
    @NamedQuery(name = "Equipamiento.findByModelo", query = "SELECT e FROM Equipamiento e WHERE e.modelo = :modelo"),
    @NamedQuery(name = "Equipamiento.findByUsuarioidUsuario", query = "SELECT e FROM Equipamiento e WHERE e.equipamientoPK.usuarioidUsuario = :usuario_idUsuario")})
public class Equipamiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EquipamientoPK equipamientoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoEquipamiento")
    private String tipoEquipamiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "modelo")
    private String modelo;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public Equipamiento() {
    }

    public Equipamiento(EquipamientoPK equipamientoPK) {
        this.equipamientoPK = equipamientoPK;
    }

    public Equipamiento(String tipoEquipamiento, String nombre, String marca, String modelo, int idUsuario) {
        this.tipoEquipamiento = tipoEquipamiento;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.equipamientoPK = new EquipamientoPK(); // crea una instancia de EquipamientoPK
        this.equipamientoPK.setUsuarioidUsuario(idUsuario); // establece el idUsuario en EquipamientoPK
    }

    public Equipamiento(EquipamientoPK equipamientoPK, String tipoEquipamiento, String nombre, String marca, String modelo) {
        this.equipamientoPK = equipamientoPK;
        this.tipoEquipamiento = tipoEquipamiento;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Equipamiento(int idEquipamiento, String tipoEquipamiento, String nombre, String marca, String modelo, int idUsuario) {
        this.equipamientoPK = new EquipamientoPK(idEquipamiento, idUsuario);
        this.tipoEquipamiento = tipoEquipamiento;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Equipamiento(int idEquipamiento, int usuarioidUsuario) {
        this.equipamientoPK = new EquipamientoPK(idEquipamiento, usuarioidUsuario);
    }

    public EquipamientoPK getEquipamientoPK() {
        return equipamientoPK;
    }

    public void setEquipamientoPK(EquipamientoPK equipamientoPK) {
        this.equipamientoPK = equipamientoPK;
    }

    public String getTipoEquipamiento() {
        return tipoEquipamiento;
    }

    public void setTipoEquipamiento(String tipoEquipamiento) {
        this.tipoEquipamiento = tipoEquipamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
        hash += (equipamientoPK != null ? equipamientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipamiento)) {
            return false;
        }
        Equipamiento other = (Equipamiento) object;
        if ((this.equipamientoPK == null && other.equipamientoPK != null) || (this.equipamientoPK != null && !this.equipamientoPK.equals(other.equipamientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.Equipamiento[ equipamientoPK=" + equipamientoPK + " ]";
    }
    
}
