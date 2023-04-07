/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.vista;

import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.itson.boton.CeldaBotonEditor;
import org.itson.boton.CeldaBotonRender;
import org.itson.dao.PersonaDAO;
import org.itson.dominio.Persona;
import org.itson.interfaces.IPersona;
import org.itson.utilidades.ConfiguracionPaginado;
import org.itson.utilidades.ParametrosBusquedaConsultaDTO;

/**
 *
 * @author LoanWeefos
 */
public class FrmConsulta extends javax.swing.JFrame {
    
    private ParametrosBusquedaConsultaDTO params;
    private List<Persona> listaPersonas;
    private IPersona personaDAO;
    private EntityManager entityManager;
    private Persona persona;
    private ConfiguracionPaginado configPaginado;
    /**
     * Creates new form consultas
     */
    public FrmConsulta() {
        initComponents();
        params = new ParametrosBusquedaConsultaDTO();
        listaPersonas = new ArrayList<>();
        personaDAO = new PersonaDAO();
        tblConsultas.getColumnModel().getColumn(3).setCellEditor(new CeldaBotonEditor(this,personaDAO, tblConsultas));
        tblConsultas.getColumnModel().getColumn(3).setCellRenderer(new CeldaBotonRender());
        configPaginado = new ConfiguracionPaginado();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblBuscarPersona = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtCurp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsultas = new javax.swing.JTable();
        lblCurp = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblAnioNacimiento = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        cmbPaginas = new javax.swing.JComboBox<>();
        txtYear = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Módulo de consultas");
        lblTitulo.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(105, 28, 50));
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblBuscarPersona.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBuscarPersona.setText("Buscar persona");
        lblBuscarPersona.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblBuscarPersona.setForeground(new java.awt.Color(105, 28, 50));

        btnBuscar.setText("Buscar");
        btnBuscar.setBackground(new java.awt.Color(159, 34, 65));
        btnBuscar.setBorderPainted(false);
        btnBuscar.setFocusPainted(false);
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.setBackground(new java.awt.Color(159, 34, 65));
        btnRegresar.setBorderPainted(false);
        btnRegresar.setFocusPainted(false);
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tblConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RFC", "Nombre", "Fecha de nacimiento", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblConsultas.setRowHeight(30);
        tblConsultas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblConsultas);
        if (tblConsultas.getColumnModel().getColumnCount() > 0) {
            tblConsultas.getColumnModel().getColumn(0).setResizable(false);
            tblConsultas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblConsultas.getColumnModel().getColumn(1).setResizable(false);
            tblConsultas.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblConsultas.getColumnModel().getColumn(2).setResizable(false);
            tblConsultas.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblConsultas.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        lblCurp.setText("RFC:");
        lblCurp.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblCurp.setForeground(new java.awt.Color(105, 28, 50));

        lblNombre.setText("Nombre:");
        lblNombre.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(105, 28, 50));

        lblAnioNacimiento.setText("Año de nacimiento:");
        lblAnioNacimiento.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblAnioNacimiento.setForeground(new java.awt.Color(105, 28, 50));

        btnAnterior.setText("<--");
        btnAnterior.setBackground(new java.awt.Color(159, 34, 65));
        btnAnterior.setBorderPainted(false);
        btnAnterior.setEnabled(false);
        btnAnterior.setFocusPainted(false);
        btnAnterior.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setText("-->");
        btnSiguiente.setBackground(new java.awt.Color(159, 34, 65));
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setEnabled(false);
        btnSiguiente.setFocusPainted(false);
        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        cmbPaginas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));
        cmbPaginas.setEnabled(false);
        cmbPaginas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPaginasItemStateChanged(evt);
            }
        });
        cmbPaginas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaginasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBuscarPersona, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblAnioNacimiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                    .addComponent(txtCurp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtYear, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(lblCurp, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(cmbPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBuscarPersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurp)
                    .addComponent(txtCurp)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAnioNacimiento)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new FrmPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        retrocederPagina();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        avanzarPagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void cmbPaginasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaginasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPaginasActionPerformed

    private void cmbPaginasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPaginasItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementosPorPagina = Integer.parseInt((String) evt.getItem());
            int numeroPagina = 0;
            this.configPaginado.setElementosPorPagina(elementosPorPagina);   
            this.configPaginado.setNumeroPagina(numeroPagina);
            actualizarTabla();
        }
    }//GEN-LAST:event_cmbPaginasItemStateChanged

    private void actualizarTabla(){
        validacionesCampos();
    }
    
    private void validacionesCampos() {
        
        if (txtCurp.getText().isBlank() && txtNombre.getText().isBlank() && txtYear.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "No deje los campos de texto vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!txtCurp.getText().isBlank()) {
                params.setRfc(txtCurp.getText());
            }
            if (!txtYear.getText().isBlank()) {
                params.setYear(Integer.valueOf(txtYear.getText()));
            }
            if (!txtNombre.getText().isBlank()) {
                params.setNombre(txtNombre.getText());
            }
            listaPersonas = personaDAO.consultarPorParametros(params,configPaginado);
            btnAnterior.setEnabled(true);
            btnSiguiente.setEnabled(true);
            cmbPaginas.setEnabled(true);
            cargarTablaPersonas();
        }
    }

    /**
     * Este método carga y recarga la tabla de  personas
     */
    private void cargarTablaPersonas() {       
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblConsultas.getModel();
        modeloTabla.setRowCount(0);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        for (Persona p : listaPersonas) {
            Object[] fila = {p.getRfc(),(p.getNombre()+" "+p.getApellidoPaterno()+" "+p.getApellidoMaterno()),formatoFecha.format(p.getFechaNacimiento().getTime())};
            modeloTabla.addRow(fila);
        }
        params = new ParametrosBusquedaConsultaDTO();
    }
    
    private void avanzarPagina(){
        configPaginado.avanzarPagina();
        actualizarTabla();
    }
    private void retrocederPagina(){
        configPaginado.retrocederPagina();
        actualizarTabla();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbPaginas;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAnioNacimiento;
    private javax.swing.JLabel lblBuscarPersona;
    private javax.swing.JLabel lblCurp;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblConsultas;
    private javax.swing.JTextField txtCurp;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
