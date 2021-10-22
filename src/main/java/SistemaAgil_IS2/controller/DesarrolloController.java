package SistemaAgil_IS2.controller;

import SistemaAgil_IS2.dao.DesarrolloDaoImpl;
import SistemaAgil_IS2.model.Backlog;
import SistemaAgil_IS2.model.Sprint;
import SistemaAgil_IS2.model.UserStorie;
import SistemaAgil_IS2.model.Usuario;
import SistemaAgil_IS2.service.DesarrolloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesarrolloController extends HttpServlet {


    UserStorie u = new UserStorie();
    Backlog b = new Backlog();
    Sprint s = new Sprint();
    DesarrolloDaoImpl dao = new DesarrolloDaoImpl();
    int id;
    int usId;
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
    String listarSprints = "WEB-INF/vistas/listarSprints.jsp";
    String agregarSprint = "WEB-INF/vistas/agregarSprint.jsp";
    String exitoAgregarSprint = "WEB-INF/redirectsIgnorar/exitoAgregarSprint.jsp";
    String modificarSprint = "WEB-INF/vistas/modificarSprint.jsp";
    String errorModificarSprint = "WEB-INF/redirectsIgnorar/errorModificarSprint.jsp";
    String seleccionarSprint = "WEB-INF/vistas/seleccionarSprint.jsp";
    String listarUsEnSprintSeleccionado = "WEB-INF/vistas/listarUsEnSprintSeleccionado.jsp";
    String agregarUsAlSprint = "WEB-INF/vistas/agregarUsAlSprint.jsp";
    
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
        } else if (action.equalsIgnoreCase("Redirect AM de Sprints")){
            acceso = listarSprints;
        } else if (action.equalsIgnoreCase("editsprnt")){
            request.setAttribute("idsp", request.getParameter("id"));
            acceso = modificarSprint;
        } else if (action.equalsIgnoreCase("Seleccionar Sprints")){
            acceso = seleccionarSprint;
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
        } else if (action.equalsIgnoreCase("AM de Sprints")){
            acceso = listarSprints;
        } else if (action.equalsIgnoreCase("Crear Sprint")){
            acceso = agregarSprint;
        } else if (action.equalsIgnoreCase("Crear Sprints")){
            String descp = request.getParameter("descripcion");
            String projectid = request.getParameter("ProjectId");
            int project_id = Integer.parseInt(projectid.substring(projectid.indexOf("(") + 4, projectid.indexOf(")")));
            String dur = request.getParameter("duracion");
            s.setName(descp);
            s.setProject_id(project_id);
            s.setDuration(dur);
            s.setEstatus("TO-DO");
            Boolean resultado = dao.adds(s);
            if (resultado) {
                acceso = paginaError;
            } else {
                acceso = exitoAgregarSprint;
            }
        } else if (action.equalsIgnoreCase("Actualizar Sprint")){
            id = Integer.parseInt(request.getParameter("txtid"));
            String nam = request.getParameter("descripcion");
            String ProjId = request.getParameter("ProjectId");
            String dur = request.getParameter("duracion");
            String stat = request.getParameter("estatus");
            int project_id = Integer.parseInt(ProjId.substring(ProjId.indexOf("(") + 4, ProjId.indexOf(")")));
            s.setId_sprint(id);
            s.setName(nam);
            s.setProject_id(project_id);
            s.setDuration(dur);
            s.setEstatus(stat);
            Boolean resultado = dao.edits(s);
            if (resultado) {
                acceso = errorModificarSprint;
            } else {
                acceso = listarSprints;
            }
        } else if (action.equalsIgnoreCase("Agregar US a Sprints")){
            acceso = seleccionarSprint;
        } else if (action.equalsIgnoreCase("Ok")){
            String is_sprint_cadena = request.getParameter("SprintId");
            int sprint_id = Integer.parseInt(is_sprint_cadena.substring(is_sprint_cadena.indexOf("(") + 4, is_sprint_cadena.indexOf(")")));
            request.setAttribute("idsp", sprint_id);
            acceso = listarUsEnSprintSeleccionado;
        } else if (action.equalsIgnoreCase("Agregar US al Sprint")){
            acceso = agregarUsAlSprint;
        } else if(action.equalsIgnoreCase("Agregar al Sprint")){
            id = Integer.parseInt(request.getParameter("id_us"));
            usId = Integer.parseInt(request.getParameter("id_sprint"));
            u.setId_us(id);
            u.setSprint_id(usId);
            Boolean resultado = dao.updateSprintUS(u);
            if (resultado) {
                acceso = errorModificarSprint;//cambiar aqui
            } else {
                request.setAttribute("idsp", usId);
                acceso = listarUsEnSprintSeleccionado;
            }
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>




}
