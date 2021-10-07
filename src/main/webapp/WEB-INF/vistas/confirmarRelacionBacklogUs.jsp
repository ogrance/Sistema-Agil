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
                String varUS = request.getParameter("proyectos");
                int varIdUs = Integer.parseInt(varUS.substring(varUS.indexOf("(") + 4, varUS.indexOf(")")));
                
                String varBackl = request.getParameter("usuarios");
                int varIdBackl = Integer.parseInt(varBackl.substring(varBackl.indexOf("(") + 4, varBackl.indexOf(")")));
            %>
            <br><br>
            <b>  ¿Desea agregar al backlog <u><%= varBackl.substring(0, varBackl.indexOf("("))%></u> la historia "<i><%=varUS.substring(0, varUS.indexOf("(")-1)%>"</i> ?</b> <br>
            <br>
            
            <input type="hidden" name="idBackl" value="<%= varIdBackl %>"><br>
            <input type="hidden" name="idUseStorie" value="<%= varIdUs %>"><br>
            
            
            <input type="submit" name="accion" value="Confirmar accion"><br><br>
            <input type="submit" name="accion" value="Cancelar"><br>
        </form>
    </body>
</html>
