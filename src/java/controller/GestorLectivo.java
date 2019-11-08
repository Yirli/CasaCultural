/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Modalidad;
import model.PeriodoLectivo;

/**
 *
 * @author yir
 */
public class GestorLectivo {
    private DAOCatalogo daoCatalogo;

    public GestorLectivo() {
        try {
            daoCatalogo = new DAOCatalogo();
        } catch (SQLException ex) {
            System.out.println("Error Gestor Lectivo: "+ex.getMessage());
        }
    }
    
     public boolean agregar(PeriodoLectivo p){
         System.out.println("fechas: "+validarFechas(p));
         System.out.println("modalidad: "+validarModalidad(p));

        if(validarFechas(p) && validarModalidad(p)){
            p.setFechaPublicacion(cambiarFormatoFecha(p.getFechaPublicacion()));
            p.setFechaMatriculaInicio(cambiarFormatoFecha(p.getFechaMatriculaInicio()));
            p.setFechaMatriculaFinal(cambiarFormatoFecha(p.getFechaMatriculaFinal()));
            p.setFechaInicio(cambiarFormatoFecha(p.getFechaInicio()));
            p.setFechaFinal(cambiarFormatoFecha(p.getFechaFinal()));
            return daoCatalogo.agregar(p);
        }else
            return false;
    }
    
    public boolean darDeAlta(PeriodoLectivo p){
        return daoCatalogo.darDeAlta(p);
    }
    
    public boolean darDeBaja(PeriodoLectivo p){
        return daoCatalogo.darDeBaja(p);
    }
    
    public boolean modificar(PeriodoLectivo p){
        System.out.println("fechas: "+validarFechas(p));
        System.out.println("modalidad: "+validarModalidad(p));
        if(validarFechas(p) && validarModalidad(p)){
            p.setFechaPublicacion(cambiarFormatoFecha(p.getFechaPublicacion()));
            p.setFechaMatriculaInicio(cambiarFormatoFecha(p.getFechaMatriculaInicio()));
            p.setFechaMatriculaFinal(cambiarFormatoFecha(p.getFechaMatriculaFinal()));
            p.setFechaInicio(cambiarFormatoFecha(p.getFechaInicio()));
            p.setFechaFinal(cambiarFormatoFecha(p.getFechaFinal()));
            return daoCatalogo.modificar(p);
        }else 
            return false;
    }
    
    public ArrayList<PeriodoLectivo> consultar(PeriodoLectivo p){
        return daoCatalogo.consultarPeriodoLectivo();
    }
    
    public ArrayList<String> consultarModalidad(){
        return daoCatalogo.consultarModalidad();
    }
    
    public boolean validarFechas(PeriodoLectivo p){
        /*System.out.println("pub: "+p.getFechaPublicacion());
        System.out.println("matricuIni: "+p.getFechaMatriculaInicio());
        System.out.println("matricuFin: "+p.getFechaMatriculaFinal());
        System.out.println("Ini: "+p.getFechaInicio());
        System.out.println("Fin: "+p.getFechaFinal());*/
        
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaPub = format.parse(p.getFechaPublicacion());
            Date fechaInicioMatricula = format.parse(p.getFechaMatriculaInicio());
            Date fechaFinalMatricula = format.parse(p.getFechaMatriculaFinal());
            Date fechaInicio = format.parse(p.getFechaInicio());
            Date fechaFinal = format.parse(p.getFechaFinal());

            if(fechaPub.after(Calendar.getInstance().getTime())){
                if(fechaPub.before(fechaInicioMatricula)){
                    if(fechaInicioMatricula.before(fechaFinalMatricula)){
                        if(fechaFinalMatricula.before(fechaInicio)){
                            if(fechaInicio.before(fechaFinal)){
                                return true;
                            }
                        }
                    }
                }
            }
            
        } catch (ParseException ex) {
            System.out.println("Error validar fechas: " +ex.getMessage());
            return false;
        }
        return false;
    }

    
    private String cambiarFormatoFecha(String d){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = format.parse(d);
            String dia = String.valueOf(fecha.getDate());
            String mes = String.valueOf(fecha.getMonth()+1);
            String anno = String.valueOf(fecha.getYear()+1900);
            String fechaCambiada = dia+"-"+mes+"-"+anno;
            return fechaCambiada;
        } catch (ParseException ex) {
            System.out.println("Error cambiar formato fecha: "+ ex.getMessage());
        }
        return "";
    }
    
    public boolean validarModalidad(PeriodoLectivo p){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = format.parse(p.getFechaInicio());
            Date fechaFinal = format.parse(p.getFechaFinal());
            
            int dias = (int) ((fechaFinal.getTime()-fechaInicio.getTime())/86400000);
            int meses = dias/30;
                    
            if(meses <= 1.5){
                return false;
            }
            if(meses >= 1.5 && meses <= 2.5 && p.getModalidad() == Modalidad.Bimestral){
                return true;
            }
            if(meses >= 2.5 && meses <= 3.5 && p.getModalidad() == Modalidad.Trimestral){
                return true;
            }
            if(meses >= 3 && meses <= 4.5 && p.getModalidad() == Modalidad.Cuatrimestral){
                return true;
            }
            if(meses >= 4 && meses <= 6.5 && p.getModalidad() == Modalidad.Semestral){
                return true;
            }
            if(meses >= 7 && meses <= 12 && p.getModalidad() == Modalidad.Anual){
                return true;
            }
            return false;
        } catch (ParseException ex) {
            Logger.getLogger(GestorLectivo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
