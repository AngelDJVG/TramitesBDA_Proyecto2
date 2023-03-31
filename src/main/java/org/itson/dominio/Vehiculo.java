/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {

    @Id
    @Column(name = "numero_serie", nullable = false, length = 40)
    private String numero;

    @Column(name = "marca", nullable = false, length = 30)
    private String marca;
    
    @Column(name = "linea", nullable = false, length = 30)
    private String linea;
    
    @Column(name = "color", nullable = false, length = 30)
    private String color;
    
    @Column(name = "modelo", nullable = false, length = 30)
    private String modelo;
    
    @ManyToOne
    @JoinColumn(name = "persona_rfc", nullable = false)
    private Persona persona; 
    
    
    public Vehiculo() {
    }

    public Vehiculo(String numero, String marca, String linea, String color, String modelo, Persona persona) {
        this.numero = numero;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.numero, other.numero);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "numero=" + numero + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", persona=" + persona + '}';
    }

    
    
    
}
