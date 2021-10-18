<%@include file="head.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="All Patterns" />

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#patternTable').DataTable();
    } );
</script>

<html>
<body>
<div class="container-fluid">
<table id="patternTable" class="display">
    <thead>
    <th>Designer</th>
    <th>Name</th>
    <th>Size (WxH)</th>
    <th>Number of Colors</th>
    <th>Stitched Example</th>
    <th>Image</th>
    <th>Link</th>
    </thead>
    <tbody>
        <c:forEach var="pattern" items="${patterns}">
            <tr>
                <td>${pattern.designer.name}</td>
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
</div>
</body>
</html>
