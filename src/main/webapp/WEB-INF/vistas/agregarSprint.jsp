

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Crear Sprints</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
    </head>
    <body>
        <form action="DesarrolloController" method="POST">
            <div class="form">
                <div class="title">Crear Sprints</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic2">
                    <input id="descripcion" class="input" type="text" name="descripcion" placeholder=" " />
                    <div class="cut"></div>
                    <label for="descripcion" class="placeholder">Nombre</label>
                </div>
                
                <div class="input-container ic2">
                    <input id="duracion" class="input" type="text" name="duracion" placeholder=" " />
                    <div class="cut"></div>
                    <label for="duracion" class="placeholder">Duracion</label>
                </div>

                 <div class="input-container ic2">
                    
                        <input list="Project_list" id="ProjectId" class="input" type="text"  name="ProjectId" placeholder=" " />
                        <label for="ProjectId" class="placeholder">Proyecto</label>
                        
                        <datalist id="Project_list">
                            <%
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ingsofdos?serverTimezone=UTC", "root", "root");
                                    Statement st = con.createStatement();
                                    String sql = "select project_name, id from projects";
                                    ResultSet rs = st.executeQuery(sql);
                                    while (rs.next()) {
                            %>
                            <option><%=rs.getString("project_name")%>(id:<%=rs.getInt("id")%>)</option>
                            <%
                                    }
                                } catch (Exception e) {
                                }

                            %>
                        </datalist>
                </div>
                
                <br>
                <input type="submit" name="accion" value="Crear Sprints" onclick="if (!(confirm('Vas a agregar este registro. Estas Seguro? '))) return false"/><br>
            </div>
        </form>

    </body>
</html>
