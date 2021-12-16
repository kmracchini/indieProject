<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Delete Designer" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
<body>
<div class="container">
<c:choose>
<c:when test="${user.isAdmin == 1}">
    <div class="mx-5 px-5">
<h2 class="mt-3">Delete a Pattern</h2>
<p>Are you sure you want to delete the following pattern?</p>
<ul>
    <li>ID: ${pattern.id}</li>
    <li>Name: ${pattern.name}</li>
    <li>Designer: ${pattern.designer.name}</li>
    <li><a href="images/${pattern.image}">Pattern image</li>
    <li><a href="${pattern.url}">Link to pattern</a></li>
</ul>
<form id="deletePattern" method="post" action="deletePattern">
    <input type="hidden" id="id" name="id" value="${pattern.id}">
    <input type="submit" value="Yes, delete it!">
</form>
    </div>
</c:when>
    <c:otherwise>
        <h2 class="mt-3">You must be an admin to view this page.</h2>
        <p><a href="index.jsp">Go back!</a></p>
    </c:otherwise>
</c:choose>
    </div>
</body>
</html>