

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="SistemaAgil_IS2_war.dao.DesarrolloDaoImpl"%>
<%@page import="SistemaAgil_IS2_war.model.Backlog"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Editar Backlog</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
    </head>
    <body>
        <form action="DesarrolloController" method="POST">
            <div class="form">
                <%
                    DesarrolloDaoImpl dao = new DesarrolloDaoImpl();
                    int id = Integer.parseInt((String) request.getAttribute("idb"));
                    Backlog b = (Backlog) dao.listb(id);
                %>
                <div class="title">Editar Backlog</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic1">
                    <input class="input" type="text" name="name" value=" <%= b.getNombre()%> " />
                    <div class="cut"></div>
                    <label class="placeholder">Nombre</label>
                </div>

                <div class="input-container ic2">

                    <input list="Project_list" id="ice-cream-choice" class="input" type="text"  name="ProjectId" placeholder=" " value="(id:<%= b.getProject_id() %>)"/>
                    <label for="ProjectId" class="placeholder">Proyecto</label>

                    <datalist id="Project_list">
                        <%
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");

                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ingsofdos", "root", "");

                                Statement st = con.createStatement();
                                String sql = "select project_name, id from projects where id not in (select project_id from backlogs)";
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

                <br><br>

                <input type="hidden" name="txtid" value="<%= b.getId_backlog()%>"><br>

                <input type="submit" name="accion" value="Actualizar Backlog"><br>
            </div>
        </form>

    </body>
</html>
