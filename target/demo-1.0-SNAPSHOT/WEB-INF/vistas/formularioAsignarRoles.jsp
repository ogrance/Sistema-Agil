<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: juaos
  Date: 17/08/2021
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asignar Roles</title>
</head>
<a>
<h1>Asignar Rol al usuario: &nbsp${listaRolesDetalle.user.nombre}&nbsp ${listaRolesDetalle.user.apellido}</h1>
<form:form action="formulario-asignar-rol" modelAttribute="listaRolesDetalle" method="post">

    <table>
        <thead>
        <tr>


            <th>Roles</th>

        </tr>
        </thead>
    <tbody>
    <c:forEach var="rolesCont" items="${listaRolesDetalle.lista}">
        <c:url var="linkAsignar" value="asignar-rol">
            <c:param name="idRole" value="${rolesCont.idRole}"/>
            <c:param name="idUsuario" value="${listaRolesDetalle.user.idUsuario}"/>
        </c:url>


    <tr>

        <td><a href="${linkAsignar}"> <input class="check-box" type="checkbox" /></a></td>
        <td><form:label path="lista">${rolesCont.descripcion}</form:label> </td>
    </tr>
        <br/>

    </c:forEach>
    </tbody>

    </table>
</form:form>




</body>
</html>
