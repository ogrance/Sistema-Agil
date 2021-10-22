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
        <th>Id del Proyecto</th>
        <th>Nombre del Sprint</th>
        <th>Duracion del Sprint</th>
        <th>Estado del Sprint</th>
        <th>Iniciar</th>
        <th>Finalizar</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sprintCont" items="${listaSprintsDisponibles}">

        <tr>
            <td>${sprintCont.id_sprint}</td>
            <td>${sprintCont.project_id}</td>
            <td>${sprintCont.name}</td>
            <td>${sprintCont.duration}</td>
            <td>${sprintCont.estatus}</td>
        </tr>

    </c:forEach>
    </tbody>

</table>
<br/>
<input class="btn" type="button" value="Agregar Usuario" onclick="window.location.href='agregar_usuario';return false;"/>
<input class="btn" type="button" value="Inicio" onclick="window.location.href='inicio_seguridad';return false;"/>
</body>
</html>
