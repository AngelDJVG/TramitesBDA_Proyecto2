/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.vista;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dao.LicenciaDAO;
import org.itson.dao.PersonaDAO;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Tramite;
import org.itson.enums.EnumCostosLicencias;
import org.itson.enums.EnumTipoLicencia;
import org.itson.interfaces.ILicencia;
import org.itson.interfaces.IPersona;

/**
 *
 * @author LoanWeefos
 */
public class FrmRegistroLicencia extends javax.swing.JFrame {
    
    private Persona persona;
    private ILicencia licenciaDAO;
    private IPersona personaDAO;
    private float costo;

    /**
     * Creates new form registroLicencias
     *
     * @param persona
     */
    public FrmRegistroLicencia(Persona persona) {
        initComponents();
        this.actualizarCosto();
        this.persona = persona;
        this.licenciaDAO = new LicenciaDAO();
        this.personaDAO = new PersonaDAO();
        this.costo = 600;
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
        lblTitulo = new javax.swing.JLabel();
        lblVigencia = new javax.swing.JLabel();
        lblRegistrar = new javax.swing.JLabel();
        cbVigencia = new javax.swing.JComboBox<>();
        lblDiscapacidad = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        chbDiscapacidad = new javax.swing.JCheckBox();
        lblDatos = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblRFC = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblNombreP = new javax.swing.JLabel();
        lblRFCP = new javax.swing.JLabel();
        lblTelefonoP = new javax.swing.JLabel();
        lblFechaP = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(105, 28, 50));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Módulo de licencias");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblVigencia.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblVigencia.setForeground(new java.awt.Color(105, 28, 50));
        lblVigencia.setText("Vigencia:");

        lblRegistrar.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRegistrar.setForeground(new java.awt.Color(105, 28, 50));
        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrar.setText("Registrar nueva licencia");

        cbVigencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 año", "2 años", "3 años" }));
        cbVigencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVigenciaItemStateChanged(evt);
            }
        });

        lblDiscapacidad.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblDiscapacidad.setForeground(new java.awt.Color(105, 28, 50));
        lblDiscapacidad.setText("Discapacidad");

        lblTotal.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(105, 28, 50));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnRegistrar.setBackground(new java.awt.Color(159, 34, 65));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

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

        chbDiscapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbDiscapacidadActionPerformed(evt);
            }
        });

        lblDatos.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblDatos.setForeground(new java.awt.Color(105, 28, 50));
        lblDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDatos.setText("Datos de la persona");

        lblNombre.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(105, 28, 50));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombre.setText("Nombre:");

        lblRFC.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRFC.setForeground(new java.awt.Color(105, 28, 50));
        lblRFC.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblRFC.setText("RFC:");

        lblFecha.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(105, 28, 50));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFecha.setText("Fecha de nacimiento:");

        lblTelefono.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(105, 28, 50));
        lblTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
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

        lblFechaP.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblFechaP.setForeground(new java.awt.Color(105, 28, 50));
        lblFechaP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRFC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(lblTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreP, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(lblRFCP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTelefonoP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblFechaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblVigencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDiscapacidad)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbDiscapacidad))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11))
            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(lblDatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRFC))
                    .addComponent(lblRFCP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFecha)
                    .addComponent(lblFechaP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTelefono)
                    .addComponent(lblTelefonoP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbDiscapacidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVigencia)
                        .addComponent(cbVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDiscapacidad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

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
        new FrmLicencia().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void cbVigenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVigenciaItemStateChanged
        actualizarCosto();
    }//GEN-LAST:event_cbVigenciaItemStateChanged

    private void chbDiscapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbDiscapacidadActionPerformed
        actualizarCosto();
    }//GEN-LAST:event_chbDiscapacidadActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        guardar();
        personaDAO.actualizarPersona(persona);
        JOptionPane.showMessageDialog(null, "Se ha tramitado la licencia correctamente");
        this.dispose();
        new FrmPrincipal().setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    private Licencia extraerDatosFormulario() {
        String nombrePersona = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
        Calendar fechaExpedicion = new GregorianCalendar();
        
        EnumTipoLicencia tipo;
        if (chbDiscapacidad.isSelected()) {
            tipo = EnumTipoLicencia.DISCAPACITADOS;
        } else {
            tipo = EnumTipoLicencia.NORMAL;
        }
        int vigencia = cbVigencia.getSelectedIndex() + 1;
        
        Calendar fechaVencimiento = new GregorianCalendar();
        fechaVencimiento.setTime(fechaExpedicion.getTime());
        fechaVencimiento.add(Calendar.YEAR, vigencia);
        
        Licencia licencia = new Licencia(nombrePersona, costo, persona, vigencia, fechaExpedicion, fechaVencimiento, tipo);
        return licencia;
    }
    
    private void guardar() {
        Licencia licencia = extraerDatosFormulario();
        licenciaDAO.agregarLicencia(licencia);
        List<Tramite> listaTramites = persona.getTramites();
        listaTramites.add(licencia);
        persona.setTramites(listaTramites);
    }
    
    private void cargarDatosPersona() {     
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        lblNombreP.setText(persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno());
        lblRFCP.setText(persona.getRfc());
        lblFechaP.setText(formatoFecha.format(persona.getFechaNacimiento().getTime()));
        lblTelefonoP.setText(persona.getTelefono());
    }
    
    private void actualizarCosto() {
        if (chbDiscapacidad.isSelected()) {
            if (cbVigencia.getSelectedItem().equals("1 año")) {
                costo = EnumCostosLicencias.UN_ANIO.getCostoDiscapacitado();
            } else if (cbVigencia.getSelectedItem().equals("2 años")) {
                costo = EnumCostosLicencias.DOS_ANIOS.getCostoDiscapacitado();
            } else {
                costo = EnumCostosLicencias.TRES_ANIOS.getCostoDiscapacitado();
            }
        } else {
            if (cbVigencia.getSelectedItem().equals("1 año")) {
                costo = EnumCostosLicencias.UN_ANIO.getCostoNormal();
            } else if (cbVigencia.getSelectedItem().equals("2 años")) {
                costo = EnumCostosLicencias.DOS_ANIOS.getCostoNormal();
            } else {
                costo = EnumCostosLicencias.TRES_ANIOS.getCostoNormal();
            }
        }
        lblTotal.setText("Costo: $" + costo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbVigencia;
    private javax.swing.JCheckBox chbDiscapacidad;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDatos;
    private javax.swing.JLabel lblDiscapacidad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaP;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JLabel lblRFC;
    private javax.swing.JLabel lblRFCP;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoP;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVigencia;
    // End of variables declaration//GEN-END:variables
}
