<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body>
<form method="POST" action="<%=request.getContextPath()%>/testservlet">
    <input type="text" name="username"/>
    <br/><input type="submit" value="登录"/>
</form>
</body>
</html>