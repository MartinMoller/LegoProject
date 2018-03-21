<%-- 
    Document   : order
    Created on : 19-Mar-2018, 15:30:34
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestil</title>
    </head>
    <%@include file="includes/links.jsp" %>
    <%@include file="includes/customerNav.jsp" %>
    <body>
        <%
            if (request.getSession().getAttribute("message") != null) {
        %>
        <script>alert("<%=request.getSession().getAttribute("message")%>");</script>
        <%request.getSession().removeAttribute("message");
            }
        %>
        <div class="container">
            <h1>Bestil dit Lego hus!</h1>
            <form name="order" action="FrontController" method="post">
                <input type="hidden" name="command" value="order">
                <label>Længde</label>
                <input class="form-control" type="text" name="length"> 
                <label>Bredde</label>
                <input class="form-control" type="text" name="width">
                <label>Højde</label>
                <input class="form-control" type="text" name="height">
                <br>
                <input class="btn btn-primary" type="submit" value="Bestil">
            </form>
        </div>
    </body>
</html>
