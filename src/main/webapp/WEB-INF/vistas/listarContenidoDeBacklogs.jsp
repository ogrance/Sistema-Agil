<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        <li><a href="ProyectoController?accion=Desarrollo">Pag. Desarrollo</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <table class="usuarios-tabla">
            <thead>
                <tr>
                    <th>Backlog</th>
                    <th>User Storie</th>
                </tr>
            </thead>
            <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://node6137-env-0497118.dal.togglebox.site:3306/db_ingsofdos?serverTimezone=UTC", "root", "F1KWWzhBZC");
                        Statement st = con.createStatement();
                        String sql = "select u.nombre, p.descripcion from backlogs u join us_backlog pm on u.id_backlog = pm.backlog_id join user_stories p on p.id_us=pm.US_id order by 1,2";
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
            %>
            <tbody>
                <tr>
                    <td><%= rs.getString("nombre") %></td>
                    <td><%= rs.getString("descripcion")%></td>
                </tr>
                <%}
                 } catch (Exception e) {
                    }
                %>
            </tbody>

        </table>
        <br/>
        <form action="DesarrolloController" method="POST" style="margin:0; padding:0">
            <input class="btn" type="submit" name="accion" value="Volver "/>
        </form>
    </body>
</html>
