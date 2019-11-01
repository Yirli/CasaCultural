/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Usuario;

/**
 *
 * @author yir
 */
public class UsuarioActual {
    //private UsuarioActual usuario;
    private Usuario usrConectado;

    private UsuarioActual(Usuario usrConectado) {
        this.usrConectado = usrConectado;
    }

    private UsuarioActual() {
    }
    
    /*public UsuarioActual getInstance(){
        if (instance == null) {
            instance = new DataSource();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataSource();
        }

        return instance;
    }*/
}
