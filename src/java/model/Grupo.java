/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author yir
 */
public class Grupo {
    private int id;
    private String aula;
    private int capacidad;
    private Curso curso;
    private Profesor profesor;
    private boolean estado;
    private PeriodoLectivo periodoLectivo;
    ArrayList<DiaDeClase> diasDeClase;
    ArrayList<Usuario> estudiantes;
          
}
