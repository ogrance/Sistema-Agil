<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Users a Proyectos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="ProyectoController?accion=Proyecto">Pag. Proyecto</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
    <center>
        <form action="ProyectoController" method="POST">
            <b>Seleccionar Proyecto</b><br>
            <select name="proyectos" class="custom-select custom-select-lg mb-3" style="width:200px;">
                <%
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ingsofdos", "root", "454234798");
=======
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ingsofdos?serverTimezone=UTC", "root", "");
>>>>>>> af6bf83b5dfb331cfe706c16ab1584f001096163
                        Statement st = con.createStatement();
                        String sql = "select * from projects where estatus<>'FIN'";
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

            <br><br><br><b>Seleccionar User</b><br>
            <select name="usuarios" class="custom-select custom-select-lg mb-3" style="width:200px;">
                <%                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
<<<<<<< HEAD
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ingsofdos", "root", "454234798");
=======
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ingsofdos?serverTimezone=UTC", "root", "");
>>>>>>> af6bf83b5dfb331cfe706c16ab1584f001096163
                        Statement st = con.createStatement();
                        String sql = "select * from usuario";
                        ResultSet rs = st.executeQuery(sql);
                        while (rs.next()) {
                %>
                <option><%= rs.getString("nombreUsuario")%>(id:<%=rs.getInt("idUsuario")%>)</option>
                <%
                        }
                    } catch (Exception e) {
                    }

                %>
            </select>
            <br><br><br>
            <input type="submit" name="accion" value="Agregar User al Proyecto"><br><br>
            <input type="submit" name="accion" value="Ver Project Members">
        </form>
    </center>
</body>
</html>
