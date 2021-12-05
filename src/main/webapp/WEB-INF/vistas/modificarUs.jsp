

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page import="SistemaAgil_IS2.model.UserStorie"%>
<%@page import="SistemaAgil_IS2.dao.DesarrolloDaoImpl"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Editar User Storie</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
    </head>
    <body>
        <form action="DesarrolloController" method="POST">
            <div class="form">
                 <%
                DesarrolloDaoImpl dao=new DesarrolloDaoImpl();
                int id=Integer.parseInt((String)request.getAttribute("ids"));
                UserStorie u=(UserStorie)dao.list(id);
            %>
                <div class="title">Modificar User Storie</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic2">
                    <input id="descripcion" class="input" type="text" name="descripcion" value="<%= u.getDescripcion() %> " />
                    <div class="cut"></div>
                    <label for="descripcion" class="placeholder">Descripcion</label>
                </div>

                <div class="input-container ic2">
                    
                        <input list="Project_list" id="ProjectId" class="input" type="text"  name="ProjectId" value="(id:<%= u.getProject_id() %>)"/>
                        <label for="ProjectId" class="placeholder">Proyecto</label>
                        
                        <datalist id="Project_list">
                            <%
                                try {
                                    Class.forName("com.mysql.cj.jdbc.Driver");

                                    Connection con = DriverManager.getConnection("jdbc:mysql://node6239-env-6654381.dal.togglebox.site:3306/db_ingsofdos", "root", "7neVkPepTt");

                                    Statement st = con.createStatement();
                                    String sql = "select nombre, id_backlog from backlogs";
                                    ResultSet rs = st.executeQuery(sql);
                                    while (rs.next()) {
                            %>
                            <option><%=rs.getString("nombre")%>(id:<%=rs.getInt("id_backlog")%>)</option>
                            <%
                                    }
                                } catch (Exception e) {
                                }

                            %>
                        </datalist>
                </div> 
                    
                <input type="hidden" name="txtid" value="<%= u.getId_us() %>"><br>
                
                <input type="submit" name="accion" value="Actualizar"><br>
            </div>
        </form>

    </body>
</html>
