/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import Modelo.Directorio;
import Modelo.Fichero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class tFichDirec {
    private Connection con;
    public tFichDirec(Connection con)
    {
        this.con = con;
    }
    public void registrarFicheros(int fichID, int direcID) throws Exception {
        String plantilla = "INSERT INTO tfichdirec VALUES (?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
            
        ps.setInt(1, fichID);
        ps.setInt(2, direcID);
        int n = ps.executeUpdate();
  
        if (n != 1){
            throw new Exception("Fichero no se ha introducido correctamente");
        }
    }

    public void copiarFichero(Fichero fich, Directorio dir) throws Exception{
        String plantilla = "INSERT INTO tfichdirec VALUES (?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ps.setInt(1, fich.getId());
        ps.setInt(2, dir.getId());
        
        int n = ps.executeUpdate();
        if (n!=1){
            throw new Exception("Fichero no se ha introducido correctamente");
        }
    }
}
