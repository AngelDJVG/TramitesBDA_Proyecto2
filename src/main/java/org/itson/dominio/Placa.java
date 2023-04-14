/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Esta clase representa un objeto Placa que hereda de la clase Tramite.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
@Entity
@Table(name = "placas")
@PrimaryKeyJoinColumn(name = "id_tramite_placa")
public class Placa extends Tramite implements Serializable {

    @Column(name = "numero", unique = true, nullable = false, length = 7)
    private String numero;

    @Column(name = "fecha_recepcion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaRecepcion;

    @Column(name = "esActivo")
    private boolean esActivo;

    @ManyToOne()
    @JoinColumn(name = "serie_vehiculo", nullable = false)
    private Vehiculo vehiculo;

    /**
     * Constructor por omisión.
     */
    public Placa() {
    }

    /**
     * Constructor que inicializa algunos atributos de la placa.
     *
     * @param nombrePersona el nombre de la persona a la que pertenece la placa
     * @param costo el costo de la placa
     * @param persona los datos de la persona a la que pertenece la placa
     * @param id el identificador único de la placa
     * @param numero el número de placa
     * @param fechaEmision la fecha en que se emitió la placa
     * @param fechaRecepcion la fecha en que se recibió la placa
     * @param esActivo indica si la placa está activa o no
     */
    public Placa(String nombrePersona, Float costo, Persona persona, Long id, String numero, Calendar fechaEmision, Calendar fechaRecepcion, boolean esActivo) {
        super(nombrePersona, costo, persona, fechaEmision);
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.esActivo = esActivo;
    }

    /**
     * Constructor que inicializa algunos atributos de la placa, sin id.
     *
     * @param nombrePersona el nombre de la persona a la que pertenece la placa
     * @param costo el costo de la placa
     * @param persona los datos de la persona a la que pertenece la placa
     * @param numero el número de placa
     * @param fechaEmision la fecha en que se emitió la placa
     * @param fechaRecepcion la fecha en que se recibió la placa
     * @param esActivo indica si la placa está activa o no
     */
    public Placa(String nombrePersona, Float costo, Persona persona, String numero, Calendar fechaEmision, Calendar fechaRecepcion, boolean esActivo) {
        super(nombrePersona, costo, persona, fechaEmision);
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.esActivo = esActivo;
    }

    /**
     * Constructor que inicializa algunos atributos de la placa, con vehículo.
     *
     * @param numero el número de placa
     * @param fechaEmision la fecha en que se emitió la placa
     * @param fechaRecepcion la fecha en que se recibió la placa
     * @param esActivo indica si la placa está activa o no
     * @param vehiculo vehiculo al que le pertenece
     * @param nombrePersona el nombre de la persona a la que pertenece la placa
     * @param costo el costo de la placa
     * @param persona los datos de la persona a la que pertenece la placa
     */
    public Placa(String numero, Calendar fechaEmision, Calendar fechaRecepcion, boolean esActivo, Vehiculo vehiculo, String nombrePersona, Float costo, Persona persona) {
        super(nombrePersona, costo, persona, fechaEmision);
        this.numero = numero;
        this.fechaRecepcion = fechaRecepcion;
        this.esActivo = esActivo;
        this.vehiculo = vehiculo;
    }

    /**
     * Devuelve el número de la placa.
     *
     * @return el número de la placa
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la placa.
     *
     * @param numero el número de la placa
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Devuelve la fecha de recepción de la placa.
     *
     * @return la fecha de recepción de la placa
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     *
     * @param fechaRecepcion la fecha de recepción de la placa
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Devuelve el estado de la placa.
     *
     * @return el estado de la placa
     */
    public boolean isEsActivo() {
        return esActivo;
    }

    /**
     * Establece el estado de la placa.
     *
     * @param esActivo el estado de la placa
     */
    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    /**
     * Método que genera un código hash para la clase Placa.
     *
     * @return el código hash generado
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getId() != null ? this.getId().hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara la igualdad de objetos de la clase Placa.
     *
     * @param object el objeto a comparar
     * @return true si los objetos son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Placa)) {
            return false;
        }
        Placa other = (Placa) object;
        return !((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId())));
    }

    /**
     * Método que devuelve una cadena de texto que representa al objeto
     * Placa.
     *
     * @return la cadena de texto generada
     */
    @Override
    public String toString() {
        return "Placa{" + "numero=" + numero + ", fechaEmision=" + super.getFechaExpedicion() + ", fechaRecepcion=" + fechaRecepcion + ", esActivo=" + esActivo + '}';
    }
}
