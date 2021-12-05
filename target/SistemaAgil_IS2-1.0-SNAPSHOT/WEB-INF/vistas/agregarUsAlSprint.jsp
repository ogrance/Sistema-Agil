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
                String varhistorias = request.getParameter("historias");
                int varIdhistorias = Integer.parseInt(varhistorias.substring(varhistorias.indexOf("(") + 4, varhistorias.indexOf(")")));
                
                String idSprint = request.getParameter("sprint_id");
                
            %>
           <br><br>
           <b>  ¿Desea agregar al sprint <u><%= idSprint %></u> el User Storie "<i><%=varhistorias.substring(0, varhistorias.indexOf("(")-1)%>"</i> </b> <br>
            <br>
            
            <input type="hidden" name="id_us" value="<%= varIdhistorias %>"><br>
            <input type="hidden" name="id_sprint" value="<%= idSprint %>"><br>
            
            <input type="submit" name="accion" value="Agregar al Sprint"><br><br>
            <input type="submit" name="accion" value="Cancelar"><br>
        </form>
    </body>
</html>
