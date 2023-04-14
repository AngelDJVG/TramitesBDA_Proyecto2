/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.boton;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author wikit
 */
public class CeldaBotonRender implements TableCellRenderer {

    private JButton boton;

    public CeldaBotonRender() {
        boton = new JButton();
        boton.setText("🔍︎");
        boton.setBackground(new Color(159, 34, 65));
        boton.setForeground(Color.WHITE);
    }
    
    public CeldaBotonRender(String texto) {
        boton = new JButton();
        boton.setText("Cambiar︎");
        boton.setBackground(new Color(159, 34, 65));
        boton.setForeground(Color.WHITE);
    }


    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return boton;
    }
}