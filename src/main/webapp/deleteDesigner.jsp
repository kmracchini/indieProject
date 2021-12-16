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
<h2 class="mt-3">Delete a Designer</h2>
<p>Are you sure you want to delete the following designer? This will cause all patterns by this designer to be deleted also.  </p>
<ul>
    <li>ID: ${designer.id}</li>
    <li>Name: ${designer.name}</li>
    <li>Website: ${designer.website}</li>
</ul>
<form id="deleteDesigner" method="post" action="deleteDesigner">
    <input type="hidden" id="id" name="id" value="${designer.id}">
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