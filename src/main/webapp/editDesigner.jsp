<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Add or Edit a Designer" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
<body>
<div class="container-fluid">
  <div class="mx-5">
    <c:choose>
      <c:when test="${user.isAdmin == 1}">

        <h2>Add/Edit Designer</h2>
        <form id="editDesignerForm" method="post" action="editDesigner" class="needs-validation" novalidate>
          <div class="form-group">
            <input type="hidden" id="id" name="id" value="${designer.id}">
            <label for="name">Designer name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${designer.name}"
                   maxlength="30" required>
            <div class="invalid-feedback">Enter a designer name - max 30 characters</div>
          </div>

          <div class="form-group">
            <label for="website">Designer website:</label>
            <input type="text" class="form-control" id="website" name="website" value="${designer.website}"
                   maxlength="50" required>
            <div class="invalid-feedback">Enter the designer's website - max 50 characters</div>
          </div>

          <div class="form-group">
            <label for="logo">Logo:</label>
            <input type="text" class="form-control" name="logo" id="logo" value="${designer.logo}"
                   maxlength="25" required>
            <div class="invalid-feedback">Enter the filename for the designer's logo</div>
          </div>

          <div class="form-group">
            <label for="etsyId">Etsy shop ID:</label>
            <input type="text" class="form-control" id="etsyId" name="etsyId" value="${designer.etsyId}" required>
            <div class="invalid-feedback">Enter the designer's Etsy Shop ID</div>
          </div>



          <input type="submit" class="btn btn-primary" value="Add / Update">
          <input type="reset" class="btn btn-light" value="Clear">
        </form>
      </c:when>
      <c:otherwise>
        <h2>You must be an admin to view this page.</h2>
        <p><a href="index.jsp">Go back!</a></p>
      </c:otherwise>
    </c:choose>
  </div>
</div>

<%@include file="footer.jsp"%>
</body>
</html>
