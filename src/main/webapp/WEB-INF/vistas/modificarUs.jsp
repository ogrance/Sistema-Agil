

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
                    <input id="Estatus" class="input" type="text" name="Estatus" value="<%= u.getEstatus() %> " />
                    <div class="cut"></div>
                    <label for="Estatus" class="placeholder">Status</label>
                </div>
                <input type="hidden" name="txtid" value="<%= u.getId_us() %>"><br>
                
                <input type="submit" name="accion" value="Actualizar"><br>
            </div>
        </form>

    </body>
</html>
