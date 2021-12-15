<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="View All Patterns" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>


<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#patternTable').DataTable();
    } );
</script>

<html>
<body>
<div class="container-fluid">
    <div class="mx-5">
        <h2>All Patterns</h2>
        <table id="patternTable" class="display">
            <thead>
            <th>Designer</th>
            <th>Name</th>
            <th>Size (WxH)</th>
            <th>Number of Colors</th>
            <th>Stitched Example</th>
            <th>Image</th>
            <th>Link</th>
            <c:if test="${user.userName != null}">
                <th>Favorite</th>
            </c:if>

            </thead>
            <tbody>
            <c:forEach var="pattern" items="${patterns}">
                <tr>
                    <td>${pattern.designer.name}</td>
                    <td>${pattern.name}</td>
                    <td>${pattern.size} - ${pattern.width} x ${pattern.height}</td>
                    <td>${pattern.numberOfColors}</td>
                    <td>${pattern.stitchedExample}</td>
                    <td><a href="images/${pattern.image}">Pattern image</a></td>
                    <td><a href="${pattern.url}">Link to pattern</a></td>
                    <c:if test="${user.userName != null}">
                        <td><a href="addFavorite?id=${pattern.id}">Add to Favorites</a></td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
