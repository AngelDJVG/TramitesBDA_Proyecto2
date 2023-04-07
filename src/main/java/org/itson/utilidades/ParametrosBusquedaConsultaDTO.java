
package org.itson.utilidades;

import java.util.Calendar;

/**
 *
 * @author Ángel Valenzuela, Luis Duran
 */
public class ParametrosBusquedaConsultaDTO {

    private String rfc;
    private Calendar fechaNacimiento;
    private String nombre;
    
    public ParametrosBusquedaConsultaDTO() {
    }

    public ParametrosBusquedaConsultaDTO(String rfc, Calendar fechaNacimiento, String nombre) {
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}