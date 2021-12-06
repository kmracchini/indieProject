<nav class="navbar navbar-expand navbar-light bg-light">
  <ul class="navbar-nav mr-auto">
    <li class="nav-item mx-2"><a class="nav-link" href="index.jsp">Home</a></li>
    <li class="nav-item mx-2"><a class="nav-link" href="viewDesigners">Designers</a></li>
    <li class="nav-item mx-2"><a class="nav-link" href="allPatterns">Browse Patterns</a></li>
    <li class="nav-item mx-2"><a class="nav-link" href="search.jsp">Search Patterns</a></li>
    <c:choose>
      <c:when test="${empty user.userName}">
        <li class="nav-item mx-2"><a class="nav-link" href="logIn">Log In</a></li>
      </c:when>
      <c:otherwise>
        <li class="nav-item mx-2"><a class="nav-link" href="profile.jsp">Your Profile</a></li>
      </c:otherwise>
    </c:choose>


  </ul>
</nav>

