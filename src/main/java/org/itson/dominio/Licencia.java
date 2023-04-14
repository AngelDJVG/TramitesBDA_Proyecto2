/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.itson.enums.EnumTipoLicencia;

/**
 * Esta clase representa un objeto Licencia que hereda de la clase Trámite.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
@Entity
@Table(name = "licencias")
@PrimaryKeyJoinColumn(name = "id_tramite_licencia")
public class Licencia extends Tramite implements Serializable {

    @Column(name = "vigencia", nullable = false)
    private int vigencia;

    @Column(name = "fecha_vencimiento", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fechaVencimiento;

    @Column(name = "tipo", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private EnumTipoLicencia tipo;

    /**
     * Constructor por omisión.
     */
    public Licencia() {
    }

    /**
     * Constructor que inicializa los atributos de la licencia de su clase
     * padre.
     *
     * @param nombrePersona Nombre de la persona que solicita la licencia.
     * @param costo Costo de la licencia.
     * @param persona Persona que solicita la licencia.
     * @param fechaExpedicion Fecha en que se expidió la licencia.
     */
    public Licencia(String nombrePersona, Float costo, Persona persona, Calendar fechaExpedicion) {
        super(nombrePersona, costo, persona, fechaExpedicion);
    }

    /**
     * Constructor que inicializa todos los atributos de la licencia.
     *
     * @param nombrePersona Nombre de la persona que solicita la licencia.
     * @param costo Costo de la licencia.
     * @param persona Persona que solicita la licencia.
     * @param vigencia Número de años de vigencia de la licencia.
     * @param fechaExpedicion Fecha en que se expidió la licencia.
     * @param fechaVencimiento Fecha de vencimiento de la licencia.
     * @param tipo Tipo de licencia (normal o discapacitado).
     */
    public Licencia(String nombrePersona, Float costo, Persona persona, int vigencia, Calendar fechaExpedicion, Calendar fechaVencimiento, EnumTipoLicencia tipo) {
        super(nombrePersona, costo, persona, fechaExpedicion);
        this.vigencia = vigencia;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;
    }

    /**
     * Constructor que inicializa algunos atributos de la licencia.
     *
     * @param vigencia Número de años de vigencia de la licencia.
     * @param fechaExpedicion Fecha en que se expidió la licencia.
     * @param tipo Tipo de licencia (normal o discapacitado).
     * @param nombrePersona Nombre de la persona que solicita la licencia.
     * @param costo Costo de la licencia.
     * @param persona Persona que solicita la licencia.
     */
    public Licencia(int vigencia, Calendar fechaExpedicion, EnumTipoLicencia tipo, String nombrePersona, Float costo, Persona persona) {
        super(nombrePersona, costo, persona, fechaExpedicion);
        this.vigencia = vigencia;
        this.tipo = tipo;
    }

    /**
     * Devuelve la vigencia de la licencia.
     *
     * @return la vigencia de la licencia
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la licencia.
     *
     * @param vigencia la nueva vigencia de la licencia
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Devuelve la fecha de vencimiento de la licencia.
     *
     * @return la fecha de vencimiento de la licencia
     */
    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Establece la fecha de vencimiento de la licencia.
     *
     * @param fechaVencimiento la nueva fecha de vencimiento de la licencia
     */
    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Devuelve el tipo de la licencia.
     *
     * @return el tipo de la licencia
     */
    public EnumTipoLicencia getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de la licencia.
     *
     * @param tipo el nuevo tipo de la licencia
     */
    public void setTipo(EnumTipoLicencia tipo) {
        this.tipo = tipo;
    }

    /**
     * Método que genera un código hash para la clase Licencia.
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
     * Método que compara la igualdad de objetos de la clase Licencia.
     *
     * @param object el objeto a comparar
     * @return true si los objetos son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        return !((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId())));
    }

    /**
     * Método que devuelve una cadena de texto que representa al objeto
     * Licencia.
     *
     * @return la cadena de texto generada
     */
    @Override
    public String toString() {
        return "Licencia{" + "vigencia=" + vigencia + ", fechaExpedicion=" + super.getFechaExpedicion() + ", fechaVencimiento=" + fechaVencimiento + ", tipo=" + tipo + '}';
    }

}
