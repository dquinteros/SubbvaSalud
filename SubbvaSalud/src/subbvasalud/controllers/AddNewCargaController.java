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
import javax.swing.JTextField;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import subbvasalud.models.Carga;
import subbvasalud.models.Socio;
import subbvasalud.views.ViewUtils;

/**
 *
 * @author damage
 */
public class AddNewCargaController {

    Carga c;
    Socio s;

    /**
     *
     */
    public AddNewCargaController() {
        s = new Socio();
        c = new Carga();
    }

    /**
     *
     * @param ca
     * @return
     */
    public int guardarCarga(Carga ca) {
        c = c.getCargasByRut(ca.getRut());
        if (c.getNombre() == null) {
            int i = c.insertCarga(ca);
            if (i == 0) {
                return 0;
            } else {
                return 1;
            }
        } else {
            c.setIdEstado(1);
            int i = c.updateCarga(c);
            if (i == 0) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    /**
     *
     * @param rutTextField
     * @param nameTextField
     * @param lastnameTextField
     * @param rutSocioTextField
     * @return
     */
    public boolean validateNullMainFields(JTextField rutTextField, JTextField nameTextField, JTextField lastnameTextField, JTextField rutSocioTextField) {

        if ((rutTextField.getText().length() == 0) || (nameTextField.getText().length() == 0) || (lastnameTextField.getText().length() == 0) || (rutSocioTextField.getText().length() == 0)) {

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

        if ("".equals(rutTextField.getText()) || "".equals(nameTextField.getText()) || "".equals(lastnameTextField.getText()) || "".equals(rutSocioTextField.getText())) {

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

    public void cargaMasivaCargasLegales(File file) {
        if (file.exists() && file.isFile() && file.canRead()) {
            LinkedList<Carga> cargasNuevas = cargaArchivo(file);
            LinkedList<Carga> cargasActuales = c.getAllCargasFull();
            LinkedList<String> lista = new LinkedList<>();
            setAllCargasDisabled();
            boolean flag = true;
            for (Carga carga : cargasNuevas) {
                for (Carga ca : cargasActuales) {
                    if (ca.getRut().trim().equals(carga.getRut().trim())) {
                        ca.setIdEstado(1);
                        lista.add(c.cargaToSqlUpdate(ca));
                        flag = false;
                    }
                }
                if (flag) {
                    lista.add(c.cargaToSqlInsert(carga));
                }
                flag = true;
            }
            c.insertAllCarga(lista);
        }
    }

    private LinkedList<Carga> cargaArchivo(File file) {
        try {

            //Get the workbook instance for XLS file
            Workbook workbook = WorkbookFactory.create(file);
            //Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            //Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = sheet.iterator();
            LinkedList<Carga> cargas = new LinkedList<>();
            LinkedList<Socio> socios = s.getAllSocios();
            CellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int i = 0;

                String name = null, rutSocio = null, rutCarga = null;
                while (cellIterator.hasNext() && i < 3) {
                    Cell cell = cellIterator.next();
                    switch (i) {
                        case 0:
                            rutSocio = getRut(cell);
                            if (rutSocio == null) {
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
                            rutCarga = getRut(cell);
                            if (rutCarga == null) {
                                cell.setCellStyle(style);
                            }
                            break;
                    }
                    i++;
                }
                if ((rutSocio == null) || (name == null) || (rutCarga == null)) {
                    row.setRowStyle(style);
                } else {
                    for (Socio socio : socios) {
                        if (socio.getRutSocio().equals(rutSocio)) {
                            Carga car = new Carga(-1, socio.getIdSocio(), rutCarga, name, 1);
                            cargas.add(car);
                        }
                    }

                }
            }
            try (FileOutputStream out = new FileOutputStream(file.getName())) {
                workbook.write(out);
            }
            return cargas;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(AddNewSocioController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void setAllCargasDisabled() {
        Carga c = new Carga();
        LinkedList<Carga> cargas = c.getAllCargas();
        for (Carga carga : cargas) {
            carga.setIdEstado(0);
            c.updateCarga(carga);
        }
    }
}
