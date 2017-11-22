<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>

<html>
<body>

<head>
    <script type="text/javascript" charset="utf-8" src="/resources/lib/ueditor/neditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/lib/ueditor/neditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="/resources/lib/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>

<h2>Hello World!</h2>

<%
    ServletContext context = session.getServletContext();
    Integer count = (Integer) context.getAttribute("count");
%>
<%=count %>
<br/>
当前用户：${user}

<h1>完整demo</h1>
<textarea id="editor"  style="width:1024px;height:500px;"></textarea>


<script type="text/javascript">
    var ue = UE.getEditor('editor');
</script>
</body>
</html>
