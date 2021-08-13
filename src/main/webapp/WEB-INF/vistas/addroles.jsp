<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Rol</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/navbar.css">
    </head>
    <body>
        <ul>
            <li><a href="UsuarioCrudController?accion=paginabienvenida">Home</a></li>
            <li><a href="UsuarioCrudController?accion=seguridad">Seguridad</a></li>
            <li><a href="RoleCrudController?accion=Listar Roles">Lista de Roles</a></li>
            <li style="float:right"><a class="active" href="login">Cerrar Sesion</a></li>
        </ul>
        <div>
            <h1>Agregar User</h1>
            <form action="RoleCrudController">
                Descripcion: <br>
                <input type="text" name="txtuname"><br>
                
                <input type="submit" name="accion" value="Agregar"><br>
            </form>
        </div>
    </body>
</html>
