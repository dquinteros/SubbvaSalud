/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import java.util.Collections;
import java.util.LinkedList;
import subbvasalud.models.Condicion;
import subbvasalud.models.DetalleSolicitud;
import subbvasalud.models.Periodo;
import subbvasalud.models.SolicitudDeReembolso;
import subbvasalud.models.TipoDeDocumento;
import subbvasalud.models.Tope;
import subbvasalud.views.ViewUtils;

/**
 *
 * @author damage
 */
public class DocumentUtils {

    public static LinkedList<Tope> getTopebyDocType(TipoDeDocumento tipo) {
        Condicion auxCondicion = new Condicion();
        LinkedList<Condicion> condiciones = auxCondicion.getAllCondiciones();
        LinkedList<Condicion> docCondList = new LinkedList<>();
        for (Condicion condicion : condiciones) {
            if (condicion.getIdTipo() == tipo.getId_tipo()) {
                docCondList.add(condicion);
            }
        }
        LinkedList<Tope> ans = new LinkedList<>();
        for (Condicion cond : docCondList) {
            Tope newTope = new Tope();
            newTope = newTope.getTopeById(cond.getIdTope());
            ans.add(newTope);
        }
        return ans;
    }

    public static int calculaReeembolso(TipoDeDocumento tipo, int monto, int rut, Periodo periodo) {

        int reembolso = 0;
        if (ViewUtils.validaRut(rut)) {
            LinkedList<Tope> topes = getTopebyDocType(tipo);
            if (topes.size() == 1) {
                Tope tope = topes.getFirst();
                reembolso = calculaReembolsoUnaCondicion(tipo, monto, tope, periodo, rut);
            } else if (topes.size() > 1) {
                LinkedList<Integer> reembolsos = new LinkedList();
                for (Tope tope : topes) {
                    int reembolsoAux = calculaReembolsoUnaCondicion(tipo, monto, tope, periodo, rut);
                    reembolsos.add(reembolsoAux);
                }
                reembolso = Collections.min(reembolsos);
            }
        }
        return reembolso;
    }

    public static int calculaReembolsoUnaCondicion(TipoDeDocumento tipo, int monto, Tope tope, Periodo periodo, int rut) {
        int reembolso = 0;
        if (tope.getTope() != 0) {
            if (tope.getTipoTope() == 1) {
                //Topes anuales
                if (tope.getMonedaTope() == 0) {
                    int uf = periodo.getValor_uf();
                    reembolso = (monto * uf * tipo.getPorcentaje_tipo()) / 100;
                    int acumulado = getSumaDeMontosByRut(rut, tope, periodo);
                    int total = reembolso + acumulado;
                    if (total > (tope.getTope() * uf)) {
                        reembolso = (int) (reembolso - (total - (tope.getTope() * uf)));
                    }
                } else {
                    reembolso = (monto * tipo.getPorcentaje_tipo()) / 100;
                    int acumulado = getSumaDeMontosByRut(rut, tope, periodo);
                    int total = reembolso + acumulado;
                    if (total > tope.getTope()) {
                        reembolso = (int) (reembolso - (total - tope.getTope()));
                    }
                }

            } else if (tope.getTipoTope() == 0) {
                //Topes por Eventos
                if (tope.getMonedaTope() == 0) {
                    int uf = periodo.getValor_uf();
                    reembolso = (monto * uf * tipo.getPorcentaje_tipo()) / 100;
                    if (reembolso > (tope.getTope() * uf)) {
                        reembolso = (int) (tope.getTope() * uf);
                    }
                } else {
                    reembolso = (monto * tipo.getPorcentaje_tipo()) / 100;
                    if (reembolso > tope.getTope()) {
                        reembolso = (int) tope.getTope();
                    }
                }
            }
        } else {
            reembolso = monto;
        }
        return reembolso;
    }

    public static int getSumaDeMontosByRut(int rut, Tope tope, Periodo periodo) {
        LinkedList<DetalleSolicitud> documentos = getAllDocByIdYear(periodo.getId_anio(), rut);
        LinkedList<TipoDeDocumento> tipos = getTiposbyTope(tope);
        int suma = 0;

        for (DetalleSolicitud doc : documentos) {
            for (TipoDeDocumento tipo : tipos) {
                if (doc.getId_tipo() == tipo.getId_tipo()) {
                    suma += doc.getReembolso();
                }
            }
        }
        return suma;
    }

    public static LinkedList<DetalleSolicitud> getAllDocByIdYear(int id, int rut) {
        Periodo periodo = new Periodo();
        LinkedList<Periodo> periodos = periodo.getAllPeriodosByYear(id);

        LinkedList<SolicitudDeReembolso> solicitudes = new LinkedList<>();

        SolicitudDeReembolso sdr = new SolicitudDeReembolso();
        for (Periodo per : periodos) {
            LinkedList<SolicitudDeReembolso> auxSoli = sdr.getAllSolicitudByPeriodo(id);
            solicitudes.addAll(auxSoli);
        }
        LinkedList<DetalleSolicitud> detalles = new LinkedList<>();
        DetalleSolicitud ds = new DetalleSolicitud();
        for (SolicitudDeReembolso solicitud : solicitudes) {
            LinkedList<DetalleSolicitud> detalleAux = ds.getAllDetallebyIdSolicitud(id, rut);
            detalles.addAll(detalleAux);
        }
        return detalles;
    }

    public static LinkedList<TipoDeDocumento> getTiposbyTope(Tope tope) {
        Condicion auxCondicion = new Condicion();
        LinkedList<Condicion> condiciones = auxCondicion.getAllCondiciones();
        LinkedList<Condicion> docCondList = new LinkedList<>();
        for (Condicion condicion : condiciones) {
            if (condicion.getIdTope() == tope.getIdTope()) {
                docCondList.add(condicion);
            }
        }
        LinkedList<TipoDeDocumento> ans = new LinkedList<>();
        for (Condicion cond : docCondList) {
            TipoDeDocumento newTipoDoc = new TipoDeDocumento();
            newTipoDoc = newTipoDoc.getTipoDeDocumentosById(cond.getIdTipo());
            ans.add(newTipoDoc);
        }
        return ans;
    }

}
