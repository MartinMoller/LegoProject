<%-- 
    Document   : employeeNav
    Created on : 21-Mar-2018, 14:15:49
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Lego project</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="FrontController?command=home">Hjem</a></li>
            <li><a href="FrontController?command=viewallorders">Ordre</a></li>            
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="FrontController?command=logout">Log ud</a></li>
        </ul>
    </div>
</nav>