<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="View All Designers" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>


<html><body>

<div class="mx-5">
    <h1>Designers</h1>
    <div class="row">
        <c:forEach var="designer" items="${designers}">
            <div class="card text-center col-6 col-md-3 p-1 m-2">
                <img class="img-fluid rounded mx-auto my-1 d-block w-75" src="images/${designer.logo}" alt="${designer.name} logo"/>
                <div class="card-body">
                    <h2 class="card-title">${designer.name}</h2>
                    <p class="card-text"><a href="designerProfile?id=${designer.id}">View designer profile</a></p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body></html>
