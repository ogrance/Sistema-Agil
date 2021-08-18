<%--
  Created by IntelliJ IDEA.
  User: osmargrance
  Date: 11/8/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Agregar Usuario</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
</head>
<body>
<form:form action="inserta_usuario" modelAttribute="usuario" method="post">
<div class="form">
    <div class="title">Crear Usuario</div>
    <div class="subtitle">Vamos a crear al usuario!</div>
    <div class="input-container ic1">
        <form:hidden path="idUsuario"/>
        <form:input path="nombre" id="firstname" class="input" type="text" placeholder=" " />
        <div class="cut"></div>
        <form:label path="nombre" for="firstname" class="placeholder">Nombre</form:label>
    </div>
    <div class="input-container ic2">
        <form:input path="apellido" id="lastname" class="input" type="text" placeholder=" " />
        <div class="cut"></div>
        <form:label path="apellido" for="lastname" class="placeholder">Apellido</form:label>
    </div>
    <div class="input-container ic2">
        <form:input path="nombreUsuario" id="nombreUsuario" class="input" type="text" placeholder=" " />
        <div class="cut cut-short"></div>
        <form:label path="nombreUsuario" for="nombreUsuario"  class="placeholder">Nombre de Usuario</form:label>
    </div>
    <div class="input-container ic2">
        <form:input path="passwrd" id="passwrd" class="input" type="password" placeholder=" " />
        <div class="cut cut-short"></div>
            <form:label path="passwrd" for="passwrd"  class="placeholder">Password</form:label>
    </div>
    <button type="text" class="submit">Crear</button>
</div>
</form:form>
</body>

</html>
