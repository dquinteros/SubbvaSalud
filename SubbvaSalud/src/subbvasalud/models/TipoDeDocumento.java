/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author damage
 */
public class TipoDeDocumento extends Conexion {

    private int id_tipo;
    private int id_gasto;
    private int id_prestacion;
    private int id_prevision;
    private int porcentaje_tipo;

    public TipoDeDocumento() {
    }

    public TipoDeDocumento(int id_tipo, int id_gasto, int id_prestacion, int id_prevision, int porcentaje_tipo) {
        this.id_tipo = id_tipo;
        this.id_gasto = id_gasto;
        this.id_prestacion = id_prestacion;
        this.id_prevision = id_prevision;
        this.porcentaje_tipo = porcentaje_tipo;
    }

    public String tipoDocumentoToSqlInsert(TipoDeDocumento td) {
        if (td != null) {
            String sql = "INSERT INTO \"tipos_de_documento\""
                    + "(\"id_tipo\","
                    + "\"id_gasto\","
                    + "\"id_prestacion\","
                    + "\"id_prevision\","
                    + "\"porcentaje_tipo\")"
                    + " VALUES("
                    + " NULL,"
                    + td.getId_gasto() + ","
                    + td.getId_prestacion() + ","
                    + td.getId_prevision() + ","
                    + td.getPorcentaje_tipo()
                    + ");";
            return sql;
        } else {
            return null;
        }
    }

    public String tipoDocumentoToSqlUpdate(TipoDeDocumento td) {
        if (td != null) {
            String sql = "UPDATE \"tipos_de_documento\""
                    + " SET"
                    + " id_gasto = " + td.getId_gasto() + ","
                    + " id_prestacion = " + td.getId_prestacion() + ","
                    + " id_prevision = " + td.getId_prevision() + ","
                    + " porcentaje_tipo = " + td.getPorcentaje_tipo()
                    + " WHERE id_tipo = " + td.getId_tipo()
                    + ";";
            System.out.println(sql);
            return sql;
        } else {
            return null;
        }
    }

    public String tipoDocumentoToSqlFindById(int id) {
        if (id > 0) {
            String sql = "SELECT * FROM tipos_de_documento WHERE id_tipo =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    public int insertPeriodo(TipoDeDocumento td) {
        String sql = this.tipoDocumentoToSqlInsert(td);

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

    public int updatePeriodo(TipoDeDocumento td) {
        String sql = this.tipoDocumentoToSqlUpdate(td);

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

    public LinkedList<TipoDeDocumento> getAllTipoDocumentos() {
        String sql = "select * from tipos_de_documento";
        ResultSet result = null;
        connect();
        LinkedList<TipoDeDocumento> listTipoDocumento;
        listTipoDocumento = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                     
                    TipoDeDocumento newTipoDocumento = this.createTipoDocumentoFromResultSet(result);
                    boolean ans;
                    ans = listTipoDocumento.add(newTipoDocumento);
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
        return listTipoDocumento;
    }

    public LinkedList<TipoDeDocumento> getAllTipoDocumentosBySearch(int id_gasto, int id_prestacion, int id_prevision) {
        String sql = "select * from tipos_de_documento where (id_gasto = " + id_gasto + ") and (id_prestacion = " + id_prestacion + ") and (id_prevision=" + id_prevision + ")";
        ResultSet result = null;
        connect();
        LinkedList<TipoDeDocumento> listTipoDocumento;
        listTipoDocumento = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                     
                    TipoDeDocumento newTipoDocumento = this.createTipoDocumentoFromResultSet(result);
                    boolean ans;
                    ans = listTipoDocumento.add(newTipoDocumento);
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
        return listTipoDocumento;
    }

    public TipoDeDocumento getTipoDeDocumentosById(int id) {
        String sql = tipoDocumentoToSqlFindById(id);
        ResultSet result = null;
        connect();
        TipoDeDocumento newTipoDeDocumento = new TipoDeDocumento();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {
                     
                    newTipoDeDocumento = this.createTipoDocumentoFromResultSet(result);
                    if (newTipoDeDocumento != null) {
                         
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
        return newTipoDeDocumento;
    }

    public TipoDeDocumento createTipoDocumentoFromResultSet(ResultSet r) {
        try {
            TipoDeDocumento p;
            p = new TipoDeDocumento(
                    (int) r.getObject(1),
                    (int) r.getObject(2),
                    (int) r.getObject(3),
                    (int) r.getObject(4),
                    (int) r.getObject(5)
            );
            return p;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public int getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
    }

    public int getId_prestacion() {
        return id_prestacion;
    }

    public void setId_prestacion(int id_prestacion) {
        this.id_prestacion = id_prestacion;
    }

    public int getId_prevision() {
        return id_prevision;
    }

    public void setId_prevision(int id_prevision) {
        this.id_prevision = id_prevision;
    }

    public int getPorcentaje_tipo() {
        return porcentaje_tipo;
    }

    public void setPorcentaje_tipo(int porcentaje_tipo) {
        this.porcentaje_tipo = porcentaje_tipo;
    }

}
