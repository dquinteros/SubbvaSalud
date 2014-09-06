/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import subbvasalud.models.DetalleSolicitud;
import subbvasalud.models.Periodo;
import subbvasalud.models.Socio;
import subbvasalud.models.SolicitudDeReembolso;
import subbvasalud.models.TipoDeDocumento;

/**
 *
 * @author damage
 */
public class ReportController {

    public ReportController() {
    }

    public void createPersonalReport(File file, Socio socio, Periodo periodo) {

        SolicitudDeReembolso s = new SolicitudDeReembolso();
        s = s.getSolicitudByPeriodoAndSocio(socio.getIdSocio(), periodo.getId_periodo());
        if (s != null) {
            Workbook wb = createPersonalReport(s, socio);
            try (FileOutputStream out = new FileOutputStream(file.getPath() + ".xlsx")) {
                wb.write(out);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private Workbook createPersonalReport(SolicitudDeReembolso s, Socio so) {
        try {
            String path = System.getProperty("user.dir").substring(2).replace('\\', '/') + "/data/formatoInforme.xlsx";
            File f = new File(path);
            DetalleSolicitud d = new DetalleSolicitud();
            LinkedList<DetalleSolicitud> detalles = d.getAllDetallebyIdSolicitud(s.getIdSolicitud());
            Workbook workbook = WorkbookFactory.create(f);
            //Get first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            //Get iterator to all the rows in current sheet
            CellStyle style = workbook.createCellStyle();
            style.setBorderBottom(CellStyle.BORDER_MEDIUM);
            style.setBorderTop(CellStyle.BORDER_MEDIUM);
            style.setBorderRight(CellStyle.BORDER_MEDIUM);
            style.setBorderLeft(CellStyle.BORDER_MEDIUM);

            CellStyle styleLeftSide = workbook.createCellStyle();
            CellStyle styleRightSide = workbook.createCellStyle();
            styleRightSide.setBorderRight(CellStyle.BORDER_MEDIUM);
            styleLeftSide.setBorderLeft(CellStyle.BORDER_MEDIUM);
            styleLeftSide.setDataFormat(workbook.createDataFormat().getFormat("dd/mm/yyyy hh:mm"));

            Row row = sheet.createRow(1);
            Cell cell = row.createCell(1);
            cell.setCellValue("Rut:" + so.getRutSocio());
            cell = row.createCell(2);
            cell.setCellValue("Nombre:" + so.getNombreSocio());

            row = sheet.createRow(2);

            cell = row.createCell(1);
            cell.setCellValue("Fecha");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("Rut");
            cell.setCellStyle(style);
            cell = row.createCell(3);
            cell.setCellValue("Cod");
            cell.setCellStyle(style);
            cell = row.createCell(4);
            cell.setCellValue("Prestacion");
            cell.setCellStyle(style);
            cell = row.createCell(5);
            cell.setCellValue("Bon %");
            cell.setCellStyle(style);
            cell = row.createCell(6);
            cell.setCellValue("Vtotal");
            cell.setCellStyle(style);
            cell = row.createCell(7);
            cell.setCellValue("Cbonific");
            cell.setCellStyle(style);
            cell = row.createCell(8);
            cell.setCellValue("Reembolso");
            cell.setCellStyle(style);
            int i = 3;
            while (!detalles.isEmpty()) {
                DetalleSolicitud de = detalles.pop();
                row = sheet.createRow(i);
                cell = row.createCell(1);
                cell.setCellValue(de.getFecha());
                cell.setCellStyle(styleLeftSide);
                cell = row.createCell(2);
                cell.setCellValue(de.getRut());
                cell = row.createCell(3);
                cell.setCellValue(de.getId_tipo());
                cell = row.createCell(4);
                cell.setCellValue(de.getNombre());
                cell = row.createCell(5);
                TipoDeDocumento t = new TipoDeDocumento();
                t = t.getTipoDocumentoById(de.getId_tipo());
                cell.setCellValue(t.getPorcentaje_tipo() + "%");
                cell = row.createCell(6);
                cell.setCellValue(de.getMonto_total());
                cell = row.createCell(7);
                cell.setCellValue(de.getNo_bonificado());
                cell = row.createCell(8);
                cell.setCellValue(de.getReembolso());
                cell.setCellStyle(styleRightSide);
                i++;
            }

            row = sheet.createRow(i);
            cell = row.createCell(7);
            cell.setCellValue("Total");
            cell.setCellStyle(style);
            cell = row.createCell(8);
            cell.setCellValue(s.getMontoTotal());
            cell.setCellStyle(style);

            return workbook;
        } catch (IOException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createGeneralReport(File file, Periodo p) {
        try {
            SolicitudDeReembolso sdr = new SolicitudDeReembolso();
            LinkedList<SolicitudDeReembolso> ls = sdr.getAllSolicitudByPeriodo(p.getId_periodo());
            String path = System.getProperty("user.dir").substring(2).replace('\\', '/') + "/data/formatoInforme.xlsx";
            File f = new File(path);
            Workbook workbook = WorkbookFactory.create(f);
            int i = 0;
            for (SolicitudDeReembolso solicitud : ls) {
                Object[] obj = makeGeneralReport(solicitud, i, workbook);
                i = (int) obj[0];
                workbook = (Workbook) obj[1];
            }
            try (FileOutputStream out = new FileOutputStream(file.getPath() + ".xlsx")) {
                workbook.write(out);
            }

        } catch (IOException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Object[] makeGeneralReport(SolicitudDeReembolso s, int i, Workbook workbook) {
        String path = System.getProperty("user.dir").substring(2).replace('\\', '/') + "/data/formatoInforme.xlsx";
        DetalleSolicitud d = new DetalleSolicitud();
        LinkedList<DetalleSolicitud> detalles = d.getAllDetallebyIdSolicitud(s.getIdSolicitud());
        Socio so = new Socio();
        so = so.getSociosById(s.getIdSocio());
        Sheet sheet = workbook.getSheetAt(0);
        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(CellStyle.BORDER_MEDIUM);
        style.setBorderTop(CellStyle.BORDER_MEDIUM);
        style.setBorderRight(CellStyle.BORDER_MEDIUM);
        style.setBorderLeft(CellStyle.BORDER_MEDIUM);
        CellStyle styleLeftSide = workbook.createCellStyle();
        CellStyle styleRightSide = workbook.createCellStyle();
        styleLeftSide.setDataFormat(workbook.createDataFormat().getFormat("dd/mm/yyyy hh:mm"));
        Row row;
        Cell cell;
        while (!detalles.isEmpty()) {
            DetalleSolicitud de = detalles.pop();
            row = sheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(so.getRutSocio());
            cell = row.createCell(1);
            cell.setCellValue(so.getNombreSocio());
            cell = row.createCell(2);
            cell.setCellValue(de.getFecha());
            cell.setCellStyle(styleLeftSide);
            cell = row.createCell(3);
            cell.setCellValue(de.getRut());
            cell = row.createCell(4);
            cell.setCellValue(de.getId_tipo());
            cell = row.createCell(5);
            cell.setCellValue(de.getNombre());
            cell = row.createCell(6);
            TipoDeDocumento t = new TipoDeDocumento();
            t = t.getTipoDocumentoById(de.getId_tipo());
            cell.setCellValue(t.getPorcentaje_tipo() + "%");
            cell = row.createCell(7);
            cell.setCellValue(de.getMonto_total());
            cell = row.createCell(8);
            cell.setCellValue(de.getNo_bonificado());
            cell = row.createCell(9);
            cell.setCellValue(de.getReembolso());
            cell.setCellStyle(styleRightSide);
            cell = row.createCell(10);
            cell.setCellValue(s.getMontoTotal());
            cell.setCellStyle(style);
            i++;
        }
        Object[] obj = new Object[2];
        obj[0] = i;
        obj[1] = workbook;
        return obj;
    }

}
