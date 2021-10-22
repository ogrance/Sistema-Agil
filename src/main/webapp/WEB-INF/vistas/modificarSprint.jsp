

<%@page import="SistemaAgil_IS2.model.Sprint"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="SistemaAgil_IS2.dao.DesarrolloDaoImpl"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Editar Sprint</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
    </head>
    <body>
        <form action="DesarrolloController" method="POST">
            <div class="form">
                 <%
                DesarrolloDaoImpl dao=new DesarrolloDaoImpl();
                int id=Integer.parseInt((String)request.getAttribute("idsp"));
                Sprint s=(Sprint)dao.lists(id);
            %>
                <div class="title">Modificar Sprint</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic2">
                    <input id="descripcion" class="input" type="text" name="descripcion" value="<%= s.getName()%> " />
                    <div class="cut"></div>
                    <label for="descripcion" class="placeholder">Descripcion</label>
                </div>
                    
                <div class="input-container ic2">
                    <input id="duracion" class="input" type="text" name="duracion" value="<%= s.getDuration()%> " />
                    <div class="cut"></div>
                    <label for="duracion" class="placeholder">Duracion</label>
                </div>
                    
                <div class="input-container ic2">
                    <input id="estatus" class="input" type="text" name="estatus" value="<%= s.getEstatus()%> " />
                    <div class="cut"></div>
                    <label for="estatus" class="placeholder">Estatus</label>
                </div> 

                <div class="input-container ic2">
                    
                        <input list="Project_list" id="ProjectId" class="input" type="text"  name="ProjectId" value="(id:<%= s.getProject_id() %>)"/>
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
                    
                <input type="hidden" name="txtid" value="<%= s.getId_sprint()%>"><br>
                
                <input type="submit" name="accion" value="Actualizar Sprint"><br>
            </div>
        </form>

    </body>
</html>
