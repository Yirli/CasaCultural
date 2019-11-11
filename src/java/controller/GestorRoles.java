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
import model.Funcionalidad;
import model.Rol;

/**
 *
 * @author yir
 */
public class GestorRoles {
    private DAOPermisos daoPermisos;


    public GestorRoles(DAOPermisos daoPermisos, DTOPermiso dtoPermisos) {
        this.daoPermisos = daoPermisos;
    }

    public GestorRoles() {
        try {
            daoPermisos = new DAOPermisos();
        } catch (SQLException ex) {
            System.out.println("Error gestor roles: "+ ex.getMessage());
        }
    }
    
    
    
    public boolean agregar(Rol r){
        return daoPermisos.agregar(r);
    }
    
    public boolean otorgarPermiso(Rol r, Funcionalidad f){
        return daoPermisos.otorgarPermiso(r, f);
    }
    
    public boolean denegarPermiso(Rol r, Funcionalidad f){
        return daoPermisos.denegarPermiso(r, f);
    }
    
    public ArrayList<Funcionalidad> consultarPermisos(Rol r){
        return (ArrayList<Funcionalidad>)daoPermisos.consultar(r);
    }
    
    public ArrayList<Rol>consultar(){
        return daoPermisos.consultarRoles();
    }

    public DAOPermisos getDaoPermisos() {
        return daoPermisos;
    }

    public void setDaoPermisos(DAOPermisos daoPermisos) {
        this.daoPermisos = daoPermisos;
    }


    
    
}
