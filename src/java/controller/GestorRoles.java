/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Funcionalidad;
import model.Rol;

/**
 *
 * @author yir
 */
public class GestorRoles {
    private DAOPermisos daoPermisos;
    private DTOPermiso dtoPermisos;

    public GestorRoles(DAOPermisos daoPermisos, DTOPermiso dtoPermisos) {
        this.daoPermisos = daoPermisos;
        this.dtoPermisos = dtoPermisos;
    }

    public GestorRoles() {
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

    public DTOPermiso getDtoPermisos() {
        return dtoPermisos;
    }

    public void setDtoPermisos(DTOPermiso dtoPermisos) {
        this.dtoPermisos = dtoPermisos;
    }
    
    
}
