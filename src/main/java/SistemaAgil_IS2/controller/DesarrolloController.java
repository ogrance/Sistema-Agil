package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.dao.DesarrolloDaoImpl;
import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.ProjectBacklog;
import SistemaAgil_IS2.model.UsBacklog;
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
    ProjectBacklog pb = new ProjectBacklog();
    UsBacklog ub = new UsBacklog();
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
        if (action.equalsIgnoreCase("Desarrollo")){
            acceso = paginaDesarrollo;
        } else if (action.equalsIgnoreCase("editust")){
            request.setAttribute("ids", request.getParameter("id"));
            acceso = modificarUs;
        } else if (action.equalsIgnoreCase("deleteust")){
            id = Integer.parseInt(request.getParameter("id"));
            u.setId_us(id);
            dao.eliminar(id);
            acceso = listarUs;
        } else if (action.equalsIgnoreCase("editbackl")){
            request.setAttribute("idb", request.getParameter("id"));
            acceso = modificarBacklogs;
        } else if (action.equalsIgnoreCase("Redirect ABM de User Stories")){
            acceso = listarUs;
        } else if (action.equalsIgnoreCase("Redirect AM de Backlogs")){
            acceso = listarBacklogs;
        } else if (action.equalsIgnoreCase("Redirect Relacion Proyecto_Backlog")){
            acceso = relacionarBacklogProyecto;
        } else if (action.equalsIgnoreCase("Redirect Relacion Backlog_UserStorie")){
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
        if (action.equalsIgnoreCase("ABM de User Stories") ) {
            acceso = listarUs;
        } else if (action.equalsIgnoreCase("Agregar User Storie")){
            acceso = agregarUs;
        } else if (action.equalsIgnoreCase("Agregar")){
            String descp = request.getParameter("descripcion");
            String estap = request.getParameter("Estatus");
            u.setDescripcion(descp);
            u.setEstatus(estap);
            dao.add(u);
            acceso = exitoAgregarUS;
        } else if (action.equalsIgnoreCase("Actualizar")){
            id = Integer.parseInt(request.getParameter("txtid"));
            String desc = request.getParameter("descripcion");
            String est = request.getParameter("Estatus");
            u.setId_us(id);
            u.setDescripcion(desc);
            u.setEstatus(est);
            dao.edit(u);
            acceso = listarUs;
        } else if (action.equalsIgnoreCase("AM de Backlogs")){
            acceso = listarBacklogs;
        } else if (action.equalsIgnoreCase("Crear Backlog")){
            acceso = crearBacklog;
        } else if (action.equalsIgnoreCase("Crear")){
            String namep = request.getParameter("nameb");
            String descp = request.getParameter("descripcionb");
            b.setNombre(namep);
            b.setComentario(descp);
            dao.addb(b);
            acceso = exitoAgregarBacklog;
        } else if (action.equalsIgnoreCase("Actualizar Backlog")){
            id = Integer.parseInt(request.getParameter("txtid"));
            String desc = request.getParameter("descripcion");
            String nam = request.getParameter("name");
            b.setId_backlog(id);
            b.setComentario(desc);
            b.setNombre(nam);
            dao.editb(b);
            acceso = listarBacklogs;
        } else if (action.equalsIgnoreCase("Asignar Proyecto a Backlog") || action.equalsIgnoreCase("Cancelar") || action.equalsIgnoreCase("Volver atras")){
            acceso = relacionarBacklogProyecto;
        } else if (action.equalsIgnoreCase("Relacionar Proyecto con Backlog")){
            acceso = confirmarRelacionBackProy;
        } else if (action.equalsIgnoreCase("Confirmar relacion")){
            id = Integer.parseInt(request.getParameter("idProyecto"));
            int backlid = Integer.parseInt(request.getParameter("nombreBacklog"));
            pb.setId_project(id);
            pb.setId_backlog(backlid);
            String resultado = dao.addpb(pb);
            if (resultado.equalsIgnoreCase("errorexp")) {
                acceso = paginaError;
            } else {
                acceso = exitoRelacionBacklogProject;
            }
        } else if (action.equalsIgnoreCase("Ver Backlogs/Proyectos")){
            acceso = listarBacklogProyecto;
        } else if (action.equalsIgnoreCase("Agregar US a Backlogs") || action.equalsIgnoreCase("Volver ") ){
            acceso = relacionarBacklogConUserStorie;
        } else if (action.equalsIgnoreCase("Agregar US al Backlog")){
            acceso = confirmarRelacionBacklogUs;
        } else if (action.equalsIgnoreCase("Confirmar accion")){
            id = Integer.parseInt(request.getParameter("idUseStorie"));
            int backlid = Integer.parseInt(request.getParameter("idBackl"));
            ub.setId_Us(id);
            ub.setId_Backl(backlid);
            String resultado = dao.addub(ub);
            if (resultado.equalsIgnoreCase("errorexp")) {
                acceso = paginaError;
            } else {
                acceso = exitoRelacionUsBacklog;
            }

        } else if (action.equalsIgnoreCase("Ver contenido de Backlogs")){
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
