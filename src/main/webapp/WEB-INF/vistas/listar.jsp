<%-- 
    Document   : listar
    Created on : Aug 11, 2021, 10:57:41 PM
    Author     : usuario
--%>

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
        <title>ABM de Usuarios</title>
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
            <h3>Lista de Usuarios</h3>
<!--            <form action="UsuarioCrudController">
             <input type="submit" name="accion" value="Listar"> 
            </form>-->
        </div>
        <form action="UsuarioCrudController">
            <input type="submit" name="accion" value="Agregar un nuevo User">
        </form><br>
        <table border="1">
            <thead>
                <tr>
                    <th>id</th>
                    <th>username</th>
                    <th>name</th>
                    <th>lastname</th>
                    <th>pass</th>
                    <th>status</th>
                    <th>ACCIONES</th>
                </tr>
            </thead>
            <%
                UsuarioDaoImpl dao=new UsuarioDaoImpl();
                List<Usuario>list=dao.listar();
                Iterator<Usuario>iter=list.iterator();
                Usuario user=null;
                while(iter.hasNext()){
                user=iter.next();
                
            %>
            <tbody>
                <tr>
                    <td><%= user.getIdUsuario() %></td>
                    <td><%= user.getNombreUsuario() %></td>
                    <td><%= user.getNombre() %></td>
                    <td><%= user.getApellido() %></td>
                    <td><%= user.getPasswrd() %></td>
                    <td><%= user.getStatus() %></td>
                    <td>
                        <form >
                            <a href="UsuarioCrudController?accion=edituser&id=<%= user.getIdUsuario() %>" >Editar</a>
                            <a href="UsuarioCrudController?accion=deleteuser&id=<%= user.getIdUsuario() %>" >Remove</a>
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </center>
    </body>
</html>
