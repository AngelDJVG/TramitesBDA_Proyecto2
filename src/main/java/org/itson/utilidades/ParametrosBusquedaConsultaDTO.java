
package org.itson.utilidades;

import java.util.Calendar;


/**
 *
 * @author Ángel Valenzuela, Luis Duran
 */
public class ParametrosBusquedaConsultaDTO {

    private String rfc;
    private Integer year;
    private String nombre;
    private Calendar desde;
    private Calendar hasta;
    private String opcionComboBox;
    
    public ParametrosBusquedaConsultaDTO() {
    }

    public ParametrosBusquedaConsultaDTO(String rfc, Integer year, String nombre) {
        this.rfc = rfc;
        this.year = year;
        this.nombre = nombre;
    }

    public ParametrosBusquedaConsultaDTO(String nombre, Calendar desde, Calendar hasta, String opcionComboBox) {
        this.nombre = nombre;
        this.desde = desde;
        this.hasta = hasta;
        this.opcionComboBox = opcionComboBox;
    }

    public ParametrosBusquedaConsultaDTO(String opcionComboBox) {
        this.opcionComboBox = opcionComboBox;
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

    public Calendar getDesde() {
        return desde;
    }

    public void setDesde(Calendar desde) {
        this.desde = desde;
    }

    public Calendar getHasta() {
        return hasta;
    }

    public void setHasta(Calendar hasta) {
        this.hasta = hasta;
    }

    public String getOpcionComboBox() {
        return opcionComboBox;
    }

    public void setOpcionComboBox(String opcionComboBox) {
        this.opcionComboBox = opcionComboBox;
    }
    
    
}