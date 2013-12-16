/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import java.awt.Color;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import subbvasalud.controllers.EditSocioController;
import subbvasalud.models.Banco;
import subbvasalud.models.Socio;
import subbvasalud.models.TipoCuenta;

/**
 *
 * @author damage
 */
public class EditSocio extends javax.swing.JDialog {

    EditSocioController editController;
    Socio s;
    LinkedList<Banco> listBancos;
    ArrayList<TipoCuenta> listTipoCuenta;
    static int id;
    static Frame padre;

    /**
     * Creates new form NewSocio
     *
     * @param parent
     * @param modal
     */
    public EditSocio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        editController = new EditSocioController();
        s = editController.getSocio(id);
        initComponents();
        listBancos = editController.fillBancoComboBox(bancoComboBox, s.getBancoSocio());
        listTipoCuenta = viewUtils.fillTipoCuentaComBox(accounTypeComboBox);
        rutTextField.setText(s.getRutSocio() + "");
        nameTextField.setText(s.getNombreSocio());
        accounTypeComboBox.setSelectedItem(viewUtils.getTipoCuentaName(s.getTipoCuentaSocio()));
        accountTextField.setText(s.getCuentaBancariaSocio());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newSociosPanel = new javax.swing.JPanel();
        rutSociosLabel = new javax.swing.JLabel();
        nombreSociosLabel = new javax.swing.JLabel();
        accountSociosLabel = new javax.swing.JLabel();
        accountTypeSociosLabel = new javax.swing.JLabel();
        accounTypeComboBox = new javax.swing.JComboBox();
        accountTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        rutTextField = new javax.swing.JTextField();
        cancelSociosButton = new javax.swing.JButton();
        saveSociosButton = new javax.swing.JButton();
        bancoNewSociosLabel = new javax.swing.JLabel();
        bancoComboBox = new javax.swing.JComboBox();
        mandatoryFieldsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Socio");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        newSociosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar socio"));

        rutSociosLabel.setText("Rut*");

        nombreSociosLabel.setText("Nombres*");

        accountSociosLabel.setText("N° Cuenta");

        accountTypeSociosLabel.setText("Tipo Cuenta");

        accounTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione un tipo de cuenta>" }));

        accountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                accountTextFieldKeyTyped(evt);
            }
        });

        nameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameTextFieldKeyTyped(evt);
            }
        });

        rutTextField.setColumns(9);
        rutTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        rutTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rutTextFieldKeyTyped(evt);
            }
        });

        cancelSociosButton.setText("Cancelar");
        cancelSociosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelSociosButtonActionPerformed(evt);
            }
        });

        saveSociosButton.setText("Guardar");
        saveSociosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSociosButtonActionPerformed(evt);
            }
        });

        bancoNewSociosLabel.setText("Banco");

        bancoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione un Banco>" }));

        mandatoryFieldsLabel.setText("* Campos obligatorios");

        javax.swing.GroupLayout newSociosPanelLayout = new javax.swing.GroupLayout(newSociosPanel);
        newSociosPanel.setLayout(newSociosPanelLayout);
        newSociosPanelLayout.setHorizontalGroup(
            newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSociosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newSociosPanelLayout.createSequentialGroup()
                        .addComponent(mandatoryFieldsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveSociosButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelSociosButton))
                    .addGroup(newSociosPanelLayout.createSequentialGroup()
                        .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountSociosLabel)
                            .addComponent(nombreSociosLabel)
                            .addComponent(rutSociosLabel)
                            .addComponent(bancoNewSociosLabel)
                            .addComponent(accountTypeSociosLabel))
                        .addGap(18, 18, 18)
                        .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accountTextField)
                            .addComponent(bancoComboBox, 0, 250, Short.MAX_VALUE)
                            .addComponent(nameTextField)
                            .addComponent(accounTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        newSociosPanelLayout.setVerticalGroup(
            newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSociosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutSociosLabel)
                    .addComponent(rutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreSociosLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bancoNewSociosLabel)
                    .addComponent(bancoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountSociosLabel)
                    .addComponent(accountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountTypeSociosLabel)
                    .addComponent(accounTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveSociosButton)
                    .addComponent(cancelSociosButton)
                    .addComponent(mandatoryFieldsLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rutTextField.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newSociosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newSociosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rutTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutTextFieldKeyTyped
        rutTextField.setBackground(null);
        viewUtils.onlyRutNumbers(evt, rutTextField, 9);
    }//GEN-LAST:event_rutTextFieldKeyTyped

    private void nameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyTyped
        nameTextField.setBackground(null);
        viewUtils.onlyLetters(evt, nameTextField);
    }//GEN-LAST:event_nameTextFieldKeyTyped

    private void accountTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountTextFieldKeyTyped
        viewUtils.onlyRutNumbers(evt, rutTextField, 20);
    }//GEN-LAST:event_accountTextFieldKeyTyped

    private void saveSociosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSociosButtonActionPerformed
        if (!editController.validateNullMainFields(rutTextField, nameTextField)) {
            if (!viewUtils.validaRut(rutTextField.getText())) {
                rutTextField.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "El rut ingresado no es correcto", "Rut inválido", WIDTH);
            } else {
                int banco = -1;
                for (Banco b : listBancos) {
                    banco = b.getNombreBanco().equals((String) bancoComboBox.getSelectedItem()) ? b.getIdBanco() : banco;
                }
                int tipo = -1;
                for (TipoCuenta tc : listTipoCuenta) {
                    tipo = tc.getNombreCuenta().equals((String) accounTypeComboBox.getSelectedItem()) ? tc.getIdCuenta() : tipo;
                }
                s.setRutSocio(Integer.parseInt(rutTextField.getText()));
                s.setNombreSocio(nameTextField.getText());
                s.setBancoSocio(banco);
                s.setCuentaBancariaSocio(accountTextField.getText());
                s.setTipoCuentaSocio(tipo);
                //Socio so = new Socio(id, Integer.parseInt(rutTextField.getText()), nameTextField.getText(), accountTextField.getText(), tipo, 0, 1, banco);
                editController.editarSocio(s);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Los campos obligatorios no pueden estar vacíos", "Campos vacíos", WIDTH);
        }

    }//GEN-LAST:event_saveSociosButtonActionPerformed

    private void cancelSociosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelSociosButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelSociosButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        id = Integer.parseInt(args[0]);

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                EditSocio dialog = new EditSocio(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox accounTypeComboBox;
    private javax.swing.JLabel accountSociosLabel;
    private javax.swing.JTextField accountTextField;
    private javax.swing.JLabel accountTypeSociosLabel;
    private javax.swing.JComboBox bancoComboBox;
    private javax.swing.JLabel bancoNewSociosLabel;
    private javax.swing.JButton cancelSociosButton;
    private javax.swing.JLabel mandatoryFieldsLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel newSociosPanel;
    private javax.swing.JLabel nombreSociosLabel;
    private javax.swing.JLabel rutSociosLabel;
    private javax.swing.JTextField rutTextField;
    private javax.swing.JButton saveSociosButton;
    // End of variables declaration//GEN-END:variables
}
