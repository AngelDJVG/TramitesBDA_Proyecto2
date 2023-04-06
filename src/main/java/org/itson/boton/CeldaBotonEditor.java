/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.boton;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import org.itson.vista.FrmHistorial;

/**
 *
 * @author wikit
 */
public class CeldaBotonEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton boton;

    public CeldaBotonEditor(JFrame frame) {
        boton = new JButton();
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setText("🔍︎");
        boton.setBackground(new Color(159, 34, 65));
        boton.setForeground(Color.WHITE);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Buscando");
                new FrmHistorial().setVisible(true);
                frame.dispose();
            }
        });
    }

    public Object getCellEditorValue() {
        return null;
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return boton;
    }
}
