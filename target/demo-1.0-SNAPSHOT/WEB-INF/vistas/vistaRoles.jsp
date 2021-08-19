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
        <th>Borrar</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach var="rolesCont" items="${rolesDetalles}">
        <c:url var="linkBorrarRol" value="formulario-eliminar-rol-usuario">
            <c:param name="idRole" value="${rolesCont.roles.idRole}"/>
            <c:param name="idUsuario" value="${rolesCont.user.idUsuario}"/>
        </c:url>
        <tr>
            <td>${rolesCont.user.nombreUsuario}</td>
            <td>${rolesCont.user.nombre}</td>
            <td>${rolesCont.user.apellido}</td>
            <td>${rolesCont.roles.descripcion}</td>
            <td><a href="${linkBorrarRol}" ><input type="button" value="Eliminar Rol" onclick="if (!(confirm('Vas a eliminar un registro. Estas seguro?')))return false"></a></td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<button type="button" name="Asignar Rol" onclick="window.location.href='usuarios';return false;">Volver</button>
<br/><br/>
<p style="color: red;padding-top:400px">${ErrorKeyDuplicada}</p>
<p style="color: red;padding-top:400px">${ErrorDelete}</p>
</body>
</html>
