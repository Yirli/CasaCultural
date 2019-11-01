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


public class Usuario {
   
   private int id;
   private String username;
   private String password;
   private String name;
   private String apellido1;
   private String apellido2;
   private String email;
   private String phone;
   private Rol rol;
   private TEstado estado;

   
   //para el consultar
    public Usuario(int id, Rol rol, String name, String apellido1, String apellido2, String username,  String email, String phone, String password, TEstado estado) {
        this.id = id;
        this.rol = rol;
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.estado = estado;
    }
    
    //para el insert
    public Usuario(Rol rol, String name, String apellido1, String apellido2, String username,  String email, String phone, String password) {
        this.rol = rol;
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    
    //para el update
      public Usuario(int id,Rol rol, String name, String apellido1, String apellido2, String username,  String email, String phone, String password) {
        this.id = id;
        this.rol = rol;
        this.name = name;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    

    public Usuario() {
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public TEstado getEstado() {
        return estado;
    }

    public void setEstado(TEstado estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    
   
    
}
