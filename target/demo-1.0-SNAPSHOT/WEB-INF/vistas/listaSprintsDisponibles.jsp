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
        <th>Id del Sprint</th>
        <th>Nombre del Sprint</th>
        <th>Id del Proyecto</th>
        <th>Nombre del Proyecto</th>
        <th>Duracion del Sprint</th>
        <th>Estado del Sprint</th>
        <th>Iniciar</th>
        <th>Finalizar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sprintCont" items="${listaSprintsDisponibles}">
        <c:url var="linkIniciar" value="iniciar-sprints">
            <c:param name="project_id" value="${sprintCont.project_id}"/>
            <c:param name="id_sprint" value="${sprintCont.id_sprint}"/>
        </c:url>
        <c:url var="linkModificar" value="actualizar-user-stories">
            <c:param name="project_id" value="${sprintCont.project_id}"/>
            <c:param name="id_sprint" value="${sprintCont.id_sprint}"/>
        </c:url>
        <c:url var="linkFinalizar" value="finalizar-sprint">
            <c:param name="project_id" value="${sprintCont.project_id}"/>
            <c:param name="id_sprint" value="${sprintCont.id_sprint}"/>
        </c:url>
        <tr>
            <td>${sprintCont.id_sprint}</td>
            <td>${sprintCont.name}</td>
            <td>${sprintCont.project_id}</td>
            <td>${sprintCont.nombreProyecto}</td>
            <td>${sprintCont.duration}</td>
            <td>${sprintCont.estatus}</td>
            <td><a href="${linkIniciar}"><input type="button" value="Iniciar"/></a></td>
            <td><a href="${linkModificar}"><input type="button" value="Estado del US"/></a></td>
            <td><a href="${linkFinalizar}"><input type="button" value="Finalizar"onclick="if (!(confirm('Vas a finalizar este sprint. Estas Seguro? ')))return false"/></a></td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>

<input class="btn" type="button" value="Inicio" onclick="window.location.href='ProyectoController';return false;"/>
<p>${inicioCorrecto}</p>
<p>${inicioRepetido}</p>
<p>${finCorrecto}</p>
<p>${finIncorrecto}</p>
</body>
</html>
