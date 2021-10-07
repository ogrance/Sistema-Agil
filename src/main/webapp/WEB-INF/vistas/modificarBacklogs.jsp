

<%@page import="SistemaAgil_IS2.dao.DesarrolloDaoImpl"%>
<%@page import="SistemaAgil_IS2.model.Backlog"%>
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
                DesarrolloDaoImpl dao=new DesarrolloDaoImpl();
                int id=Integer.parseInt((String)request.getAttribute("idb"));
                Backlog b=(Backlog)dao.listb(id);
            %>
                <div class="title">Editar Backlog</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic1">
                    <input class="input" type="text" name="name" value=" <%= b.getNombre() %> " />
                    <div class="cut"></div>
                    <label class="placeholder">Nombre</label>
                </div>

                <div class="input-container ic2">
                    <input id="descripcion" class="input" type="text" name="descripcion" value="<%= b.getComentario() %> " />
                    <div class="cut"></div>
                    <label for="descripcion" class="placeholder">Comentario</label>
                </div>
                    
                <input type="hidden" name="txtid" value="<%= b.getId_backlog() %>"><br>
                
                <input type="submit" name="accion" value="Actualizar Backlog"><br>
            </div>
        </form>

    </body>
</html>
