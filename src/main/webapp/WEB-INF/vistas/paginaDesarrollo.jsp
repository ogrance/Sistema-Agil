<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Desarrollo</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_seguridad.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <p>Modulo Desarrollo</p>

        <!-- Title -->
        <h1>Desarrollo</h1>

        <!-- Buttons Start!! -->
        <div class="buttons">
            <form action="DesarrolloController" method="POST" style="margin:0; padding:0">
                <input class="btn orange" type="submit" name="accion" value="AM de Backlogs"/>
                <input class="btn purple" type="submit" name="accion" value="ABM de User Stories"/>
                <input class="btn yellow" type="submit" name="accion" value="AM de Sprints"/>
                <br>
                <input class="btn orange" type="submit" name="accion" value="Agregar US a Sprints"/>
            </form>
        </div>