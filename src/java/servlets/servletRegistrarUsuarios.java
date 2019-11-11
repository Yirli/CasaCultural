/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controller.Controlador;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Curso;
import model.Profesor;
import model.Rol;
import model.Usuario;

/**
 *
 * @author yir
 */

@WebServlet(name = "servletRegistrarUsuarios", urlPatterns = {"/servletRegistrarUsuarios"})
public class servletRegistrarUsuarios extends HttpServlet{
    
    private Controlador controller = new Controlador();
    

     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        String mensaje=" ";
         
            int rol = Integer.parseInt(request.getParameter("rol").trim());
            String nombre = request.getParameter("nombre").trim();
            String apellido1 = request.getParameter("apellido1").trim();
            String apellido2 = request.getParameter("apellido2").trim();
            String correo = request.getParameter("correo").trim();
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String telefono = request.getParameter("telefono").trim();
            String cedula = request.getParameter("cedula").trim();
            System.out.println("username: "+username);
            System.out.println("corre: "+correo);
            System.out.println("apellido1: "+apellido1);
            System.out.println("apellido2: "+apellido2);
            System.out.println("telefono: "+telefono);
            Rol r = new Rol();
            r.setId(rol);
            Usuario u = new Usuario(r,nombre,apellido1,apellido2,username,correo,telefono,password);

           controller.agregarUsuario(u);
            
            //sesion.setAttribute("mensaje", "");
                

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *  
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }//
    
}
