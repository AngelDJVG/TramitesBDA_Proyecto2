/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Licencia;

/**
 * Esta interfaz define los métodos para manejar la entidad Licencia.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public interface ILicencia {

    /**
     * Agrega un nuevo registro de Licencia a la base de datos.
     *
     * @param licencia el objeto Licencia a agregar
     */
    public void agregarLicencia(Licencia licencia);

    /**
     * Actualiza un registro de Licencia en la base de datos.
     *
     * @param licencia el objeto Licencia a actualizar
     */
    public void actualizarLicencia(Licencia licencia);

    /**
     * Elimina un registro de Licencia de la base de datos.
     *
     * @param licencia el objeto Licencia a eliminar
     */
    public void eliminarLicencia(Licencia licencia);

    /**
     * Consulta todos los registros de Licencia en la base de datos.
     *
     * @return una lista de objetos Licencia
     */
    public List<Licencia> consultarTodos();

    /**
     * Consulta la licencia de una persona por su RFC.
     *
     * @param rfc RFC de la persona de la que se quiere consultar la licencia.
     * @return la licencia de la persona
     */
    public Licencia consultarLicenciaPersona(String rfc);
}
