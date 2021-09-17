<%-- 
    Document   : accionErronea
    Created on : Aug 25, 2021, 6:34:06 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>No se pudo realizar la accion!</h1>
        <form action="ProyectoController" method="POST">
            <input type="submit" name="accion" value="Volver a Proyecto"><br>
        </form>
    </body>
</html>
