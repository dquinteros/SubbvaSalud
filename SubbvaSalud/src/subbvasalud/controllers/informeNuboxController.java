/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.controllers;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import subbvasalud.models.DetalleSolicitud;
import subbvasalud.models.Periodo;
import subbvasalud.models.Socio;
import subbvasalud.models.SolicitudDeReembolso;

/**
 *
 * @author damage
 */
public class informeNuboxController {

    /**
     *
     */
    public informeNuboxController() {
    }

    /**
     *
     * @param f
     * @param p
     */
    public void createNuboxReport(File f, Periodo p) {
        String comprobantes = f.getPath().replace('\\', '/');
        SolicitudDeReembolso sdr = new SolicitudDeReembolso();
        LinkedList<SolicitudDeReembolso> ls = sdr.getAllSolicitudByPeriodo(p.getId_periodo());
        int i = createComprobantesFile(comprobantes, ls);

    }

    private LinkedList<DetalleSolicitud> getDetallesFromSolicitud(LinkedList<SolicitudDeReembolso> ls) {
        LinkedList<DetalleSolicitud> ld = new LinkedList<>();
        DetalleSolicitud dsAux = new DetalleSolicitud();
        for (SolicitudDeReembolso sr : ls) {
            ld.addAll(dsAux.getAllDetallebyIdSolicitud(sr.getIdSolicitud()));
        }
        return ld;
    }

    private int sumaDetalles(LinkedList<DetalleSolicitud> ld) {
        int sum = 0;
        for (DetalleSolicitud ds : ld) {
            sum += ds.getReembolso();
        }
        return sum;
    }

    private Integer getMontoTotal(Integer[] montos) {
        Integer total = 0;
        for (Integer integer : montos) {
            total += integer;
        }
        return total;
    }

    private String[] getFecha() {
        Calendar cal = Calendar.getInstance();
        Integer dia = cal.get(Calendar.DAY_OF_MONTH);
        Integer mes = cal.get(Calendar.MONTH) + 1;
        Integer anio = cal.get(Calendar.YEAR);
        return new String[]{dia.toString(), mes.toString(), anio.toString()};
    }

    //prepara la lista de strings a escribir en el archivo de comprobantes
    private LinkedList<String[]> prepareCompList(Integer[] montos) {
        String[] date = getFecha();
        LinkedList<String[]> lc = new LinkedList<>();
        lc.add(new String[]{"Código de cuenta asociada al movimiento", "Día del movimiento", "Mes del movimiento", "Año del movimiento", "Número del comprobante", "Tipo comprobante (1: Ingreso, 2: Egreso, 3: Traspaso)", "Valor al debe", "Valor al haber", "Número de secuencia", "Código de centro de costo", "Glosa", "Código de sucursal"});
        Integer i = 1;
        if (montos[0] > 0) {
            lc.add(new String[]{"2155-10", date[0], date[1], date[2], "", "2", montos[0].toString(), "0", i.toString(), "", "Reembolso Lentes"});
            i++;
        }
        if (montos[1] > 0) {
            lc.add(new String[]{"2155-11", date[0], date[1], date[2], "", "2", montos[1].toString(), "0", i.toString(), "", "Reembolso Salud"});
            i++;
        }
        if (montos[2] > 0) {
            lc.add(new String[]{"2155-12", date[0], date[1], date[2], "", "2", montos[2].toString(), "0", i.toString(), "", "Reembolso Dental"});
            i++;
        }
        if (montos[3] > 0) {
            lc.add(new String[]{"2155-13", date[0], date[1], date[2], "", "2", montos[3].toString(), "0", i.toString(), "", "Reembolso Farmacia"});
            i++;
        }
        lc.add(new String[]{"1111-11", date[0], date[1], date[2], "", "2", "0", getMontoTotal(montos).toString(), i.toString(), "", "Reembolso"});

        return lc;
    }

    private void printFile(LinkedList<String[]> list, String fileName) {
        try {
            OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(fileName + ".csv"), "Cp1252");
            CSVWriter wr = new CSVWriter(fw, ';', '\u0000');
            wr.writeAll(list);
            wr.close();
        } catch (IOException ex) {
            Logger.getLogger(informeNuboxController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Escribe el archivo de comprobantes
    private void plantImportComprobantes(String fileName, Integer[] montos) {
        LinkedList<String[]> lc = new LinkedList<>();
        lc = prepareCompList(montos);
        printFile(lc, fileName);
    }

    private void plantImportAuxiliares(String fileName, LinkedList<LinkedList<DetalleSolicitud>> lista) {
        fileName += "_auxiliares";
        LinkedList<String[]> la = new LinkedList<>();
        la = prepareAux(lista);
        printFile(la, fileName);
    }

    // Obtiene las sumas totales por cada cuenta nubox
    private Integer[] getSumas(LinkedList<LinkedList<DetalleSolicitud>> listas) {
        Integer[] sumas = new Integer[4];
        int i = 0;
        for (LinkedList<DetalleSolicitud> linkedList : listas) {
            sumas[i] = sumaDetalles(linkedList);
            i++;
        }
        return sumas;
    }

    //crea los archivos de salida de comprobantes
    private int createComprobantesFile(String fileName, LinkedList<SolicitudDeReembolso> ls) {
        //Obtener todos los detalles de las solicitudes del periodo
        LinkedList<DetalleSolicitud> ld = new LinkedList<>();
        ld = getDetallesFromSolicitud(ls);
        //Inicializar las listas de detalles segun cuenta
        LinkedList<DetalleSolicitud> lentes = new LinkedList<>(),
                dental = new LinkedList<>(),
                farmacia = new LinkedList<>(),
                salud = new LinkedList<>();
        //Rellenar cada lista con los documentos que les corresponden
        for (DetalleSolicitud ds : ld) {
            int code = ds.getId_tipo();
            if (code == 113) {
                lentes.add(ds); //Cuenta lentes 2155-10
            } else if (code == 145) {
                dental.add(ds); //Cuenta dental 2155-12
            } else if (code == 152 || code == 182 || code == 1521 || code == 1821) {
                farmacia.add(ds);//Cuenta farmacia 2155-13
            } else {
                salud.add(ds);//Cuenta salud 2155-11
            }
        }
        //Inicializar lista con para almacenar las cuatro listas de detalles
        LinkedList<LinkedList<DetalleSolicitud>> listas = new LinkedList<>();
        listas.add(lentes);
        listas.add(salud);
        listas.add(dental);
        listas.add(farmacia);

        Integer[] sumas = getSumas(listas);

        plantImportComprobantes(fileName, sumas);
        plantImportAuxiliares(fileName, listas);
        return 0;
    }

    private String getRutSinDV(Socio s) {
        String rut = s.getRutSocio();
        return rut.substring(0, rut.length() - 1);
    }

    private String getDV(Socio s) {
        String rut = s.getRutSocio();
        return String.valueOf(rut.charAt(rut.length() - 1));
    }

    private LinkedList<String[]> prepareAux(LinkedList<LinkedList<DetalleSolicitud>> lista) {
        String[] date = getFecha();
        LinkedList<String[]> la = new LinkedList<>();
        SolicitudDeReembolso sr = new SolicitudDeReembolso();
        Socio s = new Socio();
        Integer i = 1;
        Integer cta = 10;
        la.add(new String[]{"Código de cuenta usada como auxiliar (cuenta relacionada al auxiliar y la cuenta corriente)","Rut Cliente","Digito verificador","Nombre Cliente","Número del documento","Número de línea del detalle ","Día del vencimiento del documento","Mes del vencimiento del documento","Año del vencimiento del documento","Valor del documento","Mes del periodo contable o tributario ","Año del periodo contable o tributario","Número del comprobante","Tipo comprobante (1: Ingreso, 2: Egreso, 3: Traspaso)"," Número de secuencia comprobante"});
        for (LinkedList<DetalleSolicitud> linkedList : lista) {
            for (DetalleSolicitud ds : linkedList) {
                if (ds.getReembolso() > 0) {
                    int id_sol = ds.getId_solicitud();
                    sr = sr.getSolicitudById(id_sol);
                    s = s.getSociosById(sr.getIdSocio());
                    String rut = getRutSinDV(s);
                    String dv = getDV(s);
                    la.add(new String[]{"2155-" + cta, rut, dv, s.getNombreSocio(), i.toString(), i.toString(), "", "", "", ds.getReembolso() + "",date[1],date[2],"","2",i.toString()});
                    i++;
                }
            }
            cta++;
        }
        return la;
    }

}
