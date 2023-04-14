package org.itson.utilidades;

import java.util.Calendar;

/**
 * Clase que representa los parámetros de búsqueda para una consulta.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class ParametrosBusquedaConsultaDTO {

    private String rfc;
    private Integer year;
    private String nombre;
    private Calendar desde;
    private Calendar hasta;
    private String opcionComboBox;

    /**
     * Constructor por omisión.
     */
    public ParametrosBusquedaConsultaDTO() {
    }

    /**
     * Constructor con los campos rfc, year y nombre, filtros para la sección de
     * consultas.
     *
     * @param rfc el RFC a buscar.
     * @param year el año a buscar.
     * @param nombre el nombre a buscar.
     */
    public ParametrosBusquedaConsultaDTO(String rfc, Integer year, String nombre) {
        this.rfc = rfc;
        this.year = year;
        this.nombre = nombre;
    }

    /**
     * Constructor con los campos nombre, desde, hasta y opcionComboBox, filtros
     * para la sección de reportes.
     *
     * @param nombre el nombre a buscar.
     * @param desde la fecha de inicio a buscar.
     * @param hasta la fecha de fin a buscar.
     * @param opcionComboBox la opción seleccionada en el combobox.
     */
    public ParametrosBusquedaConsultaDTO(String nombre, Calendar desde, Calendar hasta, String opcionComboBox) {
        this.nombre = nombre;
        this.desde = desde;
        this.hasta = hasta;
        this.opcionComboBox = opcionComboBox;
    }

    /**
     * Constructor con el campo opcionComboBox.
     *
     * @param opcionComboBox la opción seleccionada en el combobox.
     */
    public ParametrosBusquedaConsultaDTO(String opcionComboBox) {
        this.opcionComboBox = opcionComboBox;
    }

    /**
     * Obtiene el RFC a buscar.
     *
     * @return el RFC a buscar.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC a buscar.
     *
     * @param rfc el RFC a buscar.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el año a buscar.
     *
     * @return el año a buscar.
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Establece el año a buscar.
     *
     * @param year el año a buscar.
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Obtiene el nombre a buscar.
     *
     * @return el nombre a buscar.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre a buscar.
     *
     * @param nombre el nombre a buscar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de inicio a buscar.
     *
     * @return la fecha de inicio a buscar.
     */
    public Calendar getDesde() {
        return desde;
    }

    /**
     * Establece la fecha de inicio a buscar.
     *
     * @param desde la fecha de inicio a buscar.
     */
    public void setDesde(Calendar desde) {
        this.desde = desde;
    }

    /**
     * Obtiene la fecha de fin a buscar.
     *
     * @return la fecha de fin a buscar.
     */
    public Calendar getHasta() {
        return hasta;
    }

    /**
     * Establece la fecha de fin a buscar.
     *
     * @param hasta la fecha de fin a buscar.
     */
    public void setHasta(Calendar hasta) {
        this.hasta = hasta;
    }

    /**
     * Obtiene la opción seleccionada del combobox.
     *
     * @return el texto de la opción
     */
    public String getOpcionComboBox() {
        return opcionComboBox;
    }

    /**
     * Establece la opción del combobox.
     *
     * @param opcionComboBox opción a buscar
     */
    public void setOpcionComboBox(String opcionComboBox) {
        this.opcionComboBox = opcionComboBox;
    }

}
