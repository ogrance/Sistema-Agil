<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Permisos</title>
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
        <th>Id Permiso</th>
        <th>Nombre del Permiso</th>
        <th>Alcance del Permiso</th>
        <th>Modificar Permiso</th>
        <th>Eliminar Permiso</th>
        <th>Asignar Rol</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="permisoCont" items="${listaPermisos}">
        <c:url var="linkModificar" value="formulario-actualizar-permiso">
            <c:param name="idPermiso" value="${permisoCont.idPermiso}"/>
        </c:url>
        <c:url var="linkEliminar" value="formulario-eliminar-permiso">
            <c:param name="idPermiso" value="${permisoCont.idPermiso}"/>
        </c:url>
        <c:url var="linkAsignarRolPermiso" value="formulario-asignar-rol-permiso">
            <c:param name="idPermiso" value="${permisoCont.idPermiso}"/>
        </c:url>

        <tr>
            <td>${permisoCont.idPermiso}</td>
            <td>${permisoCont.nombrePermiso}</td>
            <td>${permisoCont.alcance}</td>

            <td colspan="1" style="text-align:center;"><a href="${linkModificar}"><input type="button" value="Modificar" /></a></td>
            <td colspan="1" style="text-align:center;"><a href="${linkEliminar}"><input type="button"  value="Eliminar"onclick="if (!(confirm('Vas a eliminar este registro. Estas Seguro? ')))return false"/></a></td>
            <td colspan="1" style="text-align:center;"><a href="${linkAsignarRolPermiso}" ><input type="button" value="Asignar Rol"></a></td>

        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<input class="btn" type="button" value="Agregar Permiso" onclick="window.location.href='agregar-permiso';return false;"/>
<br/>


</body>
</html>

