<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Pagina Bienvenida</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <body>
        <ul>
            <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
        </ul>
        <p>Bienvenido ${laBienvenida}</p>

        <!-- Title -->
        <h1>Comencemos</h1>

        <!-- Buttons Start!! -->
        <div class="buttons">
            <a href="UsuarioCrudController?accion=seguridad" class="btn seguridad">Seguridad</a>
            <a class="btn proyecto">Proyecto</a>
            <a class="btn desarrollo">Desarrollo</a>
            <!--<a class="btn purple">Salir</a>
            <a class="btn orange">Proyectos</a>
            <a class="btn yellow">Backlog</a>-->
        </div>


    </body>
</html>
