/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.awt.Color;
import javax.swing.JTextField;
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
