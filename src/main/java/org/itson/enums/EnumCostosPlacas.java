/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.itson.enums;

/**
 *
 * @author wikit
 */
public enum EnumCostosPlacas {
    NUEVO(1500.0f),
    USADO(1000.0f);
    
    private final Float costo;
    
    private EnumCostosPlacas(Float costo) {
        this.costo = costo;
    }
    
    public Float getCosto() {
        return costo;
    }
}
