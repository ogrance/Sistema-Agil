<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Pagina Bienvenida</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_seguridad.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <p>Modulo Proyecto</p>

        <!-- Title -->
        <h1>Proyecto</h1>

        <!-- Buttons Start!! -->
        <div class="buttons">
            <form action="ProyectoController" method="POST" style="margin:0; padding:0">
                <input class="btn purple" type="submit" name="accion" value="ABM de Proyectos"/>
                <input class="btn orange" type="submit" name="accion" value="Agregar Usuarios a Proyecto"/>
            </form>
        </div>