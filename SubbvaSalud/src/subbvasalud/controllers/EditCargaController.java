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
public class EditCargaController {
    
    Carga c;
    Socio s;
    

    public EditCargaController() {
        s = new Socio();
        c = new Carga();
    }

    public int editarCarga(Carga ca) {
        int i = c.updateCarga(ca);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public Carga getCarga(int id) {
        return c.getCargasById(id);
    }

   

    public boolean validateNullMainFields(JTextField rutTextField, JTextField nameTextField, JTextField rutSocioTextField) {

        if ((rutTextField.getText().length() == 0) || (nameTextField.getText().length() == 0) || (rutSocioTextField.getText().length()==0)) {

            if (rutTextField.getText().length() == 0) {
                rutTextField.setBackground(Color.red);
            }
            if (nameTextField.getText().length() == 0) {
                nameTextField.setBackground(Color.red);
            }
            if (rutSocioTextField.getText().length() == 0) {
                rutSocioTextField.setBackground(Color.red);
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
