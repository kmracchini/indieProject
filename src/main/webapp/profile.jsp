<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Your profile" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>
<html>
<body>
<!--TODO: This doesn't work either! -->

<c:choose>
  <c:when test="${empty user.userName}">
    <h2><a href="logIn">You need to log in to view this page.</a></h2>
  </c:when>
  <c:otherwise>
    <h2>${user.userName}'s Profile</h2>
  </c:otherwise>
</c:choose>

</body>
</html>
