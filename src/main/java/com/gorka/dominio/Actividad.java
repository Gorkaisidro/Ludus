/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gorka.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gorka
 */
@Entity
@Table(name = "actividad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a"),
    @NamedQuery(name = "Actividad.findByIdActividad", query = "SELECT a FROM Actividad a WHERE a.actividadPK.idActividad = :idActividad"),
    @NamedQuery(name = "Actividad.findByTipoDeporte", query = "SELECT a FROM Actividad a WHERE a.tipoDeporte = :tipoDeporte"),
    @NamedQuery(name = "Actividad.findByTitulo", query = "SELECT a FROM Actividad a WHERE a.titulo = :titulo"),
    @NamedQuery(name = "Actividad.findByUbicacion", query = "SELECT a FROM Actividad a WHERE a.ubicacion = :ubicacion"),
    @NamedQuery(name = "Actividad.findByDistancia", query = "SELECT a FROM Actividad a WHERE a.distancia = :distancia"),
    @NamedQuery(name = "Actividad.findByDuracion", query = "SELECT a FROM Actividad a WHERE a.duracion = :duracion"),
    @NamedQuery(name = "Actividad.findByDesnivel", query = "SELECT a FROM Actividad a WHERE a.desnivel = :desnivel"),
    @NamedQuery(name = "Actividad.findByFechaHoraInicio", query = "SELECT a FROM Actividad a WHERE a.fechaHoraInicio = :fechaHoraInicio"),
    @NamedQuery(name = "Actividad.findByTipoActividad", query = "SELECT a FROM Actividad a WHERE a.tipoActividad = :tipoActividad"),
    @NamedQuery(name = "Actividad.findByRitmo", query = "SELECT a FROM Actividad a WHERE a.ritmo = :ritmo"),
    @NamedQuery(name = "Actividad.findByUsuarioidUsuario", query = "SELECT a FROM Actividad a WHERE a.actividadPK.usuarioidUsuario = :usuario_idUsuario")
})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    public ActividadPK actividadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoDeporte")
    private String tipoDeporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Size(max = 16777215)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "distancia")
    private double distancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private long duracion;
    @Column(name = "desnivel")
    private Integer desnivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHoraInicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoActividad")
    private String tipoActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ritmo")
    private long ritmo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad")
    private List<Reaccion> reaccionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad")
    private List<Comentario> comentarioList;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    public Actividad() {
    }

    public Actividad(ActividadPK actividadPK) {
        this.actividadPK = actividadPK;
    }

    public Actividad(ActividadPK actividadPK, String tipoDeporte, String titulo, String ubicacion, double distancia, long duracion, Date fechaHoraInicio, String tipoActividad, long ritmo) {
        this.actividadPK = actividadPK;
        this.tipoDeporte = tipoDeporte;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.distancia = distancia;
        this.duracion = duracion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.tipoActividad = tipoActividad;
        this.ritmo = ritmo;
    }

    public Actividad(int idActividad, int usuarioidUsuario) {
        this.actividadPK = new ActividadPK(idActividad, usuarioidUsuario);
    }

    public Actividad(String tipoDeporte, String titulo, String descripcion, String ubicacion, double distancia, int duracion, int desnivel, Date fechaHoraInicio, String tipoActividad, int ritmo, int idUsuario) {
        this.tipoDeporte = tipoDeporte;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.distancia = distancia;
        this.duracion = duracion;
        this.desnivel = desnivel;
        this.fechaHoraInicio = fechaHoraInicio;
        this.tipoActividad = tipoActividad;
        this.ritmo = ritmo;
        this.actividadPK = new ActividadPK();
        this.actividadPK.setUsuarioidUsuario(idUsuario);
    }

    public ActividadPK getActividadPK() {
        return actividadPK;
    }

    public void setActividadPK(ActividadPK actividadPK) {
        this.actividadPK = actividadPK;
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public long getDuracion() {
        return duracion;
    }

    public void setDuracion(long duracion) {
        this.duracion = duracion;
    }

    public Integer getDesnivel() {
        return desnivel;
    }

    public void setDesnivel(Integer desnivel) {
        this.desnivel = desnivel;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public long getRitmo() {
        return ritmo;
    }

    public void setRitmo(long ritmo) {
        this.ritmo = ritmo;
    }
    
    @XmlTransient
    public List<Reaccion> getReaccionList() {
        return reaccionList;
    }

    public void setReaccionList(List<Reaccion> reaccionList) {
        this.reaccionList = reaccionList;
    }

    @XmlTransient
    public List<Comentario> getComentarioList() {
        return comentarioList;
    }

    public void setComentarioList(List<Comentario> comentarioList) {
        this.comentarioList = comentarioList;
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
        hash += (actividadPK != null ? actividadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actividadPK == null && other.actividadPK != null) || (this.actividadPK != null && !this.actividadPK.equals(other.actividadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gorka.dominio.Actividad[ actividadPK=" + actividadPK + " ]";
    }


}
