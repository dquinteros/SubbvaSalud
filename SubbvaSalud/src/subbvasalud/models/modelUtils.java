/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subbvasalud.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author damage
 */
public class modelUtils {

    /**
     *
     * @param e
     */
    public static void showSQLException(SQLException e) {
        System.out.println("SQLExeption");
        System.out.println(e.getSQLState());
        System.out.println(e.getMessage());
    }

    /**
     *
     * @param q
     * @param c
     * @param r
     */
    public static void postSelectFinally(Statement q, Connection c, ResultSet r) {
        try {
            q.close();
            c.close();
            if (r != null) {
                r.close();
            }
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        }
    }

    /**
     *
     * @param q
     * @param c
     */
    public static void postUpdateFinally(Statement q, Connection c) {
        try {
            q.close();
            c.close();
        } catch (SQLException e) {
            modelUtils.showSQLException(e);
        }
    }
}
