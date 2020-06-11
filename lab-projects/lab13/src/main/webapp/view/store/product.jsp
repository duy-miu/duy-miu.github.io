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
    <link href="<c:url value="/resources/css/product.css"/>" rel="stylesheet"/>
    <script lang="javascript" src="<c:url value="/resources/js/product.js"/>"></script>
</head>
<body>

<h2>CS472 - Simple web store</h2>
<hr/>
<div id="wrapper">
    <c:forEach items="${productList}" var="product">
        <div class="box">
            <c:out value="${product.name}"/><br/>
            <hr/>
            <img src="<c:out value="resources/images/${product.imageFile}"/>"/>
                    <input type="text" id="<c:out value="quantity_${product.id}"/>" placeholder="1"/>
                    <input type="button" id="<c:out value="btnAdd_${product.id}"/>" class="button" value="Add To Cart"/><br/>
                    <em>Price:</em> $ <c:out value="${product.unitPrice}"/><br>
                    <em>Unit In Stock:</em> <c:out value="${product.unitInStock}"/><br>
                    <em>Description:</em> <c:out value="${product.description}"/><br>
        </div>
    </c:forEach>
</div>

</body>
</html>
