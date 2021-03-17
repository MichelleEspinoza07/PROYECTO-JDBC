/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prototipos;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Master
 */
public class Seguridad {
    Frm_Ingreso login = new Frm_Ingreso();
    String res;
    
    public void validarUsuario(String[] usuarios, String user, String password, int intentos) throws SQLException{
        boolean encontrado=false;
       
        for (int i=0; i<usuarios.length; i++) {
            if((usuarios[i].equalsIgnoreCase(user) && usuarios[i+1].equals(password))){
              res="Bienvenido "  + user;
              encontrado = true;
              JOptionPane.showMessageDialog(null, res, "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
              intentos=0;
              login.setIntentos(intentos);
              new Frm_Ingreso().setVisible(true);
              
              Usuario u = new Usuario();
              u.setVisible(true);
        
              break;
            }
        } //fin del for
        
        if (encontrado==false){
            res = "clave y/o usuario erroneos van" + intentos + "intentos fallidos";
            JOptionPane.showMessageDialog(null, res, "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);                
        }
        
        if (intentos > 2 ){
            JOptionPane.showMessageDialog(null, "3 intentos erroneos, se bloquea", "Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
            System.exit(0);    
        }
    } 
}
