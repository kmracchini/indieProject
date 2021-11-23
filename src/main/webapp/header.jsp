<nav class="navbar navbar-expand navbar-light bg-light">
  <ul class="navbar-nav mr-auto">
    <li class="nav-item mx-2"><a class="nav-link" href="index.jsp">Home</a></li>
    <li class="nav-item mx-2"><a class="nav-link" href="viewDesigners">Designers</a></li>
    <li class="nav-item mx-2"><a class="nav-link" href="allPatterns">Patterns</a></li>
    <c:choose>
      <c:when test="${empty userName}">
        <li class="nav-item mx-2"><a class="nav-link" href="logIn">Log In</a></li>
      </c:when>
      <c:otherwise>
        <li class="nav-item mx-2"><a class="nav-link">Hello ${userName}</a></li>
      </c:otherwise>
    </c:choose>


  </ul>
</nav>

