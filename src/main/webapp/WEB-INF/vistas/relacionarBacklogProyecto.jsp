<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relacion Proyecto/Backlog</title>
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
            <b>Seleccionar Proyecto</b><br>
            <select name="proyectos" class="custom-select custom-select-lg mb-3" style="width:200px;">
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://node6140-env-9249604.dal.togglebox.site:3306/db_ingsofdos?serverTimezone=UTC", "root", "ZuvyKpdpGa");
                        Statement st = con.createStatement();
                        String sql = "select id, project_name from projects where estatus <> 'FIN' AND id NOT IN (SELECT project_id FROM project_backlogs);";
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                %>
                <option><%=rs.getString("project_name")%>(id:<%=rs.getInt("id")%>)</option>
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
                        Connection con = DriverManager.getConnection("jdbc:mysql://node6140-env-9249604.dal.togglebox.site:3306/db_ingsofdos?serverTimezone=UTC", "root", "ZuvyKpdpGa");
                        Statement st = con.createStatement();
                        String sql = "select nombre, id_backlog from backlogs where id_backlog NOT IN (Select backlog_id from project_backlogs);";
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
            <input type="submit" name="accion" value="Relacionar Proyecto con Backlog"><br><br>
            <input type="submit" name="accion" value="Ver Backlogs/Proyectos">
        </form>
    </center>
</body>
</html>
