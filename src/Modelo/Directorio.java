/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Directorio {
    private int id;
    private String nombre;
    private String ubicacion;
    private String propietario;
    
    private ArrayList<Fichero> ficheros;

    public Directorio() {
    }

    public Directorio(int id, String nombre, String ubicacion, String propietario) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Fichero> getFicheros() {
        return ficheros;
    }

    public void setFicheros(ArrayList<Fichero> ficheros) {
        this.ficheros = ficheros;
    }
    
    
}
