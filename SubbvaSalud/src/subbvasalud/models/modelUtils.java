/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package subbvasalud.models;

import java.sql.SQLException;

/**
 *
 * @author damage
 */
public class modelUtils {
    public static void showSQLException(SQLException e){
           System.out.println("SQLExeption");
           System.out.println(e.getSQLState());
           System.out.println(e.getMessage()); 
    }    
}
