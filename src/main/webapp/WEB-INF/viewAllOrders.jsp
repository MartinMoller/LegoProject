<%-- 
    Document   : viewAllOrders
    Created on : 21-Mar-2018, 14:27:31
    Author     : martin
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ordre</title>
        <%@include file="includes/links.jsp" %>
    </head>
    <%@include file="includes/employeeNav.jsp" %>
    <body>
        <div class="container">
            <h2>Alle ordre</h2>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Længde</th>
                        <th>Bredde</th>
                        <th>Højde</th>
                        <th>Kunde</th>
                        <th>Status</th>
                        <th></th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.getId()}</td>
                            <td>${order.getLength()}</td>
                            <td>${order.getWidth()}</td>
                            <td>${order.getHeight()}</td>
                            <td>${order.getEmail()}</td>
                            <c:choose>
                                <c:when test="${order.getStatus()=='0'}">
                                    <td>Afventer</td>
                                </c:when>
                                <c:otherwise>
                                    <td>Afsendt</td>
                                </c:otherwise>
                            </c:choose>


                            <td><a href="FrontController?command=getbricks&id=${order.getId()}">Stykliste</a></td>
                            <td>
                                <c:if test="${order.getStatus()=='0'}">
                                    <a class="btn btn-primary" href="FrontController?command=sendorder&id=${order.getId()}">Marker som afsendt</a>    
                                </c:if>
                            </td>
                        </c:forEach>


                    </tr>

                </tbody>
            </table>
        </div>
    </body>
</html>

