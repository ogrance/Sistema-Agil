<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Relacion Proyecto/Proyecto</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <ul>
        <li><a href="ProyectoController?accion=home">Home</a></li>
        <li><a href="ProyectoController?accion=Desarrollo">Pag. Desarrollo</a></li>
        <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
    </ul>
    <body>
        <form action="DesarrolloController" method="POST">
            <%
                String varProyecto = request.getParameter("proyectos");
                int varIdProyecto = Integer.parseInt(varProyecto.substring(varProyecto.indexOf("(") + 4, varProyecto.indexOf(")")));
                
                String varUser = request.getParameter("usuarios");
                int varIdUser = Integer.parseInt(varUser.substring(varUser.indexOf("(") + 4, varUser.indexOf(")")));
            %>
            <br><br>
            <b>  ¿Desea relacionar al backlog <u><%= varUser.substring(0, varUser.indexOf("("))%></u> con el proyecto "<i><%=varProyecto.substring(0, varProyecto.indexOf("(")-1)%>"</i> </b> <br>
            <br>
            
            <input type="hidden" name="nombreBacklog" value="<%= varIdUser %>"><br>
            <input type="hidden" name="idProyecto" value="<%= varIdProyecto %>"><br>
            
            
            <input type="submit" name="accion" value="Confirmar relacion"><br><br>
            <input type="submit" name="accion" value="Cancelar"><br>
        </form>
    </body>
</html>
