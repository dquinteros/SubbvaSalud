/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import subbvasalud.models.Anio;
import subbvasalud.models.Periodo;
import subbvasalud.models.Socio;
import subbvasalud.models.SolicitudDeReembolso;

/**
 *
 * @author damage
 */
public class PeriodoController {

    Periodo p;
    Anio a;
    AnioController ac;
    LinkedList<Periodo> lp;

    /**
     *
     */
    public PeriodoController() {
        p = new Periodo();
        a = new Anio();
        ac = new AnioController();
    }

    /**
     *
     * @param pe
     * @return
     */
    public int guardarPeriodo(Periodo pe) {

        int i = p.insertPeriodo(pe);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     *
     * @param pe
     * @return
     */
    public int editarPeriodo(Periodo pe) {
        int i = p.updatePeriodo(p);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Periodo getPeriodo(int id) {
        return p.getPeriodoById(id);
    }

    /**
     *
     * @param tableModel
     * @param anio
     */
    public void mostrarPeriodos(DefaultTableModel tableModel, int anio) {
        a = a.getAnioByYear(anio);
        lp = p.getAllPeriodosByYear(a.getId_anio());
        if ((lp != null) && (a != null)) {
            for (Periodo p : lp) {
                Object[] obj = new Object[2];
                obj[0] = p.getId_periodo();
                obj[1] = p.getNombre_periodo();
                tableModel.addRow(obj);
            }
        } else {
            System.out.println("Table Empty");
        }
    }

    public void mostrarSolicitudes(DefaultTableModel tableModel, Periodo p) {
        SolicitudDeReembolso s = new SolicitudDeReembolso();
        LinkedList<SolicitudDeReembolso> ls = s.getAllSolicitudByPeriodo(p.getId_periodo());
        if (ls != null && ls.size() > 0) {
            for (SolicitudDeReembolso solicitud : ls) {
                Object[] obj = new Object[4];
                Socio so = new Socio();
                so = so.getSociosById(solicitud.getIdSocio());
                obj[0] = so.getRutSocio();
                obj[1] = so.getNombreSocio();
                obj[2] = solicitud.getMontoTotal();
                obj[3] = solicitud.getIdSolicitud();
                tableModel.addRow(obj);

            }
        }
    }

    /**
     *
     * @param nombrePeriodo
     * @param valorUF
     * @return
     */
    public boolean validateNullMainFields(JTextField nombrePeriodo, JTextField valorUF) {

        if ((nombrePeriodo.getText().length() == 0) || (valorUF.getText().length() == 0)) {

            if (nombrePeriodo.getText().length() == 0) {
                nombrePeriodo.setBackground(Color.red);
            }

            if (valorUF.getText().length() == 0) {
                valorUF.setBackground(Color.red);
            }

            return true;
        }

        if ("".equals(nombrePeriodo.getText()) || "".equals(valorUF.getText())) {

            if ("".equals(nombrePeriodo.getText())) {
                nombrePeriodo.setBackground(Color.red);
            }
            if ("".equals(valorUF.getText())) {
                valorUF.setBackground(Color.red);
            }
            return true;
        }
        return false;
    }

}
