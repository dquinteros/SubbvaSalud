/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import java.awt.Color;
import javax.swing.JOptionPane;
import subbvasalud.controllers.AddNewCargaController;
import subbvasalud.controllers.MainMenuController;
import subbvasalud.models.Carga;
import subbvasalud.models.Socio;

/**
 *
 * @author damage
 */
public class NewCarga extends javax.swing.JDialog {

    AddNewCargaController addController;
    MainMenuController mmc;

    /**
     * Creates new form NewCarga
     */
    public NewCarga(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addController = new AddNewCargaController();
        mmc = new MainMenuController();
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newCargasPanel = new javax.swing.JPanel();
        rutNewCargasLabel = new javax.swing.JLabel();
        nombreNewCargasLabel = new javax.swing.JLabel();
        lastnameNewCargasLabel = new javax.swing.JLabel();
        lastnameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        rutTextField = new javax.swing.JTextField();
        cancelNewCargasButton = new javax.swing.JButton();
        aceptNewCargasButton = new javax.swing.JButton();
        mandatoryFieldsLabel = new javax.swing.JLabel();
        rutSocioLabel = new javax.swing.JLabel();
        rutSocioNewCargaTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        newCargasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar carga"));

        rutNewCargasLabel.setText("Rut*");

        nombreNewCargasLabel.setText("Nombres*");

        lastnameNewCargasLabel.setText("Apellidos*");

        lastnameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastnameTextFieldKeyTyped(evt);
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

        cancelNewCargasButton.setText("Cancelar");
        cancelNewCargasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNewCargasButtonActionPerformed(evt);
            }
        });

        aceptNewCargasButton.setText("Aceptar");
        aceptNewCargasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptNewCargasButtonActionPerformed(evt);
            }
        });

        mandatoryFieldsLabel.setText("* Campos obligatorios");

        rutSocioLabel.setText("Rut Socio*");

        rutSocioNewCargaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rutSocioNewCargaTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout newCargasPanelLayout = new javax.swing.GroupLayout(newCargasPanel);
        newCargasPanel.setLayout(newCargasPanelLayout);
        newCargasPanelLayout.setHorizontalGroup(
            newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCargasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newCargasPanelLayout.createSequentialGroup()
                        .addComponent(mandatoryFieldsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(aceptNewCargasButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelNewCargasButton))
                    .addGroup(newCargasPanelLayout.createSequentialGroup()
                        .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastnameNewCargasLabel)
                            .addComponent(nombreNewCargasLabel)
                            .addComponent(rutNewCargasLabel)
                            .addComponent(rutSocioLabel))
                        .addGap(28, 28, 28)
                        .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rutSocioNewCargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(rutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lastnameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(nameTextField)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        newCargasPanelLayout.setVerticalGroup(
            newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newCargasPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutNewCargasLabel)
                    .addComponent(rutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreNewCargasLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameNewCargasLabel)
                    .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutSocioLabel)
                    .addComponent(rutSocioNewCargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(93, 93, 93)
                .addGroup(newCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptNewCargasButton)
                    .addComponent(cancelNewCargasButton)
                    .addComponent(mandatoryFieldsLabel))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newCargasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newCargasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastnameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameTextFieldKeyTyped
        lastnameTextField.setBackground(null);
        viewUtils.onlyLetters(evt, nameTextField, lastnameTextField);
    }//GEN-LAST:event_lastnameTextFieldKeyTyped

    private void nameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextFieldKeyTyped
        nameTextField.setBackground(null);
        viewUtils.onlyLetters(evt, nameTextField, lastnameTextField);
    }//GEN-LAST:event_nameTextFieldKeyTyped

    private void rutTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutTextFieldKeyTyped
        rutTextField.setBackground(null);
        viewUtils.onlyRutNumbers(evt, rutTextField, 9);
    }//GEN-LAST:event_rutTextFieldKeyTyped

    private void cancelNewCargasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNewCargasButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelNewCargasButtonActionPerformed

    private void aceptNewCargasButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptNewCargasButtonActionPerformed
        
        int socio = mmc.getIdSociosByRut(Integer.parseInt(rutSocioNewCargaTextField.getText()));

        if (!addController.validateNullMainFields(rutTextField, nameTextField, lastnameTextField, rutSocioNewCargaTextField)) {
            if (!viewUtils.validaRut(rutTextField.getText())) {
                rutTextField.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "El rut ingresado no es correcto", "Rut inválido", WIDTH);
            } else if (socio == (-1)) {
                JOptionPane.showMessageDialog(this, "El socio con el rut "+rutSocioNewCargaTextField.getText()+" no existe", "Rut Socio no existe", WIDTH);
            } else {
                Carga ca = new Carga(-1, socio, Integer.parseInt(rutTextField.getText()), lastnameTextField.getText() + " " + nameTextField.getText(), 1);
                addController.guardarCarga(ca);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Los campos obligatorios no pueden estar vacíos", "Campos vacíos", WIDTH);
        }
    }//GEN-LAST:event_aceptNewCargasButtonActionPerformed

    private void rutSocioNewCargaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutSocioNewCargaTextFieldKeyTyped
        rutSocioNewCargaTextField.setBackground(null);
        viewUtils.onlyRutNumbers(evt, rutSocioNewCargaTextField, 9);
    }//GEN-LAST:event_rutSocioNewCargaTextFieldKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(NewCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewCarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewCarga dialog = new NewCarga(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptNewCargasButton;
    private javax.swing.JButton cancelNewCargasButton;
    private javax.swing.JLabel lastnameNewCargasLabel;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JLabel mandatoryFieldsLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel newCargasPanel;
    private javax.swing.JLabel nombreNewCargasLabel;
    private javax.swing.JLabel rutNewCargasLabel;
    private javax.swing.JLabel rutSocioLabel;
    private javax.swing.JTextField rutSocioNewCargaTextField;
    private javax.swing.JTextField rutTextField;
    // End of variables declaration//GEN-END:variables
}