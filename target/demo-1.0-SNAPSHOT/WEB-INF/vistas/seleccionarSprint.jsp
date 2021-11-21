<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <form action="DesarrolloController" method="POST">
            <b>Seleccionar Sprint</b><br><br>
            <div class="input-container ic2">

                <input list="Sprint_list" id="SprintId" class="input" type="text"  name="SprintId" />
                <label for="SprintId" class="placeholder"></label>

                <datalist id="Sprint_list">
                    <%
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://node6137-env-0497118.dal.togglebox.site:3306/db_ingsofdos?serverTimezone=UTC", "root", "F1KWWzhBZC");
                            Statement st = con.createStatement();
                            String sql = "select name, id_sprint from sprints where estatus = 'TO-DO'";
                            ResultSet rs = st.executeQuery(sql);
                            while (rs.next()) {
                    %>
                    <option><%=rs.getString("name")%>(id:<%=rs.getInt("id_sprint")%>)</option>
                    <%
                            }
                        } catch (Exception e) {
                        }

                    %>
                </datalist>
                <input type="submit" name="accion" value="Ok"><br>
            </div>
        </form>
    </body>
</html>