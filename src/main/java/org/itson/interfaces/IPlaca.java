/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;

/**
 * Esta interfaz define los métodos para manejar la entidad Placa.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public interface IPlaca {

    /**
     * Agrega un nuevo registro de Placa a la base de datos.
     *
     * @param placa el objeto Placa a agregar
     */
    public void agregarPlaca(Placa placa);

    /**
     * Actualiza un registro de Placa en la base de datos a partir de un
     * vehículo registrado.
     *
     * @param vehiculo el objeto Vehiculo al que se le va actualizar la placa.
     */
    public void actualizarPlaca(Vehiculo vehiculo);

    /**
     * Elimina un registro de Placa de la base de datos.
     *
     * @param placa el objeto Placa a eliminar
     */
    public void eliminarPlaca(Placa placa);

    /**
     * Verifica si una placa ya existe en la base de datos.
     *
     * @param placa String que representa el número de la placa a verificar.
     * @return true si la placa ya existe en la base de datos, false en caso
     * contrario.
     */
    public boolean verificarExistencia(String placa);
}
