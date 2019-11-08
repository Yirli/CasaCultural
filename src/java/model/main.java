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
        

        //Controlador c = new Controlador();
        PeriodoLectivo p = new PeriodoLectivo("2020-01-23","2020-01-25","2020-01-29","2020-02-05","2020-07-05", Modalidad.Semestral);
        /*Curso cr = new Curso("B-101","Baile",2.0F);*/
        //System.out.println(c.agregarPeriodoLectivo(p));
        GestorLectivo g = new GestorLectivo();
        System.out.println(g.validarFechas(p));
        
    }
}
