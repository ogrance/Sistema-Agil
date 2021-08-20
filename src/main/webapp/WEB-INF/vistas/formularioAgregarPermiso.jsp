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
    <title>Agregar Permiso</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
</head>
<body>
<form:form action="inserta-permiso" modelAttribute="permisos" method="post">
<div class="form">
    <div class="title">Crear Permiso</div>
    <div class="subtitle">Digite los datos solicitados</div>
    <div class="input-container ic1">
        <form:hidden path="idPermiso"/>
        <form:input path="nombrePermiso" id="firstname" class="input" type="text" maxlength="15" placeholder=" " />
        <div class="cut"></div>
        <form:label path="nombrePermiso" for="firstname" class="placeholder">Nombre del Permiso</form:label>
    </div>
    <div class="input-container ic2">
        <form:input path="alcance" id="lastname" class="input" type="text"  placeholder=" " />
        <div class="cut"></div>
        <form:label path="alcance" for="lastname" class="placeholder">Alcance</form:label>
    </div>

    <button type="text" class="submit">Crear</button>
</div>
</form:form>
<p>${ErrorInsertaPermiso}</p>
</body>

</html>
