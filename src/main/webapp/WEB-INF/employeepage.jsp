<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
        <%@include file="includes/links.jsp" %>
    </head>
    <%@include file="includes/employeeNav.jsp" %>
    <body>
        <div class="container">

            <h1>Hello <%= session.getAttribute("name")%> </h1>
            You are now logged in as a EMPLOYEE of our wonderful site.
        </div>  
    </body>
</html>
