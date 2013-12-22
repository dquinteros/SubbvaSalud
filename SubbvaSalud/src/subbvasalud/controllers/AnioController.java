/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.util.LinkedList;
import javax.swing.JComboBox;
import subbvasalud.models.Anio;

/**
 *
 * @author damage
 */
public class AnioController {

    Anio a;

    public AnioController() {
        a = new Anio();
    }

    public int guardarAnio(Anio a) {
        int i = a.insertAnio(a);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public Anio getAnioByAnioNumber(int year) {
        Anio a = new Anio();
        a = a.getAnioByYear(year);
        if (a != null) {
            return a;
        }
        return null;
    }
    
    public LinkedList<Anio> fillAnioComboBox(JComboBox anioComboBox) {
        LinkedList<Anio> listAnios = a.getAllAnios();
        for (Anio a : listAnios) {
            anioComboBox.addItem(a.getNumero_anio());
        }
        return listAnios;
    }
}
