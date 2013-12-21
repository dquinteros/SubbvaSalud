/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import subbvasalud.models.Carga;
import subbvasalud.models.Socio;

/**
 *
 * @author damage
 */
public class MainMenuController {

    Socio s;
    LinkedList<Socio> ls;
    Carga c;
    LinkedList<Carga> lc;

    public MainMenuController() {
        s = new Socio();
        c = new Carga();
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

    public void mostrarCargas(DefaultTableModel tableModel) {

        lc = c.getAllCargas();
        if (ls != null) {
            for (Carga ca : lc) {
                Object[] obj = new Object[2];
                obj[0] = ca.getRut();
                obj[1] = ca.getNombre();
                tableModel.addRow(obj);
            }
        } else {
            System.out.println("Table Empty");
        }
    }

    public int getIdSociosByRut(int rut) {
         ls = s.getAllSocios();
        for (Socio so : ls) {
            if (so.getRutSocio() == rut) {
                return so.getIdSocio();
            }
        }
        return -1;
    }

    public int getIdCargasByRut(int rut) {
        for (Carga ca : lc) {
            if (ca.getRut() == rut) {
                return ca.getIdCarga();
            }
        }
        return -1;
    }
}
