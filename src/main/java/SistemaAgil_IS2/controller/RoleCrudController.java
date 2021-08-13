package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.dao.RoleDapImpl;
import SistemaAgil_IS2.model.Role;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoleCrudController extends HttpServlet {
    Role r=new Role();
    RoleDapImpl dao=new RoleDapImpl();
    int id;
    String listarole="WEB-INF/vistas/listaroles.jsp";
    String addrole="WEB-INF/vistas/addroles.jsp";
    String pagseguridad="WEB-INF/vistas/seguridad.jsp";
    String homepage="WEB-INF/vistas/bienvenido.jsp";
    String editroles="WEB-INF/vistas/editroles.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RoleCrudController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RoleCrudController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("editrole")){
            request.setAttribute("idrole", request.getParameter("id"));
            acceso=editroles;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String uname=request.getParameter("txtuname");
            r.setIdRole(id);
            r.setDescripcion(uname);
            dao.edit(r);
            acceso=listarole;
        }else if(action.equalsIgnoreCase("deleterole")){
            id=Integer.parseInt(request.getParameter("id"));
            r.setIdRole(id);
            dao.eliminar(id);
            acceso=listarole;
        }else if(action.equalsIgnoreCase("addrole")){
            acceso=addrole;
        }else if(action.equalsIgnoreCase("Agregar")){
            String uname=request.getParameter("txtuname");
            r.setDescripcion(uname);
            dao.add(r);
            acceso=listarole;
        }else if(action.equalsIgnoreCase("Listar Roles")){
            acceso=listarole;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("Listar Roles")){
            acceso=listarole;
        }else if(action.equalsIgnoreCase("seguridad")){
            acceso=pagseguridad;
        }else if(action.equalsIgnoreCase("paginabienvenida")){
            acceso=homepage;
        }else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String uname=request.getParameter("txtuname");
            r.setIdRole(id);
            r.setDescripcion(uname);
            dao.edit(r);
            acceso=listarole;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
