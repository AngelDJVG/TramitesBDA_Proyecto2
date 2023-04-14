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
 * Esta clase representa un objeto Trámite.
 *
 * @author Ángel Valenzuela, Luis Durán
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
    @Column(name = "nombre_persona", nullable = false, length = 150)
    private String nombrePersona;

    @Column(name = "costo", nullable = false)
    private Float costo;

    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaExpedicion;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "persona_rfc", nullable = false)
    private Persona persona;

    /**
     * Constructor por omisión.
     */
    public Tramite() {
    }

    /**
     * Constructor que inicializa todos los atributos del trámite.
     *
     * @param nombrePersona Nombre de la persona que solicita el trámite.
     * @param costo Costo de la licencia.
     * @param persona Persona que solicita el trámite.
     * @param fechaExpedicion Fecha en que se expidió el trámite.
     */
    public Tramite(String nombrePersona, Float costo, Persona persona, Calendar fechaExpedicion) {
        this.nombrePersona = nombrePersona;
        this.costo = costo;
        this.persona = persona;
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Constructor que inicializa algunos atributos del trámite.
     *
     * @param nombrePersona Nombre de la persona que solicita el trámite.
     * @param costo Costo de la licencia.
     * @param id Id del trámite.
     */
    public Tramite(Long id, String nombrePersona, Float costo) {
        this.id = id;
        this.nombrePersona = nombrePersona;
        this.costo = costo;
    }

    /**
     * Devuelve el id de la placa.
     *
     * @return el id de la placa
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el id de la placa.
     *
     * @param id el nuevo id de la placa
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre de la persona de la placa.
     *
     * @return el nombre de la persona de la placa
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * Establece el nombre de la persona de la placa.
     *
     * @param nombrePersona el nuevo nombre de la persona de la placa
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    /**
     * Devuelve el costo de la placa.
     *
     * @return el costo de la placa
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la placa.
     *
     * @param costo el nuevo costo de la placa
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Devuelve la persona de la placa.
     *
     * @return la persona de la placa
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona de la placa.
     *
     * @param persona la nueva persona dueña de la placa
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve la fecha de expedición de la placa.
     *
     * @return la fecha de expedición de la placa
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Establece la fecha de expedición de la placa.
     *
     * @param fechaExpedicion la nueva fecha de expedición de la placa
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Método que genera un código hash para la clase Trámite.
     *
     * @return el código hash generado
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara la igualdad de objetos de la clase Trámite.
     *
     * @param object el objeto a comparar
     * @return true si los objetos son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    /**
     * Método que devuelve una cadena de texto que representa al objeto Trámite.
     *
     * @return la cadena de texto generada
     */
    @Override
    public String toString() {
        return "Tramite{" + "id=" + id + ", nombrePersona=" + nombrePersona + ", costo=" + costo + ", fechaExpedicion=" + fechaExpedicion + ", persona=" + persona + '}';
    }

}
