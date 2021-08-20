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
        <th>Id Usuario</th>
        <th>Nombre de Usuario</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Estado</th>
        <th>Modificar</th>
        <th>Eliminar</th>
        <th>Roles</th>
         </tr>
    </thead>
    <tbody>
    <c:forEach var="usuarioCont" items="${listaUsuarios}">
        <c:url var="linkModificar" value="formulario-actualizar-usuario">
            <c:param name="idUsuario" value="${usuarioCont.idUsuario}"/>
        </c:url>
        <c:url var="linkEliminar" value="formulario-eliminar-usuario">
            <c:param name="idUsuario" value="${usuarioCont.idUsuario}"/>
        </c:url>
        <c:url var="linkAsignarRol" value="formulario-asignar-rol">
            <c:param name="idUsuario" value="${usuarioCont.idUsuario}"/>
        </c:url>
        <tr>
            <td>${usuarioCont.idUsuario}</td>
            <td>${usuarioCont.nombreUsuario}</td>
            <td>${usuarioCont.nombre}</td>
            <td>${usuarioCont.apellido}</td>
            <td>${usuarioCont.status}</td>
            <td><a href="${linkModificar}"><input type="button" value="Modificar"/></a></td>
            <td><a href="${linkEliminar}"><input type="button" value="Eliminar"onclick="if (!(confirm('Vas a eliminar este registro. Estas Seguro? ')))return false"/></a></td>
            <td><a href="${linkAsignarRol}" ><input type="button" value="Asignar Rol"></a></td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<input class="btn" type="button" value="Agregar Usuario" onclick="window.location.href='agregar_usuario';return false;"/>
<input class="btn" type="button" value="Inicio" onclick="window.location.href='inicio_seguridad';return false;"/>
</body>
</html>
