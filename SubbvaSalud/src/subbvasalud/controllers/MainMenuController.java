/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import subbvasalud.models.Socio;

/**
 *
 * @author damage
 */
public class MainMenuController {

    Socio s;
    LinkedList<Socio> ls;

    public MainMenuController() {
        s = new Socio();
    }

    public void mostrarSocios(DefaultTableModel tableModel) {

        ls = s.getAllSocios();
        if (ls != null) {
            for (Socio so : ls) {
                Object[] obj = new Object[2];
                obj[0] = so.getRutSocio();
                obj[1] = so.getNombreSocio();
                tableModel.addRow(obj);
            }
        } else {
            System.out.println("Table Empty");
        }
    }

    public int getIdSociosByRut(int rut) {
        for (Socio so : ls) {
            if (so.getRutSocio() == rut) {
                return so.getIdSocio();
            }
        }
        return -1;
    }

}
