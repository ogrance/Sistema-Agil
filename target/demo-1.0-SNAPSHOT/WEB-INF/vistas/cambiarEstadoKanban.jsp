<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Adicion al Proyecto</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="ProyectoController?accion=Proyecto">Pag. Proyecto</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <form action="DesarrolloController" method="POST">
            <%
                String varProyecto = request.getParameter("ofTODO");
            %>
            <br><br>
            <b>Confirmar Cambio de Estado</b>    
            <input type="hidden" name="cambio" value="<%= varProyecto %>"><br>
            
            
            <input type="submit" name="accion" value="Cambiar Estado"><br><br>
            <input type="submit" name="accion" value="Cancelar"><br>
        </form>
    </body>
</html>
