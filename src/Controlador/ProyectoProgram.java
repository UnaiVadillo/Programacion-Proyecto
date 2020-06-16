/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BD.*;
import Modelo.*;
import Vista.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ProyectoProgram {
    private static BaseDatos bd;
    private static tDirectorios td;
    private static tFicheros tf;
    private static tFichDirec tfd;
    private static Directorio d;
    private static Fichero f;
    
    private static vPrincipal vp;
    private static vDirectorio vd;
    private static vFichero vf;
    private static vDirectorioMenu vdm;
    private static vFicheroMenu vfm;
    private static vBorrarFichero vbf;
    private static vBorrarDirectorio vbd;
    private static vCopiarFichero vcf;
    private static vModificarFichero vmf;
    
    private static ArrayList <Fichero> ficheros;
    private static ArrayList <Directorio> ubicacion;
    
    public static void main(String[] args) {
        bd = new BaseDatos();
        boolean conectado = bd.conectar();
        td = new tDirectorios(bd.getCon());
        tf = new tFicheros(bd.getCon());
        tfd = new tFichDirec(bd.getCon());
        vp = new vPrincipal();
        if(conectado){
            vp.setVisible(true);
        }else{
            System.out.println("Programa finalizado");
            System.exit(0);
        }
    }

    public static void insertarDatosDirectorio(String nombre, String ubicacion, String propietario) {
        try{
        d=new Directorio();
        d.setNombre(nombre);
        d.setUbicacion(ubicacion);
        d.setPropietario(propietario);
        td.registrarDirectorios(d);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error");
        }
    }

    public static void insertarDatosFichero(String nombre, String extension) {
        try{
            
            f=new Fichero();
            f.setNombre(nombre);
            f.setExtension(extension);
            
            tf.registrarFicheros(f);
            
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
    public static void abrirVentanaMenuFichero(){
        vp.dispose();
        vfm= new vFicheroMenu();
        vfm.setVisible(true);
    }
    public static void cerrarVentanaMenuFichero(){
        vfm.dispose();
        vp.setVisible(true);
    }
    public static void abrirVentanaCrearFichero(){
        vfm.dispose();
        vf= new vFichero();
        vf.setVisible(true);
    }
    public static void cerrarVentanaCrearFichero(){
        vf.dispose();
        vp.setVisible(true);
    }
    public static void vFicheroCancelar(){
        vf.dispose();
        vp = new vPrincipal();
        vp.setVisible(true);
    }

    public static void abrirVentanaMenuDirectorio() {
        vp.dispose();
        vdm = new vDirectorioMenu();
        vdm.setVisible(true);
    }
    public static void cerrarVentanaMenuDirectorio(){
        vdm.dispose();
        vp.setVisible(true);
    }
    public static void abrirVentanaCrearDirectorio() {
        vdm.dispose();
        vd = new vDirectorio();
        vd.setVisible(true);
    }
    public static void cerrarVentanaCrearDirectorio(){
        vd.dispose();
        vp.setVisible(true);
    }
    public static void abrirVentanaBorrarDirectorio() {
        vdm.dispose();
        vbd = new vBorrarDirectorio();
        vbd.setVisible(true);
    }
    public static void cerrarVentanaBorrarDirectorio(){
        vbd.dispose();
        vp.setVisible(true);
    }
    public static void abrirVentanaBorrarFichero() {
        vfm.dispose();
        vbf = new vBorrarFichero();
        vbf.setVisible(true);
    }
    public static void cerrarVentanaBorrarFichero(){
        vbf.dispose();
        vp.setVisible(true);
    }
    public static void abrirVentanaCopiarFichero() {
        vfm.dispose();
        vcf = new vCopiarFichero();
        vcf.setVisible(true);
    }
    public static void cerrarVentanaCopiarFichero(){
        vcf.dispose();
        vp.setVisible(true);
    }

    public static void abrirVentanaModificarFichero() {
        vfm.dispose();
        vmf= new vModificarFichero();
        vmf.setVisible(true);
    }
    public static void cerrarVentanaModificarFichero(){
        vmf.dispose();
        vp.setVisible(true);
    }
    public static void borrarDirectorio(String nombre, String ubicacion) {
        try{
            int id= td.buscarIdDirectorio(nombre, ubicacion);
            if(id != 0){
                td.borrarDirectorio(id);
            }else{
                System.out.println("No existe ese archivo");
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
    public static void borrarFichero(String nombre, String extension) {
       try{
            int id= tf.buscarIdFichero(nombre, extension);
            if(id != 0){
                tf.borrarFichero(id);
            }else{
                System.out.println("No existe ese archivo");
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }


    public static void modificarDatosFichero(String nombre, String extension, String nuevoNombre, String nuevoExtension) {
        try{
            int id= tf.buscarIdFichero(nombre, extension);
            tf.ModificarDirectorio(id, nuevoNombre, nuevoExtension);
            if(id != 0){
                tf.ModificarDirectorio(id, nuevoNombre, nuevoExtension);
            }else{
                System.out.println("No existe ese archivo");
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
    public static int buscarIdDirectorio(String nombre, String ubicacion) throws Exception{
        return td.buscarIdDirectorio(nombre, ubicacion);
    }
    public static int buscarIdFichero(String nombre, String extension) throws Exception{
        return tf.buscarIdFichero(nombre, extension);
    }
    public static boolean directorioEncontrado(String nombre, String ubicacion) throws Exception{
        int id=buscarIdDirectorio(nombre, ubicacion);
        return id!=0;
    }
    public static boolean ficheroEncontrado(String nombre, String extension) throws Exception{
        int id=buscarIdFichero(nombre, extension);
        return id!=0;
    }
    public static boolean validarNombre(String nombre){
        Pattern p = Pattern.compile("^[A-z0-9]+$");
        Matcher m = p.matcher(nombre);
        return m.matches();
    }
    public static boolean validarExtension(String extension){
        Pattern p = Pattern.compile("^[.]{1}[a-z0-9]+$");
        Matcher m = p.matcher(extension);
        return m.matches();
    }
    public static boolean validarUbicacion(String ubicacion){
        Pattern p = Pattern.compile("^[C|D]{1}[:]{1}\\\\[A-z0-9]+(\\\\[A-z0-9]+)*$");
        Matcher m = p.matcher(ubicacion);
        return m.matches();

    }
    public static boolean validarPropietario(String propietario){
        Pattern p = Pattern.compile("^[A-Z]{1}[a-z]+$");
        Matcher m = p.matcher(propietario);
        return m.matches();
    }

    public static void escogerUbicacion(JComboBox<String> cbUbicacion) {
        ubicacion = new ArrayList();
        try {
            ubicacion= td.selectUbicacion(ubicacion);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        for(int x=0; x<ubicacion.size();x++){
            cbUbicacion.addItem(ubicacion.get(x).getUbicacion());
        }
    }

    public static void relacionFichDirec(String nombre, String extension, int ubi) {
        try {
            int ficheroID=tf.buscarIdFichero(nombre, extension);
            int directorioID=td.buscarIdDirectorioPorUbicacion(ubicacion.get(ubi).getUbicacion());
            tfd.registrarFicheros(ficheroID, directorioID);
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        
    }

    public static void escogerFichero(JComboBox<String> cbFichero) {
        ficheros = new ArrayList();
        try {
            ficheros=tf.selectNombre(ficheros);
            for(int x=0; x<ficheros.size();x++){
                String msg = ficheros.get(x).getNombre() + ficheros.get(x).getExtension();
                cbFichero.addItem(msg);
            }   
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        
    }

    public static void copiarFichero(int fichero, int directorio) {
        try {
            tfd.copiarFichero(ficheros.get(fichero), ubicacion.get(directorio));
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
