/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.awt.Color;
import javax.swing.JTextField;
import subbvasalud.models.Carga;
import subbvasalud.models.Socio;

/**
 *
 * @author damage
 */
public class AddNewCargaController {

    Carga c;
    Socio s;

    public AddNewCargaController() {
        s = new Socio();
        c = new Carga();
    }

    public int guardarCarga(Carga ca) {
        int i = c.insertCarga(ca);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean validateNullMainFields(JTextField rutTextField, JTextField nameTextField, JTextField lastnameTextField, JTextField rutSocioTextField) {

        if ((rutTextField.getText().length() == 0) || (nameTextField.getText().length() == 0) || (lastnameTextField.getText().length() == 0)||(rutSocioTextField.getText().length() == 0) ) {

            if (rutTextField.getText().length() == 0) {
                rutTextField.setBackground(Color.red);
            }
            if (nameTextField.getText().length() == 0) {
                nameTextField.setBackground(Color.red);
            }
            if (lastnameTextField.getText().length() == 0) {
                lastnameTextField.setBackground(Color.red);
            }
            if (rutSocioTextField.getText().length() == 0) {
                rutSocioTextField.setBackground(Color.red);
            }
            return true;
        }

        if ("".equals(rutTextField.getText()) || "".equals(nameTextField.getText()) || "".equals(lastnameTextField.getText())||"".equals(rutSocioTextField.getText())) {

            if ("".equals(rutTextField.getText())) {
                rutTextField.setBackground(Color.red);
            }
            if ("".equals(nameTextField.getText())) {
                nameTextField.setBackground(Color.red);
            }
            if ("".equals(lastnameTextField.getText())) {
                lastnameTextField.setBackground(Color.red);
            }
            if ("".equals(rutSocioTextField.getText())) {
                rutSocioTextField.setBackground(Color.red);
            }
            return true;
        }
        return false;
    }
}
