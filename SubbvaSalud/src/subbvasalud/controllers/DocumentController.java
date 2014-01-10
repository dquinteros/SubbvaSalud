/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.util.LinkedList;
import subbvasalud.models.DetalleSolicitud;
import subbvasalud.models.SolicitudDeReembolso;
import subbvasalud.models.TipoDeDocumento;

/**
 *
 * @author damage
 */
public class DocumentController {

    DetalleSolicitud ds;
    SolicitudDeReembolso sr;
    SolicitudController src;
    TipoDeDocumento td;

    /**
     *
     */
    public DocumentController() {
        ds = new DetalleSolicitud();
        sr = new SolicitudDeReembolso();
        src = new SolicitudController();
        td = new TipoDeDocumento();
    }

    /**
     *
     * @param dso
     * @return
     */
    public int guardarDocumento(DetalleSolicitud dso) {

        int i = ds.insertDetalle(dso);
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
    public TipoDeDocumento getById(int id) {
        TipoDeDocumento newType = new TipoDeDocumento();
        LinkedList<TipoDeDocumento> tipos = newType.getAllTipoDocumentos();
        for (TipoDeDocumento tipo : tipos) {
            if (tipo.getId_tipo() == id) {
                return tipo;
            }
        }
        return null;
    }

}
