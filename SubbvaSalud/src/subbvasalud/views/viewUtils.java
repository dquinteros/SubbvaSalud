/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import subbvasalud.models.TipoCuenta;

/**
 *
 * @author damage
 */
public class viewUtils {

    public static void onlyRutNumbers(java.awt.event.KeyEvent evt, JTextField rutTextField, int maxChars) {
        char c = evt.getKeyChar();
        if (((!(Character.isDigit(c))) && (c != '\b')) && (c != 'k')) {
            evt.consume();
        }
        if (rutTextField.getText().length() > maxChars) {
            evt.consume();
        }
    }

    public static void onlyLetters(java.awt.event.KeyEvent evt, JTextField nameTextField, JTextField lastnameTextField) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c) && (c == '\b')) {
            evt.consume();
        }
        if ((nameTextField.getText().length() + lastnameTextField.getText().length()) > 45) {
            evt.consume();
        }
    }

    public static boolean validaRut(int rut) {
        return validaRut(String.valueOf(rut));
    }

    public static ArrayList<TipoCuenta> fillTipoCuentaComBox(JComboBox typeAccountComboBox) {
        ArrayList<TipoCuenta> accountTypeList = new ArrayList<>();
        TipoCuenta corriente = new TipoCuenta(1, "Cuenta Corriente");
        accountTypeList.add(corriente);
        typeAccountComboBox.addItem(corriente);
        TipoCuenta ahorro = new TipoCuenta(2, "Cuenta de Ahorro");
        accountTypeList.add(ahorro);
        typeAccountComboBox.addItem(ahorro);
        TipoCuenta valeVista = new TipoCuenta(3, "Vale Vista");
        accountTypeList.add(valeVista);
        typeAccountComboBox.addItem(valeVista);
        TipoCuenta enLinea = new TipoCuenta(4, "Cuenta en Linea");
        accountTypeList.add(enLinea);
        typeAccountComboBox.addItem(enLinea);

        return accountTypeList;
    }

    public static boolean validaRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

}
