/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import subbvasalud.models.Periodo;
import subbvasalud.models.Socio;
import subbvasalud.models.SolicitudDeReembolso;
import subbvasalud.views.ViewUtils;

/**
 *
 * @author damage
 */
public class InfoController {

    public InfoController() {
    }

    public void createPlanPago(String file, int idPeriodo) {
        PeriodoController pc = new PeriodoController();
        Periodo p = pc.getPeriodo(idPeriodo);
        if (p != null) {
            SolicitudDeReembolso s = new SolicitudDeReembolso();
            LinkedList<SolicitudDeReembolso> solicitudes = s.getAllSolicitudByPeriodo(idPeriodo);
            LinkedList<String> pagos = new LinkedList<>();
            LinkedList<String> cheques = new LinkedList<>();
            for (SolicitudDeReembolso solicitud : solicitudes) {
                String linea = createSingleLine(solicitud);
                if (linea != null) {
                    pagos.add(linea);
                } else {
                    String lineaCheque = createSingleExcludeLine(solicitud);
                    if (lineaCheque != null) {
                        cheques.add(lineaCheque);
                    }
                }
            }
            printListToFile(file, pagos);
            file = StringUtils.replace(file, ".txt", " cheque.txt");
            printListToFile(file, cheques);
        }
    }

    public String createSingleExcludeLine(SolicitudDeReembolso solicitud) {
        Socio s = new Socio();
        s = s.getSociosById(solicitud.getIdSocio());
        if (s != null) {

            String linea;
            String rut = s.getRutSocio().trim();
            rut = StringUtils.leftPad(rut, 9, '0');
            String name = s.getNombreSocio().trim().toUpperCase();
            name = StringUtils.substring(name, 0, 44);
            if (solicitud.getMontoTotal() <= 0) {
                return null;
            }
            String monto = solicitud.getMontoTotal() + "";
            monto = StringUtils.leftPad(monto, 9, '0');
            linea = rut + "   " + name + "  " + monto;
            System.out.println(linea);
            return linea;
        }
        return null;
    }

    public String createSingleLine(SolicitudDeReembolso solicitud) {
        Socio s = new Socio();
        s = s.getSociosById(solicitud.getIdSocio());
        if (s != null) {

            String cuenta = s.getCuentaBancariaSocio().trim();
            int code = s.getTipoCuentaSocio();
            
            if ((cuenta.length() < 19) && ViewUtils.isNum(cuenta) && (code > 0) && (code < 5)) {
                String linea;
                String rut = s.getRutSocio().trim();
                rut = StringUtils.leftPad(rut, 9, '0');
                String idCode = StringUtils.rightPad(rut, 15);
                String name = s.getNombreSocio().trim().toUpperCase().replace('Ñ', 'N');
                name = StringUtils.substring(name, 0, 44);
                name = StringUtils.rightPad(name, 45);
                String uno = "1";
                String codBanco = "504";
                cuenta = StringUtils.rightPad(cuenta, 20);
                if (solicitud.getMontoTotal() <= 0) {
                    return null;
                }
                String monto = solicitud.getMontoTotal() + "";
                monto = StringUtils.leftPad(monto, 9, '0');
                linea = rut + idCode + name + uno + codBanco + cuenta + code + monto;
                System.out.println(linea);
                return linea;
            }
        }
        return null;
    }

    public void printListToFile(String fileName, LinkedList<String> lista) {
        FileWriter fstream = null;
        try {
            fstream = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            for (String string : lista) {
                out.write(string);
                out.newLine();
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fstream.close();
            } catch (IOException ex) {
                Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
