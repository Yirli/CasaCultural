/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Rol;
import model.TEstado;

/**
 *
 * @author yir
 */
public class DTOUsuario {
    private String username;
    private String name;
    private String email;
    private Rol r;
    private TEstado estado;
    private boolean respuesta;

    public DTOUsuario() {
    }

    public DTOUsuario(String username, String name, String email, Rol r, TEstado estado, boolean respuesta) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.r = r;
        this.estado = estado;
        this.respuesta = respuesta;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getR() {
        return r;
    }

    public void setR(Rol r) {
        this.r = r;
    }

    public TEstado getEstado() {
        return estado;
    }

    public void setEstado(TEstado estado) {
        this.estado = estado;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
    
}
