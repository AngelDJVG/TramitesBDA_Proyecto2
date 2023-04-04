/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
@Entity
@Table(name = "placas")
@PrimaryKeyJoinColumn(name = "id_tramite_placa")
public class Placa extends Tramite implements Serializable {
    
    @Column(name = "numero", unique = true, nullable = false, length = 7)
    private String numero;
    
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaEmision;
    
    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;
    
    @Column(name = "esActivo")
    private boolean esActivo;
    
    @ManyToOne
    @JoinColumn(name = "serie_vehiculo", nullable = false)
    private Vehiculo vehiculo; 
    
    public Placa() {
    }

    public Placa(String nombrePersona, Float costo, Persona persona, Long id, String numero, Calendar fechaEmision, Calendar fechaRecepcion, boolean esActivo) {
        super(nombrePersona, costo, persona);
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.esActivo = esActivo;
    }

    public Placa(String nombrePersona, Float costo, Persona persona, String numero, Calendar fechaEmision, Calendar fechaRecepcion, boolean esActivo) {
        super(nombrePersona, costo, persona);
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.esActivo = esActivo;
    }

    public Placa(String numero, Calendar fechaEmision, Calendar fechaRecepcion, boolean esActivo, Vehiculo vehiculo, String nombrePersona, Float costo, Persona persona) {
        super(nombrePersona, costo, persona);
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.fechaRecepcion = fechaRecepcion;
        this.esActivo = esActivo;
        this.vehiculo = vehiculo;
    }
    
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Placa{" + "numero=" + numero + ", fechaEmision=" + fechaEmision + ", fechaRecepcion=" + fechaRecepcion + ", esActivo=" + esActivo + '}';
    }

    
    
}
