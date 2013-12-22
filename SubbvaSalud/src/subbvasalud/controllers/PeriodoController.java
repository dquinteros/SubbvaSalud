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
import subbvasalud.models.Carga;
import subbvasalud.models.Periodo;

/**
 *
 * @author damage
 */
public class PeriodoController {

    Periodo p;
    Anio a;
    AnioController ac;
    LinkedList<Periodo> lp;

    public PeriodoController() {
        p = new Periodo();
        a = new Anio();
        ac = new AnioController();
    }

    public int guardarPeriodo(Periodo pe) {

        int i = p.insertPeriodo(pe);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int editarPeriodo(Periodo pe) {
        int i = p.updatePeriodo(p);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public Periodo getPeriodo(int id) {
        return p.getPeriodoById(id);
    }

    public void mostrarPeriodos(DefaultTableModel tableModel, int anio) {
        a = a.getAnioByYear(anio);
        lp = p.getAllPeriodosByYear(a.getId_anio());
        if ((lp != null) && (a != null)) {
            for (Periodo p : lp) {
                Object[] obj = new Object[2];
                obj[0] = p.getNombre_periodo();
                tableModel.addRow(obj);
            }
        } else {
            System.out.println("Table Empty");
        }
    }

    public boolean validateNullMainFields(JTextField nombrePeriodo) {

        if ((nombrePeriodo.getText().length() == 0)) {

            if (nombrePeriodo.getText().length() == 0) {
                nombrePeriodo.setBackground(Color.red);
            }

            return true;
        }

        if ("".equals(nombrePeriodo.getText())) {

            if ("".equals(nombrePeriodo.getText())) {
                nombrePeriodo.setBackground(Color.red);
            }

            return true;
        }
        return false;
    }

}
