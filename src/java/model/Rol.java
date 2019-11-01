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
public class Rol {
    private int id;
    private String description;
    ArrayList<Funcionalidad> functionList = new ArrayList<Funcionalidad>();

    public Rol() {
    }

    public Rol(int id, String description, ArrayList<Funcionalidad> functionList) {
        this.id = id;
        this.description = description;
        this.functionList = functionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Funcionalidad> getFunctionList() {
        return functionList;
    }

    public void setFunctionList(ArrayList<Funcionalidad> functionList) {
        this.functionList = functionList;
    }
    
    public void addFunctionList(Funcionalidad f) {
        this.functionList.add(f);
    }
    
}
