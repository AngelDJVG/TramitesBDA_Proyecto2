/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
@Entity
@Table(name = "automoviles")
@PrimaryKeyJoinColumn(name = "serie_automovil")
public class Automovil extends Vehiculo implements Serializable {

    public Automovil() {
    }

    public Automovil(String numero, String marca, String linea, String color, String modelo, Persona persona) {
        super(numero, marca, linea, color, modelo, persona);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getNumero() != null ? this.getNumero().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.getNumero() == null && other.getNumero() != null) || (this.getNumero() != null && !this.getNumero().equals(other.getNumero()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Automovil{" +super.getNumero()+ '}';
    }

    
    
}
