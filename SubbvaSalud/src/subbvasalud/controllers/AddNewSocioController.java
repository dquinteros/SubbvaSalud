/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import subbvasalud.models.Carga;
import subbvasalud.views.ViewUtils;

/**
 *
 * @author damage
 */
public class AddNewSocioController {

    Socio s;
    Banco b;

    /**
     *
     */
    public AddNewSocioController() {
        s = new Socio();
        b = new Banco();
    }

    /**
     *
     * @param file
     * @return
     */
    public int cargaMasivaSocios(File file) {
        if (file.exists() && file.isFile() && file.canRead()) {

            LinkedList<Socio> socios = cargaArchivo(file);
            setAllSociosDisabled();
            for (Socio socio : socios) {
                guardarSocio(socio);
            }
        }
        return 0;
    }

    public void setAllSociosDisabled() {
        Socio o = new Socio();
        LinkedList<Socio> socios = o.getAllSocios();
        for (Socio socio : socios) {
            socio.setIdEstado(0);
            o.updateSocio(socio);
        }
        Carga c = new Carga();
        LinkedList<Carga> cargas = c.getAllCargas();
        for (Carga carga : cargas) {
            carga.setIdEstado(0);
            c.updateCarga(carga);
        }
    }

    /**
     *
     * @param file
     * @return
     */
    public LinkedList<Socio> cargaArchivo(File file) {
        try {

            //Get the workbook instance for XLS file
            Workbook workbook = WorkbookFactory.create(file);
            //Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            //Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = sheet.iterator();
            LinkedList<Socio> socios = new LinkedList<>();
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int i = 0;
                int tipoCuenta = -1;
                String name = null, cuenta = null, rut = null;
                while (cellIterator.hasNext() && i < 4) {
                    Cell cell = cellIterator.next();
                    switch (i) {
                        case 0:
                            rut = getRut(cell);
                            if (rut == null) {
                                cell.setCellStyle(style);
                            }
                            break;
                        case 1:
                            name = getName(cell);
                            if (name == null) {
                                cell.setCellStyle(style);
                            }
                            break;
                        case 2:
                            cuenta = getCuenta(cell);
                            if (cuenta == null) {
                                cell.setCellStyle(style);
                            }
                            break;
                        case 3:
                            tipoCuenta = getTipoCuenta(cell);
                            if (tipoCuenta == -1) {
                                cell.setCellStyle(style);
                            }
                            break;
                    }
                    i++;
                }
                if ((rut == null) || (name == null)) {
                    row.setRowStyle(style);
                } else if ((cuenta == null) || (tipoCuenta == -1)) {
                    Socio socio = new Socio(-1, rut, name, "0", 0, 0, 1, 504);
                    socios.add(socio);
                } else {
                    Socio socio = new Socio(-1, rut, name, cuenta, tipoCuenta, 0, 1, 504);
                    socios.add(socio);
                }
            }
            try (FileOutputStream out = new FileOutputStream(file.getName())) {
                workbook.write(out);
            }
            return socios;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return null;
    }

    /**
     *
     * @param cell
     * @return
     */
    public String getRut(Cell cell) {
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String stringRut = cell.getStringCellValue();
        stringRut = stringRut.replaceFirst("^0+(?!$)", "");
        if (ViewUtils.validaRut(stringRut)) {
            return stringRut;
        } else {
            return null;
        }
    }

    /**
     *
     * @param cell
     * @return
     */
    public String getName(Cell cell) {
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String name = cell.getStringCellValue();
        if (ViewUtils.isAlpha(name) && (name.trim().length() <= 45)) {
            return name.trim();
        } else {
            return null;
        }
    }

    /**
     *
     * @param cell
     * @return
     */
    public String getCuenta(Cell cell) {
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String cuenta = cell.getStringCellValue();
        if (ViewUtils.isNum(cuenta.trim())) {
            return cuenta.trim();
        } else {
            return null;
        }
    }

    /**
     *
     * @param cell
     * @return
     */
    public int getTipoCuenta(Cell cell) {
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String cuenta = cell.getStringCellValue();
        if (ViewUtils.isNum(cuenta.trim())) {
            return Integer.parseInt(cuenta.trim());
        } else {
            return -1;
        }

    }

    /**
     *
     * @param so
     * @return
     */
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

    /**
     *
     */
    public void formInsertarSocio() {
    }

    /**
     *
     * @param bancoComboBox
     * @return
     */
    public LinkedList<Banco> fillBancoComboBox(JComboBox bancoComboBox) {
        LinkedList<Banco> listBancos = b.getAllBancos();
        for (Banco ba : listBancos) {
            bancoComboBox.addItem(ba.getNombreBanco());
        }
        return listBancos;
    }

    /**
     *
     * @param rutTextField
     * @param nameTextField
     * @param lastnameTextField
     * @return
     */
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
