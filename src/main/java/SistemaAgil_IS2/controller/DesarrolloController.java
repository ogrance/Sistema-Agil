package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.dao.DesarrolloDaoImpl;
import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.UserStorie;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesarrolloController extends HttpServlet {

    UserStorie u = new UserStorie();
    Backlog b = new Backlog();
    DesarrolloDaoImpl dao = new DesarrolloDaoImpl();
    int id;
    String paginaDesarrollo = "WEB-INF/vistas/paginaDesarrollo.jsp";
    String listarUs = "WEB-INF/vistas/listarUs.jsp";
    String agregarUs = "WEB-INF/vistas/agregarUs.jsp";
    String exito = "WEB-INF/vistas/accionExitosa.jsp";
    String modificarUs = "WEB-INF/vistas/modificarUs.jsp";
    String listarBacklogs = "WEB-INF/vistas/listarBacklogs.jsp";
    String crearBacklog = "WEB-INF/vistas/agregarBacklogs.jsp";
    String modificarBacklogs = "WEB-INF/vistas/modificarBacklogs.jsp";
    String relacionarBacklogProyecto = "WEB-INF/vistas/relacionarBacklogProyecto.jsp";
    String confirmarRelacionBackProy = "WEB-INF/vistas/confirmarRelacionBackProy.jsp";
    String paginaError = "WEB-INF/vistas/accionErronea.jsp";
    String listarBacklogProyecto = "WEB-INF/vistas/listarBacklogProyecto.jsp";
    String relacionarBacklogConUserStorie = "WEB-INF/vistas/relacionarBacklogConUserStorie.jsp";
    String confirmarRelacionBacklogUs = "WEB-INF/vistas/confirmarRelacionBacklogUs.jsp";
    String listarContenidoDeBacklogs = "WEB-INF/vistas/listarContenidoDeBacklogs.jsp";
    String exitoAgregarUS = "WEB-INF/redirectsIgnorar/exitoAgregarUS.jsp";
    String exitoAgregarBacklog = "WEB-INF/redirectsIgnorar/exitoAgregarBacklog.jsp";
    String exitoRelacionBacklogProject = "WEB-INF/redirectsIgnorar/exitoRelacionBacklogProject.jsp";
    String exitoRelacionUsBacklog = "WEB-INF/redirectsIgnorar/exitoRelacionUsBacklog.jsp";
    String errorAgregarBacklog = "WEB-INF/redirectsIgnorar/errorAgregarBacklog.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DesarrolloController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DesarrolloController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("Desarrollo")) {
            acceso = paginaDesarrollo;
        } else if (action.equalsIgnoreCase("editust")) {
            request.setAttribute("ids", request.getParameter("id"));
            acceso = modificarUs;
        } else if (action.equalsIgnoreCase("deleteust")) {
            id = Integer.parseInt(request.getParameter("id"));
            u.setId_us(id);
            dao.eliminar(id);
            acceso = listarUs;
        } else if (action.equalsIgnoreCase("editbackl")) {
            request.setAttribute("idb", request.getParameter("id"));
            acceso = modificarBacklogs;
        } else if (action.equalsIgnoreCase("Redirect ABM de User Stories")) {
            acceso = listarUs;
        } else if (action.equalsIgnoreCase("Redirect AM de Backlogs")) {
            acceso = listarBacklogs;
        } else if (action.equalsIgnoreCase("Redirect Relacion Proyecto_Backlog")) {
            acceso = relacionarBacklogProyecto;
        } else if (action.equalsIgnoreCase("Redirect Relacion Backlog_UserStorie")) {
            acceso = relacionarBacklogConUserStorie;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("ABM de User Stories")) {
            acceso = listarUs;
        } else if (action.equalsIgnoreCase("Agregar User Storie")) {
            acceso = agregarUs;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String descp = request.getParameter("descripcion");
            String projectid = request.getParameter("ProjectId");
            int project_id = Integer.parseInt(projectid.substring(projectid.indexOf("(") + 4, projectid.indexOf(")")));
            u.setDescripcion(descp);
            u.setProject_id(project_id);
            u.setBacklog_id(3);
            Boolean resultado = dao.add(u);
            if (resultado) {
                acceso = paginaError;
            } else {
                acceso = exitoAgregarUS;
            }
        } else if (action.equalsIgnoreCase("Actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String desc = request.getParameter("descripcion");
            String projectid = request.getParameter("ProjectId");
            int project_id = Integer.parseInt(projectid.substring(projectid.indexOf("(") + 4, projectid.indexOf(")")));
            u.setId_us(id);
            u.setDescripcion(desc);
            u.setProject_id(project_id);
            u.setBacklog_id(3);
            Boolean resultado = dao.edit(u);
            if (resultado) {
                acceso = paginaError;
            } else {
                acceso = listarUs;
            }
        } else if (action.equalsIgnoreCase("AM de Backlogs")) {
            acceso = listarBacklogs;
        } else if (action.equalsIgnoreCase("Crear Backlog")) {
            acceso = crearBacklog;
        } else if (action.equalsIgnoreCase("Crear")) {
            String namep = request.getParameter("nameb");
            String ProjId = request.getParameter("ProjectId");
            int project_id = Integer.parseInt(ProjId.substring(ProjId.indexOf("(") + 4, ProjId.indexOf(")")));
            b.setNombre(namep);
            b.setProject_id(project_id);
            Boolean resultado = dao.addb(b);
            if (resultado) {
                acceso = errorAgregarBacklog;
            } else {
                acceso = exitoAgregarBacklog;
            }
        } else if (action.equalsIgnoreCase("Actualizar Backlog")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String nam = request.getParameter("name");
            String ProjId = request.getParameter("ProjectId");
            int project_id = Integer.parseInt(ProjId.substring(ProjId.indexOf("(") + 4, ProjId.indexOf(")")));
            b.setId_backlog(id);
            b.setNombre(nam);
            b.setProject_id(project_id);
            Boolean resultado = dao.editb(b);
            if (resultado) {
                acceso = errorAgregarBacklog;
            } else {
                acceso = listarBacklogs;
            }
        } else if (action.equalsIgnoreCase("Asignar Proyecto a Backlog") || action.equalsIgnoreCase("Cancelar") || action.equalsIgnoreCase("Volver atras")) {
            acceso = relacionarBacklogProyecto;
        } else if (action.equalsIgnoreCase("Relacionar Proyecto con Backlog")) {
            acceso = confirmarRelacionBackProy;
        } else if (action.equalsIgnoreCase("Ver Backlogs/Proyectos")) {
            acceso = listarBacklogProyecto;
        } else if (action.equalsIgnoreCase("Agregar US a Backlogs") || action.equalsIgnoreCase("Volver ")) {
            acceso = relacionarBacklogConUserStorie;
        } else if (action.equalsIgnoreCase("Agregar US al Backlog")) {
            acceso = confirmarRelacionBacklogUs;
        } else if (action.equalsIgnoreCase("Ver contenido de Backlogs")) {
            acceso = listarContenidoDeBacklogs;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
