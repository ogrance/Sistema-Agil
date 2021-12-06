<%@page import="SistemaAgil_IS2.dao.DesarrolloDaoImpl"%>
<%@page import="SistemaAgil_IS2.model.UserStorie"%>
<%@page import="java.util.Iterator"%>
<%@page import="SistemaAgil_IS2.model.Project"%>
<%@page import="java.util.List"%>
<%@page import="SistemaAgil_IS2.dao.ProjectDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User Stories</title>
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
                    <th>User Storie Id</th>
                    <th>Project Id</th>
                    <th>Backlog Id</th>
                    <th>Descripcion</th>
                    <th>Estado</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <%
                DesarrolloDaoImpl dao = new DesarrolloDaoImpl();
                List<UserStorie> list = dao.listar();
                Iterator<UserStorie> iter = list.iterator();
                UserStorie ustorie = null;
                while (iter.hasNext()) {
                    ustorie = iter.next();

            %>
            <tbody>
                <tr>
                    <td><%= ustorie.getId_us()%></td>
                    <td><%= ustorie.getProject_id()%></td>
                    <td><%= ustorie.getBacklog_id()%></td>
                    <td><%= ustorie.getDescripcion()%></td>
                    <td> <%= ustorie.getEstatus()%> </td>
                    <td><a href="DesarrolloController?accion=editust&id=<%= ustorie.getId_us()%>" ><input type="button" value="Modificar"/></a></td>
                    <td><a href="DesarrolloController?accion=deleteust&id=<%= ustorie.getId_us()%>"><input type="button" value="Eliminar" onclick="if (!(confirm('Vas a eliminar este registro. Estas Seguro? ')))
                                return false"/></a></td>
                </tr>
                <%}%>
            </tbody>

        </table>
        <br/>
        <form action="DesarrolloController" method="POST" style="margin:0; padding:0">
            <input class="btn" type="submit" name="accion" value="Agregar User Storie"/>
        </form>
    </body>
</html>