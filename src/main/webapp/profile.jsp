<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Your profile" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html>
<body>
<!--TODO: This needs to be snazzed up! -->

<c:choose>
  <c:when test="${empty user.userName}">
    <h2><a href="logIn">You need to log in to view this page.</a></h2>
  </c:when>
  <c:otherwise>
    <h2>${user.name}'s Profile</h2>

    <h3>Favorite Patterns</h3>
    <table id="patternTable" class="display">
      <thead>
      <th>Name</th>
      <th>Size (WxH)</th>
      <th>Number of Colors</th>
      <th>Stitched Example</th>
      <th>Image</th>
      <th>Link</th>
      </thead>
      <tbody>
      <c:forEach var="pattern" items="${user.favoritePatterns}">
        <tr>
          <td>${pattern.name}</td>
          <td>${pattern.width} x ${pattern.height}</td>
          <td>${pattern.numberOfColors}</td>
          <td>${pattern.stitchedExample}</td>
          <td><a href="images/${pattern.image}">Pattern image</a></td>
          <td><a href="${pattern.url}">Link to pattern</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </c:otherwise>
</c:choose>


</body>
</html>
