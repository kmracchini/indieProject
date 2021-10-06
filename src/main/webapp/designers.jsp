<%@include file="head.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html><body>

<h1>Designers! I hope. </h1>

<c:forEach var="designer" items="${designers}">
    <h2>${designer.name}</h2>
    <p>${designer.website}</p>
</c:forEach>
</body></html>
