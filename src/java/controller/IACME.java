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
public interface IACME {
    public boolean agregar(Object obj);
    public boolean modificar(Object obj);
    public Object consultar(Object clave);
}
