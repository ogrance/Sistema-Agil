<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
</head>
<ul>
        <li><a href="http://localhost:8080/demo/ProyectoController?accion=home">Home</a></li>
        <li><a href='inicio_seguridad'>Pagina Seguridad</a></li>
        <li style="float:right"><a class="active" href="http://localhost:8080/demo/login">Cerrar Sesion</a></li>
    </ul>
<body>
<table class="usuarios-tabla">
    <thead>
    <tr>
        <th>Id Usuario</th>
        <th>Nombre de Usuario</th>
        <th>Nombre</th>
        <th>Apellido</th>
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
            <td><a href="${linkModificar}"><input type="button" value="Modificar"/></a></td>
            <td><a href="${linkEliminar}"><input type="button" value="Eliminar"onclick="if (!(confirm('Vas a eliminar este registro. Estas Seguro? ')))return false"/></a></td>
            <td><a href="${linkAsignarRol}" ><input type="button" value="Asignar Rol"></a></td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<input class="btn" type="button" value="Agregar Usuario" onclick="window.location.href='agregar_usuario';return false;"/>
</body>
</html>
