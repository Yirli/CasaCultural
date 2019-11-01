/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author yir
 */
public class Curso {
    private String id;
    private String descripcion;
    private float horasXSemana;
    private int estado;

    public Curso() {
    }

    //para consultar
    public Curso(String id, String descripcion, float horasXSemana, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.horasXSemana = horasXSemana;
        this.estado = estado;
    }
    
    //para insertar o modificar
    public Curso(String id, String descripcion, float horasXSemana) {
        this.id = id;
        this.descripcion = descripcion;
        this.horasXSemana = horasXSemana;
    }
    
    
    public Curso(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.horasXSemana = horasXSemana;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getHorasXSemana() {
        return horasXSemana;
    }

    public void setHorasXSemana(float horasXSemana) {
        this.horasXSemana = horasXSemana;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
