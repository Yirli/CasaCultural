/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;


public class PeriodoLectivo {
    private int id;
    private String fechaPublicacion;
    private String fechaMatriculaInicio;
    private String fechaMatriculaFinal;
    private String fechaInicio;
    private String fechaFinal;
    private int isActive;
    private Modalidad modalidad;

    public PeriodoLectivo() {
    }

    //para insert
    public PeriodoLectivo(String fechaPublicacion, String fechaMatriculaInicio, String fechaMatriculaFinal, String fechaInicio, String fechaFinal, Modalidad modalidad) {
        this.fechaPublicacion = fechaPublicacion;
        this.fechaMatriculaInicio = fechaMatriculaInicio;
        this.fechaMatriculaFinal = fechaMatriculaFinal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.modalidad = modalidad;
    }

    
    
    //para  update
    public PeriodoLectivo(int id, String fechaPublicacion, String fechaMatriculaInicio, String fechaMatriculaFinal, String fechaInicio, String fechaFinal, Modalidad modalidad) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaMatriculaInicio = fechaMatriculaInicio;
        this.fechaMatriculaFinal = fechaMatriculaFinal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.modalidad = modalidad;
    }

    // para consultar
    public PeriodoLectivo(int id, String fechaPublicacion, String fechaMatriculaInicio, String fechaMatriculaFinal, String fechaInicio, String fechaFinal, int isActive, Modalidad modalidad) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.fechaMatriculaInicio = fechaMatriculaInicio;
        this.fechaMatriculaFinal = fechaMatriculaFinal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.isActive = isActive;
        this.modalidad = modalidad;
    }

    
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getFechaMatriculaInicio() {
        return fechaMatriculaInicio;
    }

    public void setFechaMatriculaInicio(String fechaMatricula) {
        this.fechaMatriculaInicio = fechaMatricula;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public String getFechaMatriculaFinal() {
        return fechaMatriculaFinal;
    }

    public void setFechaMatriculaFinal(String fechaMatriculaFinal) {
        this.fechaMatriculaFinal = fechaMatriculaFinal;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    
    
    
}
