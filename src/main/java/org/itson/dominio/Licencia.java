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
 *
 * @author Ángel De Jesús Valenzuela García
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

    public Licencia() {
    }

    public Licencia(String nombrePersona, Float costo, Persona persona, Calendar fechaExpedicion) {
        super(nombrePersona, costo, persona,fechaExpedicion);
    }

    public Licencia(String nombrePersona, Float costo, Persona persona, int vigencia, Calendar fechaExpedicion, Calendar fechaVencimiento, EnumTipoLicencia tipo) {
        super(nombrePersona, costo, persona,fechaExpedicion);
        this.vigencia = vigencia;
        this.fechaVencimiento = fechaVencimiento;
        this.tipo = tipo;
    }

    public Licencia(int vigencia, Calendar fechaExpedicion, EnumTipoLicencia tipo, String nombrePersona, Float costo, Persona persona) {
        super(nombrePersona, costo, persona,fechaExpedicion);
        this.vigencia = vigencia;
        this.tipo = tipo;
    }
    
    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }


    public Calendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Calendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public EnumTipoLicencia getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipoLicencia tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof Licencia)) {
            return false;
        }
        Licencia other = (Licencia) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Licencia{" + "vigencia=" + vigencia + ", fechaExpedicion=" + super.getFechaExpedicion() + ", fechaVencimiento=" + fechaVencimiento + ", tipo=" + tipo + '}';
    }

    
    
}
