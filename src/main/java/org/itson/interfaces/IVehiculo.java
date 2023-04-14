/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Vehiculo;
import org.itson.utilidades.ConfiguracionPaginado;

/**
 * Esta interfaz define los métodos para manejar la entidad Vehiculo.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public interface IVehiculo {

    /**
     * Consulta los vehículos de una persona mediante su RFC.
     *
     * @param rfc el RFC de la persona.
     * @param configPaginado la configuración de la página.
     * @return una lista de arreglos de objetos que contiene los números de
     * serie del vehículo y la placa.
     */
    public List<Object[]> consultarActivosPorRFC(String rfc, ConfiguracionPaginado configPaginado);

    /**
     * Consulta un vehículo en la base de datos a partir de su número de serie.
     *
     * @param numSerie el número de serie del vehículo a consultar.
     * @return el vehículo encontrado en la base de datos, null si no existe.
     */
    public Vehiculo consultarVehiculo(String numSerie);

    /**
     * Verifica si existe un vehículo en la base de datos a partir de su número
     * de serie.
     *
     * @param numSerie el número de serie del vehículo a verificar.
     * @return true si existe un vehículo con ese número de serie, false de lo
     * contrario.
     */
    public boolean verificarExistencia(String numSerie);
}
