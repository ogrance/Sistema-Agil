<%--
  Created by IntelliJ IDEA.
  User: juaos
  Date: 01/08/2021
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pagina Bienvenida</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo.css">
</head>
<body>
<p>Bienvenido ${laBienvenida}</p>

<!-- Title -->
<h1>Comencemos</h1>

<!-- Buttons Start!! -->
<div class="buttons">
    <a class="btn seguridad">Seguridad</a>
    <a class="btn proyecto">Proyecto</a>
    <a class="btn desarrollo">Desarrollo</a>
    <!--<a class="btn purple">Salir</a>
    <a class="btn orange">Proyectos</a>
    <a class="btn yellow">Backlog</a>-->
</div>


</body>
</html>
