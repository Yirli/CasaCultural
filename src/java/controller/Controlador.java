/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Curso;
import model.PeriodoLectivo;
import model.Profesor;
import model.Rol;
import model.Usuario;

/**
 *
 * @author yir
 */
public class Controlador {
    
    private UsuarioActual usuarioActual;
    private Usuario usuarioSeleccionado;
    private PeriodoLectivo periodoLectivoActual;
    private GestorRoles gestorRoles;
    private GestorFuncionalidades gestorFuncionalidades;
    private GestorUsuarios gestorUsuarios;
    private GestorProfesores gestorProfesores;
    private GestorCursos gestorCursos;
    private GestorLectivo gestorLectivo;


    public Controlador() {
        //this.usuarioActual = usuarioActual;
        //this.periodoLectivoActual = periodoLectivoActual;
        this.gestorRoles = new GestorRoles();
        this.gestorFuncionalidades = new GestorFuncionalidades();
        this.gestorUsuarios = new GestorUsuarios();
        this.gestorProfesores = new GestorProfesores();
        this.gestorLectivo = new GestorLectivo();
        this.gestorCursos = new GestorCursos();
    }
     
    //------------Usuarios-------------------------------
    
    public int validarLogin(String username, String password){
        return gestorUsuarios.validarLogin(username, password);
    }
    
    public boolean agregarUsuario(Usuario u){
        return gestorUsuarios.agregar(u);
    }
    
    public boolean modificarUsuario(Usuario u){
        return gestorUsuarios.modificar(u);
    }
    
    public ArrayList<Usuario> consultarUsuario(Usuario u){
        return gestorUsuarios.consultar(u);
    }
    
    public Usuario consultarUnUsuario(int id){
        return gestorUsuarios.consultarUnUsuario(id);
    }
    
    public boolean darDeBajaUsuario(Usuario u){
        return gestorUsuarios.darDeBaja(u);
    }
    
    public boolean darDeAltaUsuario(Usuario u){
        return gestorUsuarios.darDeAlta(u);
    }
    
    public void setUsuarioSeleccionado(Usuario u){
       usuarioSeleccionado = consultarUsuario(u).get(0);
    }
    
    public ArrayList<Rol> consultarRoles(){
        return gestorRoles.consultar();
    }
    
    //------------Profesores-------------------------------
    
    public boolean agregarProfesor(Profesor p){
        return gestorProfesores.agregar(p);
    }
    
    public boolean modificarProfesor(Profesor p){
        return gestorProfesores.modificar(p);
    }
    
    public ArrayList<Profesor> consultarProfesor(Profesor p){
        return gestorProfesores.consultar(p);
    }
    
    public boolean darDeBajaProfesor(Profesor p){
        return gestorProfesores.darDeBaja(p);
    }
    
    public boolean darDeAltaProfesor(Profesor p){
        return gestorProfesores.darDeAlta(p);
    } 
    
    //------------Cursos-------------------------------
    
     public boolean agregarCurso(Curso c){
        return gestorCursos.agregar(c);
    }
    
    public boolean modificarCurso(Curso c){
        return gestorCursos.modificar(c);
    }
    
    public ArrayList<Curso> consultarCurso(Curso c){
        return gestorCursos.consultar(c);
    }
    
    public boolean darDeBajaCurso(Curso c){
        return gestorCursos.darDeBaja(c);
    }
    
    public boolean darDeAltaCurso(Curso c){
        return gestorCursos.darDeAlta(c);
    } 
    
    //------------Periodo Lectivo-------------------------------
    
     public boolean agregarPeriodoLectivo(PeriodoLectivo p){
        return gestorLectivo.agregar(p);
    }
    
    public boolean modificarPeriodoLectivo(PeriodoLectivo p){
        return gestorLectivo.modificar(p);
    }
    
    public ArrayList<PeriodoLectivo> consultarPeriodoLectivo(PeriodoLectivo p){
        return gestorLectivo.consultar(p);
    }
    
    public ArrayList<String> consultarModalidad(){
        return gestorLectivo.consultarModalidad();
    }
    
    public boolean darDeBajaPeriodoLectivo(PeriodoLectivo p){
        return gestorLectivo.darDeBaja(p);
    }
    
    public boolean darDeAltaPeriodoLectivo(PeriodoLectivo p){
        return gestorLectivo.darDeAlta(p);
    } 
    
    
    
}
