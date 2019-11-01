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
import model.Curso;
import model.Profesor;

/**
 *
 * @author yir
 */
public class GestorCursos {
    DAOCatalogo daoCatalogo;

    public GestorCursos(DAOCatalogo daoCatalogo) {
        this.daoCatalogo = daoCatalogo;
    }

    public GestorCursos() {
        try {
            this.daoCatalogo = new DAOCatalogo();
        } catch (SQLException ex) {
            System.out.println("Erro: "+ex.getMessage());
        }
    }
    
    
     public boolean agregar(Curso c){
        return daoCatalogo.agregar(c);
    }
    
    public boolean darDeAlta(Curso c){
        return daoCatalogo.darDeAlta(c);
    }
    
    public boolean darDeBaja(Curso c){
        return daoCatalogo.darDeBaja(c);
    }
    
    public boolean modificar(Curso c){
        return daoCatalogo.modificar(c);
    }
    
    public ArrayList<Curso> consultar(Curso c){
        return daoCatalogo.consultarCurso(c);
    }
}
