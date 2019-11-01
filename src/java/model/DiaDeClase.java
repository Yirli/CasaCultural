/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author yir
 */


public class DiaDeClase {
    private Dia dia;
    private Date horaEntrada; 
    private Date horaSalida;

    public DiaDeClase() {
    }

    
    public DiaDeClase(Dia dia, Date horaEntrada, Date horaSalida) {
        this.dia = dia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
}
