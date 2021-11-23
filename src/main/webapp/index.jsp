<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Stitchable" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>


<html>
<body>
<h2>Hello World!</h2>
<p><a href="viewDesigners">View Designers</a></p>
<p><a href="viewPatterns">View Patterns</a></p>
<c:choose>
    <c:when test="${empty userName}">
        <p><a href="logIn">Log In</a></li>
    </c:when>
    <c:otherwise>
        <li class="nav-item mx-2">Hello ${userName}</li>
    </c:otherwise>
</c:choose>
</body>
</html>
