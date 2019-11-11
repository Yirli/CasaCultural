/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Usuario;

/**
 *
 * @author yir
 */
public class UsuarioActual {
    //private UsuarioActual usuario;
    private static Usuario usrConectado;

    public UsuarioActual(Usuario usrConectado) {
        this.usrConectado = usrConectado;
    }

    public UsuarioActual() {
    }
    

      public static Usuario getInstance()throws SQLException{
        return usrConectado;
   }
      
        public static void setUsuarioConectado(Usuario usrConectado) {
            UsuarioActual.usrConectado = usrConectado;
    }

}
