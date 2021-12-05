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
        <li><a href='http://localhost:8081/SistemaAgil_IS2/seguridad/permisos'>Permisos</a></li>
        <li style="float:right"><a class="active" href="http://localhost:8081/SistemaAgil_IS2/login">Cerrar Sesion</a></li>
</ul>

<h1>Asignar Roles al permiso: &nbsp${listaPermisosDetalle.permiso.nombrePermiso}&nbsp con alcance&nbsp  ${listaPermisosDetalle.permiso.alcance}</h1>
<form:form action="formulario-asignar-rol-permiso" modelAttribute="listaPermisosDetalle" method="post">

    <table>
        <thead>
        <tr>


            <th>Roles</th>

        </tr>
        </thead>
    <tbody>
    <c:forEach var="permisosCont" items="${listaPermisosDetalle.lista}">
        <c:url var="linkAsignar" value="asignar-rol-permiso">
            <c:param name="idRole" value="${permisosCont.idRole}"/>
            <c:param name="idPermiso" value="${listaPermisosDetalle.permiso.idPermiso}"/>
        </c:url>


    <tr>

        <td colspan="1" style="text-align:center;"><a href="${linkAsignar}"> <input class="radio-button" type="radio" /></a></td>
        <td colspan="1" style="text-align:center;"><form:label path="lista">${permisosCont.descripcion}</form:label> </td>
    </tr>
        <br/>



    </c:forEach>
    </tbody>

    </table>







</form:form>




</body>
</html>
