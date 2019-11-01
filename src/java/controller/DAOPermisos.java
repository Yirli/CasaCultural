/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionalidad;
import model.Rol;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author yir
 */
public class DAOPermisos implements IACME{

    private DataSource dataSrc;
        

    public DAOPermisos() throws SQLException {
        dataSrc =  DataSource.getInstance();
    }

    // agrega una funcionalidad en la base de datos
    @Override
    public boolean agregar(Object obj) {
        if (obj instanceof Funcionalidad){
            Funcionalidad f = (Funcionalidad)obj;
            return agregarFuncionalidad(f);
        }
        if(obj instanceof Rol){
            Rol r = (Rol)obj;
            return agregarRol(r);
        }
        return false;
    }
    
    private boolean agregarFuncionalidad(Funcionalidad f){
        Connection conn = dataSrc.getConnection();

            String descripcion = f.getDescription();
            try {
                String query = "{call insert_funcionalidad(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setString(1, descripcion);
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    private boolean agregarRol(Rol rol) {
        Connection conn = dataSrc.getConnection();
        String descripcion = rol.getDescription();
       
         
        try {
                String query = "{call insert_rol(?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.registerOutParameter(2,java.sql.Types.INTEGER);
                stmt.setString(1, descripcion);
                stmt.executeQuery();
                int id = stmt.getInt(2);
                System.out.println("id: "+id);
                
                for(Funcionalidad f : rol.getFunctionList()){
                    String query2 = "{call insert_permisos(?,?)}";
                    CallableStatement stmt2 = conn.prepareCall(query2);
                    stmt2.setInt(1, id);
                    stmt2.setInt(2, f.getId());
                    stmt2.executeQuery();
                }
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return true;
    }
    
   
    
    @Override
    public boolean modificar(Object obj) {
        if (obj instanceof Funcionalidad){
            Funcionalidad f = (Funcionalidad)obj;
            return modificarFuncionalidad(f);
        }
        if(obj instanceof Rol){
            Rol r = (Rol)obj;
            return modificarRol(r);
        }
        return false;
    }
    
    private boolean modificarFuncionalidad(Funcionalidad f){
    
            Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call update_funcionalidad(?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setInt(1, f.getId());
                stmt.setString(2, f.getDescription());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    
    private boolean modificarRol(Rol r){
        Connection conn = dataSrc.getConnection();
        String descripcion = r.getDescription();
       
         
        try {
                String query = "{call update_rol(?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setInt(1, r.getId());
                stmt.setString(2, descripcion);
                stmt.executeQuery();

                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return true;
    }

    // devuelve lista de funcionalidades
    @Override
    public Object consultar(Object obj) {
        if(obj instanceof Rol){
            Rol r = (Rol)obj;
            return getPermisos(r);
        }
        return false;
    }

    private ArrayList<Funcionalidad>getPermisos(Rol r){
        Connection conn = dataSrc.getConnection();
        ArrayList<Funcionalidad> funcionalityList = new ArrayList<Funcionalidad>();
       
         
        try {

                CallableStatement stmt = conn.prepareCall("{call get_rolPermisos(?)}");
                stmt.setInt(1, r.getId());
                ResultSet result = stmt.executeQuery();
                
                while(result.next()) {
                    Funcionalidad f = new Funcionalidad();
                    f.setId(result.getInt("ID"));
                    f.setDescription(result.getString("funcionalidad"));
                    funcionalityList.add(f);
                }
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return funcionalityList;
    }
    
    public ArrayList<Rol> consultarRoles(){
        Connection conn = dataSrc.getConnection();
        ArrayList<Rol> rolList = new ArrayList<Rol>();
       
         
        try {
                CallableStatement stmt = conn.prepareCall("{call get_roles()}");
                ResultSet result = stmt.executeQuery();
                while(result.next()) {
                    Rol r = new Rol();
                    r.setId(result.getInt("ID"));
                    r.setDescription(result.getString("role_name"));
                    rolList.add(r);
                }
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return rolList;
    
    }
   
    public ArrayList<Funcionalidad> consultarFuncionalidades(){
        Connection conn = dataSrc.getConnection();
        ArrayList<Funcionalidad> funcionalityList = new ArrayList<Funcionalidad>();
       
         
        try {
                CallableStatement stmt = conn.prepareCall("{call get_functionalities()}");
                ResultSet result = stmt.executeQuery();
                while(result.next()) {
                    Funcionalidad f = new Funcionalidad();
                    f.setId(result.getInt("ID"));
                    f.setDescription(result.getString("NameFuncionality"));
                    funcionalityList.add(f);
                }
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return funcionalityList;
    }
    
    
    public boolean otorgarPermiso(Rol r, Funcionalidad f){
       Connection conn = dataSrc.getConnection();
       
        try {
                String query = "{call insert_permisos(?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setInt(1, r.getId());
                stmt.setInt(2, f.getId());
                stmt.executeQuery();
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return true;
    }
    
    public boolean denegarPermiso(Rol r, Funcionalidad f){
        Connection conn = dataSrc.getConnection();
       
        try {
                String query = "{call delete_permiso(?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setInt(1, r.getId());
                stmt.setInt(2, f.getId());
                stmt.executeQuery();
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
        return true;
    }
     
    
}
