<%-- 
    Document   : bricks
    Created on : 22-Mar-2018, 14:46:13
    Author     : martin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Styk liste</title>
        <%@include file="includes/links.jsp" %>
    </head>

    <body>
        <div class="container">
            <h1>Styk liste</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Type</th>
                        <th>Side 1</th>
                        <th>Side 2</th>
                        <th>Side 3</th>
                        <th>Side 4</th>
                        <th>ialt x højde</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>2x1</td>
                        <c:set var="count1" value="0" scope="page" />
                        <c:forEach items="${bricks['2x1length']}" var="bricks">
                            <c:set var="count1" value="${count1 + 1}" scope="page"/>
                        </c:forEach>
                        <td>${count1}</td>
                        <c:set var="count2" value="0" scope="page" />
                        <c:forEach items="${bricks['2x1width']}" var="bricks">
                            <c:set var="count2" value="${count2 + 1}" scope="page"/>
                        </c:forEach>
                        <td>${count2}</td>
                        <td>${count1}</td>
                        <td>${count2}</td>
                        <c:set var="total" value="${(count1 * 2 + count2 * 2) * (height/2)}"/>
                        <td>${total}</td>
                    </tr>
                    <tr>
                        <td>2x2</td>
                        <c:set var="count1" value="0" scope="page" />
                        <c:forEach items="${bricks['2x2length']}" var="bricks">
                            <c:set var="count1" value="${count1 + 1}" scope="page"/>
                        </c:forEach>
                        <td>${count1}</td>
                        <c:set var="count2" value="0" scope="page" />
                        <c:forEach items="${bricks['2x2width']}" var="bricks">
                            <c:set var="count2" value="${count2 + 1}" scope="page"/>
                        </c:forEach>
                        <td>${count2}</td>
                        <td>${count1}</td>
                        <td>${count2}</td>
                        <c:set var="total" value="${(count1 * 2 + count2 * 2) * (height/2)}"/>
                        <td>${total}</td>
                    </tr>
                    <tr>
                        <td>2x4</td>
                        <c:set var="count1" value="0" scope="page" />
                        <c:forEach items="${bricks['2x4length']}" var="bricks">
                            <c:set var="count1" value="${count1 + 1}" scope="page"/>
                        </c:forEach>
                        <td>${count1}</td>
                        <c:set var="count2" value="0" scope="page" />
                        <c:forEach items="${bricks['2x4width']}" var="bricks">
                            <c:set var="count2" value="${count2 + 1}" scope="page"/>
                        </c:forEach>
                        <td>${count2}</td>
                        <td>${count1}</td>
                        <td>${count2}</td>

                        <c:set var="total" value="${(count1 * 2 + count2 * 2) * (height/2)}"/>
                        <td>${total}</td>
                    </tr>







                </tbody>
            </table>
            <a href="FrontController?command=vieworders">Tilbage</a>
        </div>
    </body>
</html>
