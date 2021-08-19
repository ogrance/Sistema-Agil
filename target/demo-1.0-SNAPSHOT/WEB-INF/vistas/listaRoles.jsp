<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
</head>
<body>
<table class="usuarios-tabla">
    <thead>
    <tr>
        <th>Id Rol</th>
        <th>Nombre del Rol</th>
        <th>Modificar Rol</th>
        <th>Eliminar Rol</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="rolCont" items="${listaRoles}">
        <c:url var="linkModificar" value="formulario-actualizar-rol">
            <c:param name="idRole" value="${rolCont.idRole}"/>
        </c:url>
        <c:url var="linkEliminar" value="formulario-eliminar-rol">
            <c:param name="idRole" value="${rolCont.idRole}"/>
        </c:url>

        <tr>
            <td>${rolCont.idRole}</td>
            <td>${rolCont.descripcion}</td>

            <td><a href="${linkModificar}"><input type="button" value="Modificar"/></a></td>
            <td><a href="${linkEliminar}"><input type="button" value="Eliminar"onclick="if (!(confirm('Vas a eliminar este registro. Estas Seguro? ')))return false"/></a></td>

        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<input class="btn" type="button" value="Agregar Rol" onclick="window.location.href='agregar-rol';return false;"/>
<br/>
<p>${ErrorEliminarRol}</p>
</body>
</html>

