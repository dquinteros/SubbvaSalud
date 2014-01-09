/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import subbvasalud.models.Banco;
import subbvasalud.models.Socio;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author damage
 */
public class AddNewSocioController {

    Socio s;
    Banco b;

    public AddNewSocioController() {
        s = new Socio();
        b = new Banco();
    }

    public int cargaMasivaSocios(File file) {
        if (file.exists() && file.isFile() && file.canRead()) {
            String[] rutaArchivo = file.getPath().split("\\.");
            int tam = rutaArchivo.length - 1;

            switch (rutaArchivo[tam]) {
                case "xls":
                    System.out.println("Archivo xls: " + file.getPath());
                    return cargaArchivoXls(file);
                case "xlsx":
                    System.out.println("Archivo xlsx: " + file.getPath());
                    return 0;

            }
        }
        return 0;
    }

    public int cargaArchivoXls(File file) {
        FileInputStream f = null;
        try {

            //Get the workbook instance for XLS file
            Workbook workbook = WorkbookFactory.create(file);
            //Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            //Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //Get iterator to all cells of current row
                Iterator<Cell> cellIterator = row.cellIterator();

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public int guardarSocio(Socio so) {
        s = s.getSociosByRut(so.getRutSocio());
        if (s.getNombreSocio() == null) {
            int i = s.insertSocio(so);
            if (i == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            s.setIdEstado(1);
            int i = s.updateSocio(s);
            if (i == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public void formInsertarSocio() {
    }

    public LinkedList<Banco> fillBancoComboBox(JComboBox bancoComboBox) {
        LinkedList<Banco> listBancos = b.getAllBancos();
        for (Banco ba : listBancos) {
            bancoComboBox.addItem(ba.getNombreBanco());
        }
        return listBancos;
    }

    public boolean validateNullMainFields(JTextField rutTextField, JTextField nameTextField, JTextField lastnameTextField) {

        if ((rutTextField.getText().length() == 0) || (nameTextField.getText().length() == 0) || (lastnameTextField.getText().length() == 0)) {

            if (rutTextField.getText().length() == 0) {
                rutTextField.setBackground(Color.red);
            }
            if (nameTextField.getText().length() == 0) {
                nameTextField.setBackground(Color.red);
            }
            if (lastnameTextField.getText().length() == 0) {
                lastnameTextField.setBackground(Color.red);
            }
            return true;
        }

        if ("".equals(rutTextField.getText()) || "".equals(nameTextField.getText()) || "".equals(lastnameTextField.getText())) {

            if ("".equals(rutTextField.getText())) {
                rutTextField.setBackground(Color.red);
            }
            if ("".equals(nameTextField.getText())) {
                nameTextField.setBackground(Color.red);
            }
            if ("".equals(lastnameTextField.getText())) {
                lastnameTextField.setBackground(Color.red);
            }
            return true;
        }
        return false;
    }
}
