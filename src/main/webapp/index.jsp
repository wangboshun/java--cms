<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>

<html>
<body>
<h2>Hello World!</h2>

<%
    ServletContext context = session.getServletContext();
    Integer count = (Integer) context.getAttribute("count");
%>
<%=count %>
<br/>
当前用户：${user}

</body>
</html>
