<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar US a Backlog</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="ProyectoController?accion=Desarrollo">Pag. Desarrollo</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
    <center>
        <form action="DesarrolloController" method="POST">
            <b>Seleccionar User Storie</b><br>
            <select name="proyectos" class="custom-select custom-select-lg mb-3" style="width:200px;">
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://node6239-env-6654381.dal.togglebox.site:3306/db_ingsofdos", "root", "7neVkPepTt");

                        Statement st = con.createStatement();
                        String sql = "select id_us, descripcion from user_stories where id_us NOT IN (SELECT US_id from us_backlog)";
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

            <br><br><br><b>Seleccionar Backlog</b><br>
            <select name="usuarios" class="custom-select custom-select-lg mb-3" style="width:200px;">
                <%                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        Connection con = DriverManager.getConnection("jdbc:mysql://node6239-env-6654381.dal.togglebox.site:3306/db_ingsofdos", "root", "7neVkPepTt");

                        Statement st = con.createStatement();
                        String sql = "select nombre, id_backlog from backlogs where id_backlog in (select backlog_id from project_backlogs)";
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                %>
                <option><%= rs.getString("nombre")%>(id:<%=rs.getInt("id_backlog")%>)</option>
                <%
                        }
                    } catch (Exception e) {
                    }

                %>
            </select>
            <br><br><br>
            <input type="submit" name="accion" value="Agregar US al Backlog"><br><br>
            <input type="submit" name="accion" value="Ver contenido de Backlogs">
        </form>
    </center>
</body>
</html>
