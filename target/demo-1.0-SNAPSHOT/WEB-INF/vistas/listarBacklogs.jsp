<%@page import="SistemaAgil_IS2_war.model.Backlog"%>
<%@page import="SistemaAgil_IS2_war.dao.DesarrolloDaoImpl"%>
<%@page import="java.util.Iterator"%>
<%@page import="SistemaAgil_IS2_war.model.Project"%>
<%@page import="java.util.List"%>
<%@page import="SistemaAgil_IS2_war.dao.ProjectDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Backlogs</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="DesarrolloController?accion=Desarrollo">Pag. Desarrollo</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <table class="usuarios-tabla">
            <thead>
                <tr>
                    <th>Backlog Id</th>
                    <th>Project Id</th>
                    <th>Nombre</th>
                    <th>Modificar</th>
                </tr>
            </thead>
            <%
                DesarrolloDaoImpl dao = new DesarrolloDaoImpl();
                List<Backlog> list = dao.listarb();
                Iterator<Backlog> iter = list.iterator();
                Backlog backl = null;
                while (iter.hasNext()) {
                    backl = iter.next();

            %>
            <tbody>
                <tr>
                    <td><%= backl.getId_backlog() %></td>
                    <td><%= backl.getProject_id()%></td>
                    <td><%= backl.getNombre()%></td>
                    <td><a href="DesarrolloController?accion=editbackl&id=<%= backl.getId_backlog()%>" ><input type="button" value="Modificar"/></a></td>
                </tr>
                <%}%>
            </tbody>

        </table>
        <br/>
        <form action="DesarrolloController" method="POST" style="margin:0; padding:0">
            <input class="btn" type="submit" name="accion" value="Crear Backlog"/>
        </form>
    </body>
</html>