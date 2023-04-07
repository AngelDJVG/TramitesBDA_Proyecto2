/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.dominio.Placa;
import org.itson.dominio.Vehiculo;

/**
 *
 * @author wikit
 */
public interface IPlaca {
    
    public void agregarPlaca(Placa placa);
    public void actualizarPlaca(Vehiculo vehiculo);
    public boolean verificarExistencia(String placa);
}
