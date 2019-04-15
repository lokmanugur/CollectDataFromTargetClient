<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 
    Document   : index
    Created on : Feb 13, 2019, 1:04:38 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <form name="index" action="index" method="POST" >
            <ul>
                <li><label>Write Your Domain Name:</label> <input type="text" name="domain_name" /></li>
                <li><label></label> <input type="submit" name="submit" value="OK" class="btn"></li>
            </ul>
        </form>
        <c:forEach items="${message}" var="item">
            ${item}<br>
        </c:forEach>
    </body>
</html>
