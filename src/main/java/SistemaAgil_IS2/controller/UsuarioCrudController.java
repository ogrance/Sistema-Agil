/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.dao.UsuarioDaoImpl;
import SistemaAgil_IS2.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
public class UsuarioCrudController extends HttpServlet {
    
    Usuario u=new Usuario();
    UsuarioDaoImpl dao=new UsuarioDaoImpl();
    int id;
    String listaruser="WEB-INF/vistas/listar.jsp";
    String adduser="WEB-INF/vistas/adduser.jsp";
    String pagseguridad="WEB-INF/vistas/seguridad.jsp";
    String homepage="WEB-INF/vistas/bienvenido.jsp";
    String edituser="WEB-INF/vistas/edituser.jsp";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioCrudController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioCrudController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("Listar Users")){
            acceso=listaruser;
        }else if(action.equalsIgnoreCase("Agregar un nuevo User")){
            acceso=adduser;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String uname=request.getParameter("txtuname");
            String name=request.getParameter("txtname");
            String lname=request.getParameter("txtlname");
            String pass=request.getParameter("txtpass");
            u.setNombreUsuario(uname);
            u.setNombre(name);
            u.setApellido(lname);
            u.setPasswrd(pass);
            dao.add(u);
            acceso=listaruser;
        }else if(action.equalsIgnoreCase("seguridad")){
            acceso=pagseguridad;
        }else if(action.equalsIgnoreCase("paginabienvenida")){
            acceso=homepage;
        }else if(action.equalsIgnoreCase("edituser")){
            request.setAttribute("iduser", request.getParameter("id"));
            acceso=edituser;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String uname=request.getParameter("txtuname");
            String name=request.getParameter("txtname");
            String lname=request.getParameter("txtlname");
            String pass=request.getParameter("txtpass");
            String status=request.getParameter("txtstatus");
            u.setIdUsuario(id);
            u.setNombreUsuario(uname);
            u.setNombre(name);
            u.setApellido(lname);
            u.setPasswrd(pass);
            u.setStatus(status);
            dao.edit(u);
            acceso=listaruser;
        }else if(action.equalsIgnoreCase("deleteuser")){
            id=Integer.parseInt(request.getParameter("id"));
            u.setIdUsuario(id);
            dao.eliminar(id);
            acceso=listaruser;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
        
    }


    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            }
    }

    
    
    
    
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// 

}
*/