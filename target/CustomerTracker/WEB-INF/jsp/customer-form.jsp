<%--
  Created by IntelliJ IDEA.
  User: MNS
  Date: 11/7/2022
  Time: 6:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/ressources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/ressources/css/add-customer-style.css">

</head>
<body>

      <div id="wrapper">

          <div id="header">
              <h2>CRM - Customer Relationship Manager</h2>
          </div>
      </div>

        <div id="container">
                <H3>  save Customer  </H3>

                <form:form action="saveCustomer" modelAttribute="customer" method="post">

                        <form:hidden path="id"/>

                    <table>
                        <tbody>
                                <tr>
                                    <td><label>First Name:</label></td>
                                    <td><form:input path="firstName"/></td>
                                </tr>

                                <tr>
                                    <td><label>Last Name:</label></td>
                                    <td><form:input path="lastName"/></td>
                                </tr>

                                <tr>
                                    <td><label>Email:</label></td>
                                    <td><form:input path="email"/></td>
                                </tr>

                                <tr>
                                    <td><label></label></td>
                                    <td><input type="submit" value="save" class="save" /></td>
                                </tr>
                        </tbody>
                    </table>

                </form:form>

                <div style="clear:both"></div>
            <p>
                <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
            </p>
        </div>

</body>
</html>
