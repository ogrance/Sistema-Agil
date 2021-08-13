<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Inicio de Sesion</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_login.css" type="text/css">
</head>
<body>

<div id="cuadro">
    <div id="cabeza">Inicio de Sesion</div>
    <div id="cuerpo">

        <form:form action="procesarLogin" modelAttribute="usuario">
            <table align="center">
         <tr>
       <td> <form:label path="nombreUsuario">Usuario</form:label></td>
       <td><form:input path="nombreUsuario" name="nombreUsuario" id="nombreUsuario"/></td>
         </tr>
                <tr>
            <td>  <form:label path="passwrd">Password</form:label></td>
                    <td> <form:password path="passwrd" name="password" id="password"/></td>
                </tr>
                <tr>
                   <td></td><td></td>
                </tr>
             <tr>
                 <td></td><td></td><td></td>
            <td><form:button id="loguear" name="loguear">Iniciar Sesion</form:button></td>
             </tr>
            </table>

        </form:form>

    </div>

</div>

<p>${registoIncorrecto}</p>
</body>

</html>