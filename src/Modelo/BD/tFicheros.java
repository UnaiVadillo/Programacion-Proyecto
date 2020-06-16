/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import Modelo.Fichero;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;


/**
 *
 * @author Usuario
 */
public class tFicheros {
    private Connection con;
    public tFicheros(Connection con)
    {
        this.con = con;
    }

    public void registrarFicheros(Fichero f) throws SQLException, Exception {
        String plantilla = "INSERT INTO tficheros VALUES (null,?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
       

        
        ps.setString(1, f.getNombre());
        ps.setString(2, f.getExtension());
        ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
        ps.setTime(4, java.sql.Time.valueOf(LocalTime.now()));

        int n = ps.executeUpdate();
  
        if (n != 1){
            throw new Exception("Fichero no se ha introducido correctamente");
        }
    }
    public int buscarIdFichero(String nombre, String extension) throws SQLException, Exception {
        String plantilla = "SELECT id FROM tficheros WHERE nombre= ? AND extension = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ps.setString(1, nombre);
        ps.setString(2, extension);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return rs.getInt("id");
        }
        return 0;
    }
    public void borrarFichero(int id) throws SQLException, Exception {
        String plantilla = "DELETE FROM tficheros WHERE id= ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ps.setInt(1, id);

        int n = ps.executeUpdate();
  
        if (n != 1)
            throw new Exception("No se ha borrado correctamente");
    }
    public void ModificarDirectorio(int id, String nuevoNombre, String nuevoExtension) throws SQLException, Exception {
        String plantilla = "UPDATE tficheros SET nombre = ? AND extension= ? AND fecha = ? AND hora = ? WHERE id = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ps.setString(1, nuevoNombre);
        ps.setString(2, nuevoExtension);
        ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
        ps.setTime(4, java.sql.Time.valueOf(LocalTime.now()));
        ps.setInt(5, id);

        ps.executeUpdate();
        ps.close();
    }

    public ArrayList<Fichero> selectNombre(ArrayList<Fichero> ficheros) throws SQLException {
        String plantilla = "SELECT * FROM tficheros;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Fichero f = new Fichero();
            f.setId(rs.getInt("id"));
            f.setNombre(rs.getString("nombre"));
            f.setExtension(rs.getString("extension"));
            ficheros.add(f);
        }
        return ficheros;
    }
 }

