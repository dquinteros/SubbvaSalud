/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.views;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import subbvasalud.models.Carga;
import subbvasalud.models.Socio;
import subbvasalud.models.TipoCuenta;

/**
 *
 * @author damage
 */
public class ViewUtils {

    /**
     *
     * @param name
     * @return
     */
    public static boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }
    
    /**
     *
     * @param name
     * @return
     */
    public static boolean isNum(String name) {
        return name.matches("[0-9]+");
    }

    /**
     *
     * @param evt
     * @param rutTextField
     * @param maxChars
     */
    public static void onlyRutNumbers(java.awt.event.KeyEvent evt, JTextField rutTextField, int maxChars) {
        char c = evt.getKeyChar();
        if (((!(Character.isDigit(c))) && (c != '\b')) && (c != 'k')) {
            evt.consume();
        }
        if (rutTextField.getText().length() > maxChars) {
            evt.consume();
        }
    }

    /**
     *
     * @param evt
     * @param rutTextField
     * @param maxChars
     */
    public static void onlyNumbers(java.awt.event.KeyEvent evt, JTextField rutTextField, int maxChars) {
        char c = evt.getKeyChar();
        if (((!(Character.isDigit(c))) && (c != '\b'))) {
            evt.consume();
        } else if ((rutTextField.getText().length() + 1) > maxChars) {
            evt.consume();
        }
    }

    /**
     *
     * @param evt
     * @param rutTextField
     * @param maxValue
     */
    public static void onlyNumbersMaxValue(java.awt.event.KeyEvent evt, JTextField rutTextField, int maxValue) {
        char c = evt.getKeyChar();
        if ((!(Character.isDigit(c))) && (c != '\b')) {
            evt.consume();
        } else if (Integer.parseInt(rutTextField.getText() + c) > maxValue) {
            evt.consume();
        }
    }

    /**
     *
     * @param evt
     * @param nameTextField
     * @param lastnameTextField
     */
    public static void onlyLetters(java.awt.event.KeyEvent evt, JTextField nameTextField, JTextField lastnameTextField) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
        if ((nameTextField.getText().length() + lastnameTextField.getText().length()) > 45) {
            evt.consume();
        }
    }

    /**
     *
     * @param evt
     * @param nameTextField
     */
    public static void onlyLetters(java.awt.event.KeyEvent evt, JTextField nameTextField) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }

    /**
     *
     * @param evt
     * @param textField
     * @param maxChars
     */
    public static void maxLongInput(java.awt.event.KeyEvent evt, JTextField textField, int maxChars) {
        char c = evt.getKeyChar();
        if (textField.getText().length() > maxChars) {
            evt.consume();
        }
    }

    /**
     *
     * @param rut
     * @return
     */
    public static boolean validaRut(int rut) {
        return validaRut(String.valueOf(rut));
    }

    /**
     *
     * @param typeAccountComboBox
     * @return
     */
    public static ArrayList<TipoCuenta> fillTipoCuentaComBox(JComboBox typeAccountComboBox) {
        ArrayList<TipoCuenta> accountTypeList = new ArrayList<>();
        TipoCuenta corriente = new TipoCuenta(1, "Cuenta Corriente");
        accountTypeList.add(corriente);
        typeAccountComboBox.addItem("Cuenta Corriente");
        TipoCuenta ahorro = new TipoCuenta(2, "Cuenta de Ahorro");
        accountTypeList.add(ahorro);
        typeAccountComboBox.addItem("Cuenta de Ahorro");
        TipoCuenta valeVista = new TipoCuenta(3, "Vale Vista");
        accountTypeList.add(valeVista);
        typeAccountComboBox.addItem("Vale Vista");
        TipoCuenta enLinea = new TipoCuenta(4, "Cuenta en Linea");
        accountTypeList.add(enLinea);
        typeAccountComboBox.addItem("Cuenta en Linea");

        return accountTypeList;
    }

    /**
     *
     * @param id
     * @return
     */
    public static String getTipoCuentaName(int id) {
        String name;
        if (id == 1) {
            name = "Cuenta Corriente";
        } else if (id == 2) {
            name = "Cuenta de Ahorro";
        } else if (id == 3) {
            name = "Vale Vista";
        } else {
            name = "Cuenta en Linea";
        }
        return name;
    }

    /**
     *
     * @param rut
     * @return
     */
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

    /**
     *
     * @param rutSocio
     * @param rutCarga
     * @return
     */
    public static boolean validaCargaByRut(String rutSocio, String rutCarga) {
        return validaCargaByRut(Integer.parseInt(rutSocio), Integer.parseInt(rutCarga));
    }

    /**
     *
     * @param rutSocio
     * @param rutCarga
     * @return
     */
    public static boolean validaCargaByRut(String rutSocio, int rutCarga) {
        return validaCargaByRut(Integer.parseInt(rutSocio), rutCarga);
    }

    /**
     *
     * @param rutSocio
     * @param rutCarga
     * @return
     */
    public static boolean validaCargaByRut(int rutSocio, String rutCarga) {
        return validaCargaByRut(rutSocio, Integer.parseInt(rutCarga));
    }

    /**
     *
     * @param rutSocio
     * @param rutCarga
     * @return
     */
    public static boolean validaCargaByRut(int rutSocio, int rutCarga) {
        if (!ViewUtils.validaRut(rutSocio) || !validaRut(rutCarga)) {
            Socio s = new Socio();
            Carga c = new Carga();
            s = s.getSociosByRut(rutSocio);
            c = c.getCargasByRut(rutCarga);
            if (s == null || c == null) {
                return false;
            } else {
                return c.getIdSocio() == s.getIdSocio();
            }
        } else {
            return false;
        }
    }
}
