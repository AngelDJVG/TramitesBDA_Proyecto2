/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Persona;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public interface IPersona {
    public void agregarPersona(Persona persona);
    public void actualizarPersona(Persona persona);
    public Persona consultarPersona(String RFC);
    public List<Persona> consultarTodos();
    public List<Persona> consultarPorRFC(String rfc);
}
