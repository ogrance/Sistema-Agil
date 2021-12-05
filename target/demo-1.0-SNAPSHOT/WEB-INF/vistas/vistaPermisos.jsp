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
    <title>Resumen Permisos</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
</head>
<ul>
        <li><a href="http://localhost:8081/SistemaAgil_IS2_war/ProyectoController?accion=home">Home</a></li>
        <li><a href='inicio_seguridad'>Pagina Seguridad</a></li>
        <li><a href='http://localhost:8081/SistemaAgil_IS2_war/seguridad/permisos'>Permisos</a></li>
        <li style="float:right"><a class="active" href="http://localhost:8081/SistemaAgil_IS2_war/login">Cerrar Sesion</a></li>
</ul>

<body>
<table class="usuarios-tabla">
    <thead>
    <tr>

        <th>Nombre de Permiso</th>
        <th>Alcance</th>
        <th>Nombre del Rol</th>
        <th>Borrar</th>


    </tr>
    </thead>
    <tbody>
    <c:forEach var="permisosCont" items="${permisoDetalles}">
        <c:url var="linkBorrarPermiso" value="formulario-eliminar-rol-permiso">
            <c:param name="idRole" value="${permisosCont.roles.idRole}"/>
            <c:param name="idPermiso" value="${permisosCont.permiso.idPermiso}"/>
        </c:url>
        <tr>
            <td>${permisosCont.permiso.nombrePermiso}</td>
            <td>${permisosCont.permiso.alcance}</td>
            <td>${permisosCont.roles.descripcion}</td>
            <td colspan="1" style="text-align:center;"><a href="${linkBorrarPermiso}" ><input type="button" value="Eliminar Asignacion" onclick="if (!(confirm('Vas a eliminar un registro. Estas seguro?')))return false"></a></td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<button type="button" name="Asignar Rol" onclick="window.location.href='permisos';return false;">Volver</button>
<input class="btn" type="button" value="Inicio" onclick="window.location.href='inicio_seguridad';return false;"/>
<br/><br/>
<p style="color: red;padding-top:400px">${ErrorKeyDuplicada}</p>
<p style="color: red;padding-top:400px">${ErrorDelete}</p>
</body>
</html>
