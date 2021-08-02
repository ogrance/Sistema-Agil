<%--
  Created by IntelliJ IDEA.
  User: Osmar
  Date: 01/08/2021
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
<head>
    <title>Inicio de Sesion</title>
</head>
<body>
<br/><br/><br/><br/><br/><br/>
<h1 align="center">INICIO DE SESION</h1>
<br/><br/><br/>
<form:form action="procesarLogin" modelAttribute="usuario">
<table  align="center">
<tr>
    <td>
        <form:label path="nombreUsuario">Usuario</form:label>
    </td>
    <td>
        <form:input path="nombreUsuario" name="nombreUsuario" id="nombreUsuario"/>
    </td>
</tr>
<tr>
    <td>
        <form:label path="passwrd">Password</form:label>
    </td>
    <td>
        <form:password path="passwrd" name="password" id="password"/>
    </td>
</tr>
 <tr>
     <td></td>
     <td>
         <form:button id="loguear" name="loguear">Iniciar Sesion</form:button>
     </td>
 </tr>
    <tr></tr>
    <tr>
        <td></td>
        <td><a href="index">Atras</a> </td>
    </tr>


</table>


</form:form>
</br></br></br></br></br></br>
<h2>${registoIncorrecto}</h2>

</body>
</html>
