/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import com.ezware.oxbow.swingbits.table.filter.TableRowFilterSupport;
import subbvasalud.models.Socio;
import java.awt.event.ItemEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import subbvasalud.controllers.AnioController;
import subbvasalud.controllers.PeriodoController;
import subbvasalud.controllers.ReportController;
import subbvasalud.controllers.SolicitudController;
import subbvasalud.models.Anio;
import subbvasalud.models.Periodo;
import subbvasalud.models.SolicitudDeReembolso;

/**
 *
 * @author damage
 */
public class SelectInformeGeneral extends javax.swing.JDialog {

    LinkedList<Socio> ls;
    Socio s;
    PeriodoController pc;
    AnioController ac;
    SolicitudController sc;
    LinkedList<Anio> la;
    int idSol = -1;

    /**
     * Creates new form NewSolicitud
     *
     * @param parent
     * @param modal
     */
    public SelectInformeGeneral(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ls = new LinkedList<>();
        pc = new PeriodoController();
        sc = new SolicitudController();
        ac = new AnioController();
        s = new Socio();
        ls = s.getAllSocios();
        initComponents();
        TableRowFilterSupport.forTable(periodoTable).searchable(true).apply();
        anioComboBox.removeAllItems();
        la = ac.fillAnioComboBox(anioComboBox);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectFile = new javax.swing.JFileChooser();
        newSolicitudPanel = new javax.swing.JPanel();
        selectPeriodoNewSolicitudLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        periodoScrollPanel = new javax.swing.JScrollPane();
        periodoTable = new javax.swing.JTable();
        anioComboBox = new javax.swing.JComboBox();
        anioLabel = new javax.swing.JLabel();

        selectFile.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        selectFile.setSelectedFile(new java.io.File("C:\\Program Files (x86)\\NetBeans 7.4\\InformeGeneral"));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        newSolicitudPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Solicitud"));
        newSolicitudPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newSolicitudPanelMouseClicked(evt);
            }
        });
        newSolicitudPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newSolicitudPanelFocusGained(evt);
            }
        });

        selectPeriodoNewSolicitudLabel.setText("Periodo");

        saveButton.setText("Crear informe");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        periodoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Periodo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        periodoTable.setToolTipText("");
        periodoTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        periodoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                periodoTableMouseClicked(evt);
            }
        });
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
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectPeriodoNewSolicitudLabel)
                            .addComponent(anioLabel))
                        .addGap(47, 47, 47)
                        .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(periodoScrollPanel)
                            .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                                .addComponent(anioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(500, 500, 500))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newSolicitudPanelLayout.createSequentialGroup()
                        .addGap(546, 546, 546)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        newSolicitudPanelLayout.setVerticalGroup(
            newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newSolicitudPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anioLabel))
                .addGap(18, 18, 18)
                .addGroup(newSolicitudPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(periodoScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectPeriodoNewSolicitudLabel))
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newSolicitudPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newSolicitudPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private void newSolicitudPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newSolicitudPanelFocusGained

    }//GEN-LAST:event_newSolicitudPanelFocusGained

    private void newSolicitudPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newSolicitudPanelMouseClicked

    }//GEN-LAST:event_newSolicitudPanelMouseClicked

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

    private void periodoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_periodoTableMouseClicked

    }//GEN-LAST:event_periodoTableMouseClicked

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        newDocByType();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void newDocByType() {
        int row = periodoTable.getSelectedRow();

        if (row != -1) {
            Periodo p = new Periodo();
            p = p.getPeriodoById((int) periodoTable.getModel().getValueAt(row, 0));
            SolicitudDeReembolso sol = new SolicitudDeReembolso();
            int rv = selectFile.showSaveDialog(getContentPane());
            if (rv != JFileChooser.CANCEL_OPTION) {
                File file = selectFile.getSelectedFile();
                if (file.exists()) {
                    int result = JOptionPane.showConfirmDialog(this, "El archivo " + file.getName() + " ya existe, desea sobreescribirlo?", "Archivo existente", JOptionPane.YES_NO_OPTION);
                    switch (result) {
                        case JOptionPane.YES_OPTION:
                            ReportController rc = new ReportController();
                            rc.createGeneralReport(file, p);
                            JOptionPane.showMessageDialog(this, "Informe creado de forma exitosa", "Exito", WIDTH);
                            this.dispose();
                    }
                } else {
                    ReportController rc = new ReportController();
                    rc.createGeneralReport(file, p);
                    JOptionPane.showMessageDialog(this, "Informe creado de forma exitosa", "Exito", WIDTH);
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un rut de socio valido", "Rut Invalido", WIDTH);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo antes de ingresar un documento", "Periodo no seleccionado", WIDTH);
        }

    }

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
            java.util.logging.Logger.getLogger(SelectInformeGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectInformeGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectInformeGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectInformeGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SelectInformeGeneral dialog = new SelectInformeGeneral(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel newSolicitudPanel;
    private javax.swing.JScrollPane periodoScrollPanel;
    private javax.swing.JTable periodoTable;
    private javax.swing.JButton saveButton;
    private javax.swing.JFileChooser selectFile;
    private javax.swing.JLabel selectPeriodoNewSolicitudLabel;
    // End of variables declaration//GEN-END:variables
}
