<%@page import="SistemaAgil_IS2.model.Role"%>
<%@page import="SistemaAgil_IS2.dao.RoleDapImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Informacion de Roles</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <body>
        <ul>
            <li><a href="UsuarioCrudController?accion=paginabienvenida">Home</a></li>
            <li><a href="UsuarioCrudController?accion=seguridad">Seguridad</a></li>
            <li><a href="UsuarioCrudController?accion=Listar Roles">Lista de Usuarios</a></li>
            <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
        </ul>
        <div>
            <%
                RoleDapImpl dao=new RoleDapImpl();
                int id=Integer.parseInt((String)request.getAttribute("idrole"));
                Role r=(Role)dao.list(id);
            %>
            <h1>Editar Rol</h1>
            <form action="RoleCrudController">
                Descripcion: <br>
                <input type="text" name="txtuname" value="<%= r.getDescripcion() %>"><br>
                
                <input type="hidden" name="txtid" value="<%= r.getIdRole() %>"><br>
                <input type="submit" name="accion" value="Actualizar"><br>
            </form>
        </div>
    </body>
</html>
