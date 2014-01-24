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

    /**
     *
     */
    public MainMenuController() {
        s = new Socio();
        c = new Carga();
    }

    /**
     *
     * @param tableModel
     */
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

    /**
     *
     * @param tableModel
     */
    public void mostrarCargas(DefaultTableModel tableModel) {

        lc = c.getAllCargas();
        if (ls != null) {
            for (Carga ca : lc) {
                Object[] obj = new Object[3];
                obj[0] = ca.getRut();
                obj[1] = ca.getNombre();
                s = s.getSociosById(ca.getIdSocio());
                obj[2] = s.getNombreSocio();
                tableModel.addRow(obj);
            }
        } else {
            System.out.println("Table Empty");
        }
    }

    /**
     *
     * @param rut
     * @return
     */
    public int getIdSociosByRut(String rut) {
        Socio so = new Socio();
        so = so.getSociosByRut(rut);
        if (so.getNombreSocio() != null) {
            return so.getIdSocio();

        } else {
            return -1;
        }
    }

    /**
     *
     * @param rut
     * @return
     */
    public int getIdCargasByRut(String rut) {
        for (Carga ca : lc) {
            if (ca.getRut().equals(rut)) {
                return ca.getIdCarga();
            }
        }
        return -1;
    }
}
