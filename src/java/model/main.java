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
import controller.UsuarioActual;
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
        
        /*Controlador controlador = new Controlador();
        int userActual = controlador.validarLogin("jmonge", "admin123");
        Usuario u = new Usuario();
        u.setId(userActual);
        UsuarioActual ua = new UsuarioActual(u);
        
        Usuario us = controlador.consultarUnUsuario(ua.getInstance().getId());
        System.out.println("nombre: "+ us.getName());*/
        
            Controlador cn = new Controlador();
            Rol r = new Rol();
            r.setDescription("");
            Usuario u = new Usuario(r,"","","","","","","");
            ArrayList<Usuario> a = cn.consultarUsuario(u);
            System.out.println(a.get(0).getEstado());
                
    }
}
