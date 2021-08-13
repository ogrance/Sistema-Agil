<%@page contentType="text/html" pageEncoding="windows-1252"%>
<html>
    <head>
        <title>ABM de Usuarios, Roles y Permisos</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <body>
        <ul>
            <li><a href="UsuarioCrudController?accion=paginabienvenida">Home</a></li>
            <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
        </ul>
        <!-- Title -->
        <h1>Opciones de ABM</h1>

            <form action="UsuarioCrudController">
                <input type="submit" name="accion" value="Listar Users">
             </form>
             <form action="RoleCrudController" method="POST">
                 <input type="submit" name="accion" value="Listar Roles" >
            </form>
        <a>ABM de Permisos</a>
