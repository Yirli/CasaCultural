/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import model.Modalidad;
import model.PeriodoLectivo;

/**
 *
 * @author yir
 */
public class GestorLectivo {
    private DAOCatalogo daoCatalogo;
    
     public boolean agregar(PeriodoLectivo p){
        if(validarFechas(p) && validarModalidad(p))
            return daoCatalogo.agregar(p);
        else
            return false;
    }
    
    public boolean darDeAlta(PeriodoLectivo p){
        return daoCatalogo.darDeAlta(p);
    }
    
    public boolean darDeBaja(PeriodoLectivo p){
        return daoCatalogo.darDeBaja(p);
    }
    
    public boolean modificar(PeriodoLectivo p){
        if(validarFechas(p) && validarModalidad(p))
            return daoCatalogo.modificar(p);
        else 
            return false;
    }
    
    public ArrayList<PeriodoLectivo> consultar(PeriodoLectivo p){
        return daoCatalogo.consultarPeriodoLectivo();
    }
    
    private boolean validarFechas(PeriodoLectivo p){
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
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
            return false;
            
        } catch (ParseException ex) {
            Logger.getLogger(GestorLectivo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private boolean validarModalidad(PeriodoLectivo p){
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
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
