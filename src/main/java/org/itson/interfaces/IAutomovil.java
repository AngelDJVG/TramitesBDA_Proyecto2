/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Automovil;

/**
 * Esta interfaz define los métodos para manejar la entidad Automovil.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public interface IAutomovil {

    /**
     * Agrega un nuevo registro de Automovil a la base de datos.
     *
     * @param automovil el objeto Automovil a agregar
     */
    public void agregarAutomovil(Automovil automovil);

    /**
     * Actualiza un registro de Automovil en la base de datos.
     *
     * @param automovil el objeto Automovil a actualizar
     */
    public void actualizarAutomovil(Automovil automovil);

    /**
     * Elimina un registro de Automovil de la base de datos.
     *
     * @param automovil el objeto Automovil a eliminar
     */
    public void eliminarAutomovil(Automovil automovil);

    /**
     * Consulta todos los registros de Automovil en la base de datos.
     *
     * @return una lista de objetos Automovil
     */
    public List<Automovil> consultarTodos();

}
