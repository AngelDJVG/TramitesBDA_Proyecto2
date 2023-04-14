/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Esta clase representa un objeto Automovil que hereda de la clase Vehiculo.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
@Entity
@Table(name = "automoviles")
@PrimaryKeyJoinColumn(name = "serie_automovil")
public class Automovil extends Vehiculo implements Serializable {

    /**
     * Constructor por omisión.
     */
    public Automovil() {
    }

    /**
     * Constructor de la clase Automovil con parámetros, aplica el constructor
     * de la clase padre.
     *
     * @param numero el número de serie del automóvil
     * @param marca la marca del automóvil
     * @param linea la línea del automóvil
     * @param color el color del automóvil
     * @param modelo el modelo del automóvil
     * @param persona la persona asociada al automóvil
     */
    public Automovil(String numero, String marca, String linea, String color, String modelo, Persona persona) {
        super(numero, marca, linea, color, modelo, persona);
    }

    /**
     * Método que genera un código hash para la clase Automovil.
     *
     * @return el código hash generado
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.getNumero() != null ? this.getNumero().hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara la igualdad de objetos de la clase Automovil.
     *
     * @param object el objeto a comparar
     * @return true si los objetos son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        return !((this.getNumero() == null && other.getNumero() != null) || (this.getNumero() != null && !this.getNumero().equals(other.getNumero())));
    }

    /**
     * Método que devuelve una cadena de texto que representa al objeto
     * Automovil.
     *
     * @return la cadena de texto generada
     */
    @Override
    public String toString() {
        return "Automovil{" + super.getNumero() + '}';
    }

}
