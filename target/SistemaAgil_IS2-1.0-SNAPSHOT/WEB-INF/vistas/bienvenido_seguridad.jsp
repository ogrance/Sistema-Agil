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
            <form action="ProyectoController" method="POST" style="margin:0; padding:0">

                <a class="btn seguridad" href="seguridad/inicio_seguridad">Seguridad</a>


            </form>



           
        </div>


    </body>
</html>
