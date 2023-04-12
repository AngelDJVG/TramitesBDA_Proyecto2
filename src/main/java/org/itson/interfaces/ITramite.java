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
 *
 * @author Ángel De Jesús Valenzuela García
 */
public interface ITramite {
    public void agregarTramite(Tramite tramite);
    public void actualizarTramite(Tramite tramite);
    public void eliminarTramite(Tramite tramite);
    public Tramite consultarTramite(Integer id);
    public List<Tramite> consultarTodos();
    public List<Tramite> consultarTramitesPersona(String rfc, ConfiguracionPaginado configPaginado);
    public List<Tramite> consultarTramitesPersona(String rfc);
    public List<Tramite> consultarTramitesPorParametros(ParametrosBusquedaConsultaDTO params); 
    public List<Licencia> consultarTramitesLicencia(); 
    public List<Placa> consultarTramitesPlacas(); 
}
