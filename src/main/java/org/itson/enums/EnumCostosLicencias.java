/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.itson.enums;

/**
 * Esta clase enum representa los costos de los tipos de licencia.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public enum EnumCostosLicencias {
    UN_ANIO(600.0f, 200.0f),
    DOS_ANIOS(900.0f, 500.0f),
    TRES_ANIOS(1100.0f, 700.0f);

    private final Float costoNormal;
    private final Float costoDiscapacitado;

    /**
     * Constructor que inicializa los costos de la licencia para una persona
     * normal y una persona discapacitada.
     *
     * @param costoNormal el costo de la licencia para una persona sin
     * discapacidad
     * @param costoDiscapacitado el costo de la licencia para una persona con
     * discapacidad
     */
    private EnumCostosLicencias(Float costoNormal, Float costoDiscapacitado) {
        this.costoNormal = costoNormal;
        this.costoDiscapacitado = costoDiscapacitado;
    }

    /**
     * Devuelve el costo de la licencia para una persona sin discapacidad.
     *
     * @return el costo de la licencia para una persona sin discapacidad
     */
    public Float getCostoNormal() {
        return costoNormal;
    }

    /**
     * Devuelve el costo de la licencia para una persona con discapacidad.
     *
     * @return el costo de la licencia para una persona con discapacidad
     */
    public Float getCostoDiscapacitado() {
        return costoDiscapacitado;
    }
}
