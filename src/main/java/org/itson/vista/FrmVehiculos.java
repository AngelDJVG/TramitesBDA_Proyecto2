/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.vista;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.itson.boton.CeldaBotonEditor;
import org.itson.boton.CeldaBotonRender;
import org.itson.dao.AutomovilDAO;
import org.itson.dao.VehiculoDAO;
import org.itson.dominio.Persona;
import org.itson.interfaces.IAutomovil;
import org.itson.interfaces.IVehiculo;

/**
 *
 * @author Ángel De Jesús Valenzuela García
 */
public class FrmVehiculos extends javax.swing.JFrame {

    private Persona persona;
    private IAutomovil automovilDAO;
    private IVehiculo vehiculoDAO;

    /**
     * Creates new form Automoviles
     */
    public FrmVehiculos(Persona persona) {
        initComponents();
        this.persona = persona;
        this.automovilDAO = new AutomovilDAO();
        this.vehiculoDAO = new VehiculoDAO();
        tblVehiculos.getColumnModel().getColumn(2).setCellEditor(new CeldaBotonEditor(this, persona, tblVehiculos));
        tblVehiculos.getColumnModel().getColumn(2).setCellRenderer(new CeldaBotonRender("Cambiar"));
        this.cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAgregarAutomovil = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        cmbPaginas = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVehiculos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnAgregarAutomovil.setBackground(new java.awt.Color(159, 34, 65));
        btnAgregarAutomovil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarAutomovil.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarAutomovil.setText("Agregar");
        btnAgregarAutomovil.setBorderPainted(false);
        btnAgregarAutomovil.setFocusPainted(false);
        btnAgregarAutomovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAutomovilActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(105, 28, 50));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Vehículos y Placas");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnRegresar.setBackground(new java.awt.Color(159, 34, 65));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorderPainted(false);
        btnRegresar.setFocusPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnAnterior.setBackground(new java.awt.Color(159, 34, 65));
        btnAnterior.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("<--");
        btnAnterior.setBorderPainted(false);
        btnAnterior.setFocusPainted(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(159, 34, 65));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("-->");
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setFocusPainted(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        cmbPaginas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));

        tblVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serie", "Placas", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculos.setRowHeight(30);
        tblVehiculos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblVehiculos);
        if (tblVehiculos.getColumnModel().getColumnCount() > 0) {
            tblVehiculos.getColumnModel().getColumn(0).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(1).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(2).setResizable(false);
            tblVehiculos.getColumnModel().getColumn(2).setPreferredWidth(30);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(cmbPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarAutomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAgregarAutomovil, btnRegresar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarAutomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAgregarAutomovil, btnRegresar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new FrmPlaca().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnAgregarAutomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutomovilActionPerformed
        new FrmRegistrarPlaca(persona, true, null).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarAutomovilActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void cargarTabla() {
        List<Object[]> datos = vehiculoDAO.consultarActivosPorRFC(persona.getRfc());
        DefaultTableModel modelo = (DefaultTableModel) tblVehiculos.getModel();
        modelo.setRowCount(0);
        for (Object[] fila : datos) {
            modelo.addRow(fila);
        }
    }
    
//    private void verificarNumSerie(){
//        String numSerie = JOptionPane.showInputDialog(this, "Ingrese el número de placas anteriores:", "Módulo de placas", JOptionPane.QUESTION_MESSAGE);
//        if (numSerie != null) {
//            if (!numSerie.isBlank()) {
//                if (vehiculoDAO.verificarExistencia(numSerie)) {
//                    new FrmRegistrarPlaca(persona, false, numSerie).setVisible(true);
//                    this.dispose();
//                } else {
//                    JOptionPane.showMessageDialog(null, "El vehículo con ese número de serie no se encuentra registrado.\nFavor de dirigirse a la sección AGREGAR.", "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Por favor, ingrese datos en el campo de texto", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAutomovil;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbPaginas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables
}
