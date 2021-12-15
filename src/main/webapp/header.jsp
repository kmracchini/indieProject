<nav class="navbar navbar-expand navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp">Stitchable</a>
  <ul class="navbar-nav">
    <li class="nav-item mx-3"><a class="nav-link" href="viewDesigners">Designers</a></li>
    <li class="nav-item mx-3"><a class="nav-link" href="allPatterns">Browse Patterns</a></li>
    <li class="nav-item mx-3"><a class="nav-link" href="search.jsp">Search Patterns</a></li>
    <c:choose>
      <c:when test="${!empty user.userName}">
        <li class="nav-item mx-3"><a class="nav-link" href="profile.jsp">Profile</a></li>
      </c:when>
    </c:choose>
    <c:choose>
      <c:when test="${user.isAdmin == 1}">
        <li class="nav-item mx-3"><a class="nav-link" href="admin">Administration</a></li>
      </c:when>
    </c:choose>
    <c:choose>
      <c:when test="${empty user.userName}">
        <li class="nav-item mx-3"><a class="nav-link" href="logIn">Sign Up / Log In</a></li>
      </c:when>
      <c:otherwise>
        <li class="nav-item mx-3"><a class="nav-link" href="logOut">Log Out</a></li>
      </c:otherwise>
    </c:choose>
  </ul>

</nav>

