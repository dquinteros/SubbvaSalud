/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author damage
 */
public class SolicitudDeReembolso extends Conexion {

    private int idSolicitud;
    private int idSocio;
    private int idPeriodo;
    private Date fecha;
    private int montoTotal;

    public SolicitudDeReembolso() {
    }

    public SolicitudDeReembolso(int idSolicitud, int idSocio, int idPeriodo, Date fecha, int montoTotal) {
        this.idSolicitud = idSolicitud;
        this.idSocio = idSocio;
        this.idPeriodo = idPeriodo;
        this.fecha = fecha;
        this.montoTotal = montoTotal;
    }

    public String solicitudToSqlInsert(SolicitudDeReembolso sr) {
        if (sr != null) {
            Calendar cal = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
            format.format(sr.getFecha());
            cal = format.getCalendar();
            String sql = "INSERT INTO \"solicitud_de_reembolso\""
                    + "(\"id_solicitud\","
                    + "\"id_socio\","
                    + "\"id_periodo\","
                    + "\"fecha_recepcion_solicitud\","
                    + "\"total_solicidtud\")"
                    + " VALUES("
                    + " NULL,"
                    + sr.getIdSocio() + ","
                    + sr.getIdPeriodo() + ","
                    + " '" + cal.getTime() + "',"
                    + sr.getMontoTotal()
                    + ");";
            return sql;
        } else {
            return null;
        }
    }

    public String solicitudToSqlUpdate(SolicitudDeReembolso sr) {
        if (sr != null) {
            Calendar cal = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
            format.format(sr.getFecha());
            cal = format.getCalendar();
            String sql = "UPDATE \"solicitud_de_reembolso\""
                    + " SET"
                    + " id_socio = " + sr.getIdSocio() + ","
                    + " fecha_recepcion_solicitud = \"" + cal.getTime() + "\","
                    + " id_periodo = " + sr.getIdPeriodo() + ","
                    + " total_solicidtud = " + sr.getMontoTotal()
                    + " WHERE id_solicitud= " + sr.getIdSolicitud()
                    + ";";
            System.out.println(sql);
            return sql;
        } else {
            return null;
        }
    }

    public String solicitudToSqlFindById(int id) {
        if (id > 0) {
            String sql = "SELECT * FROM solicitud_de_reembolso WHERE id_solicitud =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    public String solcitudToSqlFindBySocioAndPeriodo(int idSocio, int idPeriodo) {
        if (idSocio > 0) {
            String sql = "SELECT * FROM solicitud_de_reembolso WHERE  id_socio=" + idSocio + " and id_periodo =" + idPeriodo + ";";
            return sql;
        } else {
            return null;
        }
    }

    public int insertSolicitud(SolicitudDeReembolso sr) {
        String sql = this.solicitudToSqlInsert(sr);

        if (sql != null) {
            connect();
            try {
                query.executeUpdate(sql);
            } catch (SQLException e) {
                modelUtils.showSQLException(e);
            } finally {
                modelUtils.postUpdateFinally(query, connection);
            }
            return 0;
        }
        return 1;
    }

    public int updateSolicitud(SolicitudDeReembolso sr) {
        String sql = this.solicitudToSqlUpdate(sr);

        if (sql != null) {
            connect();
            try {
                query.executeUpdate(sql);
            } catch (SQLException e) {
                modelUtils.showSQLException(e);
            } finally {
                modelUtils.postUpdateFinally(query, connection);
            }
            return 0;
        }
        return 1;
    }

    public LinkedList<SolicitudDeReembolso> getAllSolicitudByPeriodo(int idPeriodo) {
        String sql = "select * from solicitud_de_reembolso where id_periodo =" + idPeriodo;
        ResultSet result = null;
        connect();
        LinkedList<SolicitudDeReembolso> listSolicitudDeReembolso;
        listSolicitudDeReembolso = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                     
                    SolicitudDeReembolso newSolicitudDeReembolso = this.createSolicitudDeReembolsoFromResultSet(result);
                    boolean ans;
                    ans = listSolicitudDeReembolso.add(newSolicitudDeReembolso);
                    if (ans == true) {
                         
                    }
                }
            }
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        } finally {
            modelUtils.postSelectFinally(query, connection, result);
        }
        return listSolicitudDeReembolso;
    }

    public LinkedList<SolicitudDeReembolso> getAllSolicitudBySocio(int idSocio) {
        String sql = "select * from solicitud_de_reembolso where id_socio =" + idSocio;
        ResultSet result = null;
        connect();
        LinkedList<SolicitudDeReembolso> listSolicitudDeReembolso;
        listSolicitudDeReembolso = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                     
                    SolicitudDeReembolso newSolicitudDeReembolso = this.createSolicitudDeReembolsoFromResultSet(result);
                    boolean ans;
                    ans = listSolicitudDeReembolso.add(newSolicitudDeReembolso);
                    if (ans == true) {
                         
                    }
                }
            }
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        } finally {
            modelUtils.postSelectFinally(query, connection, result);
        }
        return listSolicitudDeReembolso;
    }

    public SolicitudDeReembolso getSolicitudById(int id) {
        String sql = solicitudToSqlFindById(id);
        ResultSet result = null;
        connect();
        SolicitudDeReembolso newSolicitudDeReembolso = new SolicitudDeReembolso();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {
                     
                    newSolicitudDeReembolso = this.createSolicitudDeReembolsoFromResultSet(result);
                    if (newSolicitudDeReembolso != null) {
                         
                    }
                }
            }
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        } finally {
            modelUtils.postSelectFinally(query, connection, result);
        }
        return newSolicitudDeReembolso;
    }

    public SolicitudDeReembolso getSolicitudByPeriodoAndSocio(int idSocio, int idPeriodo) {
        String sql = solcitudToSqlFindBySocioAndPeriodo(idSocio, idPeriodo);
        ResultSet result = null;
        connect();
        SolicitudDeReembolso newSolicitudDeReembolso = new SolicitudDeReembolso();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {
                     
                    newSolicitudDeReembolso = this.createSolicitudDeReembolsoFromResultSet(result);
                    if (newSolicitudDeReembolso != null) {
                         
                    }
                }
            }
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
            e.printStackTrace();
        } finally {
            modelUtils.postSelectFinally(query, connection, result);
        }
        return newSolicitudDeReembolso;
    }

    public SolicitudDeReembolso createSolicitudDeReembolsoFromResultSet(ResultSet r) {
        try {
            SolicitudDeReembolso sr;
            sr = new SolicitudDeReembolso(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
                    (int) r.getObject(3),
                    (Date) r.getTimestamp(4),
                    (int) r.getObject(5)
            );
            return sr;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Date DeStringADate(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
            System.out.println(fechaDate.toString());
            return fechaDate;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return fechaDate;
        }
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

}
