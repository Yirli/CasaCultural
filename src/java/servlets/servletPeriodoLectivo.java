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
import model.Modalidad;
import model.PeriodoLectivo;

/**
 *
 * @author yir
 */

@WebServlet(name = "servletPeriodoLectivo", urlPatterns = {"/servletPeriodoLectivo"})
public class servletPeriodoLectivo extends HttpServlet{
    
    private Controlador controller = new Controlador();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession(); 
        String job = request.getParameter("job");
    
        
        if(job.equals("1")){ //dar de baja un curso
            int id = Integer.parseInt(request.getParameter("id").trim());
            System.out.println("id dar de baja: "+id);
            PeriodoLectivo p = new PeriodoLectivo();
            p.setId(id);
            controller.darDeBajaPeriodoLectivo(p);
        }
        else if(job.equals("0")){ //dar de alta un curso
            int id = Integer.parseInt(request.getParameter("id").trim());
            System.out.println("id dar de alta:"+id);
            PeriodoLectivo p = new PeriodoLectivo();
            p.setId(id);
            controller.darDeAltaPeriodoLectivo(p);
            
        }else if(job.equals("2")){ //modificar periodo lectivo
            int id = Integer.parseInt(request.getParameter("idPeriodoLectivo").trim());
            String publicacion = request.getParameter("publicacion").trim();
            String matriculaInicio = request.getParameter("matriculaInicio").trim();
            String matriculaFin = request.getParameter("matriculaFin").trim();
            String inicioP = request.getParameter("inicioP").trim();
            String finP = request.getParameter("finP").trim();
            String mod = request.getParameter("modalidad").trim();
            
            
            PeriodoLectivo p = new PeriodoLectivo(id,publicacion,matriculaInicio,matriculaFin,inicioP,finP, Modalidad.valueOf(mod));
            System.out.println("id: "+id);
            System.out.println("publi:"+ p.getFechaPublicacion());
            System.out.println("matricula inicio:"+ p.getFechaMatriculaInicio());
            System.out.println("matricula fin:"+ p.getFechaMatriculaFinal());
            System.out.println("inicio:"+ p.getFechaInicio());
            System.out.println("fin:"+ p.getFechaFinal());
            System.out.println("modalidad:"+ p.getModalidad());
            
            controller.modificarPeriodoLectivo(p);

        }else if(job.equals("3")){//agregar periodo lectivo
            String publicacion = request.getParameter("publicacion").trim();
            String matriculaInicio = request.getParameter("matriculaInicio").trim();
            String matriculaFin = request.getParameter("matriculaFin").trim();
            String inicioP = request.getParameter("inicioP").trim();
            String finP = request.getParameter("finP").trim();
            String mod = request.getParameter("modalidad").trim();
            
            PeriodoLectivo p = new PeriodoLectivo(publicacion,matriculaInicio,matriculaFin,inicioP,finP, Modalidad.valueOf(mod));
            System.out.println("publi:"+ p.getFechaPublicacion());
            System.out.println("matricula inicio:"+ p.getFechaMatriculaInicio());
            System.out.println("matricula fin:"+ p.getFechaMatriculaFinal());
            System.out.println("inicio:"+ p.getFechaInicio());
            System.out.println("fin:"+ p.getFechaFinal());
            System.out.println("modalidad:"+ p.getModalidad());
            
            controller.agregarPeriodoLectivo(p);
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
