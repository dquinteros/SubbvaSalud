/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import subbvasalud.models.DetalleSolicitud;
import subbvasalud.models.Periodo;
import subbvasalud.models.Socio;
import subbvasalud.models.SolicitudDeReembolso;

/**
 *
 * @author damage
 */
public class SolicitudController {

    SolicitudDeReembolso sr;
    Periodo p;
    Socio s;
    LinkedList<SolicitudDeReembolso> lsr;

    /**
     *
     */
    public SolicitudController() {
        sr = new SolicitudDeReembolso();
        p = new Periodo();
        s = new Socio();
    }

    /**
     *
     * @param sre
     * @return
     */
    public int guardarSolicitud(SolicitudDeReembolso sre) {

        int i = sr.insertSolicitud(sre);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     *
     * @param sre
     * @return
     */
    public int editarSolicitud(SolicitudDeReembolso sre) {
        int i = sr.updateSolicitud(sre);
        if (i == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public SolicitudDeReembolso getSolicitud(int id) {
        return sr.getSolicitudById(id);
    }

    /**
     *
     * @param sre
     * @return
     */
    public int guardarSolicitudCondicional(SolicitudDeReembolso sre) {
        SolicitudDeReembolso sol;
        sol = sre.getSolicitudByPeriodoAndSocio(sre.getIdSocio(), sre.getIdPeriodo());
        if (sol.getFecha() != null) {
            sre.setIdSolicitud(sol.getIdSolicitud());
            editarSolicitud(sre);
        } else {
            guardarSolicitud(sre);
        }
        sol = sre.getSolicitudByPeriodoAndSocio(sre.getIdSocio(), sre.getIdPeriodo());
        return sol.getIdSolicitud();
    }

    /**
     *
     * @param tableModel
     * @param id
     */
    public void mostrarDetalle(DefaultTableModel tableModel, int id) {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        LinkedList<DetalleSolicitud> lds = new LinkedList<>();
        DetalleSolicitud ds = new DetalleSolicitud();
        lds = ds.getAllDetallebyIdSolicitud(id);
        if (lds != null) {
            for (DetalleSolicitud d : lds) {
                Object[] obj = new Object[6];
                obj[0] = d.getId_tipo();
                obj[1] = d.getNombre();
                obj[2] = d.getMonto_total();
                obj[3] = d.getNo_bonificado();
                obj[4] = d.getReembolso();
                obj[5] = f.format(d.getFecha());
                tableModel.addRow(obj);
            }
        } else {
            System.out.println("Table Empty");
        }
    }

}
