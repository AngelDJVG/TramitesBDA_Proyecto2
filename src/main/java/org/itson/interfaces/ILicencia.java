/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public interface ILicencia {
    public void agregarLicencia(Licencia licencia);
    public void actualizarLicencia(Licencia licencia);
    public void eliminarLicencia(Licencia licencia);
    public List<Licencia> consultarTodos();
    public Licencia consultarLicenciaPersona(String rfc);
}
