<%-- 
    Document   : adduser
    Created on : Aug 12, 2021, 3:48:34 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar USer</title>
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
            <h1>Agregar User</h1>
            <form action="UsuarioCrudController">
                Username: <br>
                <input type="text" name="txtuname"><br>
                Nombre: <br>
                <input type="text" name="txtname"><br>
                Apellido: <br>
                <input type="text" name="txtlname"><br>
                Pass: <br>
                <input type="text" name="txtpass"><br>
                <input type="submit" name="accion" value="Agregar"><br>
            </form>
        </div>
    </body>
</html>
