<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
        <title>Kanban</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
        <style>
            * {
                box-sizing: border-box;
            }

            .row {
                display: flex;
                margin-left:-5px;
                margin-right:-5px;
            }

            .column {
                flex: 50%;
                padding: 5px;
            }

            table {
                border-collapse: collapse;
                border-spacing: 0;
                width: 100%;
                border: 1px solid #ddd;
            }

            th, td {
                text-align: left;
                padding: 16px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="DesarrolloController?accion=Desarrollo">Pag. Desarrollo</a></li>
        <li><a href="DesarrolloController?accion=Gestion de Sprints">Gestion de Sprints</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <div class="row">
            <div class="column">
                <h1>TO-DO</h1>
                <table class="usuarios-tabla">
                    <thead>
                        <tr>
                            <th>Descripcion</th>
                            <th>Cambiar Estado</th>
                        </tr>
                    </thead>
                    <%
                        int id = Integer.parseInt((String) request.getAttribute("idsp"));
                        DesarrolloDaoImpl dao = new DesarrolloDaoImpl();
                        List<UserStorie> list = dao.listarToDo(id);
                        Iterator<UserStorie> iter = list.iterator();
                        UserStorie ustorie = null;
                        while (iter.hasNext()) {
                            ustorie = iter.next();

                    %>
                    <tbody>
                        <tr>
                            <td><%= ustorie.getDescripcion()%></td>
                            <td>
                                <form action="DesarrolloController" method="POST" style="margin:0; padding:0">
                                    <input type="hidden" name="txtid" value="<%= ustorie.getId_us()%>">
                                    <input type="hidden" name="txtids" value="<%= ustorie.getSprint_id()%>">
                                    <input type="submit" name="accion" value=">">
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>

                </table>
            </div>
            <div class="column">
                <h1>DOING</h1>

                <table class="usuarios-tabla">
                    <thead>
                        <tr>
                            <th>Descripcion</th>
                            <th>Cambiar Estado</th>
                        </tr>
                    </thead>
                    <%
                        DesarrolloDaoImpl daoDoing = new DesarrolloDaoImpl();
                        List<UserStorie> listDoing = daoDoing.listarDoing(id);
                        Iterator<UserStorie> iterDoing = listDoing.iterator();
                        UserStorie ustorieDoing = null;
                        while (iterDoing.hasNext()) {
                            ustorieDoing = iterDoing.next();

                    %>
                    <tbody>
                        <tr>
                            <td><%= ustorieDoing.getDescripcion()%></td>
                            <td>
                                <form action="DesarrolloController" method="POST" style="margin:0; padding:0">
                                    <input type="hidden" name="txtid" value="<%= ustorieDoing.getId_us()%>">
                                    <input type="hidden" name="txtids" value="<%= ustorieDoing.getSprint_id()%>">
                                    <input type="submit" name="accion" value="<">
                                    <input type="submit" name="accion" value=">>">
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>

                </table>
            </div>
            <div class="column">
                <h1>DONE</h1>
                <table class="usuarios-tabla">
                    <thead>
                        <tr>
                            <th>Descripcion</th>
                            <th>Cambiar Estado</th>
                        </tr>
                    </thead>
                    <%
                        DesarrolloDaoImpl daoDone = new DesarrolloDaoImpl();
                        List<UserStorie> listDone = daoDone.listarDone(id);
                        Iterator<UserStorie> iterDone = listDone.iterator();
                        UserStorie ustorieDone = null;
                        while (iterDone.hasNext()) {
                            ustorieDone = iterDone.next();

                    %>
                    <tbody>
                        <tr>
                            <td><%= ustorieDone.getDescripcion()%></td>
                            <td>
                                <form action="DesarrolloController" method="POST" style="margin:0; padding:0">
                                    <input type="hidden" name="txtid" value="<%= ustorieDone.getId_us()%>">
                                    <input type="hidden" name="txtids" value="<%= ustorieDone.getSprint_id()%>">
                                    <input type="submit" name="accion" value="<<">
                                </form>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
        <form action="DesarrolloController" method="POST">
            <input type="hidden" name="txtids" value="<%= id %>">
            <input type="submit" name="accion" value="Finalizar Sprint" onclick="if (!(confirm('El Sprint se dara por finalizado. Esta accion es irreversible. Deseas continuar? ')))
                        return false"/><br>
        </form>
    </body>
</html>