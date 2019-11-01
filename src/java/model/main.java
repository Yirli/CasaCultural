/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controlador;
import controller.DAOCatalogo;
import controller.DAOPermisos;
import controller.DataSource;
import controller.GestorFuncionalidades;
import controller.GestorLectivo;
import controller.GestorRoles;
import controller.GestorUsuarios;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yir
 */
public class main {
    public static void main(String[] args) throws SQLException{
        

        Controlador c = new Controlador();
        Curso cr = new Curso("","");
        
        ArrayList<Curso> l = c.consultarCurso(cr);
        System.out.println("");
        for(int i=0;i<l.size();i++){
            System.out.println("id: "+l.get(i).getId());
            System.out.println("id: "+l.get(i).getDescripcion());
        }
        //System.out.println("id user: "+c.validarLogin("mhernandez", "admin123"));
        
    }
}
