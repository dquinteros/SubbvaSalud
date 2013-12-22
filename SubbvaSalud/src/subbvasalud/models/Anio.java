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
public class Anio extends Conexion {

    private int id_anio;
    private int numero_anio;

    public Anio() {
    }

    public Anio(int id_anio, int numero_anio) {
        this.id_anio = id_anio;
        this.numero_anio = numero_anio;
    }

    public String anioToSqlInsert(Anio a) {
        if (a != null) {
            String sql = "INSERT INTO \"carga\""
                    + "(\"id_anio\","
                    + "\"numero_anio\")"
                    + " VALUES("
                    + " NULL,"
                    + a.getNumero_anio()
                    + ");";
            return sql;
        } else {
            return null;
        }
    }

    public String anioToSqlFindById(int id) {
        if (id > 0) {
            String sql = "SELECT * FROM anio WHERE id_anio =" + id + ";";
            return sql;
        } else {
            return null;
        }
    }

    public String anioToSqlFindByYear(int anio) {
        if (anio > 0) {
            String sql = "SELECT * FROM anio WHERE numero_anio =" + anio + ";";
            return sql;
        } else {
            return null;
        }
    }

    public int insertAnio(Anio a) {
        String sql = this.anioToSqlInsert(a);

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

    public LinkedList<Anio> getAllAnios() {
        String sql = "select * from anio";
        ResultSet result = null;
        connect();
        LinkedList<Anio> listAnios;
        listAnios = new LinkedList<>();

        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                    System.out.println("Pasa");
                    Anio newAnio = this.createAnioFromResultSet(result);
                    boolean ans;
                    ans = listAnios.add(newAnio);
                    if (ans == true) {
                        System.out.println("Agregado");
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
        return listAnios;
    }

    public Anio getCargasById(int id) {
        String sql = anioToSqlFindById(id);
        ResultSet result = null;
        connect();
        Anio newAnio = new Anio();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {
                    System.out.println("Pasa");
                    newAnio = this.createAnioFromResultSet(result);
                    if (newAnio != null) {
                        System.out.println("Agregado");
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
        return newAnio;
    }

    public Anio getAnioByYear(int anio) {
        String sql = anioToSqlFindByYear(anio);
        ResultSet result = null;
        connect();
        Anio newAnio = new Anio();
        try {
            result = consultar(sql);
            if (result != null) {
                if (result.next()) {
                    System.out.println("Pasa");
                    newAnio = this.createAnioFromResultSet(result);
                    if (newAnio != null) {
                        System.out.println("Agregado");
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
        return newAnio;
    }

    public Anio createAnioFromResultSet(ResultSet r) {
        try {
            Anio a;
            a = new Anio(
                    (int) r.getObject(1),
                    (int) r.getObject(2)
            );
            return a;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getId_anio() {
        return id_anio;
    }

    public void setId_anio(int id_anio) {
        this.id_anio = id_anio;
    }

    public int getNumero_anio() {
        return numero_anio;
    }

    public void setNumero_anio(int numero_anio) {
        this.numero_anio = numero_anio;
    }

}
