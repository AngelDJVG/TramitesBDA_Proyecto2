/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.itson.vista;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import org.itson.dao.PersonaDAO;
import org.itson.dao.PlacaDAO;
import org.itson.dao.AutomovilDAO;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.interfaces.IPersona;
import org.itson.interfaces.IPlaca;
import org.apache.commons.lang3.RandomStringUtils;
import org.itson.dao.VehiculoDAO;
import org.itson.dominio.Automovil;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;
import org.itson.enums.EnumCostosPlacas;
import org.itson.interfaces.IAutomovil;
import org.itson.interfaces.IVehiculo;

/**
 * Esta clase se encarga de capturar datos para registrar una placa.
 * 
 * @author Ángel Valenzuela, Luis Duran
 */
public class FrmRegistrarPlaca extends javax.swing.JFrame {

    private Persona persona;
    private IAutomovil automovilDAO;
    private IVehiculo vehiculoDAO;
    private IPlaca placaDAO;
    private IPersona personaDAO;
    private boolean esNuevo;
    private String numSerie;

    /**
     * Método constructor que inicializa atributos.
     * @param persona Persona a la cual se le va a registrar una placa.
     * @param esNuevo Booleano que indica si la placa es nueva o usada.
     * @param numSerie Número de serie del automóvil.
     */
    public FrmRegistrarPlaca(Persona persona, Boolean esNuevo, String numSerie) {
        initComponents();
        this.esNuevo = esNuevo;
        this.numSerie = numSerie;
        this.vehiculoDAO = new VehiculoDAO();
        this.cambiarPorTipo();
        this.persona = persona;
        this.automovilDAO = new AutomovilDAO();
        this.placaDAO = new PlacaDAO();
        this.personaDAO = new PersonaDAO();
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
        lblRegistrar = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblMarca = new javax.swing.JLabel();
        lblSerie = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblLinea = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        lblColor = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        lblModelo = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtSerie = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("Yu Gothic UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(105, 28, 50));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Módulo de placas");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblRegistrar.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblRegistrar.setForeground(new java.awt.Color(105, 28, 50));
        lblRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegistrar.setText("Registrar vehículo y generar placas");

        lblCosto.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(105, 28, 50));
        lblCosto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCosto.setText("Costo: $");

        lblTotal.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(105, 28, 50));

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

        lblMarca.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(105, 28, 50));
        lblMarca.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMarca.setText("Marca:");

        lblSerie.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblSerie.setForeground(new java.awt.Color(105, 28, 50));
        lblSerie.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSerie.setText("Serie:");

        txtMarca.setToolTipText("");
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });

        lblLinea.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblLinea.setForeground(new java.awt.Color(105, 28, 50));
        lblLinea.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLinea.setText("Línea:");

        txtLinea.setToolTipText("");
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLineaKeyTyped(evt);
            }
        });

        lblColor.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblColor.setForeground(new java.awt.Color(105, 28, 50));
        lblColor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblColor.setText("Color:");

        txtColor.setToolTipText("");
        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });

        lblModelo.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblModelo.setForeground(new java.awt.Color(105, 28, 50));
        lblModelo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblModelo.setText("Modelo:");

        txtModelo.setToolTipText("");
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });

        txtSerie.setToolTipText("");
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerieKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblLinea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtModelo)
                                    .addComponent(txtSerie)
                                    .addComponent(txtLinea)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                                    .addComponent(lblColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lblCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addComponent(lblRegistrar)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSerie)
                    .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinea)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblColor)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        new FrmVehiculos(persona).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
    
    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de registrar.
     * Manda a llamar varios métodos para verificar si se puede registrar la placa o cambiar placa.
     * @param evt El objeto ActionEvent que representa el evento del botón de registrar.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (esNuevo) {
            if (verificarCamposVacios()) {
                JOptionPane.showMessageDialog(null, "No deje ningún campo vacio", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (vehiculoDAO.verificarExistencia(extraerDatosFormulario().getNumero())) {
                    JOptionPane.showMessageDialog(null, "El vehículo con ese número de serie ya se encuentra registrado.\nFavor de dirigirse a la sección CAMBIAR PLACA.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    guardar();
                    personaDAO.actualizarPersona(persona);
                    JOptionPane.showMessageDialog(null, "Se han tramitado las placas y registrado el vehículo correctamente");
                    this.dispose();
                    new FrmVehiculos(persona).setVisible(true);
                }
            }

        } else {
            Vehiculo vehiculo = vehiculoDAO.consultarVehiculo(numSerie);
            placaDAO.actualizarPlaca(vehiculo);
            guardar();
            personaDAO.actualizarPersona(persona);
            JOptionPane.showMessageDialog(null, "Se han cambiado las placas correctamente");
            this.dispose();
            new FrmVehiculos(persona).setVisible(true);
        }

    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    /**
     * Método de evento que limita al usuario a que no escriba caracteres especiales ni números y a un máximo de 30 caracteres.
     * @param evt El objeto KeyEvent que representa el evento de tecla presionada.
     */
    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }else if (txtColor.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtColorKeyTyped
    
    /**
     * Método de evento que limita al usuario a que no escriba caracteres especiales y a un máximo de 6 caracteres.
     * @param evt El objeto KeyEvent que representa el evento de tecla presionada.
     */
    private void txtSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        } else if (txtSerie.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSerieKeyTyped
    
    /**
     * Método de evento que limita al usuario a que no escriba caracteres especiales y a un máximo de 30 caracteres.
     * @param evt El objeto KeyEvent que representa el evento de tecla presionada.
     */
    private void txtLineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }else if (txtLinea.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLineaKeyTyped

    /**
     * Método de evento que limita al usuario a que no escriba caracteres especiales y a un máximo de 30 caracteres.
     * @param evt El objeto KeyEvent que representa el evento de tecla presionada.
     */
    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }else if (txtModelo.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtModeloKeyTyped

    /**
     * Método de evento que limita al usuario a que no escriba caracteres especiales y a un máximo de 30 caracteres.
     * @param evt El objeto KeyEvent que representa el evento de tecla presionada.
     */
    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            evt.consume();
        }else if (txtMarca.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMarcaKeyTyped
    
    /**
     * Método que valida si los campos de texto están vacios.
     * @return Verdadero si hay algún campo vacio, falso en caso contrario.
     */
    private boolean verificarCamposVacios() {
        return txtSerie.getText().isBlank() || txtModelo.getText().isBlank() || txtColor.getText().isBlank() || txtLinea.getText().isEmpty() || txtMarca.getText().isBlank();
    }
    
    /**
     * Método que genera números de placa y verifica si no existe otro número de palca igual.
     * @return El número de placa.
     */
    private String generarNumPlaca() {
        String numPlaca = RandomStringUtils.randomAlphabetic(3).toUpperCase() + "-" + RandomStringUtils.randomNumeric(3);
        if (placaDAO.verificarExistencia(numPlaca)) {
            return generarNumPlaca();
        } else {
            return numPlaca;
        }
    }
    
    /**
     * Método que verifica si la placa se va a registrar o cambiar. 
     * Si es nueva, se activan los campos de texto para capturar datos del vehiculo.
     * Si ya existe, se desactivan los campos de texto y muestran los datos del vehiculo.
     */
    private void cambiarPorTipo() {
        if (esNuevo) {
            lblTotal.setText(String.valueOf(EnumCostosPlacas.NUEVO.getCosto()));
        } else {
            lblTotal.setText(String.valueOf(EnumCostosPlacas.USADO.getCosto()));
            lblRegistrar.setText("Cambiar placas");
            Vehiculo vehiculo = vehiculoDAO.consultarVehiculo(numSerie);
            txtSerie.setText(vehiculo.getNumero());
            txtLinea.setText(vehiculo.getLinea());
            txtModelo.setText(vehiculo.getModelo());
            txtMarca.setText(vehiculo.getMarca());
            txtColor.setText(vehiculo.getColor());

            txtSerie.setEnabled(false);
            txtLinea.setEnabled(false);
            txtModelo.setEnabled(false);
            txtMarca.setEnabled(false);
            txtColor.setEnabled(false);
            btnRegistrar.setText("Cambiar");
        }
    }
    
    /**
     * Método que genera una nueva placa.
     * @return La placa generada.
     */
    private Placa generarPlaca() {
        String nombrePersona = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoMaterno();
        Calendar fechaExpedicion = new GregorianCalendar();
        return new Placa(generarNumPlaca(), fechaExpedicion, fechaExpedicion, true, extraerDatosFormulario(), nombrePersona, Float.valueOf(lblTotal.getText()), persona);

    }
    
    /**
     * Método que extrae los datos de los campos de texto para asignarlos a un objeto de automóvil.
     * @return El objeto de automóvil creado.
     */
    private Automovil extraerDatosFormulario() {
        this.numSerie = txtSerie.getText();
        String linea = txtLinea.getText();
        String modelo = txtModelo.getText();
        String marca = txtMarca.getText();
        String color = txtColor.getText();

        return new Automovil(numSerie, marca, linea, color, modelo, persona);
    }
    
    /**
     * Método que guarda o actualiza un vehiculo en la base de datos.
     */
    private void guardar() {
        if (esNuevo) {
            Automovil automovil = extraerDatosFormulario();
            automovilDAO.agregarAutomovil(automovil);
            List<Vehiculo> listaVehiculo = persona.getVehiculos();
            listaVehiculo.add(automovil);
            persona.setVehiculos(listaVehiculo);
        }

        Placa placa = generarPlaca();
        placaDAO.agregarPlaca(placa);
        List<Tramite> listaTramites = persona.getTramites();
        listaTramites.add(placa);
        persona.setTramites(listaTramites);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblRegistrar;
    private javax.swing.JLabel lblSerie;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtSerie;
    // End of variables declaration//GEN-END:variables
}
