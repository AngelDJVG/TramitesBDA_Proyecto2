/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.vista;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.itson.dao.TramiteDAO;
import org.itson.dominio.Licencia;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.interfaces.ITramite;
import org.itson.utilidades.ParametrosBusquedaConsultaDTO;

/**
 * Esta clase se encarga de mostrar al usuario formas de consultar trámites a
 * tráves de filtros por datos de una persona y por fechas determinadas, los
 * cuales muestra en un reporte Jasper.
 *
 * @author Ángel Valenzuela, Luis Duran
 */
public class FrmReporte extends javax.swing.JFrame {

    private ITramite tramiteDAO;
    private ParametrosBusquedaConsultaDTO params;

    /**
     * Método constructor que inicializa atributos.
     */
    public FrmReporte() {
        initComponents();
        tramiteDAO = new TramiteDAO();
        configurarDatePicker();
        params = new ParametrosBusquedaConsultaDTO(cbTramite.getSelectedItem().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblTramite = new javax.swing.JLabel();
        lblTramites = new javax.swing.JLabel();
        cbTramite = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        lblPeriodo = new javax.swing.JLabel();
        lblDesde = new javax.swing.JLabel();
        lblHasta = new javax.swing.JLabel();
        dtpDesde = new com.github.lgooddatepicker.components.DatePicker();
        dtpHasta = new com.github.lgooddatepicker.components.DatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Módulo de reportes");
        lblTitulo.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(105, 28, 50));
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblTramite.setText("Tipo de trámite:");
        lblTramite.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTramite.setForeground(new java.awt.Color(105, 28, 50));

        lblTramites.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTramites.setText("Reporte de Trámites Realizados");
        lblTramites.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTramites.setForeground(new java.awt.Color(105, 28, 50));

        cbTramite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Licencia", "Placas" }));
        cbTramite.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTramiteItemStateChanged(evt);
            }
        });

        lblNombre.setText("Nombre:");
        lblNombre.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(105, 28, 50));

        btnImprimir.setText("Generar");
        btnImprimir.setBackground(new java.awt.Color(159, 34, 65));
        btnImprimir.setBorderPainted(false);
        btnImprimir.setFocusPainted(false);
        btnImprimir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(255, 255, 255));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
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

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblPeriodo.setText("Periodo:");
        lblPeriodo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblPeriodo.setForeground(new java.awt.Color(105, 28, 50));

        lblDesde.setText("Desde");
        lblDesde.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblDesde.setForeground(new java.awt.Color(105, 28, 50));

        lblHasta.setText("Hasta");
        lblHasta.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lblHasta.setForeground(new java.awt.Color(105, 28, 50));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(dtpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(dtpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPeriodo)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblTramite)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblDesde))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHasta)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34))
            .addComponent(lblTramites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblTramites)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTramite)
                    .addComponent(cbTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblPeriodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtpDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesde)
                    .addComponent(lblHasta))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de
     * regresar. Cierra la ventana y se abre la ventana anterior.
     *
     * @param evt El objeto ActionEvent que representa el evento del botón de
     * regresar.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        new FrmPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de
     * imprimir. Muestra todos los reportes encontrados a través de los filtros.
     *
     * @param evt El objeto ActionEvent que representa el evento del botón de
     * imprimir.
     */
    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        generarReporte();
    }//GEN-LAST:event_btnImprimirActionPerformed

    /**
     * Método de evento que filtra los tipos de trámites que se eligen por
     * combobox.
     *
     * @param evt El objeto ItemEvent que representa el evento del combobox del
     * tipo de trámite.
     */
    private void cbTramiteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTramiteItemStateChanged
        String opcion = cbTramite.getSelectedItem().toString();
        params.setOpcionComboBox(opcion);
    }//GEN-LAST:event_cbTramiteItemStateChanged

    /**
     * Método de evento que actualiza la vigencia dependiendo del valor que se
     * elige en el combobox.
     *
     * @param evt El objeto ItemEvent que representa el evento del combobox de
     * la vigencia.
     */
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (txtNombre.getText().isBlank() && c == ' ') {
            evt.consume();
        } else if (c == ' ' && txtNombre.getText().charAt(txtNombre.getText().length() - 1) == ' ') {
            evt.consume();
        } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != ' ') {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    /**
     * Método que configura el date picker para que tenga un rango de selección
     * de fechas.
     */
    private void configurarDatePicker() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate minFecha = LocalDate.of(1920, 01, 01);
        dtpDesde.getSettings().setDateRangeLimits(minFecha, fechaActual);
        dtpHasta.getSettings().setDateRangeLimits(minFecha, fechaActual);
        dtpDesde.getComponentDateTextField().setEnabled(false);
        dtpHasta.getComponentDateTextField().setEnabled(false);
    }

    /**
     * Método que manda a llamar a un método para validar campos para consultar
     * la lista de trámites por filtros.
     *
     * @return Lista de trámites encontrados por filtro.
     */
    private List<Tramite> listaPorComboBox() {
        validacionesCampos();
        List<Tramite> lista = this.tramiteDAO.consultarTramitesPorParametros(params);
        params = new ParametrosBusquedaConsultaDTO();
        return lista;
    }

    /**
     * Método que manda a llamar el método que filtra las consultas y genera el
     * reporte en JasperReports.
     */
    private void generarReporte() {
        try {
            List<Map<String, Object>> registros = new ArrayList<>();
            List<Tramite> entities = this.listaPorComboBox();//CONSULTA
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            for (Tramite t : entities) {
                Map<String, Object> registro = new HashMap<>();
                registro.put("fecha_expedicion", formatoFecha.format(t.getFechaExpedicion().getTime()));
                if ("Placas".equals(cbTramite.getSelectedItem().toString())) {
                    if (t instanceof Placa) {
                        registro.put("DTYPE", "Placa");
                        registro.put("nombre_persona", t.getNombrePersona());
                        registro.put("costo", "$" + String.valueOf(t.getCosto()));
                        registros.add(registro);
                    }
                } else if ("Licencia".equals(cbTramite.getSelectedItem().toString())) {
                    if (t instanceof Licencia) {
                        registro.put("DTYPE", "Licencia");
                        registro.put("nombre_persona", t.getNombrePersona());
                        registro.put("costo", "$" + String.valueOf(t.getCosto()));
                        registros.add(registro);
                    }
                } else if ("Todos".equals(cbTramite.getSelectedItem().toString())) {
                    if (t instanceof Placa) {
                        registro.put("DTYPE", "Placa");
                    } else if (t instanceof Licencia) {
                        registro.put("DTYPE", "Licencia");
                    }
                    registro.put("nombre_persona", t.getNombrePersona());
                    registro.put("costo", "$" + String.valueOf(t.getCosto()));
                    registros.add(registro);
                }

            }
            if (registros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron datos para generar el reporte", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JasperCompileManager.compileReportToFile("src/main/resources/Tramites.jrxml", "src/main/resources/Tramites.jasper");

                JRBeanCollectionDataSource datos = new JRBeanCollectionDataSource(registros);
                Map<String, Object> parametros = new HashMap<>();
                JasperPrint informe = JasperFillManager.fillReport("src/main/resources/Tramites.jasper", parametros, datos);
                JasperExportManager.exportReportToPdfFile(informe, "src/main/resources/Tramites.pdf");

                JasperViewer.viewReport(informe, false);
            }
        } catch (JRException e) {
            throw new PersistenceException("Error al generar el reporte: " + e.getMessage());
        }
    }

    /**
     * Método que valida los campos de texto para mandarle los datos al
     * filtrador.
     */
    private void validacionesCampos() {
        if (!txtNombre.getText().isBlank()) {
            params.setNombre(txtNombre.getText());
        }
        if (!dtpDesde.getText().isBlank()) {
            LocalDate fechaDesde = dtpDesde.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.set(fechaDesde.getYear(), fechaDesde.getMonthValue() - 1, fechaDesde.getDayOfMonth(), 0, 0, 0);
            params.setDesde(calendar);
        }
        if (!dtpHasta.getText().isBlank()) {
            LocalDate fechaHasta = dtpHasta.getDate();
            Calendar calendar = Calendar.getInstance();
            calendar.set(fechaHasta.getYear(), fechaHasta.getMonthValue() - 1, fechaHasta.getDayOfMonth(), 23, 59, 59);
            params.setHasta(calendar);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbTramite;
    private com.github.lgooddatepicker.components.DatePicker dtpDesde;
    private com.github.lgooddatepicker.components.DatePicker dtpHasta;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JLabel lblHasta;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTramite;
    private javax.swing.JLabel lblTramites;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
