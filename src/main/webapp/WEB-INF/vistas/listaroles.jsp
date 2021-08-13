
<%@page import="SistemaAgil_IS2.model.Role"%>
<%@page import="SistemaAgil_IS2.dao.RoleDapImpl"%>
<%@page import="java.util.Iterator"%>
<%@page import="SistemaAgil_IS2.model.Usuario"%>
<%@page import="SistemaAgil_IS2.dao.UsuarioDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="SistemaAgil_IS2.dao.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABM de Roles</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>

    <body>
        <ul>
            <li><a href="UsuarioCrudController?accion=paginabienvenida">Home</a></li>
            <li><a href="UsuarioCrudController?accion=seguridad">Seguridad</a></li>
            <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
        </ul>
    <center>
        <div>
            <h3>Lista de Roles</h3>
        </div>
        <a href="RoleCrudController?accion=addrole">Agregar un nuevo Rol</a>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Descripcion</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <%
                RoleDapImpl dao=new RoleDapImpl();
                List<Role>list=dao.listar();
                Iterator<Role>iter=list.iterator();
                Role rol=null;
                while(iter.hasNext()){
                rol=iter.next();
                
            %>
            <tbody>
                <tr>
                    <td><%= rol.getIdRole() %></td>
                    <td><%= rol.getDescripcion() %></td>
                    <td>
                        <form >
                            <a href="RoleCrudController?accion=editrole&id=<%= rol.getIdRole() %>" >Editar</a>
                            <a href="RoleCrudController?accion=deleterole&id=<%= rol.getIdRole() %>" >Remove</a>
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </center>
    </body>
</html>
