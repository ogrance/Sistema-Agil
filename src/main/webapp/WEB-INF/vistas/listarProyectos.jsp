<%@page import="java.util.Iterator"%>
<%@page import="SistemaAgil_IS2.model.Project"%>
<%@page import="java.util.List"%>
<%@page import="SistemaAgil_IS2.dao.ProjectDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Proyectos</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="ProyectoController?accion=Proyecto">Pag. Proyecto</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <table class="usuarios-tabla">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Estatus</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <%
                ProjectDaoImpl dao = new ProjectDaoImpl();
                List<Project> list = dao.listar();
                        Iterator<Project> iter = list.iterator();
                Project proyecto = null;
                while (iter.hasNext()) {
                    proyecto = iter.next();

            %>
            <tbody>
                <tr>
                    <td><%= proyecto.getId()%></td>
                    <td><%= proyecto.getProjectName()%></td>
                    <td><%= proyecto.getDescription()%></td>
                    <td><%= proyecto.getStatus()%></td>
                    <td><a href="ProyectoController?accion=editproject&id=<%= proyecto.getId()%>" ><input type="button" value="Modificar"/></a></td>
                    <td><a href="ProyectoController?accion=deleteproject&id=<%= proyecto.getId()%>"><input type="button" value="Eliminar" onclick="if (!(confirm('Vas a eliminar este registro. Estas Seguro? ')))
                        return false"/></a></td>
                </tr>
                <%}%>
            </tbody>

        </table>
        <br/>
        <form action="ProyectoController" method="POST" style="margin:0; padding:0">
            <input class="btn" type="submit" name="accion" value="Crear Proyecto"/>
        </form>
    </body>
</html>