/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import model.Modalidad;
import model.PeriodoLectivo;
import model.Profesor;
import model.Rol;
import model.Usuario;

/**
 *
 * @author yir
 */
public class DAOCatalogo implements IACME {
    private DataSource dataSrc;

    public DAOCatalogo() throws SQLException {
        dataSrc =  DataSource.getInstance();
    }
    
    
    @Override
    public boolean agregar(Object obj) {
        if (obj instanceof Usuario){
            Usuario u = (Usuario)obj;
            return agregarUsuario(u);
        }
        if(obj instanceof Profesor){
            Profesor r = (Profesor)obj;
            return agregarProfesor(r);
        }
        if(obj instanceof Curso){
            Curso r = (Curso)obj;
            return agregarCurso(r);
        }
        if(obj instanceof PeriodoLectivo){
            PeriodoLectivo r = (PeriodoLectivo)obj;
            return agregarPeriodoLectivo(r);
        }
        return false;
    }
    
    private boolean agregarUsuario(Usuario u){
        Connection conn = dataSrc.getConnection();

            try {
                String query = "{call insert_usuario(?,?,?,?,?,?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
    
                stmt.setInt(1, u.getRol().getId());
                stmt.setString(2, u.getName());
                stmt.setString(3, u.getApellido1());
                stmt.setString(4, u.getApellido2());
                stmt.setString(5, u.getUsername());
                stmt.setString(6, u.getEmail());
                stmt.setString(7, u.getPhone());
                stmt.setString(8, u.getPassword());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    
    }
    
    private boolean agregarProfesor(Profesor p){
        Connection conn = dataSrc.getConnection();

            try {
                String query = "{call insert_profesor(?,?,?,?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setString(1, p.getId());
                stmt.setString(2, p.getNombre());
                stmt.setString(3, p.getApellido1());
                stmt.setString(4, p.getApellido2());
                stmt.setString(5, p.getCorreo());
                stmt.setString(6, p.getTelefono());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    
    
    }
    
    private boolean agregarCurso(Curso c){
    Connection conn = dataSrc.getConnection();

            try {
                String query = "{call insert_curso(?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setString(1, c.getId());
                stmt.setString(2, c.getDescripcion());
                stmt.setFloat(3, c.getHorasXSemana());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    
    }
    
    private boolean agregarPeriodoLectivo(PeriodoLectivo p){
        Connection conn = dataSrc.getConnection();
        
        
            try {
                String query = "{call insert_termperiod(?,?,?,?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.setString(1, p.getFechaPublicacion());
                stmt.setString(2, p.getFechaMatriculaInicio());
                stmt.setString(3, p.getFechaMatriculaFinal());
                stmt.setString(4, p.getFechaInicio());
                stmt.setString(5, p.getFechaFinal());
                stmt.setInt(6, p.getModalidad().ordinal()+1);
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    
    }

    @Override
    public boolean modificar(Object obj) {
        if (obj instanceof Usuario){
            Usuario u = (Usuario)obj;
            return modificarUsuario(u);
        }
        if(obj instanceof Profesor){
            Profesor r = (Profesor)obj;
            return modificarProfesor(r);
        }
        if(obj instanceof Curso){
            Curso r = (Curso)obj;
            return modificarCurso(r);
        }
        if(obj instanceof PeriodoLectivo){
            PeriodoLectivo r = (PeriodoLectivo)obj;
            return modificarPeriodoLectivo(r);
        }
        return false;
    }

    
    private boolean modificarUsuario(Usuario u){
        
        Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call update_usuario(?,?,?,?,?,?,?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setInt(1, u.getId());
                stmt.setInt(2, u.getRol().getId());
                stmt.setString(3, u.getName());
                stmt.setString(4, u.getApellido1());
                stmt.setString(5, u.getApellido2());
                stmt.setString(6, u.getUsername());
                stmt.setString(7, u.getEmail());
                stmt.setString(8, u.getPhone());
                stmt.setString(9, u.getPassword());               
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        
    }
    
    private boolean modificarProfesor(Profesor p){
        Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call update_profesor(?,?,?,?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setString(1, p.getId());
                stmt.setString(2, p.getNombre());
                stmt.setString(3, p.getApellido1());
                stmt.setString(4, p.getApellido2());
                stmt.setString(5, p.getCorreo());
                stmt.setString(6, p.getTelefono());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    private boolean modificarCurso(Curso c){
        Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call update_curso(?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setString(1, c.getId());
                stmt.setString(2, c.getDescripcion());
                stmt.setFloat(3, c.getHorasXSemana());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    private boolean modificarPeriodoLectivo(PeriodoLectivo p){
        Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call update_termperiod(?,?,?,?,?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setInt(1, p.getId());
                stmt.setString(2, p.getFechaPublicacion());
                stmt.setString(3, p.getFechaMatriculaInicio());
                stmt.setString(4, p.getFechaMatriculaFinal());
                stmt.setString(5, p.getFechaInicio());
                stmt.setString(6, p.getFechaFinal());
                stmt.setInt(7, p.getModalidad().ordinal()+1);
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    
    
    public boolean darDeAlta(Object obj){
        if (obj instanceof Usuario){
            Usuario u = (Usuario)obj;
            return darDeAltaUsuario(u);
        }
        if(obj instanceof Profesor){
            Profesor p = (Profesor)obj;
            return darDeAltaProfesor(p);
        }
        if(obj instanceof Curso){
            Curso c = (Curso)obj;
            return darDeAltaCurso(c);
        }

        return false;
    }
    
    private boolean darDeAltaUsuario(Usuario u){
        Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call darAlta_usuario(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setInt(1, u.getId());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    private boolean darDeAltaProfesor(Profesor p){
         Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call darAlta_profesor(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setString(1, p.getId());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    private boolean darDeAltaCurso(Curso c){
         Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call darAlta_curso(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setString(1, c.getId());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    
    public boolean darDeBaja(Object obj){
        if (obj instanceof Usuario){
            Usuario u = (Usuario)obj;
            return darDeBajaUsuario(u);
        }
        if(obj instanceof Profesor){
            Profesor p = (Profesor)obj;
            return darDeBajaProfesor(p);
        }
        if(obj instanceof Curso){
            Curso c = (Curso)obj;
            return darDeBajaCurso(c);
        }
        return false;
    }
    
    
    private boolean darDeBajaUsuario(Usuario u){
        Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call darBaja_usuario(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setInt(1, u.getId());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    private boolean darDeBajaProfesor(Profesor p){
         Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call darBaja_profesor(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setString(1, p.getId());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    private boolean darDeBajaCurso(Curso c){
         Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call darBaja_curso(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setString(1, c.getId());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    
    public boolean bloquearUsuario(Usuario u){
        Connection conn = dataSrc.getConnection();
            
            try {
                String query = "{call darBloqueo_usuario(?)}";
                CallableStatement stmt = conn.prepareCall(query);
                
                stmt.setInt(1, u.getId());
                stmt.executeQuery();
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DAOPermisos.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
    }
    
    
    //--------------------------------
    
    public int validarLogin(String username, String password){

        Connection conn = dataSrc.getConnection();
        
        try {
                String query = "{call getIdUser(?,?,?)}";
                CallableStatement stmt = conn.prepareCall(query);
                stmt.registerOutParameter(3,java.sql.Types.INTEGER);
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.execute();
                int result = stmt.getInt(3);
                //System.out.println("id user:"+ stmt.getInt(3));
                dataSrc.closeConnection();
                return result;
            } catch (SQLException ex) {
                System.out.println("Error: "+ex.getMessage());
                return 0;
            }
    }
    
    
    @Override
    public Object consultar(Object clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Usuario> consultarUsuario(Usuario u){
        Connection conn = dataSrc.getConnection();
        ArrayList<Usuario> ul = new ArrayList<Usuario>();
         
        try {
                CallableStatement stmt = conn.prepareCall("{call get_users(?,?,?,?,?,?,?)}");
                stmt.setString(1, u.getRol().getDescription());
                stmt.setString(2, u.getName());
                stmt.setString(3, u.getApellido1());
                stmt.setString(4, u.getApellido2());
                stmt.setString(5, u.getUsername());
                stmt.setString(6, u.getEmail());
                stmt.setString(7, u.getPhone());
                ResultSet result = stmt.executeQuery();

                while(result.next()) {
                    Usuario us = new Usuario();
                    us.setId(result.getInt("id_user"));
                    
                    //Obtener rol del usuario consultado
                    Rol r = new Rol();
                    r.setDescription(result.getString("role_name"));
                    us.setRol(r);
                 
                    us.setName(result.getString("first_name"));
                    us.setApellido1(result.getString("last_name_1"));
                    us.setApellido2(result.getString("last_name_2"));
                    us.setUsername(result.getString("username"));
                    us.setEmail(result.getString("email"));
                    us.setPhone(result.getString("phone_number"));
                    //us.setEstado(result.getInt("state"));
                    ul.add(us);

                }
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                System.out.println("Error: "+ ex.getMessage());
            }
        return ul;
    }
    
    
    public ArrayList<Profesor> consultarProfesor(Profesor p){
        Connection conn = dataSrc.getConnection();
        ArrayList<Profesor> ul = new ArrayList<Profesor>();
         
        try {
                CallableStatement stmt = conn.prepareCall("{call get_professor(?,?,?,?,?,?)}");
                stmt.setString(1, p.getId());
                stmt.setString(2, p.getNombre());
                stmt.setString(3, p.getApellido1());
                stmt.setString(4, p.getApellido2());
                stmt.setString(5, p.getCorreo());
                stmt.setString(6, p.getTelefono());
                ResultSet result = stmt.executeQuery();

                while(result.next()) {
                    Profesor ps = new Profesor();
                    ps.setId(result.getString("id_professor"));                                    
                    ps.setNombre(result.getString("first_name"));
                    ps.setApellido1(result.getString("last_name_1"));
                    ps.setApellido2(result.getString("last_name_2"));
                    ps.setCorreo(result.getString("email"));
                    ps.setTelefono(result.getString("phone_number"));
                    ps.setEstado(result.getInt("is_active"));
                    ul.add(ps);

                }
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                System.out.println("Error: "+ ex.getMessage());
            }
        return ul;
    }
    

    
    public ArrayList<Curso> consultarCurso(Curso c){
        Connection conn = dataSrc.getConnection();
        ArrayList<Curso> ul = new ArrayList<Curso>();
        

        try {
                CallableStatement stmt = conn.prepareCall("{call get_course(?,?)}");
                stmt.setString(1, c.getId());
                stmt.setString(2, c.getDescripcion());
                ResultSet result = stmt.executeQuery();

                while(result.next()) {
                    
                    Curso cs = new Curso();
                    cs.setId(result.getString("id_course"));                                    
                    cs.setDescripcion(result.getString("description"));
                    cs.setHorasXSemana(result.getFloat("weekly_hours"));
                    cs.setEstado(result.getInt("is_active"));
                    ul.add(cs);
                }
                
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                System.out.println("Error: "+ ex.getMessage());
            }
        return ul;
    }
    
    public ArrayList<PeriodoLectivo> consultarPeriodoLectivo(){
        Connection conn = dataSrc.getConnection();
        ArrayList<PeriodoLectivo> ul = new ArrayList<PeriodoLectivo>();
         
        try {
                CallableStatement stmt = conn.prepareCall("{call get_periodos_lectivos()}");
                ResultSet result = stmt.executeQuery();

                while(result.next()) {
                    PeriodoLectivo ps = new PeriodoLectivo();
                    ps.setId(result.getInt("id_term_period"));                                    
                    ps.setFechaPublicacion(result.getString("offer_date"));
                    ps.setFechaMatriculaInicio(result.getString("start_enrollment"));
                    ps.setFechaMatriculaFinal(result.getString("end_enrollment"));
                    ps.setFechaInicio(result.getString("start_term"));
                    ps.setFechaFinal(result.getString("end_term"));
                    ps.setIsActive(result.getInt("is_active"));
                    ps.setModalidad(Modalidad.valueOf(result.getString("term_period_type")));
                    
                    
                    ul.add(ps);
                }
                dataSrc.closeConnection();
            } catch (SQLException ex) {
                System.out.println("Error: "+ ex.getMessage());
            }
        return ul;
    }
    
    
}
