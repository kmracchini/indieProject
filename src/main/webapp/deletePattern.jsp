<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Delete Designer" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
<body>
<h2>Delete a Designer</h2>
<p>Are you sure you want to delete the following designer?</p>
<ul>
    <li>ID: ${designer.id}</li>
    <li>Name: ${designer.name}</li>
    <li>Website: ${designer.website}</li>
</ul>
<form id="deleteDesigner" method="post" action="deleteDesigner">
    <input type="hidden" id="id" name="id" value="${designer.id}">
    <input type="submit" value="Yes, delete it!">
</form>


</body>
</html>