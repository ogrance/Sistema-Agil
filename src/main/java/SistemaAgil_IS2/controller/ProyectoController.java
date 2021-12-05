package SistemaAgil_IS2_war.controller;

import SistemaAgil_IS2_war.dao.ProjectDaoImpl;
import SistemaAgil_IS2_war.model.Project;
import SistemaAgil_IS2_war.model.ProjectMember;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProyectoController extends HttpServlet {

    Project p = new Project();
    ProjectDaoImpl dao = new ProjectDaoImpl();
    int id;
    ProjectMember pm = new ProjectMember();
    String paginaBienvenida = "WEB-INF/vistas/bienvenido.jsp";
    String paginaproyecto = "WEB-INF/vistas/paginaProyecto.jsp";
    String listarproyecto = "WEB-INF/vistas/listarProyectos.jsp";
    String crearproyecto = "WEB-INF/vistas/agregarProyecto.jsp";
    String exito = "WEB-INF/vistas/accionExitosa.jsp";
    String editproyecto = "WEB-INF/vistas/editarProyecto.jsp";
    String seleccionarProyecto = "WEB-INF/vistas/selectProyToAddUser.jsp";
    String addusertoproyectconf = "WEB-INF/vistas/procesarAdicion.jsp";
    String paginaError = "WEB-INF/vistas/accionErronea.jsp";
    String listarProjectMembers = "WEB-INF/vistas/listarProjectMembers.jsp";
    String paginaDesarrollo = "WEB-INF/vistas/paginaDesarrollo.jsp";
    String exitoAgregarProyecto = "WEB-INF/redirectsIgnorar/exitoAgregarProyecto.jsp";
    String errorProjectMember = "WEB-INF/redirectsIgnorar/errorProjectMember.jsp";
    String exitoProjectMember = "WEB-INF/redirectsIgnorar/exitoProjectMember.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProyectoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProyectoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("deleteproject")) {
            id = Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso = listarproyecto;
        } else if (action.equalsIgnoreCase("editproject")) {
            request.setAttribute("idp", request.getParameter("id"));
            acceso = editproyecto;
        } else if (action.equalsIgnoreCase("home")) {
            acceso = paginaBienvenida;
        } else if (action.equalsIgnoreCase("Proyecto")) {
            acceso = paginaproyecto;
        } else if (action.equalsIgnoreCase("Desarrollo")){
            acceso = paginaDesarrollo;
        } else if (action.equalsIgnoreCase("RedirectListarProyectos")){
            acceso = listarproyecto;
        } else if (action.equalsIgnoreCase("RedirectAgregarProjectMembers")){
            acceso = seleccionarProyecto;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("Proyecto")) {
            acceso = paginaproyecto;
        } else if (action.equalsIgnoreCase("Volver a la Home")){
            acceso = paginaBienvenida;
        } else if (action.equalsIgnoreCase("ABM de Proyectos")) {
            acceso = listarproyecto;
        } else if (action.equalsIgnoreCase("Crear Proyecto")) {
            acceso = crearproyecto;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String namep = request.getParameter("projectname");
            String descp = request.getParameter("descripcion");
            String estap = request.getParameter("Estatus");
            p.setProjectName(namep);
            p.setDescription(descp);
            p.setStatus(estap);
            dao.add(p);
            acceso = exitoAgregarProyecto; //tocar aqui
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String uname = request.getParameter("projectname");
            String desc = request.getParameter("descripcion");
            String est = request.getParameter("Estatus");
            p.setId(id);
            p.setProjectName(uname);
            p.setDescription(desc);
            p.setStatus(est);
            dao.edit(p);
            acceso = listarproyecto;
        } else if (action.equalsIgnoreCase("Agregar Usuarios a Proyecto") || action.equalsIgnoreCase("Cancelar") || action.equalsIgnoreCase("Volver atras")) {
            acceso = seleccionarProyecto;
        } else if (action.equalsIgnoreCase("Agregar User al Proyecto")) {
            acceso = addusertoproyectconf;
        } else if (action.equalsIgnoreCase("Agregar al User")) {
            id = Integer.parseInt(request.getParameter("idProyecto"));
            int usuId = Integer.parseInt(request.getParameter("nombreUSer"));
            pm.setId_proyecto(id);
            pm.setId_user(usuId);
            String resultado = dao.add(pm);
            if (resultado.equalsIgnoreCase("errorexp")) {
                acceso = errorProjectMember;
            } else {
                acceso = exitoProjectMember;
            }
        } else if (action.equalsIgnoreCase("Ver Project Members")){
            acceso = listarProjectMembers;
        } else if (action.equalsIgnoreCase("Desarrollo")){
            acceso = paginaDesarrollo;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
