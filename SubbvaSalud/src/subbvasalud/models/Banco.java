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
public class Banco extends Conexion {

    private int idBanco;
    private String nombreBanco;

    public Banco() {
    }

    public Banco(int idBanco, String nombreBanco) {
        this.idBanco = idBanco;
        this.nombreBanco = nombreBanco;
    }

    public LinkedList<Banco> getAllBancos() {
        String sql = "select * from banco";
        ResultSet result = null;
        connect();
        LinkedList<Banco> listBancos = new LinkedList<>();
        try {
            result = consultar(sql);
            if (result != null) {
                while (result.next()) {
                    
                    Banco newBanco = this.createBancoFromResultSet(result);
                    boolean ans;
                    ans = listBancos.add(newBanco);
                    if (ans == true) {
                        System.out.println("Banco "+newBanco.getNombreBanco()+" obtenido con exito.");  
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
        return listBancos;
    }

    public Banco createBancoFromResultSet(ResultSet r) {
        try {
            Banco b;
            b = new Banco(
                    (int) r.getObject(1),
                    (String) r.getObject(2)
            );
            return b;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

}
