/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
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
public class DetalleSolicitud extends Conexion {

    private int id_detalle;
    private int id_solicitud;
    private int id_tipo;
    private String nombre;
    private Date fecha;
    private int monto_total;
    private int no_bonificado;
    private int reembolso;
    private int rut;

    public DetalleSolicitud() {
    }

    public DetalleSolicitud(int id_detalle, int id_solicitud, int id_tipo, String nombre, Date fecha, int monto_total, int no_bonificado, int reembolso, int rut) {
        this.id_detalle = id_detalle;
        this.id_solicitud = id_solicitud;
        this.id_tipo = id_tipo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.monto_total = monto_total;
        this.no_bonificado = no_bonificado;
        this.reembolso = reembolso;
        this.rut = rut;
    }

    public String detalleToSqlInsert(DetalleSolicitud d) {
        if (d != null) {
            Calendar cal = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
            format.format(d.getFecha());
            cal = format.getCalendar();
            String sql = "INSERT INTO \"detalle_solicitud\""
                    + "(\"id_detalle\","
                    + "\"id_solicitud\","
                    + "\"id_tipo\","
                    + "\"nombre_documento\","
                    + "\"fecha_emision_documento\","
                    + "\"monto_total_documento\","
                    + "\"monto_no_bonificado_documento\","
                    + "\"monto_reembolso_documento\","
                    + "\"rut_documento\")"
                    + " VALUES("
                    + " NULL,"
                    + d.getId_solicitud() + ","
                    + d.getId_tipo() + ","
                    + " '" + d.getNombre() + "',"
                    + " '" + cal.getTime() + "',"
                    + d.getMonto_total() + ","
                    + d.getNo_bonificado() + ","
                    + d.getReembolso() + ","
                    + d.getRut()
                    + ");";
            System.out.println(sql);
            return sql;
        } else {
            return null;
        }
    }

    public String detalleToSqlUpdate(DetalleSolicitud d) {
        if (d != null) {
            Calendar cal = Calendar.getInstance();
            DateFormat format = new SimpleDateFormat("yyyy/mm/dd");
            format.format(d.getFecha());
            cal = format.getCalendar();
            String sql = "UPDATE \"detalle_solicitud\""
                    + " SET"
                    + " id_solicitud = " + d.getId_solicitud() + ","
                    + " id_tipo = " + d.getId_tipo() + ","
                    + " nombre_documento = \"" + d.getNombre() + "\","
                    + " fecha_emision_documento = " + cal.getTime() + ","
                    + " monto_total_documento = " + d.getMonto_total() + ","
                    + " monto_no_bonificado_documento = " + d.getNo_bonificado() + ","
                    + " monto_reembolso_documento = " + d.getReembolso() + ","
                    + " monto_reembolso_documento = " + d.getRut()
                    + " WHERE id_detalle= " + d.getId_detalle()
                    + ";";
            System.out.println(sql);
            return sql;
        } else {
            return null;
        }
    }

    public String detalleToSqlFindById(int id) {
        if (id > 0) {
            String sql = "SELECT * FROM detalle_solicitud WHERE id_solicitud =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    public String detalleToSqlFindByNombre(String name) {
        if (name != null) {
            String sql = "SELECT * FROM detalle_solicitud WHERE nombre_documento = \"" + name + "\" ;";
            return sql;
        } else {
            return null;
        }
    }

    public int insertDetalle(DetalleSolicitud d) {
        String sql = this.detalleToSqlInsert(d);

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

    public int updateDetalle(DetalleSolicitud d) {
        String sql = this.detalleToSqlUpdate(d);

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

    public LinkedList<DetalleSolicitud> getAllDetalle() {
        String sql = "select * from detalle_solicitud";
        ResultSet result = null;
        connect();
        LinkedList<DetalleSolicitud> listDetalles;
        listDetalles = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    DetalleSolicitud newDetalle = this.createDetalleFromResultSet(result);
                    boolean ans;
                    ans = listDetalles.add(newDetalle);
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
        return listDetalles;
    }

    public LinkedList<DetalleSolicitud> getAllDetallebyIdSolicitud(int id, int rut) {
        String sql = "select * from detalle_solicitud where id_solicitud = " + id + " and rut_documento = " + rut;
        ResultSet result = null;
        connect();
        LinkedList<DetalleSolicitud> listDetalles;
        listDetalles = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    DetalleSolicitud newDetalle = this.createDetalleFromResultSet(result);
                    boolean ans;
                    ans = listDetalles.add(newDetalle);
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
        return listDetalles;
    }

    public LinkedList<DetalleSolicitud> getAllDetallebyIdSolicitud(int id) {
        String sql = "select * from detalle_solicitud where id_solicitud = " + id;
        ResultSet result = null;
        connect();
        LinkedList<DetalleSolicitud> listDetalles;
        listDetalles = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    DetalleSolicitud newDetalle = this.createDetalleFromResultSet(result);
                    boolean ans;
                    ans = listDetalles.add(newDetalle);
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
        return listDetalles;
    }

    public LinkedList<DetalleSolicitud> getAllDetalleByRut(int rut) {
        String sql = "select * from detalle_solicitud where rut_documento = " + rut;
        ResultSet result = null;
        connect();
        LinkedList<DetalleSolicitud> listDetalles;
        listDetalles = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {

                    DetalleSolicitud newDetalle = this.createDetalleFromResultSet(result);
                    boolean ans;
                    ans = listDetalles.add(newDetalle);
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
        return listDetalles;
    }

    public DetalleSolicitud getDetalleById(int id) {
        String sql = detalleToSqlFindById(id);
        ResultSet result = null;
        connect();
        DetalleSolicitud newDetalle = new DetalleSolicitud();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {

                    newDetalle = this.createDetalleFromResultSet(result);
                    if (newDetalle != null) {

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
        return newDetalle;
    }

    public DetalleSolicitud createDetalleFromResultSet(ResultSet r) {
        try {
            DetalleSolicitud d;

            SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            Date date = df.parse((String) r.getObject(5));

            d = new DetalleSolicitud(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
                    (int) r.getObject(3),
                    (String) r.getObject(4),
                    date,
                    (int) r.getObject(6),
                    (int) r.getObject(7),
                    (int) r.getObject(8),
                    (int) r.getObject(9)
            );
            return d;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(DetalleSolicitud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public int getNo_bonificado() {
        return no_bonificado;
    }

    public void setNo_bonificado(int no_bonificado) {
        this.no_bonificado = no_bonificado;
    }

    public int getReembolso() {
        return reembolso;
    }

    public void setReembolso(int reembolso) {
        this.reembolso = reembolso;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

}
