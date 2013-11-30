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

    Socio s = new Socio();

    public void mostrarSocios(DefaultTableModel tableModel) {

        LinkedList<Socio> ls = s.getAllSocios();
        if (ls != null) {
            for (Socio so : ls) {
                Object[] obj = new Object[3];
                obj[0] = so.getRutSocio();
                obj[1] = so.getNombreSocio();
                obj[2] = so.getApellidoSocio();
                tableModel.addRow(obj);

            }
        } else {
            System.out.println("Table Empty");
        }
    }

    public int guardarSocio(Socio so) {
        int i = s.insertSocio(so);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    
    public void formInsertarSocio(){
    }
}
