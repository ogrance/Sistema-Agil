<%--
  Created by IntelliJ IDEA.
  User: osmargrance
  Date: 11/8/21
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Seguridad</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_seguridad.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="http://localhost:8080/demo/ProyectoController?accion=home">Home</a></li>
        <li style="float:right"><a class="active" href="http://localhost:8080/demo/login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <p>Modulo ${modulo}</p>

        <!-- Title -->
        <h1>${modulo}</h1>

        <!-- Buttons Start!! -->
        <div class="buttons">
            <a class="btn purple" href="usuarios">Usuarios</a>
            <a class="btn orange" href="roles">Roles</a>
            <a class="btn yellow" href="permisos">Permisos</a>
        </div>


    </body>
</html>
