/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import com.ezware.oxbow.swingbits.table.filter.TableRowFilterSupport;
import subbvasalud.models.Socio;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.ItemEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import subbvasalud.controllers.AnioController;
import subbvasalud.controllers.PeriodoController;
import subbvasalud.models.Anio;

/**
 *
 * @author damage
 */
public class NewSolicitud extends javax.swing.JDialog {

    LinkedList<Socio> ls;
    Socio s;
    PeriodoController pc;
    AnioController ac;
    LinkedList<Anio> la;

    /**
     * Creates new form NewSolicitud
     */
    public NewSolicitud(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ls = new LinkedList<>();
        pc = new PeriodoController();
        ac = new AnioController();
        s = new Socio();
        ls = s.getAllSocios();
        initComponents();
        TableRowFilterSupport.forTable(periodoTable).searchable(true).apply();
        anioComboBox.removeAllItems();
        la = ac.fillAnioComboBox(anioComboBox);
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(nameSocioNewSolicitudTextField);
        for (Socio so : ls) {
            textAutoAcompleter.addItem(so.getNombreSocio());
        }
        textAutoAcompleter.setMode(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newSolicitudPanel = new javax.swing.JPanel();
        rutSocioNewSolicitudLabel = new javax.swing.JLabel();
        rutSocioNewSolicitudTextField = new javax.swing.JTextField();
        nameSocioNewSolicitudLabel = new javax.swing.JLabel();
        nameSocioNewSolicitudTextField = new javax.swing.JTextField();
        selectPeriodoNewSolicitudLabel = new javax.swing.JLabel();
        selectDateNewSolicitudLabel = new javax.swing.JLabel();
        selectDateNewSolicitudDateChooser = new com.toedter.calendar.JDateChooser();
        insertDocumentoPanel = new javax.swing.JPanel();
        docScrollPanel = new javax.swing.JScrollPane();
        documentTable = new javax.swing.JTable();
        totalReembolsoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        periodoScrollPanel = new javax.swing.JScrollPane();
        periodoTable = new javax.swing.JTable();
        anioComboBox = new javax.swing.JComboBox();
        anioLabel = new javax.swing.JLabel();
        newSolicitudMenuBar = new javax.swing.JMenuBar();
        newDocumentoMenuItem = new javax.swing.JMenu();
        docByCodeMenuItem = new javax.swing.JMenuItem();
        docByTypeMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        newSolicitudPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Solicitud"));

        rutSocioNewSolicitudLabel.setText("Rut Socio");

        rutSocioNewSolicitudTextField.setToolTipText("");
        rutSocioNewSolicitudTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rutSocioNewSolicitudTextFieldKeyTyped(evt);
            }
        });

        nameSocioNewSolicitudLabel.setText("Nombre Socio");

        nameSocioNewSolicitudTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameSocioNewSolicitudTextFieldKeyTyped(evt);
            }
        });

        selectPeriodoNewSolicitudLabel.setText("Periodo");

        selectDateNewSolicitudLabel.setText("Fecha de recepción");

        insertDocumentoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Documentos Ingresados"));

        documentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo", "Porcentaje de reembolso", "Monto de reembolso", "Fecha del documento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        docScrollPanel.setViewportView(documentTable);

        totalReembolsoTextField.setEditable(false);
        totalReembolsoTextField.setToolTipText("");

        jLabel1.setText("Total Reembolso");

        javax.swing.GroupLayout insertDocumentoPanelLayout = new javax.swing.GroupLayout(insertDocumentoPanel);
        insertDocumentoPanel.setLayout(insertDocumentoPanelLayout);
        insertDocumentoPanelLayout.setHorizontalGroup(
            insertDocumentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertDocumentoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(insertDocumentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(docScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(insertDocumentoPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(totalReembolsoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        insertDocumentoPanelLayout.setVerticalGroup(
            insertDocumentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertDocumentoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(docScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(insertDocumentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalReembolsoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jButton2.setText("Cancelar");

        jButton5.setText("Guardar");

        periodoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Periodo"
            }
        ));
        periodoScrollPanel.setViewportView(periodoTable);

        anioComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                anioComboBoxItemStateChanged(evt);
            }
        });

        anioLabel.setText("Año");

        javax.swing.GroupLayout newSolicitudPanelLayout = new javax.swing.GroupLayout(newSolicitudPanel);
        newSolicitudPanel.setLayout(newSolicitudPanelLayout);
        newSolicitudPanelLayout.setHorizontalGroup(
            newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertDocumentoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                        .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameSocioNewSolicitudLabel)
                            .addComponent(rutSocioNewSolicitudLabel)
                            .addComponent(selectPeriodoNewSolicitudLabel)
                            .addComponent(anioLabel))
                        .addGap(18, 18, 18)
                        .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rutSocioNewSolicitudTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                                .addComponent(anioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectDateNewSolicitudLabel)
                                .addGap(18, 18, 18)
                                .addComponent(selectDateNewSolicitudDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nameSocioNewSolicitudTextField)
                            .addComponent(periodoScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newSolicitudPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(9, 9, 9))
        );
        newSolicitudPanelLayout.setVerticalGroup(
            newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutSocioNewSolicitudLabel)
                    .addComponent(rutSocioNewSolicitudTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameSocioNewSolicitudLabel)
                    .addComponent(nameSocioNewSolicitudTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(selectDateNewSolicitudLabel)
                        .addComponent(anioLabel))
                    .addComponent(selectDateNewSolicitudDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                        .addComponent(periodoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(insertDocumentoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton2)))
                    .addComponent(selectPeriodoNewSolicitudLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        newDocumentoMenuItem.setText(" Nuevo Documento");

        docByCodeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        docByCodeMenuItem.setText("Ingresar por código");
        docByCodeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docByCodeMenuItemActionPerformed(evt);
            }
        });
        newDocumentoMenuItem.add(docByCodeMenuItem);

        docByTypeMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        docByTypeMenuItem.setText("Ingresar por tipo");
        docByTypeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docByTypeMenuItemActionPerformed(evt);
            }
        });
        newDocumentoMenuItem.add(docByTypeMenuItem);

        newSolicitudMenuBar.add(newDocumentoMenuItem);

        setJMenuBar(newSolicitudMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newSolicitudPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newSolicitudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void docByCodeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docByCodeMenuItemActionPerformed
        InsertNewDocByCode.main(null);
    }//GEN-LAST:event_docByCodeMenuItemActionPerformed

    private void rutSocioNewSolicitudTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutSocioNewSolicitudTextFieldKeyTyped
        String rut = rutSocioNewSolicitudTextField.getText() + evt.getKeyChar();
        boolean rutValido = ViewUtils.validaRut(rut);
        if (rutValido) {
            Socio socioAux = new Socio();
            socioAux = socioAux.getSociosByRut(Integer.parseInt(rut));
            System.out.println(socioAux.getNombreSocio());
            if ((socioAux.getNombreSocio() != null)) {
                nameSocioNewSolicitudTextField.setText(socioAux.getNombreSocio());
            }
        }
        ViewUtils.onlyRutNumbers(evt, rutSocioNewSolicitudTextField, 9);
    }//GEN-LAST:event_rutSocioNewSolicitudTextFieldKeyTyped

    private void nameSocioNewSolicitudTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameSocioNewSolicitudTextFieldKeyTyped
        String name = nameSocioNewSolicitudTextField.getText();
        for (Socio so : ls) {
            if (so.getNombreSocio().equals(name)) {
                rutSocioNewSolicitudTextField.setText(so.getRutSocio() + "");
            }
        }
    }//GEN-LAST:event_nameSocioNewSolicitudTextFieldKeyTyped

    private void anioComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_anioComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int year = (int) anioComboBox.getSelectedItem();
            if (year != 0) {
                while (((DefaultTableModel) periodoTable.getModel()).getRowCount() != 0) {
                    ((DefaultTableModel) periodoTable.getModel()).removeRow(0);
                }
                pc.mostrarPeriodos((DefaultTableModel) periodoTable.getModel(), year);
            }
        }
    }//GEN-LAST:event_anioComboBoxItemStateChanged

    private void docByTypeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docByTypeMenuItemActionPerformed
        String rutSocio = rutSocioNewSolicitudTextField.getText();
        if (ViewUtils.validaRut(rutSocio)) {
            String[] args = new String[1];
            args[0] = rutSocio;
            InsertNewDocByType.main(args);
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese un rut de socio valido", "Rut Invalido", WIDTH);
        }
    }//GEN-LAST:event_docByTypeMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(NewSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewSolicitud dialog = new NewSolicitud(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox anioComboBox;
    private javax.swing.JLabel anioLabel;
    private javax.swing.JMenuItem docByCodeMenuItem;
    private javax.swing.JMenuItem docByTypeMenuItem;
    private javax.swing.JScrollPane docScrollPanel;
    private javax.swing.JTable documentTable;
    private javax.swing.JPanel insertDocumentoPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nameSocioNewSolicitudLabel;
    private javax.swing.JTextField nameSocioNewSolicitudTextField;
    private javax.swing.JMenu newDocumentoMenuItem;
    private javax.swing.JMenuBar newSolicitudMenuBar;
    private javax.swing.JPanel newSolicitudPanel;
    private javax.swing.JScrollPane periodoScrollPanel;
    private javax.swing.JTable periodoTable;
    private javax.swing.JLabel rutSocioNewSolicitudLabel;
    private javax.swing.JTextField rutSocioNewSolicitudTextField;
    private com.toedter.calendar.JDateChooser selectDateNewSolicitudDateChooser;
    private javax.swing.JLabel selectDateNewSolicitudLabel;
    private javax.swing.JLabel selectPeriodoNewSolicitudLabel;
    private javax.swing.JTextField totalReembolsoTextField;
    // End of variables declaration//GEN-END:variables
}
