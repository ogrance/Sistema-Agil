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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
</head>
<ul>
        <li><a href="http://localhost:8081/SistemaAgil_IS2/ProyectoController?accion=home">Home</a></li>
        <li><a href='inicio_seguridad'>Pagina Seguridad</a></li>
        <li><a href='http://localhost:8081/SistemaAgil_IS2/seguridad/usuarios'>Usuarios</a></li>
        <li style="float:right"><a class="active" href="http://localhost:8081/SistemaAgil_IS2/login">Cerrar Sesion</a></li>
</ul>

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

        <td><a href="${linkAsignar}"> <input class="radio-button" type="radio" /></a></td>
        <td><form:label path="lista">${rolesCont.descripcion}</form:label> </td>
    </tr>
        <br/>



    </c:forEach>
    </tbody>

    </table>







</form:form>




</body>
</html>
