/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
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
