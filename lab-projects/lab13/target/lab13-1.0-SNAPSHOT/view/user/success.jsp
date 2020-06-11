<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 2020-06-10
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ERROR PAGE</title>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>
    <meta http-equiv="refresh" content="2;url=<c:out value="home?page=checkout"/>" />
</head>
<body>
<h2>CS472 - Simple web store</h2>
<hr/>
<p><c:out value="${message}"/></p>
</body>
</html>
