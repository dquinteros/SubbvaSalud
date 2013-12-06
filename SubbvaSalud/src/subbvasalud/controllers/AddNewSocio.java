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
public class AddNewSocio {

    Socio s;
    Banco b;

    public AddNewSocio() {
        s = new Socio();
        b = new Banco();
    }

    public int guardarSocio(Socio so) {
        int i = s.insertSocio(so);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public void formInsertarSocio() {
    }

    public void fillBancoComboBox(JComboBox bancoComboBox) {
        LinkedList<Banco> listBancos = b.getAllBancos();
        for (Banco ba : listBancos) {
            bancoComboBox.addItem(ba.getNombreBanco());
        }
    }
    
    public boolean validateNullMainFields(JTextField rutTextField, JTextField nameTextField, JTextField lastnameTextField){
                
        if((rutTextField.getText().length()==0) || (nameTextField.getText().length()==0) || (lastnameTextField.getText().length()==0)){
           
            if(rutTextField.getText().length()==0 ){
                rutTextField.setBackground(Color.red);
            }
            if(nameTextField.getText().length()==0){
                nameTextField.setBackground(Color.red);
            }
            if(lastnameTextField.getText().length()==0){
                lastnameTextField.setBackground(Color.red);
            }
            return true;
        }
        
        if("".equals(rutTextField)||"".equals(nameTextField)||"".equals(lastnameTextField)){
           
            if("".equals(rutTextField)){
                rutTextField.setBackground(Color.red);
            }
            if("".equals(nameTextField)){
                nameTextField.setBackground(Color.red);
            }
            if("".equals(lastnameTextField)){
                lastnameTextField.setBackground(Color.red);
            }
            return true;
        }
        return false;
    }
}