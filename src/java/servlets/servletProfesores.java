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

/**
 *
 * @author yir
 */

@WebServlet(name = "servletProfesores", urlPatterns = {"/servletProfesores"})
public class servletProfesores extends HttpServlet{
    
    private Controlador controller = new Controlador();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        String job = request.getParameter("job");
    
        
        //String description = request.getParameter("description");
        //Float hours = Float.parseFloat(request.getParameter("hours"));
        
        //System.out.println("job:"+request.getParameter("job"));
        //System.out.println("id:"+id);
        //System.out.println("course_id: "+ course_id);
        
        if(job.equals("1")){ //dar de baja un curso
            String id = request.getParameter("id");
            Profesor p = new Profesor();
            p.setId(id.trim());
            controller.darDeBajaProfesor(p);
        }
        
        else if(job.equals("0")){ //dar de alta un curso
            String id = request.getParameter("id");
            Profesor p = new Profesor();
            p.setId(id.trim());
            controller.darDeAltaProfesor(p); 
            
        }else if(job.equals("2")){ //modificar curso
            String cedula = request.getParameter("cedula").trim();
            String nombre = request.getParameter("nombre").trim();
            String apellido1 = request.getParameter("apellido1").trim();
            String apellido2 = request.getParameter("apellido2").trim();
            String correo = request.getParameter("correo").trim();
            String telefono = request.getParameter("telefono").trim();
            Profesor p = new Profesor(cedula,nombre,apellido1,apellido2,correo,telefono);
            System.out.println("id: "+ p.getId());
            System.out.println("nombre: "+ p.getNombre());
            controller.modificarProfesor(p);

        }else if(job.equals("3")){//agregar curso
            String cedula = request.getParameter("cedula").trim();
            String nombre = request.getParameter("nombre").trim();
            String apellido1 = request.getParameter("apellido1").trim();
            String apellido2 = request.getParameter("apellido2").trim();
            String correo = request.getParameter("correo").trim();
            String telefono = request.getParameter("telefono").trim();
            Profesor p = new Profesor(cedula,nombre,apellido1,apellido2,correo,telefono);
            controller.agregarProfesor(p);
        }

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
