/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Persona;
import org.itson.utilidades.ConfiguracionPaginado;
import org.itson.utilidades.ParametrosBusquedaConsultaDTO;

/**
 * Esta interfaz define los métodos para manejar la entidad Persona.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public interface IPersona {

    /**
     * Agrega un nuevo registro de Persona a la base de datos.
     *
     * @param persona el objeto Persona a agregar
     */
    public void agregarPersona(Persona persona);

    /**
     * Actualiza un registro de Persona en la base de datos.
     *
     * @param persona el objeto Persona a actualizar
     */
    public void actualizarPersona(Persona persona);

    /**
     * Elimina un registro de Persona de la base de datos.
     *
     * @param persona el objeto Persona a eliminar
     */
    public void eliminarPersona(Persona persona);

    /**
     * Consulta un registro de Persona por su RFC.
     *
     * @param RFC RFC de la persona
     * @return el objeto de Persona encontrada
     */
    public Persona consultarPersona(String RFC);

    /**
     * Consulta todos los registros de Persona en la base de datos.
     *
     * @return una lista de objetos Persona
     */
    public List<Persona> consultarTodos();

    /**
     * Consulta de personas utilizando parámetros de búsqueda y una
     * configuración de paginación.
     *
     * @param params Los parámetros de búsqueda a utilizar
     * @param configPaginado La configuración de paginación a aplicar
     * @return Lista de las personas que cumplen con los parámetros de búsqueda
     */
    public List<Persona> consultarPorParametros(ParametrosBusquedaConsultaDTO params, ConfiguracionPaginado configPaginado);
}
