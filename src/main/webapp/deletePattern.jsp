<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Delete Designer" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
<body>
<c:choose>
<c:when test="${user.isAdmin == 1}">
<h2>Delete a Pattern</h2>
<p>Are you sure you want to delete the following pattern?</p>
<ul>
    <li>ID: ${pattern.id}</li>
    <li>Name: ${pattern.name}</li>
    <li>Designer: ${pattern.designer.name}</li>
</ul>
<form id="deletePattern" method="post" action="deletePattern">
    <input type="hidden" id="id" name="id" value="${pattern.id}">
    <input type="submit" value="Yes, delete it!">
</form>
</c:when>
    <c:otherwise>
        <h2>You must be an admin to view this page.</h2>
        <p><a href="index.jsp">Go back!</a></p>
    </c:otherwise>
</c:choose>

</body>
</html>