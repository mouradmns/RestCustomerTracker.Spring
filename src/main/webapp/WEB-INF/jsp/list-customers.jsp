<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: MNS
  Date: 11/6/2022
  Time: 1:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>


<html>
<head>
    <title>list-customers</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/ressources/css/style.css">
</head>
<body>
        <div id="wrapper">
             <div id="header">
                                        <h2>CRM - Customer Relationship Manager</h2>
             </div>

        </div>

        <div id="container">
            <div id="content">

                <input type="button"
                       value="Add Customer"
                       onclick="window.location.href='showFormForAdd';return false"
                       class="add-button"
                />

                <table >
                    <tr>
                        <th>First</th>
                        <th>Last</th>
                        <th>email</th>
                        <th>Action</th>
                    </tr>
                    <%--@elvariable id="model" type="web.ProduitModel"--%>
                    <c:forEach var="cust" items="${customers}">

                        <c:url var="updateLink" value="/customer/showFormUpdate">
                            <c:param name="customerId" value="${cust.id}"/>
                        </c:url>


                        <c:url var="deleteLink" value="/customer/delete">
                            <c:param name="customerId" value="${cust.id}"/>
                        </c:url>
                        <tr>

                            <td>${cust.firstName}</td>
                            <td>${cust.lastName}</td>
                            <td>${cust.email}</td>
                            <td>
                                <a href="${updateLink}">update</a>
                                <a href="${deleteLink}"
                                   onclick="if(!(confirm('are yoou sure you wanna delete had zbi'))) return false">Delete</a>
                            </td>

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

</body>
</html>
