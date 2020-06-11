<%--
  Created by IntelliJ IDEA.
  User: Trung
  Date: 2020-06-10
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CS472 - Simple web store</title>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/cart.css"/>" rel="stylesheet"/>
    <script lang="javascript" src="<c:url value="/resources/js/cart.js"/>"></script>
</head>
<body>

<h2>CS472 - Simple web store</h2>
<hr/>
<table>
    <caption>Your Shopping Cart</caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Total ($)</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${cart.itemList}" var="item">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.price}"/></td>
            <td><c:out value="${item.quantity}"/></td>
            <td><c:out value="${item.total}"/></td>
            <td><a href="<c:url value="home?page=cart&action=remove&id=${item.id}"/>">Remove</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td></td><td><em>Total Cost: ($)</em></td>
        <td colspan="4" align="right"><strong>${cart.costTotal}</strong></td>
    </tr>
</table>
<br/>
<a href="home?page=product">Continue shopping</a><br/>
<a href="checkout">Checkout</a>
</body>
</html>
