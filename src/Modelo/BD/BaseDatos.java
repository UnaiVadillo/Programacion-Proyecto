
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class BaseDatos {
   
    private Connection con;
    
    public Connection getCon(){
       return con;
   }
    public boolean conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String bd = "bdproyecto";
            String url = "jdbc:mysql://localhost:3307/"+bd;
            String login="root";
            String password= "usbw";
            con = DriverManager.getConnection(url,login,password);
            
            if(con == null){
            throw new Exception("Problemas con la conexión");
            }else{
                return true;
            }
        }catch (Exception e){
            System.out.println("Problemas con la base de datos");
        }
        return false;
}
    public void desconectar(){
        try
        {
        con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Problemas con la conexión");
        }

}
}
