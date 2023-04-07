/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.dominio.Automovil;

/**
 *
 * @author wikit
 */
public interface IAutomovil {
    public void agregarAutomovil(Automovil automovil);
    public void actualizarAutomovil(Automovil automovil);
    public void eliminarAutomovil(Automovil automovil);
    public List<Automovil> consultarTodos();
    
}
