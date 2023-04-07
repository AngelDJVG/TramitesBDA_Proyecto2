/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Vehiculo;
import org.itson.utilidades.ConfiguracionPaginado;

/**
 *
 * @author wikit
 */
public interface IVehiculo {
    public List<Object[]> consultarActivosPorRFC(String rfc, ConfiguracionPaginado configPaginado);
    public Vehiculo consultarVehiculo(String numSerie);
    public boolean verificarExistencia(String numSerie);
}
