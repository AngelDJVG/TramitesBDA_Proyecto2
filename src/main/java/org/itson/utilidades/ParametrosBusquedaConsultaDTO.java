
package org.itson.utilidades;


/**
 *
 * @author Ángel Valenzuela, Luis Duran
 */
public class ParametrosBusquedaConsultaDTO {

    private String rfc;
    private Integer year;
    private String nombre;
    
    public ParametrosBusquedaConsultaDTO() {
    }

    public ParametrosBusquedaConsultaDTO(String rfc, Integer year, String nombre) {
        this.rfc = rfc;
        this.year = year;
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    } 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}