<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 2020-06-10
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>CS472 - Simple web store</title>
        <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet"/>
    </head>
    <body>

        <h2>CS472 - Simple web store</h2>
        <hr/>

        <form method="POST" action="login">
              <fieldset>
                  <legend>Your Credentials</legend>
                  <span>
                      <label for="username">User Name</label>
                      <input type="text" name="username" id="username">
                  </span>
                  <span>
                      <label for="password">Password</label>
                      <input type="password" name="password" id="password">
                  </span>
                  <br/>
                  <br/>
                  <input type="submit" id="login" value="Login">
              </fieldset>
        </form>
    </body>
</html>
