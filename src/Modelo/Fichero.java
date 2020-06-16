/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Fichero {
    private int id;
    private String nombre;
    private String extension;
    private LocalDate fecha;
    private LocalTime hora;
    
    private ArrayList<Directorio> directorios;

    public Fichero() {
    }

    public Fichero(int id, String nombre, String extension, LocalDate fecha, LocalTime hora) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
        this.fecha = fecha;
        this.hora = hora;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public ArrayList<Directorio> getDirectorios() {
        return directorios;
    }

    public void setDirectorios(ArrayList<Directorio> directorios) {
        this.directorios = directorios;
    }
    
     public void setDirectorios(Directorio d) {
        this.directorios.add(d);
    }
}
