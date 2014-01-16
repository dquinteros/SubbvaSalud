/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
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
        if (file.exists() && file.isFile() && file.canRead()) {
            SolicitudDeReembolso s = new SolicitudDeReembolso();
            s = s.getSolicitudByPeriodoAndSocio(socio.getIdSocio(), periodo.getId_periodo());
            if (s != null) {
                Workbook wb = createPersonalReport(s, socio, periodo);
            }
        }
    }

    private Workbook createPersonalReport(SolicitudDeReembolso s, Socio so, Periodo p) {
        try {
            String path = System.getProperty("user.dir").substring(2).replace('\\', '/') + "/data/formatoInforme.xlsx";
            File f = new File(path);
            int i = 0, j = 0;
            DetalleSolicitud d = new DetalleSolicitud();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
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
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (i == 1 && j == 15) {
                        cell.setCellValue("Rut:" + so.getRutSocio());
                    } else if (i == 2 && j == 15) {
                        cell.setCellValue("Nombre:" + so.getNombreSocio());
                    } else if (i == 1 && j == 16) {
                        cell.setCellValue("Fecha:");                        
                        cell.setCellStyle(style);
                    } else if (i == 2 && j == 16) {
                        cell.setCellValue("Rut");
                        cell.setCellStyle(style);
                    } else if (i == 3 && j == 16) {
                        cell.setCellValue("Cod");
                        cell.setCellStyle(style);
                    } else if (i == 4 && j == 16) {
                        cell.setCellValue("Prestacion");
                        cell.setCellStyle(style);
                    } else if (i == 5 && j == 16) {
                        cell.setCellValue("Bon %");
                        cell.setCellStyle(style);
                    } else if (i == 6 && j == 16) {
                        cell.setCellValue("Vtotal");
                        cell.setCellStyle(style);
                    } else if (i == 7 && j == 16) {
                        cell.setCellValue("Cbonific");
                        cell.setCellStyle(style);
                    } else if (i == 8 && j == 16) {
                        cell.setCellValue("Reembolso");
                        cell.setCellStyle(style);
                    } else if (i > 8) {
                        break;
                    }
                    if (!detalles.isEmpty()) {
                        DetalleSolicitud de = detalles.pop();
                        if (i == 1 && j > 16) {                            
                            cell.setCellValue(df.format(de.getFecha()));                            
                        } else if (i == 2 && j > 16) {
                            cell.setCellValue(de.getRut());                            
                        } else if (i == 3 && j > 16) {
                            cell.setCellValue(de.getId_tipo());
                        } else if (i == 4 && j > 16) {
                            cell.setCellValue(de.getNombre());
                        } else if (i == 5 && j > 16) {
                            TipoDeDocumento t = new TipoDeDocumento();
                            t = t.getTipoDocumentoById(de.getId_tipo());
                            cell.setCellValue(t.getPorcentaje_tipo()+"%");
                        } else if (i == 6 && j > 16) {
                            cell.setCellValue(de.getMonto_total());
                        } else if (i == 7 && j > 16) {
                            cell.setCellValue(de.getNo_bonificado());
                        } else if (i == 8 && j > 16) {
                            
                            cell.setCellStyle(style);
                        } else if (i > 8) {
                            break;
                        }
                    }
                    i++;
                }
                i = 0;
                j++;
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(ReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
