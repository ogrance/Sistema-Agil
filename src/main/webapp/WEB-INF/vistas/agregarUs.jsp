

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Agregar User Stores</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/recursos/css/estilo_agregar_usuario.css" type="text/css">
    </head>
    <body>
        <form action="DesarrolloController" method="POST">
            <div class="form">
                <div class="title">Agregar User Storie</div>
                <div class="subtitle">Digite los datos solicitados</div>

                <div class="input-container ic2">
                    <input id="descripcion" class="input" type="text" name="descripcion" placeholder=" " />
                    <div class="cut"></div>
                    <label for="descripcion" class="placeholder">Descripcion</label>
                </div>

                <div class="input-container ic2">
                    <input id="Estatus" class="input" type="text" name="Estatus" placeholder=" " />
                    <div class="cut"></div>
                    <label for="Estatus" class="placeholder">Status</label>
                </div>
                <br>
                <input type="submit" name="accion" value="Agregar" onclick="if (!(confirm('Vas a agregar este registro. Estas Seguro? '))) return false"/><br>
            </div>
        </form>

    </body>
</html>
