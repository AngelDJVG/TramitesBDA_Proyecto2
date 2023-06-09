
package org.itson.vista;

import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.itson.utilidades.CeldaBotonEditor;
import org.itson.utilidades.CeldaBotonRender;
import org.itson.dao.AutomovilDAO;
import org.itson.dao.VehiculoDAO;
import org.itson.dominio.Persona;
import org.itson.interfaces.IAutomovil;
import org.itson.interfaces.IVehiculo;
import org.itson.utilidades.ConfiguracionPaginado;

/**
 * Esta clase se encarga de mostrar al usuario todos sus automóviles y la
 * posibilidad de registrar uno nuevo o cambiarle las placas a uno usado.
 * 
 * @author Ángel Valenzuela, Luis Duran
 */
public class FrmVehiculos extends javax.swing.JFrame {

    private Persona persona;
    private IAutomovil automovilDAO;
    private IVehiculo vehiculoDAO;
    private ConfiguracionPaginado configPaginado;
    private ConfiguracionPaginado configPaginadoSiguiente;

    /**
     * Método constructor que inicializa los atributos.
     * @param persona Persona la cual se tiene registros de los automóviles.
     */
    public FrmVehiculos(Persona persona) {
        initComponents();
        this.persona = persona;
        this.automovilDAO = new AutomovilDAO();
        this.vehiculoDAO = new VehiculoDAO();
        configPaginado = new ConfiguracionPaginado();
        configPaginadoSiguiente = new ConfiguracionPaginado();
        configPaginadoSiguiente.setNumeroPagina(1);
        tblVehiculos.getColumnModel().getColumn(2).setCellEditor(new CeldaBotonEditor(this, persona, tblVehiculos));
        tblVehiculos.getColumnModel().getColumn(2).setCellRenderer(new CeldaBotonRender("Cambiar"));
        this.cargarTabla();
        this.cargarDatosPersona();
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
        lblFechaP = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblRFC = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblNombreP = new javax.swing.JLabel();
        lblRFCP = new javax.swing.JLabel();
        lblTelefonoP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
        btnAnterior.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(255, 255, 255));
        btnAnterior.setText("<");
        btnAnterior.setBorderPainted(false);
        btnAnterior.setFocusPainted(false);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnSiguiente.setBackground(new java.awt.Color(159, 34, 65));
        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText(">");
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setFocusPainted(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        cmbPaginas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));
        cmbPaginas.setFocusable(false);
        cmbPaginas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPaginasItemStateChanged(evt);
            }
        });

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

        lblFechaP.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFechaP.setForeground(new java.awt.Color(105, 28, 50));
        lblFechaP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblNombre.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(105, 28, 50));
        lblNombre.setText("Nombre:");

        lblRFC.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRFC.setForeground(new java.awt.Color(105, 28, 50));
        lblRFC.setText("RFC:");

        lblFecha.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(105, 28, 50));
        lblFecha.setText("Fecha de nacimiento:");

        lblTelefono.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(105, 28, 50));
        lblTelefono.setText("Telefono:");

        lblNombreP.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNombreP.setForeground(new java.awt.Color(105, 28, 50));
        lblNombreP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblRFCP.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRFCP.setForeground(new java.awt.Color(105, 28, 50));
        lblRFCP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblTelefonoP.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTelefonoP.setForeground(new java.awt.Color(105, 28, 50));
        lblTelefonoP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRFCP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(lblTelefonoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarAutomovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRFC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(cmbPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRFC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRFCP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTelefonoP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarAutomovil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de regresar.
     * Cierra la ventana y se abre la ventana anterior.
     * @param evt El objeto ActionEvent que representa el evento del botón de regresar.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new FrmPlaca().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    /**
     * Método que abre la ventana para registrar una nuevo automóvil con su respectiva placa.
     * @param evt 
     */
    private void btnAgregarAutomovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAutomovilActionPerformed
        new FrmRegistrarPlaca(persona, true, null).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarAutomovilActionPerformed
    
    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de anterior.
     * Manda a llamar a un método que retrocede de página de la tabla de vehículos.
     * @param evt El objeto ActionEvent que representa el evento del botón de anterior.
     */
    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        retrocederPagina();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de siguiente.
     * Manda a llamar a un método que avanza de página de la tabla de vehículos.
     * @param evt El objeto ActionEvent que representa el evento del botón de siguiente.
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        avanzarPagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    /**
     * Método de evento que actualiza la tabla dependiendo del valor que se elige en el combobox.
     * @param evt El objeto ItemEvent que representa el evento del combobox de paginado.
     */
    private void cmbPaginasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPaginasItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementosPorPagina = Integer.parseInt((String) evt.getItem());
            int numeroPagina = 0;
            this.configPaginado.setElementosPorPagina(elementosPorPagina);
            this.configPaginado.setNumeroPagina(numeroPagina);
            this.configPaginadoSiguiente.setElementosPorPagina(elementosPorPagina);
            this.configPaginadoSiguiente.setNumeroPagina(numeroPagina + 1);
            cargarTabla();
        }
    }//GEN-LAST:event_cmbPaginasItemStateChanged

    /**
     * Este método carga y recarga la tabla de vehículos.
     */
    private void cargarTabla() {
        List<Object[]> datos = vehiculoDAO.consultarActivosPorRFC(persona.getRfc(), configPaginado);
        DefaultTableModel modelo = (DefaultTableModel) tblVehiculos.getModel();
        modelo.setRowCount(0);
        for (Object[] fila : datos) {
            modelo.addRow(fila);
        }
        controlarBotones(datos);
    }
    
    /**
     * Método que carga los datos de una persona para ponerlos en labels.
     */
    private void cargarDatosPersona() {     
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        lblNombreP.setText(persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        lblRFCP.setText(persona.getRfc());
        lblFechaP.setText(formatoFecha.format(persona.getFechaNacimiento().getTime()));
        lblTelefonoP.setText(persona.getTelefono());
    }

    /**
     * Método que controla los botones dependiendo si la tabla está vacia.
     * @param listaTramites Lista de vehiculos que contiene la tabla para verificar si está vacia.
     */
    private void controlarBotones(List datos) {
        if (datos.isEmpty()){
            cmbPaginas.setEnabled(false);
        }else{
            cmbPaginas.setEnabled(true);
        }
        if (vehiculoDAO.consultarActivosPorRFC(persona.getRfc(), configPaginadoSiguiente).isEmpty()) {
            btnSiguiente.setEnabled(false);
        } else {
            btnSiguiente.setEnabled(true);
        }
        if (configPaginado.getNumeroPagina() == 0) {
            btnAnterior.setEnabled(false);
        } else {
            btnAnterior.setEnabled(true);
        }
    }

    /**
     * Método que avanza de página en la tabla de vehículos.
     */
    private void avanzarPagina() {
        configPaginado.avanzarPagina();
        configPaginadoSiguiente.avanzarPagina();
        cargarTabla();
    }

    /**
     * Método que retrocede de página en la tabla de vehículos.
     */
    private void retrocederPagina() {
        configPaginado.retrocederPagina();
        configPaginadoSiguiente.retrocederPagina();
        cargarTabla();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAutomovil;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cmbPaginas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaP;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblRFCP;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoP;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblVehiculos;
    // End of variables declaration//GEN-END:variables
}
