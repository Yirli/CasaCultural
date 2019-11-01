/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Funcionalidad;

/**
 *
 * @author yir
 */
public class GestorFuncionalidades {
    
    private DAOPermisos daoPermisos;

    public GestorFuncionalidades(DAOPermisos daoPermisos) {
        this.daoPermisos = daoPermisos;
    }

    public GestorFuncionalidades() {
    }
    
    
    
    public boolean agregar(String descripcion){
        Funcionalidad f = new Funcionalidad();
        f.setDescription(descripcion);
        return daoPermisos.agregar(f);
    }
    
    public boolean modificar(String descripcion, int id){
        Funcionalidad f = new Funcionalidad(id,descripcion);
        return daoPermisos.modificar(f);
    }
    
    public ArrayList<Funcionalidad> cargarFuncionalidades(){
        return daoPermisos.consultarFuncionalidades();
    }

    public DAOPermisos getDaoPermisos() {
        return daoPermisos;
    }

    public void setDaoPermisos(DAOPermisos daoPermisos) {
        this.daoPermisos = daoPermisos;
    }
    
    
}
