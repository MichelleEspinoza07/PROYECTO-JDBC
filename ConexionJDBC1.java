/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipojdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Master
 */
public class ConexionJDBC1 {
    public static void main(String[] args) {
        ConexionJDBC conexion = new ConexionJDBC();
        Connection cn = null;
        Statement stm = null;
        ResultSet rs = null;
        
        try {
            cn = conexion.conectar();
            stm = cn.createStatement();
            rs = stm.executeQuery("SELECT * FROM prototipo");
            
            while (rs.next()) {
            	String idUsuario = rs.getString(1);
                String usuario = rs.getString(2);
                String clave = rs.getString(3);
                
                System.out.println(idUsuario + " - " + usuario + " - " + clave);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (rs!= null) {
                    rs.close();
                }
                
                if (stm != null) {
                    stm.close();
                }
                
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }  
    }
}
