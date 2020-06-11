<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 2020-06-10
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>ERROR PAGE</title>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>
  </head>
  <body>
    <h2>CS472 - Simple web store</h2>
    <hr/>
      YOU GOT AN ERROR!!!

      <p><c:out value="${errMsg}"/></p>
  </body>
</html>
