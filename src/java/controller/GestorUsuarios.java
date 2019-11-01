/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author yir
 */
public class GestorUsuarios {
    private DAOCatalogo daocatalogo;

    public GestorUsuarios(DAOCatalogo daocatalogo) {
        this.daocatalogo = daocatalogo;
    }

    

    public GestorUsuarios() {
        try {
            daocatalogo = new DAOCatalogo();
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    
    
    public boolean agregar(Usuario u){
        u.setPassword(encrypt(u.getPassword()));
        return daocatalogo.agregar(u);
    }
    
    public boolean darDeAlta(Usuario u){
        return daocatalogo.darDeAlta(u);
    }
    
    public boolean darDeBaja(Usuario u){
        return daocatalogo.darDeBaja(u);
    }
    
    public boolean modificar(Usuario u){
        u.setPassword(encrypt(u.getPassword()));
        return daocatalogo.modificar(u);
    }
    
    public ArrayList<Usuario> consultar(Usuario u){
        return daocatalogo.consultarUsuario(u);
    }
    
    public int validarLogin(String username, String password){
        System.out.println("gestor usuarios: "+daocatalogo.validarLogin(username, encrypt(password)));
        return daocatalogo.validarLogin(username, encrypt(password));
    }
    
    static char[] chars = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
        'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
        'y', 'z', '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@',
        '#', '$', '%', '^', '&', '(', ')', '+',
        '-', '*', '/', '[', ']', '{', '}', '=',
        '<', '>', '?', '_', '"', '.', ',', ' '
    };
    
    private String encrypt(String text){
            int offset = 5;
            char[] plain = text.toCharArray();

            for (int i = 0; i < plain.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (j <= chars.length - offset) {
                        if (plain[i] == chars[j]) {
                            plain[i] = chars[j + offset];
                            break;
                        }
                    } 
                    else if (plain[i] == chars[j]) {
                        plain[i] = chars[j - (chars.length - offset + 1)];
                    }
                }
            }
            return String.valueOf(plain);
        }

    public DAOCatalogo getDaocatalogo() {
        return daocatalogo;
    }

    public void setDaocatalogo(DAOCatalogo daocatalogo) {
        this.daocatalogo = daocatalogo;
    }

    public static char[] getChars() {
        return chars;
    }

    public static void setChars(char[] chars) {
        GestorUsuarios.chars = chars;
    }
    
    
    
}
