/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subbvasalud.views;

import java.awt.CardLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import subbvasalud.controllers.MainMenuController;

/**
 *
 * @author damage
 */
public class MainMenu extends javax.swing.JFrame {

    MainMenuController mmc;
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
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

        selectSociosFile = new javax.swing.JFileChooser();
        viewSociosPanel = new javax.swing.JPanel();
        viewSociosScrollPanel = new javax.swing.JScrollPane();
        viewSociosTable = new javax.swing.JTable();
        viewCargasPanel = new javax.swing.JPanel();
        insertNewSocioPanel = new javax.swing.JPanel();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadFileSociosMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        viewMenu = new javax.swing.JMenu();
        viewSociosMenuItem = new javax.swing.JMenuItem();
        viewCargasMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 450));
        getContentPane().setLayout(new java.awt.CardLayout());

        viewSociosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        viewSociosScrollPanel.setViewportView(viewSociosTable);

        javax.swing.GroupLayout viewSociosPanelLayout = new javax.swing.GroupLayout(viewSociosPanel);
        viewSociosPanel.setLayout(viewSociosPanelLayout);
        viewSociosPanelLayout.setHorizontalGroup(
            viewSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSociosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewSociosScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewSociosPanelLayout.setVerticalGroup(
            viewSociosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewSociosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewSociosScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(viewSociosPanel, "viewSociosCard");

        javax.swing.GroupLayout viewCargasPanelLayout = new javax.swing.GroupLayout(viewCargasPanel);
        viewCargasPanel.setLayout(viewCargasPanelLayout);
        viewCargasPanelLayout.setHorizontalGroup(
            viewCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        viewCargasPanelLayout.setVerticalGroup(
            viewCargasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        getContentPane().add(viewCargasPanel, "viewCargasCard");

        javax.swing.GroupLayout insertNewSocioPanelLayout = new javax.swing.GroupLayout(insertNewSocioPanel);
        insertNewSocioPanel.setLayout(insertNewSocioPanelLayout);
        insertNewSocioPanelLayout.setHorizontalGroup(
            insertNewSocioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        insertNewSocioPanelLayout.setVerticalGroup(
            insertNewSocioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        getContentPane().add(insertNewSocioPanel, "insertNewSocioCard");

        fileMenu.setText("Archivo");

        loadFileSociosMenuItem.setText("Cargar archivo de socios");
        loadFileSociosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileSociosMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadFileSociosMenuItem);

        mainMenu.add(fileMenu);

        editMenu.setText("Editar");
        mainMenu.add(editMenu);

        viewMenu.setText("Ver");

        viewSociosMenuItem.setText("Ver Socios");
        viewSociosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSociosMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(viewSociosMenuItem);

        viewCargasMenuItem.setText("Ver Cargas");
        viewCargasMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCargasMenuItemActionPerformed(evt);
            }
        });
        viewMenu.add(viewCargasMenuItem);

        mainMenu.add(viewMenu);

        setJMenuBar(mainMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewSociosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSociosMenuItemActionPerformed
        mmc.mostrarSocios((DefaultTableModel) viewSociosTable.getModel());
        CardLayout cl = (CardLayout)(getContentPane().getLayout());
        cl.show(getContentPane(), "viewSociosCard");
    }//GEN-LAST:event_viewSociosMenuItemActionPerformed

    private void loadFileSociosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileSociosMenuItemActionPerformed
         int rv = selectSociosFile.showOpenDialog(getContentPane());
         if (rv == JFileChooser.APPROVE_OPTION) {
            File file = selectSociosFile.getSelectedFile();
             System.out.println("Archivo "+file.getPath());
         }
    }//GEN-LAST:event_loadFileSociosMenuItemActionPerformed

    private void viewCargasMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCargasMenuItemActionPerformed
        CardLayout cl = (CardLayout)(getContentPane().getLayout());
        cl.show(getContentPane(), "viewCargasCard");
    }//GEN-LAST:event_viewCargasMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel insertNewSocioPanel;
    private javax.swing.JMenuItem loadFileSociosMenuItem;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JFileChooser selectSociosFile;
    private javax.swing.JMenuItem viewCargasMenuItem;
    private javax.swing.JPanel viewCargasPanel;
    private javax.swing.JMenu viewMenu;
    private javax.swing.JMenuItem viewSociosMenuItem;
    private javax.swing.JPanel viewSociosPanel;
    private javax.swing.JScrollPane viewSociosScrollPanel;
    private javax.swing.JTable viewSociosTable;
    // End of variables declaration//GEN-END:variables
}
