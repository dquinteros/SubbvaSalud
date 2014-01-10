/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.awt.Color;
import java.util.LinkedList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import subbvasalud.models.Banco;
import subbvasalud.models.Socio;

/**
 *
 * @author damage
 */
public class EditSocioController {

    Socio s;
    Banco b;

    /**
     *
     */
    public EditSocioController() {
        s = new Socio();
        b = new Banco();
    }

    /**
     *
     * @param so
     * @return
     */
    public int editarSocio(Socio so) {
        int i = s.updateSocio(so);
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
    public Socio getSocio(int id) {
        return s.getSociosById(id);
    }

    /**
     *
     * @param bancoComboBox
     * @param idBanco
     * @return
     */
    public LinkedList<Banco> fillBancoComboBox(JComboBox bancoComboBox, int idBanco) {
        LinkedList<Banco> listBancos = b.getAllBancos();
        for (Banco ba : listBancos) {
            bancoComboBox.addItem(ba.getNombreBanco());
            if (ba.getIdBanco() == idBanco) {
                bancoComboBox.setSelectedItem(ba.getNombreBanco());
            }
        }

        return listBancos;
    }

    /**
     *
     * @param rutTextField
     * @param nameTextField
     * @return
     */
    public boolean validateNullMainFields(JTextField rutTextField, JTextField nameTextField) {

        if ((rutTextField.getText().length() == 0) || (nameTextField.getText().length() == 0)) {

            if (rutTextField.getText().length() == 0) {
                rutTextField.setBackground(Color.red);
            }
            if (nameTextField.getText().length() == 0) {
                nameTextField.setBackground(Color.red);
            }
            return true;
        }

        if ("".equals(rutTextField.getText()) || "".equals(nameTextField.getText())) {

            if ("".equals(rutTextField.getText())) {
                rutTextField.setBackground(Color.red);
            }
            if ("".equals(nameTextField.getText())) {
                nameTextField.setBackground(Color.red);
            }

            return true;
        }
        return false;
    }
}
