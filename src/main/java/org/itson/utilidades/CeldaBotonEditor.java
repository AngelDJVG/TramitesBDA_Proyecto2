/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.utilidades;

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
import javax.swing.table.TableModel;
import org.itson.dao.TramiteDAO;
import org.itson.dominio.Persona;
import org.itson.interfaces.IPersona;
import org.itson.interfaces.ITramite;
import org.itson.vista.FrmHistorial;
import org.itson.vista.FrmRegistrarPlaca;

/**
 * Clase que se utiliza para crear un editor de celda de una tabla que contiene
 * un botón.
 *
 * @author Ángel Valenzuela, Luis Durán
 */
public class CeldaBotonEditor extends AbstractCellEditor implements TableCellEditor {

    private JButton boton;
    private ITramite tramiteDAO;

    /**
     * Constructor del botón de la tabla de consultas, busca información de una
     * persona con la iformación de la fila del botón.
     *
     * @param frame La ventana padre.
     * @param personaDAO El objeto DAO para la clase Persona.
     * @param tabla La tabla que contiene la celda de la cual se está editando.
     */
    public CeldaBotonEditor(JFrame frame, IPersona personaDAO, JTable tabla) {
        boton = new JButton();
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setText("🔍︎");
        boton.setBackground(new Color(159, 34, 65));
        boton.setForeground(Color.WHITE);
        tramiteDAO = new TramiteDAO();
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Buscando");
                int fila = tabla.convertRowIndexToModel(tabla.getEditingRow());
                TableModel model = tabla.getModel();
                String rfc = model.getValueAt(fila, 0).toString();
                Persona persona = personaDAO.consultarPersona(rfc);
                if (tramiteDAO.consultarTramitesPersona(rfc).isEmpty()) {
                    JOptionPane.showMessageDialog(null, persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno() + ", no cuenta con trámites realizados", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    new FrmHistorial(persona).setVisible(true);
                    frame.dispose();
                }
            }
        });
    }

    /**
     * Constructor del botón de la tabla de vehículos, cambia la placa actual
     * del vehículo seleccionado.
     *
     * @param frame La ventana padre.
     * @param persona Persona a la que le pertenece el vehículo.
     * @param tabla La tabla que contiene la celda de la cual se está editando.
     */
    public CeldaBotonEditor(JFrame frame, Persona persona, JTable tabla) {
        boton = new JButton();
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setText("Cambiar︎");
        boton.setBackground(new Color(159, 34, 65));
        boton.setForeground(Color.WHITE);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = tabla.convertRowIndexToModel(tabla.getEditingRow());
                TableModel model = tabla.getModel();
                String numSerie = model.getValueAt(fila, 0).toString();
                new FrmRegistrarPlaca(persona, false, numSerie).setVisible(true);
                frame.dispose();
            }
        });
    }

    /**
     * Devuelve el valor de la celda que se está editando.
     */
    @Override
    public Object getCellEditorValue() {
        return null;
    }

    /**
     * Devuelve el componente editor de celdas utilizado para editar el valor de
     * la celda en la posición especificada.
     *
     * @param table La tabla a la que pertenece la celda
     * @param value El valor de la celda
     * @param isSelected Verdadero si la celda está seleccionada
     * @param row El índice de la fila de la celda
     * @param column El índice de la columna de la celda
     * @return El componente utilizado para editar la celda
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return boton;
    }
}
