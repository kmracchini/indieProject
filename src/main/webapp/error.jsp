<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" import="java.io.*" contentType="text/html" %>
<c:set var="title" value="Error" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html>
<body>
<div class="container-fluid">
    <div class="mx-5">
        <h2>Sorry about that! We've got an error.</h2>
        <p><a href="index.jsp">Want to try that again?</a></p>
    </div>
</div>




</body>
</html>
