<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <%@include file="includes/links.jsp" %>
    <%@include file="includes/customerNav.jsp" %>
    <body>
        <div class="container">
            <h1>Hello <%= session.getAttribute("name")%> </h1>
       
            You are now logged in as a customer of our wonderful site.
        </div>
    </body>
</html>
