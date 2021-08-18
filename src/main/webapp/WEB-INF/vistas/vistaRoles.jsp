<%--
  Created by IntelliJ IDEA.
  User: juaos
  Date: 17/08/2021
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resumen Roles</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
</head>

<body>
<table class="usuarios-tabla">
    <thead>
    <tr>

        <th>Nombre de Usuario</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Tipo Rol</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach var="rolesCont" items="${rolesDetalles}">

        <tr>
            <td>${rolesCont.user.nombreUsuario}</td>
            <td>${rolesCont.user.nombre}</td>
            <td>${rolesCont.user.apellido}</td>
            <td>${rolesCont.roles.descripcion}</td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<button type="button" name="Asignar Rol" onclick="history.back()">Asignar Rol</button>
<br/><br/>
<p style="color: red;padding-top:400px">${ErrorKeyDuplicada}</p>
</body>
</html>
