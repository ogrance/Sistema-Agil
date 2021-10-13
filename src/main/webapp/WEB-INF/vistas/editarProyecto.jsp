

<%@page import="SistemaAgil_IS2.model.Project"%>
<%@page import="SistemaAgil_IS2.dao.ProjectDaoImpl"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Editar Proyecto</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
    </head>
    <body>
        <form action="ProyectoController" method="POST">
            <div class="form">
                 <%
                ProjectDaoImpl dao=new ProjectDaoImpl();
                int id=Integer.parseInt((String)request.getAttribute("idp"));
                Project p=(Project)dao.list(id);
            %>
                <div class="title">Crear Proyecto</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic1">
                    <input class="input" type="text" name="projectname" value=" <%= p.getProjectName() %> " />
                    <div class="cut"></div>
                    <label class="placeholder">Nombre del Proyecto</label>
                </div>

                <div class="input-container ic2">
                    <input id="descripcion" class="input" type="text" name="descripcion" value="<%= p.getDescription() %> " />
                    <div class="cut"></div>
                    <label for="descripcion" class="placeholder">Descripcion</label>
                </div>

                <div class="input-container ic2">
                    <input id="Estatus" class="input" type="text" name="Estatus" value="<%= p.getStatus() %> " />
                    <div class="cut"></div>
                    <label for="Estatus" class="placeholder">Status</label>
                </div>
                <input type="hidden" name="txtid" value="<%= p.getId() %>"><br>
                
                <input type="submit" name="accion" value="Actualizar"><br>
            </div>
        </form>

    </body>
</html>
