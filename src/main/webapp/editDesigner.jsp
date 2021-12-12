<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Add or Edit a Designer" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
<body>
<c:choose>
<c:when test="${user.isAdmin == 1}">
<div class="container-fluid">
  <h2>Add/Edit Designer</h2>
  <form id="editDesignerForm" method="post" action="editDesigner">
    <div class="form-group">
      <input type="hidden" id="id" name="id" value="${designer.id}">
      <label for="name">Designer name:</label>
      <input type="text" class="form-control" id="name" name="name" value="${designer.name}">
    </div>

    <div class="form-group">
      <label for="website">Designer website:</label>
      <input type="text" class="form-control" id="website" name="website" value="${designer.website}">
    </div>

    <div class="form-group">
      <label for="logo">Logo:</label>
      <input type="text" class="form-control" name="logo" id="logo" value="${designer.logo}">
    </div>

    <div class="form-group">
      <label for="etsyId">Etsy shop ID:</label>
      <input type="text" class="form-control" id="etsyId" name="etsyId" value="${designer.etsyId}">
    </div>



    <button type="submit">Add / Update</button>
    <button type="reset">Clear</button>
  </form>
  </c:when>
  <c:otherwise>
    <h2>You must be an admin to view this page.</h2>
    <p><a href="index.jsp">Go back!</a></p>
  </c:otherwise>
  </c:choose>
</div>
</body>
</html>
