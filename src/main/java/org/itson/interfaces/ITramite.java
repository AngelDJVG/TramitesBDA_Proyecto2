/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Licencia;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.utilidades.ConfiguracionPaginado;
import org.itson.utilidades.ParametrosBusquedaConsultaDTO;

/**
 * Esta interfaz define los métodos para manejar la entidad Tramite.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public interface ITramite {

    /**
     * Agrega un nuevo registro de Tramite a la base de datos.
     *
     * @param tramite el objeto Tramite a agregar
     */
    public void agregarTramite(Tramite tramite);

    /**
     * Actualiza un registro de Tramite en la base de datos.
     *
     * @param tramite el objeto Tramite a actualizar
     */
    public void actualizarTramite(Tramite tramite);

    /**
     * Elimina un registro de Tramite de la base de datos.
     *
     * @param tramite el objeto Tramite a eliminar
     */
    public void eliminarTramite(Tramite tramite);

    /**
     * Consulta todos los registros de Tramite en la base de datos.
     *
     * @return una lista de objetos Tramite
     */
    public List<Tramite> consultarTodos();

    /**
     * Consulta los trámites de una persona por su RFC.
     *
     * @param rfc El RFC de la persona a buscar.
     * @param configPaginado La configuración de paginado.
     * @return Una lista con los trámites de la persona.
     */
    public List<Tramite> consultarTramitesPersona(String rfc, ConfiguracionPaginado configPaginado);

    /**
     * Consulta los trámites de una persona por su RFC.
     *
     * @param rfc El RFC de la persona a buscar.
     * @return Una lista con los trámites de la persona especificada.
     */
    public List<Tramite> consultarTramitesPersona(String rfc);

    /**
     * Consulta los trámites que coinciden con los parámetros.
     *
     * @param params Los parámetros de búsqueda.
     * @return Una lista con los trámites que coinciden con los parámetros
     * especificados.
     */
    public List<Tramite> consultarTramitesPorParametros(ParametrosBusquedaConsultaDTO params);

    /**
     * Consulta los trámites de licencia registrados.
     *
     * @return una lista de objetos Licencia que representa los trámites
     * registrados
     */
    public List<Licencia> consultarTramitesLicencia();

    /**
     * Consulta los trámites de placas registrados.
     *
     * @return una lista de objetos Placa que representa los trámites
     * registrados
     */
    public List<Placa> consultarTramitesPlacas();
}
