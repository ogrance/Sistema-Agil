<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Estados US</title>
</head>
<body>

  <form:form action="procesarUS" modelAttribute="userStories">
   <form:select path="estatus">
      <form:option value="to-do" label="TO-DO"/>
     <form:option value="doing" label="DOING"/>
     <form:option value="done" label="DONE"/>
  </form:select>
    <br/><br/><br/>
    <input type="submit" value="Cambiar">
  </form:form>
</body>
</html>
