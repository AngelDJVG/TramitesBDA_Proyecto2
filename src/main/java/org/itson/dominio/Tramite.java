/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.itson.utilidades.JPAEncryptor;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tramites")
public class Tramite implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Convert(converter = JPAEncryptor.class)
    @Column(name = "nombre_persona",nullable = false,length = 150)
    private String nombrePersona;
    
    @Column(name = "costo",nullable = false)
    private Float costo;
    
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaExpedicion;
    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "persona_rfc", nullable = false)
    private Persona persona;
            
    public Tramite() {
    }

    public Tramite(String nombrePersona, Float costo, Persona persona,Calendar fechaExpedicion) {
        this.nombrePersona = nombrePersona;
        this.costo = costo;
        this.persona = persona;
        this.fechaExpedicion = fechaExpedicion;
    }
    
    
    public Tramite(Long id, String nombrePersona, Float costo) {
        this.id = id;
        this.nombrePersona = nombrePersona;
        this.costo = costo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", nombrePersona=" + nombrePersona + ", costo=" + costo + ", fechaExpedicion=" + fechaExpedicion + ", persona=" + persona + '}';
    }
    
}
