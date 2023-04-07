/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.itson.enums;

/**
 *
 * @author wikit
 */
public enum EnumCostosLicencias {
    UN_ANIO(600.0f, 200.0f),
    DOS_ANIOS(900.0f, 500.0f),
    TRES_ANIOS(1100.0f, 700.0f);
    
    private final Float costoNormal;
    private final Float costoDiscapacitado;
    
    private EnumCostosLicencias(Float costoNormal, Float costoDiscapacitado) {
        this.costoNormal = costoNormal;
        this.costoDiscapacitado = costoDiscapacitado;
    }
    
    public Float getCostoNormal() {
        return costoNormal;
    }
    
    public Float getCostoDiscapacitado() {
        return costoDiscapacitado;
    }
}
