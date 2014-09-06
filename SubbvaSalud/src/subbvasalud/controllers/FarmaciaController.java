/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import subbvasalud.models.DetalleSolicitud;
import subbvasalud.models.Periodo;
import subbvasalud.models.Socio;
import subbvasalud.models.SolicitudDeReembolso;
import subbvasalud.views.ViewUtils;

/**
 *
 * @author damage
 */
public class FarmaciaController {

    public FarmaciaController() {
    }

    public void ingresoFarmacias(File f, Periodo p) {
        LinkedList<FarmaciaDTO> descFarma = this.obtenenerDesc(f);
        Socio s = new Socio();
        SolicitudDeReembolso sdr = new SolicitudDeReembolso();
        LinkedList<Socio> socios = s.getAllSocios();
        DocumentController dc = new DocumentController();
        if (descFarma.size() > 0) {
            for (FarmaciaDTO desc : descFarma) {
                if ((s = isSocio(desc.getRut(), socios)) != null) {
                    sdr = new SolicitudDeReembolso(-1, s.getIdSocio(), p.getId_periodo(), new Date(), desc.getMonto());
                    sdr.insertSolicitud(sdr);
                    sdr = sdr.getSolicitudByPeriodoAndSocio(s.getIdSocio(), p.getId_periodo());
                    DetalleSolicitud ds = new DetalleSolicitud(-1, sdr.getIdSolicitud(), 1522, "Tarjeta Farmacia", new Date(), desc.getMonto(), desc.getMonto(), desc.getMonto(), desc.getRut());
                    dc.guardarDocumento(ds);
                }
            }
        }
    }

    private Socio isSocio(String rut, LinkedList<Socio> socios) {
        for (Socio socio : socios) {
            if (socio.getRutSocio().trim().toUpperCase().equals(rut.trim().toUpperCase())) {
                return socio;
            }
        }
        return null;
    }

    private LinkedList<FarmaciaDTO> obtenenerDesc(File f) {
        try {
            //Get the workbook instance for XLS file
            Workbook workbook = WorkbookFactory.create(f);
            //Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            //Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = sheet.iterator();
            LinkedList<FarmaciaDTO> descFarma = new LinkedList<>();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                int i = 0;
                int monto = -1;
                String rut = null;
                while (cellIterator.hasNext() && i < 3) {
                    Cell cell = cellIterator.next();
                    switch (i) {
                        case 0:
                            rut = getRut(cell);
                            break;
                        case 1:
                            monto = getMonto(cell);
                            break;
                    }
                    i++;
                }
                if (monto != -1 && rut != null) {
                    FarmaciaDTO desc = new FarmaciaDTO(rut, monto);
                    descFarma.add(desc);
                }
            }
            return descFarma;
        } catch (IOException ex) {
            Logger.getLogger(FarmaciaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(FarmaciaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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

    public int getMonto(Cell cell) {
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String cuenta = cell.getStringCellValue();
        if (ViewUtils.isNum(cuenta.trim())) {
            return Integer.parseInt(cuenta.trim());
        } else {
            return -1;
        }
    }
}
