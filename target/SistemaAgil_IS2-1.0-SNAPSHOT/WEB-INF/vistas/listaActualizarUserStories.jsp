<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuarios</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_lista_usuarios.css">
</head>
<body>
<form:form method = "POST" action = "modificar-estados-US">
<table class="usuarios-tabla">
    <thead>
    <tr>
        <th>Id User Storie</th>
        <th>Descripcion</th>
        <th>Id del Proyecto</th>
        <th>Nombre del Proyecto</th>
        <th>Estado del US</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="usCont" items="${listaUserStorieProyect}">
        <c:url var="linkModificar" value="modificar-user-stories">
            <c:param name="id_us" value="${usCont.id_us}"/>
            <c:param name="descripcion" value="${usCont.descripcion}"/>
        </c:url>
        <tr>
            <td>${usCont.id_us}</td>
            <td>${usCont.descripcion}</td>
            <td>${usCont.project_id}</td>
            <td>${usCont.nombreProyecto}</td>
            <td>${usCont.estatus}</td>
            <td><a href="${linkModificar}"><input type="button" value="Modificar"/></a></td>


        </tr>

    </c:forEach>

    </tbody>

</table>
<br/>

<input class="btn" type="button" value="Inicio" onclick="window.location.href='ProyectoController';return false;"/>
 </form:form>
</body>
</html>
