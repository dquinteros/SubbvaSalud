/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.ItemEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Date;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import subbvasalud.controllers.CargaController;
import subbvasalud.controllers.DocumentController;
import subbvasalud.controllers.DocumentUtils;
import subbvasalud.controllers.GastoController;
import subbvasalud.models.Carga;
import subbvasalud.models.DetalleSolicitud;
import subbvasalud.models.Gasto;
import subbvasalud.models.Periodo;
import subbvasalud.models.Prestacion;
import subbvasalud.models.Prevision;
import subbvasalud.models.TipoDeDocumento;

/**
 *
 * @author damage
 */
public class InsertNewDocByType extends javax.swing.JDialog {

    private LinkedList<Prestacion> lp;
    private final Prestacion pres;
    private final Prevision prev;
    private Gasto gasto;
    private final GastoController gc;
    private final CargaController cc;
    private static int rutSocio;
    private static Periodo periodo;
    private static Date fechaSolicitud;
    private static int idSolicitud;
    private TextAutoCompleter prestacionAutoComplete;

    private Gasto gastoSelected;
    private Prestacion prestacionSelected;
    private Prevision previsionSelected;

    private TipoDeDocumento tipo;

    /**
     * Creates new form InsertNewDocByType
     *
     * @param parent
     * @param modal
     */
    public InsertNewDocByType(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        pres = new Prestacion();
        prev = new Prevision();
        lp = new LinkedList<>();
        gasto = new Gasto();
        gc = new GastoController();
        cc = new CargaController();

        gastoSelected = new Gasto();
        prestacionSelected = new Prestacion();
        previsionSelected = new Prevision();

        tipo = new TipoDeDocumento();

        LinkedList<Carga> cargas = cc.getCargasByRutSocio(rutSocio);
        initComponents();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(nombreCargaTextField);
        for (Carga so : cargas) {
            textAutoAcompleter.addItem(so.getNombre());
        }
        textAutoAcompleter.setMode(0);
        prestacionAutoComplete = new TextAutoCompleter(prestacionTextField);
        prestacionAutoComplete.setMode(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InsertNewDocByTypePanel = new javax.swing.JPanel();
        gastoLabel = new javax.swing.JLabel();
        gastoComboBox = new javax.swing.JComboBox();
        prestacionLabel = new javax.swing.JLabel();
        prestacionTextField = new javax.swing.JTextField();
        previsionLabel = new javax.swing.JLabel();
        previsionComboBox = new javax.swing.JComboBox();
        medicamentoCheckBox = new javax.swing.JCheckBox();
        montoTotalLabel = new javax.swing.JLabel();
        totalTextField = new javax.swing.JTextField();
        montoBonificableLabel = new javax.swing.JLabel();
        bonificableTextField = new javax.swing.JTextField();
        cancelarButton = new javax.swing.JButton();
        aceptarButton = new javax.swing.JButton();
        cargaCheckBox = new javax.swing.JCheckBox();
        rutLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        rutCargaTextField = new javax.swing.JTextField();
        nombreCargaTextField = new javax.swing.JTextField();
        docDateChooser = new com.toedter.calendar.JDateChooser();
        fechaLabel = new javax.swing.JLabel();
        bonificacionLabel = new javax.swing.JLabel();
        porcentajeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        InsertNewDocByTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar nuevo documento"));

        gastoLabel.setText("Tipo de gasto*:");

        gastoComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Ambulatorio", "Hospitalario", "Maternidad" }));
        gastoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                gastoComboBoxItemStateChanged(evt);
            }
        });

        prestacionLabel.setText("Prestacion*");

        prestacionTextField.setEnabled(false);
        prestacionTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                prestacionTextFieldKeyTyped(evt);
            }
        });

        previsionLabel.setText("Prevision*");

        previsionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Fonasa", "Isapre", "No aplica" }));
        previsionComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                previsionComboBoxItemStateChanged(evt);
            }
        });

        medicamentoCheckBox.setText(" Medicamento permanente");
        medicamentoCheckBox.setEnabled(false);
        medicamentoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medicamentoCheckBoxActionPerformed(evt);
            }
        });

        montoTotalLabel.setText("Monto total");

        totalTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalTextFieldKeyTyped(evt);
            }
        });

        montoBonificableLabel.setText("Monto no bonificado");

        bonificableTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bonificableTextFieldKeyTyped(evt);
            }
        });

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        cargaCheckBox.setText("Documento por carga");
        cargaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargaCheckBoxActionPerformed(evt);
            }
        });

        rutLabel.setText("Rut");

        nombreLabel.setText("Nombre");

        rutCargaTextField.setEnabled(false);
        rutCargaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rutCargaTextFieldKeyTyped(evt);
            }
        });

        nombreCargaTextField.setEnabled(false);
        nombreCargaTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreCargaTextFieldKeyTyped(evt);
            }
        });

        fechaLabel.setText("Fecha*:");

        bonificacionLabel.setText("Bonificacion");

        porcentajeTextField.setFocusable(false);
        porcentajeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                porcentajeTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout InsertNewDocByTypePanelLayout = new javax.swing.GroupLayout(InsertNewDocByTypePanel);
        InsertNewDocByTypePanel.setLayout(InsertNewDocByTypePanelLayout);
        InsertNewDocByTypePanelLayout.setHorizontalGroup(
            InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertNewDocByTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InsertNewDocByTypePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aceptarButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarButton))
                    .addGroup(InsertNewDocByTypePanelLayout.createSequentialGroup()
                        .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(previsionLabel)
                            .addComponent(nombreLabel)
                            .addComponent(rutLabel))
                        .addGap(119, 119, 119)
                        .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreCargaTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InsertNewDocByTypePanelLayout.createSequentialGroup()
                                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(rutCargaTextField)
                                        .addComponent(previsionComboBox, 0, 207, Short.MAX_VALUE))
                                    .addComponent(cargaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(InsertNewDocByTypePanelLayout.createSequentialGroup()
                        .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(prestacionLabel)
                            .addComponent(gastoLabel)
                            .addComponent(fechaLabel))
                        .addGap(93, 93, 93)
                        .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InsertNewDocByTypePanelLayout.createSequentialGroup()
                                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(docDateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(gastoComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 207, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(montoTotalLabel)
                                    .addComponent(bonificacionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(porcentajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(InsertNewDocByTypePanelLayout.createSequentialGroup()
                                .addComponent(prestacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(montoBonificableLabel)
                                .addGap(18, 18, 18)
                                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(medicamentoCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(bonificableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        InsertNewDocByTypePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bonificableTextField, docDateChooser, gastoComboBox, medicamentoCheckBox, prestacionTextField, previsionComboBox, rutCargaTextField, totalTextField});

        InsertNewDocByTypePanelLayout.setVerticalGroup(
            InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertNewDocByTypePanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(docDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaLabel)
                    .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bonificacionLabel)
                        .addComponent(porcentajeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gastoLabel)
                    .addComponent(gastoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montoTotalLabel)
                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prestacionLabel)
                    .addComponent(prestacionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(montoBonificableLabel)
                    .addComponent(bonificableTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previsionLabel)
                    .addComponent(previsionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(medicamentoCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(cargaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutLabel)
                    .addComponent(rutCargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(nombreCargaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(InsertNewDocByTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(aceptarButton))
                .addContainerGap())
        );

        InsertNewDocByTypePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bonificableTextField, docDateChooser, gastoComboBox, medicamentoCheckBox, nombreCargaTextField, porcentajeTextField, prestacionTextField, previsionComboBox, rutCargaTextField, totalTextField});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InsertNewDocByTypePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InsertNewDocByTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void medicamentoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medicamentoCheckBoxActionPerformed
        boolean flagPrestacion = prestacionSelected.getNombrePrestacion().trim().equals("");
        boolean flagPrevision = previsionSelected.getNombrePrevision().trim().equals("");
        if (!flagPrestacion && !flagPrevision) {
            int idGasto = gastoSelected.getIdGasto();
            int idPrestacion = prestacionSelected.getIdPrestacion();
            int idPrevision = previsionSelected.getIdPrevision();
            LinkedList<TipoDeDocumento> tipos = tipo.getAllTipoDocumentosBySearch(idGasto, idPrestacion, idPrevision);
            if (tipos != null) {
                if (tipos.size() == 1) {
                    tipo = tipos.get(0);
                    porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                } else if (tipos.size() > 1) {
                    if (!medicamentoCheckBox.isSelected()) {
                        for (TipoDeDocumento tipoDeDocumento : tipos) {
                            if (tipoDeDocumento.getId_tipo() < 1000) {
                                tipo = tipoDeDocumento;
                                porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                            }
                        }
                    } else {
                        for (TipoDeDocumento tipoDeDocumento : tipos) {
                            if (tipoDeDocumento.getId_tipo() >= 1000) {
                                tipo = tipoDeDocumento;
                                porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_medicamentoCheckBoxActionPerformed

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        Date fechaDocumento = (Date) docDateChooser.getDate();
        if (fechaDocumento != null) {
            long diff = fechaSolicitud.getTime() - fechaDocumento.getTime();
            long daysDiff = diff / (24 * 60 * 60 * 1000);
            if (daysDiff < 60) {
                if (gastoSelected.getIdGasto() >= 0 && prestacionSelected.getIdPrestacion() >= 0 && previsionSelected.getIdPrevision() >= 0) {
                    if (!porcentajeTextField.getText().trim().equals("")) {
                        int monto = Integer.parseInt(bonificableTextField.getText());
                        int montoTotal = Integer.parseInt(totalTextField.getText());
                        if (monto > 0 && montoTotal > 0) {
                            if ((montoTotal - monto) >= 0) {
                                int idTipo = tipo.getId_tipo();
                                if (idTipo == 194 || idTipo == 144 || idTipo == 113 || idTipo == 116) {
                                    int rutCarga = Integer.parseInt(rutCargaTextField.getText().trim());
                                    if (ViewUtils.validaCargaByRut(rutSocio, rutCarga)) {
                                        int reembolso = DocumentUtils.calculaReeembolso(tipo, monto, Integer.parseInt(rutCargaTextField.getText()), periodo);
                                        DetalleSolicitud ds = new DetalleSolicitud(-1, idSolicitud, idTipo, prestacionSelected.getNombrePrestacion(), fechaDocumento, montoTotal, monto, reembolso, rutCarga);
                                        DocumentController dc = new DocumentController();
                                        dc.guardarDocumento(ds);
                                    } else {
                                        JOptionPane.showMessageDialog(this, "El rut de la carga es incorrecto o no fue ingresado", "Error rut de la carga", WIDTH);
                                    }
                                } else {
                                    int reembolso = DocumentUtils.calculaReeembolso(tipo, monto, rutSocio, periodo);
                                    DetalleSolicitud ds = new DetalleSolicitud(-1, idSolicitud, idTipo, prestacionSelected.getNombrePrestacion(), fechaDocumento, montoTotal, monto, reembolso, rutSocio);
                                    DocumentController dc = new DocumentController();
                                    dc.guardarDocumento(ds);

                                }

                            } else {
                                JOptionPane.showMessageDialog(this, "El monto total debe ser mayor o igual que el monto no bonificado", "Montos no validos", WIDTH);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Los montos deben ser mayores que 0", "Montos no validos", WIDTH);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontró porcentaje un reembolso para el tipo de documento", "Reembolso no valido", WIDTH);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un gasto, una prestacion y una prevision", "Selecionar tipo de documento", WIDTH);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El docuemento tiene mas de 60 días de antiguedad", "Documento rechazado", WIDTH);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha", "Fecha no seleccionada", WIDTH);
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void gastoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_gastoComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) evt.getItem();
            if (item.equals("Seleccionar")) {
                prestacionTextField.setEnabled(false);
            } else {
                gasto = gc.getByName(item);
                System.out.println(gasto.getIdGasto());
                lp = pres.getAllPrestacionByGasto(gasto.getIdGasto());
                prestacionTextField.setEnabled(true);
                prestacionAutoComplete.removeAll();
                for (Prestacion p : lp) {
                    prestacionAutoComplete.addItem(p.getNombrePrestacion());
                }
                LinkedList<Gasto> gastos = gc.getAll();
                for (Gasto gasto1 : gastos) {
                    if (gasto1.getNombreGasto().equals(item)) {
                        gastoSelected = gasto1;
                    }
                }
            }
        }
    }//GEN-LAST:event_gastoComboBoxItemStateChanged

    private void cargaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargaCheckBoxActionPerformed
        if (cargaCheckBox.isSelected()) {
            rutCargaTextField.setEnabled(true);
            nombreCargaTextField.setEnabled(true);
        } else {
            rutCargaTextField.setEnabled(false);
            nombreCargaTextField.setEnabled(false);
        }
    }//GEN-LAST:event_cargaCheckBoxActionPerformed

    private void totalTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalTextFieldKeyTyped
        ViewUtils.onlyNumbers(evt, totalTextField, 50);
    }//GEN-LAST:event_totalTextFieldKeyTyped

    private void bonificableTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bonificableTextFieldKeyTyped
        ViewUtils.onlyNumbers(evt, bonificableTextField, 50);
    }//GEN-LAST:event_bonificableTextFieldKeyTyped

    private void rutCargaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutCargaTextFieldKeyTyped
        String rut = rutCargaTextField.getText() + evt.getKeyChar();
        boolean rutValido = ViewUtils.validaRut(rut);
        if (rutValido) {
            Carga cargaAux;
            cargaAux = cc.getCargaByRutCargaAndSocio(Integer.parseInt(rut), rutSocio);
            if (cargaAux != null) {
                if ((cargaAux.getNombre() != null)) {
                    nombreCargaTextField.setText(cargaAux.getNombre());
                }
            }
        }
        ViewUtils.onlyRutNumbers(evt, rutCargaTextField, 9);
    }//GEN-LAST:event_rutCargaTextFieldKeyTyped

    private void porcentajeTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_porcentajeTextFieldKeyTyped
        ViewUtils.onlyNumbersMaxValue(evt, porcentajeTextField, 100);
    }//GEN-LAST:event_porcentajeTextFieldKeyTyped

    private void nombreCargaTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreCargaTextFieldKeyTyped
        ViewUtils.onlyLetters(evt, nombreCargaTextField);
        ViewUtils.maxLongInput(evt, nombreCargaTextField, 45);
        String name = nombreCargaTextField.getText();
        LinkedList<Carga> cargas = cc.getCargasByRutSocio(rutSocio);
        for (Carga ca : cargas) {
            if (ca.getNombre().equals(name)) {
                rutCargaTextField.setText(ca.getRut() + "");
            }
        }
    }//GEN-LAST:event_nombreCargaTextFieldKeyTyped

    private void previsionComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_previsionComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) evt.getItem();
            if (item.equals("Seleccionar")) {

            } else {
                LinkedList<Prevision> previsiones = prev.getAllPrevision();
                for (Prevision prevision : previsiones) {
                    System.out.println(prevision.getNombrePrevision());
                    System.out.println(item);
                    if (prevision.getNombrePrevision().trim().equals(item)) {
                        previsionSelected = prevision;
                    }
                }
                if (prestacionSelected.getIdPrestacion() >= 0) {
                    int idGasto = gastoSelected.getIdGasto();
                    int idPrestacion = prestacionSelected.getIdPrestacion();
                    int idPrevision = previsionSelected.getIdPrevision();
                    System.out.println(idGasto + " " + idPrestacion + " " + idPrevision);
                    LinkedList<TipoDeDocumento> tipos = tipo.getAllTipoDocumentosBySearch(idGasto, idPrestacion, idPrevision);
                    if (tipos != null) {
                        porcentajeTextField.setText("");
                        if (tipos.size() == 1) {
                            tipo = tipos.get(0);
                            porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                        } else if (tipos.size() > 1) {
                            if (!medicamentoCheckBox.isSelected()) {
                                for (TipoDeDocumento tipoDeDocumento : tipos) {
                                    if (tipoDeDocumento.getId_tipo() < 1000) {
                                        tipo = tipoDeDocumento;
                                        porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                                    }
                                }
                            } else {
                                for (TipoDeDocumento tipoDeDocumento : tipos) {
                                    if (tipoDeDocumento.getId_tipo() >= 1000) {
                                        tipo = tipoDeDocumento;
                                        porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_previsionComboBoxItemStateChanged

    private void prestacionTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prestacionTextFieldKeyTyped
        ViewUtils.onlyLetters(evt, prestacionTextField);
        ViewUtils.maxLongInput(evt, prestacionTextField, 300);
        String nombrePrestacion = prestacionTextField.getText().trim();
        if (gastoSelected.getNombreGasto() != null) {
            if (!gastoSelected.getNombreGasto().isEmpty()) {
                LinkedList<Prestacion> prestaciones = pres.getAllPrestacionByGasto(gastoSelected.getIdGasto());
                for (Prestacion prestacion : prestaciones) {
                    if (prestacion.getNombrePrestacion().trim().equals(nombrePrestacion)) {
                        prestacionSelected = prestacion;
                    }
                }
                if (previsionSelected.getIdPrevision() >= 0) {
                    int idGasto = gastoSelected.getIdGasto();
                    int idPrestacion = prestacionSelected.getIdPrestacion();
                    int idPrevision = previsionSelected.getIdPrevision();
                    LinkedList<TipoDeDocumento> tipos = tipo.getAllTipoDocumentosBySearch(idGasto, idPrestacion, idPrevision);
                    if (tipos != null) {
                        porcentajeTextField.setText("");
                        if (tipos.size() == 1) {
                             medicamentoCheckBox.setEnabled(false);
                            tipo = tipos.get(0);
                            porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                        } else if (tipos.size() > 1) {
                            medicamentoCheckBox.setEnabled(true);
                            if (!medicamentoCheckBox.isSelected()) {
                                for (TipoDeDocumento tipoDeDocumento : tipos) {
                                    if (tipoDeDocumento.getId_tipo() < 1000) {
                                        tipo = tipoDeDocumento;
                                        porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                                    }
                                }
                            } else {
                                for (TipoDeDocumento tipoDeDocumento : tipos) {
                                    if (tipoDeDocumento.getId_tipo() >= 1000) {
                                        tipo = tipoDeDocumento;
                                        porcentajeTextField.setText(tipo.getPorcentaje_tipo() + "");
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                evt.consume();
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_prestacionTextFieldKeyTyped

    /**
     * @param args the command line arguments
     * @param p
     * @param fecha
     */
    public static void main(String args[], Periodo p, Date fecha) {

        rutSocio = Integer.parseInt(args[0]);
        idSolicitud = Integer.parseInt(args[1]);
        periodo = p;
        fechaSolicitud = fecha;

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
            java.util.logging.Logger.getLogger(InsertNewDocByType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertNewDocByType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertNewDocByType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertNewDocByType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InsertNewDocByType dialog = new InsertNewDocByType(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel InsertNewDocByTypePanel;
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField bonificableTextField;
    private javax.swing.JLabel bonificacionLabel;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JCheckBox cargaCheckBox;
    private com.toedter.calendar.JDateChooser docDateChooser;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JComboBox gastoComboBox;
    private javax.swing.JLabel gastoLabel;
    private javax.swing.JCheckBox medicamentoCheckBox;
    private javax.swing.JLabel montoBonificableLabel;
    private javax.swing.JLabel montoTotalLabel;
    private javax.swing.JTextField nombreCargaTextField;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField porcentajeTextField;
    private javax.swing.JLabel prestacionLabel;
    private javax.swing.JTextField prestacionTextField;
    private javax.swing.JComboBox previsionComboBox;
    private javax.swing.JLabel previsionLabel;
    private javax.swing.JTextField rutCargaTextField;
    private javax.swing.JLabel rutLabel;
    private javax.swing.JTextField totalTextField;
    // End of variables declaration//GEN-END:variables
}
