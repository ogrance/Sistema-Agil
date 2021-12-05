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
    <title>Agregar Rol</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
</head>
<body>
<form:form action="inserta-rol" modelAttribute="roles" method="post">
<div class="form">
    <div class="title">Crear Rol</div>
    <div class="subtitle">Digite los datos solicitados</div>
    <div class="input-container ic1">
        <form:hidden path="idRole"/>
        <form:input path="descripcion" id="firstname" class="input" type="text" placeholder=" " />
        <div class="cut"></div>
        <form:label path="descripcion" for="firstname" class="placeholder">Nombre del Rol</form:label>
    </div>

    <button type="text" class="submit">Crear</button>
</div>
</form:form>
</body>

</html>
