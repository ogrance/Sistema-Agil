<%-- 
    Document   : edituser
    Created on : Aug 12, 2021, 10:39:47 PM
    Author     : usuario
--%>

<%@page import="SistemaAgil_IS2.model.Usuario"%>
<%@page import="SistemaAgil_IS2.dao.UsuarioDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Informacion de Usuario</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <body>
        <ul>
            <li><a href="UsuarioCrudController?accion=paginabienvenida">Home</a></li>
            <li><a href="UsuarioCrudController?accion=seguridad">Seguridad</a></li>
            <li><a href="UsuarioCrudController?accion=Listar Users">Lista de Usuarios</a></li>
            <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
        </ul>
        <div>
            <%
                UsuarioDaoImpl dao=new UsuarioDaoImpl();
                int id=Integer.parseInt((String)request.getAttribute("iduser"));
                Usuario u=(Usuario)dao.list(id);
            %>
            <h1>Editar User</h1>
            <form action="UsuarioCrudController">
                Username: <br>
                <input type="text" name="txtuname" value="<%= u.getNombreUsuario() %>"><br>
                Nombre: <br>
                <input type="text" name="txtname" value="<%= u.getNombre() %>"><br>
                Apellido: <br>
                <input type="text" name="txtlname" value="<%= u.getApellido() %>"><br>
                Pass: <br>
                <input type="text" name="txtpass" value="<%= u.getPasswrd() %>"><br>
                Status: <br>
                <input type="text" name="txtstatus" value="<%= u.getStatus() %>"><br>
                
                <input type="hidden" name="txtid" value="<%= u.getIdUsuario() %>"><br>
                <input type="submit" name="accion" value="Actualizar"><br>
            </form>
        </div>
    </body>
</html>
