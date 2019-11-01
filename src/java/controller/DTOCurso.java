/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Curso;

/**
 *
 * @author yir
 */
public class DTOCurso {
    private ArrayList<Curso> cursos;
    private String descripcion;
    private float horasXSemana;
    private int estado;
    private boolean respuesta;

    public DTOCurso() {
    }

    public DTOCurso(ArrayList<Curso> cursos, String descripcion, float horasXSemana, int estado, boolean respuesta) {
        this.cursos = cursos;
        this.descripcion = descripcion;
        this.horasXSemana = horasXSemana;
        this.estado = estado;
        this.respuesta = respuesta;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
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

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
    
    
    
}
