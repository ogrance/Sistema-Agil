<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>How to Create responsive Homepage</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700;900&display=swap" rel="stylesheet"/>
    <link href="<c:url value="/recursos/css/style.css" />" rel="stylesheet">
</head>
<body>
<header>
    <div class="wrapper">
        <div class="logo">
            <img src="https://i.postimg.cc/FsV51PZJ/logo.png" alt="">
        </div>
        <ul class="nav-area">
            <li><a href="#">Contactanos</a></li>
            <li><a href="#">Acerca de Nosotros</a></li>
        </ul>
    </div>
    <div class="welcome-text">
        <h1>
           <span>Sistema Gestor de Proyectos Agile</span></h1>
        <a href="login">Login</a>
    </div>
</header>

</body>
</html>
