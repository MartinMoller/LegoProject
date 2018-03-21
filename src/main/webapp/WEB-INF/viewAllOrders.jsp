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
            <h2>Dine ordre</h2>

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Længde</th>
                        <th>Bredde</th>
                        <th>Højde</th>
                        <th>Status</th>
                        <th></th>

                    </tr>
                </thead>
                <tbody>

                    <%
                        for (Order order : (ArrayList<Order>) request.getAttribute("orders")) {


                    %>
                    <tr>
                        <td><%= order.getId()%></td>
                        <td><%= order.getLength()%></td>
                        <td><%= order.getWidth()%></td>
                        <td><%= order.getHeight()%></td>
                        <% if (order.getStatus() == 0) {
                        %>
                        <td>Ikke afsendt</td>
                        <% } else if (order.getStatus() == 1) {
                        %>
                        <td>Afsendt</td>
                        <%}%>

                        <% if (order.getStatus() == 0) {
                        %>
                        <td><a class="btn btn-primary" href="FrontController?command=sendorder&id=<%=order.getId()%>">Marker som afsendt</a></td>
                        <%}%>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>

