package org.itson.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
 * Esta clase representa un objeto Vehículo.
 *
 * @author Ángel Valenzuela, Luis Durán
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

    @OneToMany(mappedBy = "vehiculo")
    private List<Placa> placas = new ArrayList<>();

    /**
     * Constructor por omisión.
     */
    public Vehiculo() {
    }

    /**
     * Constructor que inicializa todos los atributos de la licencia.
     *
     * @param numero Número del vehículo.
     * @param marca Marca del vehículo.
     * @param linea Línea del vehículo.
     * @param color Color del vehículo.
     * @param modelo Modelo del vehículo.
     * @param persona Persona a la que le pertenece el vehículo.
     */
    public Vehiculo(String numero, String marca, String linea, String color, String modelo, Persona persona) {
        this.numero = numero;
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.modelo = modelo;
        this.persona = persona;
    }

    /**
     * Devuelve el número del vehículo.
     *
     * @return Número del vehículo.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de serie del vehículo.
     *
     * @param numero Número de serie del vehículo.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Devuelve la marca del vehículo.
     *
     * @return Marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca Marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve la línea del vehículo.
     *
     * @return Línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     *
     * @param linea Línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Devuelve el color del vehículo.
     *
     * @return Color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param color Color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve el modelo del vehículo.
     *
     * @return Modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     *
     * @param modelo Modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve la persona dueña del vehículo.
     *
     * @return Persona dueña del vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona dueña del vehículo.
     *
     * @param persona Persona dueña del vehículo.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve las placas asociadas al vehículo.
     *
     * @return Lista de placas asociadas al vehículo.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Establece las placas asociadas al vehículo.
     *
     * @param placas Lista de placas asociadas al vehículo.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Método que genera un código hash para la clase Vehiculo.
     *
     * @return el código hash generado
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    /**
     * Método que compara la igualdad de objetos de la clase Vehiculo.
     *
     * @param obj el objeto a comparar
     * @return true si los objetos son iguales, false si no lo son
     */
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

    /**
     * Método que devuelve una cadena de texto que representa al objeto
     * Vehiculo.
     *
     * @return la cadena de texto generada
     */
    @Override
    public String toString() {
        return "Vehiculo{" + "numero=" + numero + ", marca=" + marca + ", linea=" + linea + ", color=" + color + ", modelo=" + modelo + ", persona=" + persona + '}';
    }

}
