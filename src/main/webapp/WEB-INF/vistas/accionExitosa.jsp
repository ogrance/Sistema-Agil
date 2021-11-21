<%-- 
    Document   : accionExitosa
    Created on : Aug 21, 2021, 12:22:13 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Accion exitosa!</title>
        <meta http-equiv="refresh" content="3;url=http://localhost:8081/SistemaAgil_IS2_war/DesarrolloController?accion=ABM de User Stories">
    </head>
    <body>
        <h1>Accion Exitosa!</h1>
        <form action="ProyectoController" method="POST">
            <input type="submit" name="accion" value="Volver a la Home"><br>
        </form>
    </body>
</html>
