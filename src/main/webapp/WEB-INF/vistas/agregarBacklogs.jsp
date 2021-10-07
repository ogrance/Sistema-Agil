<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Creacion de Backlogs</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
    </head>
    <body>
        <form action="DesarrolloController" method="POST">
            <div class="form">
                <div class="title">Crear Backlog</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic1">
                    <input class="input" type="text" name="nameb" placeholder=" " />
                    <div class="cut"></div>
                    <label for="nameb" class="placeholder">Nombre</label>
                </div>

                <div class="input-container ic2">
                    <input id="descripcion" class="input" type="text" name="descripcionb" placeholder=" " />
                    <div class="cut"></div>
                    <label for="descripcionb" class="placeholder">Comentario</label>
                </div>
                <br>
                <input type="submit" name="accion" value="Crear"><br>
            </div>
        </form>

    </body>
</html>
