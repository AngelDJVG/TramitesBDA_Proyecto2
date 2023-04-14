/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.itson.enums;

/**
 * Esta clase enum representa los costos de la placa.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public enum EnumCostosPlacas {
    NUEVO(1500.0f),
    USADO(1000.0f);

    private final Float costo;

    /**
     * Constructor que inicializa el costo de la placa.
     *
     * @param costo el costo de la placa
     */
    private EnumCostosPlacas(Float costo) {
        this.costo = costo;
    }

    /**
     * Devuelve el costo de la placa.
     *
     * @return el costo de la placa.
     */
    public Float getCosto() {
        return costo;
    }
}
