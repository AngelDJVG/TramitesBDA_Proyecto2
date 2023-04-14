/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Clase que define un renderizador de celdas para una tabla que muestra
 * botones.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class CeldaBotonRender implements TableCellRenderer {

    private JButton boton;

    /**
     * Constructor que define las propiedades del botón para las consultas.
     */
    public CeldaBotonRender() {
        boton = new JButton();
        boton.setText("🔍︎");
        boton.setBackground(new Color(159, 34, 65));
        boton.setForeground(Color.WHITE);
    }

    /**
     * Constructor que define las propiedades del botón para el cambio de
     * placas.
     *
     * @param texto Texto que va mostar el botón.
     */
    public CeldaBotonRender(String texto) {
        boton = new JButton();
        boton.setText("Cambiar︎");
        boton.setBackground(new Color(159, 34, 65));
        boton.setForeground(Color.WHITE);
    }

    /**
     * Devuelve el componente render de celdas utilizado para renderizar el
     * valor de la celda en la posición especificada.
     *
     * @param table La tabla a la que pertenece la celda
     * @param value El valor de la celda
     * @param isSelected Verdadero si la celda está seleccionada
     * @param hasFocus Verdadero si se tiene focus en el botón
     * @param row El índice de la fila de la celda
     * @param column El índice de la columna de la celda
     * @return El componente utilizado para editar la celda
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return boton;
    }
}
