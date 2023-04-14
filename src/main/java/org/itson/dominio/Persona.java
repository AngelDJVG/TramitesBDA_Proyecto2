/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;
import javax.persistence.Convert;
import org.itson.utilidades.JPAEncryptor;

/**
 * Esta clase representa un objeto Persona.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
@Entity
@Table(name = "personas")
public class Persona implements Serializable {

    @Id
    @Column(name = "rfc")
    private String rfc;

    @Convert(converter = JPAEncryptor.class)
    @Column(name = "nombre ", nullable = false, length = 200)
    private String nombre;

    @Convert(converter = JPAEncryptor.class)
    @Column(name = "apellidoPaterno ", nullable = false, length = 200)
    private String apellidoPaterno;

    @Convert(converter = JPAEncryptor.class)
    @Column(name = "apellidoMaterno ", nullable = false, length = 200)
    private String apellidoMaterno;

    @Column(name = "telefono ", nullable = false, length = 10)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
    private List<Tramite> tramites = new ArrayList<>();

    @OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
    private List<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Constructor por omisión.
     */
    public Persona() {
    }

    /**
     * Constructor que inicializa todos los atributos de la persona.
     *
     * @param rfc el RFC de la persona.
     * @param nombre el nombre de la persona.
     * @param apellidoPaterno el apellido paterno de la persona.
     * @param apellidoMaterno el apellido materno de la persona.
     * @param telefono el número de teléfono de la persona.
     * @param fechaNacimiento la fecha de nacimiento de la persona.
     */
    public Persona(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor de la clase Persona sin RFC.
     *
     * @param nombre el nombre de la persona.
     * @param apellidoPaterno el apellido paterno de la persona.
     * @param apellidoMaterno el apellido materno de la persona.
     * @param telefono el número de teléfono de la persona.
     * @param fechaNacimiento la fecha de nacimiento de la persona.
     */
    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el RFC de la persona.
     *
     * @return el RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     *
     * @param rfc el RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return el nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre el nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido paterno de la persona.
     *
     * @return el apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     *
     * @param apellidoPaterno el apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Devuelve el apellido materno de la persona.
     *
     * @return el apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona.
     *
     * @param apellidoMaterno el apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Devuelve el número de teléfono de la persona.
     *
     * @return el número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     *
     * @param telefono el número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la fecha de nacimiento de la persona.
     *
     * @return la fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento la fecha de nacimiento de la persona a establecer.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve la lista de trámites realizados por la persona.
     *
     * @return la lista de trámites realizados por la persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

    /**
     * Establece la lista de trámites realizados por la persona.
     *
     * @param tramites la lista de trámites realizados por la persona a
     * establecer.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    /**
     * Devuelve la lista de vehículos de la persona.
     *
     * @return la lista de vehículos de la persona.
     */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Establece la lista de vehículos de la persona.
     *
     * @param vehiculos la lista de vehículos de la persona a establecer.
     */
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Método que genera un código hash para la clase Persona.
     *
     * @return el código hash generado
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rfc != null ? rfc.hashCode() : 0);
        return hash;
    }

    /**
     * Método que compara la igualdad de objetos de la clase Persona.
     *
     * @param object el objeto a comparar
     * @return true si los objetos son iguales, false si no lo son
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        return !((this.rfc == null && other.rfc != null) || (this.rfc != null && !this.rfc.equals(other.rfc)));
    }

    /**
     * Método que devuelve una cadena de texto que representa al objeto
     * Persona.
     *
     * @return la cadena de texto generada
     */
    @Override
    public String toString() {
        return "org.itson.dominio.Persona[ id=" + rfc + " ]";
    }

}
