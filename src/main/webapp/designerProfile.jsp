<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="${designer.name}" />
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
    <h2>Designer Profile - ${designer.name}</h2>
    <p><a href="${designer.website}">Designer's Website</a></p>
    <div class="container-md">
        <h3>Etsy Shop</h3>
        <img src="${icon}" class="float-left img-thumbnail w-25"/>
        <p>Etsy shop: <a href="${shopURL}">${shopName}</a> - currently has ${listings} items for sale!</p>
    </div>


    <h3>Free Patterns by ${designer.name}</h3>
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
        <c:forEach var="pattern" items="${designer.patterns}">
            <tr>
                <td>${pattern.name}</td>
                <td>${pattern.size} (${pattern.width} x ${pattern.height})</td>
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
