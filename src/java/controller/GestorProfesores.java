/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Profesor;

/**
 *
 * @author yir
 */
public class GestorProfesores {
    
    private DAOCatalogo daoCatalogo;

    public GestorProfesores(DAOCatalogo daoCatalogo) {
        this.daoCatalogo = daoCatalogo;
    }

    public GestorProfesores() {
        try {
            daoCatalogo = new DAOCatalogo();
        } catch (SQLException ex) {
            Logger.getLogger(GestorProfesores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean agregar(Profesor p){
        return daoCatalogo.agregar(p);
    }
    
    public boolean darDeAlta(Profesor p){
        return daoCatalogo.darDeAlta(p);
    }
    
    public boolean darDeBaja(Profesor p){
        return daoCatalogo.darDeBaja(p);
    }
    
    public boolean modificar(Profesor p){
        return daoCatalogo.modificar(p);
    }
    
    public ArrayList<Profesor> consultar(Profesor p){
        return daoCatalogo.consultarProfesor(p);
    }
}
