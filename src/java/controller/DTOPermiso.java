/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yir
 */
public class DTOPermiso {
    private int id;
    private String descripcion;
    private boolean respuesta;

    public DTOPermiso() {
    }

    
    public DTOPermiso(int id, String descripcion, boolean respuesta) {
        this.id = id;
        this.descripcion = descripcion;
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
}
