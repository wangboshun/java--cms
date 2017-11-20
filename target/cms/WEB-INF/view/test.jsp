<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>test</title>
</head>
<body>
test
<h2>message:${message}</h2>
<h2>interceptor:${interceptor}</h2>
<h2>filter:${filter}</h2>
<c:forEach var="user" items="${list}">
    <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td><fmt:formatDate value="${user.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
    </tr>
</c:forEach>
</body>
</html>
