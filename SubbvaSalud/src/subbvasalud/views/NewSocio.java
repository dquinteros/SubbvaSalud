/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import java.awt.Color;
import javax.swing.JOptionPane;
import subbvasalud.controllers.AddNewSocio;

/**
 *
 * @author damage
 */
public class NewSocio extends javax.swing.JDialog {

    AddNewSocio addController;

    /**
     * Creates new form NewSocio
     */
    public NewSocio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addController = new AddNewSocio();
        initComponents();
        addController.fillBancoComboBox(bancoComboBox);
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
        rutNewSociosLabel = new javax.swing.JLabel();
        nombreNewSociosLabel = new javax.swing.JLabel();
        lastnameNewSociosLabel = new javax.swing.JLabel();
        accountNewSociosLabel = new javax.swing.JLabel();
        accountTypeNewSociosLabel = new javax.swing.JLabel();
        accounTypeComboBox = new javax.swing.JComboBox();
        accountTextField = new javax.swing.JTextField();
        lastnameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        rutTextField = new javax.swing.JTextField();
        cancelNewSociosButton = new javax.swing.JButton();
        aceptNewSociosButton = new javax.swing.JButton();
        bancoNewSociosLabel = new javax.swing.JLabel();
        bancoComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Socio");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        newSociosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar socio"));

        rutNewSociosLabel.setText("Rut*");

        nombreNewSociosLabel.setText("Nombres*");

        lastnameNewSociosLabel.setText("Apellidos*");

        accountNewSociosLabel.setText("N° Cuenta");

        accountTypeNewSociosLabel.setText("Tipo Cuenta");

        accounTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione un tipo de cuenta>", "Cuenta corriente", "Cuenta de ahorro", "Vale vista", "Cuenta en línea" }));

        accountTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                accountTextFieldKeyTyped(evt);
            }
        });

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

        cancelNewSociosButton.setText("Cancelar");
        cancelNewSociosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNewSociosButtonActionPerformed(evt);
            }
        });

        aceptNewSociosButton.setText("Aceptar");
        aceptNewSociosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptNewSociosButtonActionPerformed(evt);
            }
        });

        bancoNewSociosLabel.setText("Banco");

        bancoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Seleccione un Banco>" }));

        jLabel1.setText("* Campos obligatorios");

        javax.swing.GroupLayout newSociosPanelLayout = new javax.swing.GroupLayout(newSociosPanel);
        newSociosPanel.setLayout(newSociosPanelLayout);
        newSociosPanelLayout.setHorizontalGroup(
            newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSociosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newSociosPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(aceptNewSociosButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelNewSociosButton))
                    .addGroup(newSociosPanelLayout.createSequentialGroup()
                        .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountNewSociosLabel)
                            .addComponent(lastnameNewSociosLabel)
                            .addComponent(nombreNewSociosLabel)
                            .addComponent(rutNewSociosLabel)
                            .addComponent(bancoNewSociosLabel)
                            .addComponent(accountTypeNewSociosLabel))
                        .addGap(18, 18, 18)
                        .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastnameTextField)
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
                    .addComponent(rutNewSociosLabel)
                    .addComponent(rutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreNewSociosLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameNewSociosLabel)
                    .addComponent(lastnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bancoNewSociosLabel)
                    .addComponent(bancoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountNewSociosLabel)
                    .addComponent(accountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountTypeNewSociosLabel)
                    .addComponent(accounTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptNewSociosButton)
                    .addComponent(cancelNewSociosButton)
                    .addComponent(jLabel1))
                .addContainerGap(16, Short.MAX_VALUE))
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
        viewUtils.onlyLetters(evt, nameTextField, lastnameTextField);
    }//GEN-LAST:event_nameTextFieldKeyTyped

    private void lastnameTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameTextFieldKeyTyped
        lastnameTextField.setBackground(null);
        viewUtils.onlyLetters(evt, nameTextField, lastnameTextField);
    }//GEN-LAST:event_lastnameTextFieldKeyTyped

    private void accountTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountTextFieldKeyTyped
        viewUtils.onlyRutNumbers(evt, rutTextField, 20);
    }//GEN-LAST:event_accountTextFieldKeyTyped

    private void aceptNewSociosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptNewSociosButtonActionPerformed
        if (!addController.validateNullMainFields(rutTextField, nameTextField, lastnameTextField)) {
            if (!viewUtils.validaRut(rutTextField.getText())) {
                rutTextField.setBackground(Color.red);
                JOptionPane.showMessageDialog(this, "El rut ingresado no es correcto", "Rut inválido", WIDTH);
            } else {

            }
        }else{
            JOptionPane.showMessageDialog(this, "Los campos obligatorios no pueden estar vacíos", "Campos vacíos", WIDTH);
        }
    }//GEN-LAST:event_aceptNewSociosButtonActionPerformed

    private void cancelNewSociosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNewSociosButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelNewSociosButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewSocio dialog = new NewSocio(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel accountNewSociosLabel;
    private javax.swing.JTextField accountTextField;
    private javax.swing.JLabel accountTypeNewSociosLabel;
    private javax.swing.JButton aceptNewSociosButton;
    private javax.swing.JComboBox bancoComboBox;
    private javax.swing.JLabel bancoNewSociosLabel;
    private javax.swing.JButton cancelNewSociosButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lastnameNewSociosLabel;
    private javax.swing.JTextField lastnameTextField;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel newSociosPanel;
    private javax.swing.JLabel nombreNewSociosLabel;
    private javax.swing.JLabel rutNewSociosLabel;
    private javax.swing.JTextField rutTextField;
    // End of variables declaration//GEN-END:variables
}
