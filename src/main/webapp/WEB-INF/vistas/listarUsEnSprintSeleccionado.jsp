<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="SistemaAgil_IS2.model.UserStorie"%>
<%@page import="SistemaAgil_IS2.model.Sprint"%>
<%@page import="SistemaAgil_IS2.model.Backlog"%>
<%@page import="SistemaAgil_IS2.dao.DesarrolloDaoImpl"%>
<%@page import="java.util.Iterator"%>
<%@page import="SistemaAgil_IS2.model.Project"%>
<%@page import="java.util.List"%>
<%@page import="SistemaAgil_IS2.dao.ProjectDaoImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Sprints</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="DesarrolloController?accion=Desarrollo">Pag. Desarrollo</a></li>
        <li><a href="DesarrolloController?accion=Seleccionar Sprints">Seleccionar Sprint</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <form action="DesarrolloController" method="POST">
        <table class="usuarios-tabla">
            <thead>
                <tr>
                    <th>Storie Id</th>
                    <th>Project Id</th>
                    <th>Backlog Id</th>
                    <th>Descripcion</th>
                    <th>Estatus</th>
                </tr>
            </thead>
            <%
                int sprint_id = (Integer)request.getAttribute("idsp");
            %>
            <h2>Sprint # <%= sprint_id%> </h2>
            <%
                DesarrolloDaoImpl dao = new DesarrolloDaoImpl();
                List<UserStorie> list = dao.listarsus(sprint_id);
                Iterator<UserStorie> iter = list.iterator();
                UserStorie ust = null;
                while (iter.hasNext()) {
                    ust = iter.next();

            %>
            <tbody>
                <tr>
                    <td><%= ust.getId_us()%></td>
                    <td><%= ust.getProject_id()%></td>
                    <td><%= ust.getBacklog_id()%></td>
                    <td><%= ust.getDescripcion()%></td>
                    <td><%= ust.getEstatus()%></td>
                </tr>
                <%}%>
            </tbody>

        </table>
        <br/>
        <h3>Agregar un nuevo User Storie de los disponibles en el backlog del proyecto</h3>
        <br>
            <select name="historias" class="custom-select custom-select-lg mb-3" style="width:200px;">
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ingsofdos?serverTimezone=UTC", "root", "");
                        Statement st = con.createStatement();
                        String sql = "select * from user_stories where estatus='TO-DO' and sprint_id is NULL and project_id=(select project_id from sprints where id_sprint="+ sprint_id + ")";
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                %>
                <option><%=rs.getString("descripcion")%>(id:<%=rs.getInt("id_us")%>)</option>
                <%
                        }
                    } catch (Exception e) {
                    }

                %>
            </select>
       <br><br>
       <input type="hidden" name="sprint_id" value="<%=sprint_id%>" />
        
            <input type="submit" name="accion" value="Agregar US al Sprint"/>
        </form>
    </body>
</html>