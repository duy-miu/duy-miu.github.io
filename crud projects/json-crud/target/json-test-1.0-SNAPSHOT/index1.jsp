<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 2020-06-17
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>CRUD JSON Demo</title>
  </head>
  <body>
    <h1>CRUD JSON Demo</h1>
  ${1+3}
  </body>

<jsp:useBean id="r" class="model.Record"></jsp:useBean>

<c:forEach var="c" items="${r.contacts}">
  <c:out value="${c.name}"/>
</c:forEach>

<%
  out.print("safasfas");
  System.out.println("TEST "+request.getServerName());
  %>
</html>
