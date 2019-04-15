<%-- 
    Document   : search
    Created on : Apr 15, 2019, 1:50:28 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
                    <c:forEach items="${message}" var="emp">
               <div><c:out value="${emp}"/></div>
            </c:forEach>
    </body>
</html>

