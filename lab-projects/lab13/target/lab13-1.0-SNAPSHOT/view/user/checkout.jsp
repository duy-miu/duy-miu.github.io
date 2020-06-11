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
    <link href="<c:url value="/resources/css/checkout.css"/>" rel="stylesheet"/>
    <script lang="javascript" src="<c:url value="/resources/js/cart.js"/>"></script>
</head>
<body>

<h2>CS472 - Simple web store</h2>
<hr/>

<h1>Checkout form</h1>

<div id="content">
    <div id="shopping-cart">
        <div>
            Your cart
        </div>
        <ul>
            <c:forEach items="${cart.itemList}" var="item">
                <li><c:out value="${item.name}"/> <span>$ <c:out value="${item.total}"/></span></li>
            </c:forEach>
            <li>Total <span>$ <c:out value="${cart.costTotal}"/></span></li>
        </ul>
    </div>
    <div id="checkout">
        <div>
            Information
        </div>
        <form action="process" method="POST">
            <fieldset>
                <legend>Personal details</legend>
                <span>
                    <label for="first-name">First name <span>*</span></label>
                    <input type="text" id="first-name" name="first-name" required
                           pattern="[a-zA-Z\s]{2,25}"/>
                </span>
                <span>
                    <label for="last-name">Last name <span>*</span></label>
                    <input type="text" id="last-name" name="last-name" required pattern="[a-zA-Z\s]{2,25}"/>
                </span>
                <span>
                    <label for="email">Email <span>*</span></label>
                    <input type="text" id="email" name="email" required
                                       pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/>
                </span>
                <span>
                    <label for="phone">Phone <span>*</span></label>
                    <input type="text" id="phone" name="phone" required pattern="[0-9]{10,15}"/>
                </span>
            </fieldset>

            <fieldset>
                <legend>Shipping address</legend>
                <span>
                    <label for="shipping-unit">Unit/Room/Apt No. <span>*</span></label>
                    <input id="shipping-unit" name="shipping-unit" placeholder="Apartment or suite" type="text" required/>
                </span>
                <span>
                    <label for="shipping-street">Street <span>*</span></label>
                    <input id="shipping-street"  name="shipping-street" placeholder="1234 Main St" type="text" required/>
                </span>
                <span>
                    <label for="shipping-city">City <span>*</span></label>
                    <input id="shipping-city" name="shipping-city" type="text" required/>
                </span>
                <span>
                    <label for="shipping-state">State <span>*</span></label>
                    <input id="shipping-state" name="shipping-state" type="text" required/>
                </span>
                <span>
                    <label for="shipping-zipcode">Zip code <span>*</span></label>
                    <input id="shipping-zipcode" name="shipping-zipcode" type="text" required/>
                </span>
                <span>
                    <label for="shipping-country">Country <span>*</span></label>
                    <select id="shipping-country" name="shipping-country">
                        <option value="">&nbsp;</option>
                        <option value="Australia">Australia</option>
                        <option value="Belgium">Belgium</option>
                        <option value="Canada">Canada</option>
                        <option value="Denmark">Denmark</option>
                        <option value="Estonia">Estonia</option>
                        <option value="France">France</option>
                        <option value="Germany">Germany</option>
                        <option value="Hong Kong">Hong Kong</option>
                        <option value="Italy">Italy</option>
                        <option value="Japan">Japan</option>
                        <option value="Korea">Korea</option>
                        <option value="Luxembourg">Luxembourg</option>
                        <option value="Malta">Malta</option>
                        <option value="Netherlands">Netherlands</option>
                        <option value="Poland">Poland</option>
                        <option value="Russia">Russia</option>
                        <option value="Sweden">Sweden</option>
                        <option value="United States of America" selected>United States of America</option>
                        <option value="Vietnam">Vietnam</option>
                        <option value="Wake Island">Wake Island</option>
                        <option value="Yemen">Yemen</option>
                        <option value="Zimbabwe">Zimbabwe</option>
                    </select>
                </span>
            </fieldset>

            <fieldset>
                <legend>Payment info</legend>
                <span>
                    <label for="card-type">Card Type <span>*</span></label>
                    <select id="card-type" name="card-type" required>
                        <option value="">&nbsp;</option>
                        <option>Credit</option>
                        <option>Debit</option>
                        <option>Paypal</option>
                    </select>
                </span>
                <span>
                    <label for="card-name">Name <span>*</span></label>
                    <input id="card-name" name="card-name" type="text" placeholder="Full name as displayed on card" required/>
                </span>
                <span>
                    <label for="card-number">Number <span>*</span></label>
                    <input id="card-number" name="card-number" placeholder="####-####-####-####" pattern="^\d{4}-\d{4}-\d{4}-\d{4}$" type="text" required/>
                </span>
                <span>
                    <label>Expiration <span>*</span></label>
                    <select id="exp-month" name="exp-month" required>
                        <option value="">&nbsp;</option>
                        <option value="01">January</option>
                        <option value="02">February </option>
                        <option value="03">March</option>
                        <option value="04">April</option>
                        <option value="05">May</option>
                        <option value="06">June</option>
                        <option value="07">July</option>
                        <option value="08">August</option>
                        <option value="09">September</option>
                        <option value="10">October</option>
                        <option value="11">November</option>
                        <option value="12">December</option>
                    </select>
                    <select id="exp-year" name="exp-year" required>
                        <option value="">&nbsp;</option>
                        <option value="16"> 2020</option>
                        <option value="17"> 2021</option>
                        <option value="18"> 2022</option>
                        <option value="19"> 2023</option>
                        <option value="20"> 2024</option>
                        <option value="21"> 2025</option>
                    </select>
                </span>
            </fieldset>

            <input type="submit" value="Process">
        </form>
    </div>
</div>
</body>
</html>
