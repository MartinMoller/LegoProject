<%-- 
    Document   : vieworders
    Created on : 19-Mar-2018, 19:06:41
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
    <%@include file="includes/customerNav.jsp" %>
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
                        <td><a href="FrontController?command=getbricks">Stykliste</a></td>

                     
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>
    </body>
</html>
