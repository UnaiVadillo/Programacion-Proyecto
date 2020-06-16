/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import Modelo.Directorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class tDirectorios {
    
    private Connection con;
    
    public tDirectorios(Connection con)
    {
        this.con = con;
    }
    public void registrarDirectorios(Directorio d) throws Exception
    {
        String plantilla = "INSERT INTO tdirectorios VALUES (null,?,?,?);";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ps.setString(1, d.getNombre());
        ps.setString(2,d.getUbicacion());
        ps.setString(3, d.getPropietario());

        int n = ps.executeUpdate();
  
        if (n != 1)
            throw new Exception("El número de filas actualizadas no es uno");
    }
    
    public int buscarIdDirectorio(String nombre, String ubicacion) throws Exception{
        String plantilla = "SELECT id FROM tdirectorios WHERE nombre= ? AND ubicacion = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ps.setString(1, nombre);
        ps.setString(2,ubicacion);
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()){
            return resultado.getInt("id");
        }
        return 0;
    }
    public void borrarDirectorio(int id) throws Exception{
        String plantilla = "DELETE FROM tdirectorios WHERE id= ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
 
        ps.setInt(1, id);
        
        int n = ps.executeUpdate();
  
        if (n != 1)
            throw new Exception("No se ha borrado correctamente");
    }
    public ArrayList<Directorio> selectUbicacion(ArrayList <Directorio> ubicaciones) throws Exception{
        String plantilla = "SELECT * FROM tdirectorios;";

        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ResultSet resultado = ps.executeQuery();
        while (resultado.next()){
            Directorio ubicacion= new Directorio();
            ubicacion.setId(resultado.getInt("id"));
            ubicacion.setUbicacion(resultado.getString("ubicacion"));
            ubicacion.setNombre(resultado.getString("nombre"));
            ubicacion.setPropietario(resultado.getString("propietario"));
            ubicaciones.add(ubicacion);
        }
        return ubicaciones;
    }
    public int buscarIdDirectorioPorUbicacion(String ubicacion) throws Exception{
        String plantilla = "SELECT id FROM tdirectorios WHERE ubicacion = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        
        ps.setString(1,ubicacion);
        ResultSet resultado = ps.executeQuery();
        if (resultado.next()){
            return resultado.getInt("id");
        }
        return 0;
    }
}
