<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Add or Edit a Pattern" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<script>
    $(document).ready(function(){
        $("#designer").val("${patternDesigner}").attr('selected', 'selected');
    });
</script>
<html>
<body>
<c:choose>
    <c:when test="${user.isAdmin == 1}">
<div class="container w-50">
    <h2>Add/Edit Pattern</h2>
    <form id="editPatternForm" method="post" action="editPattern">
        <input type="hidden" id="id" name="id" value="${pattern.id}">

        <div class="form-group">
            <label for="name">Pattern name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${pattern.name}" required>
        </div>

        <div class="form-group">
            <label for="width">Pattern width:</label>
            <input type="number" class="form-control" id="width" name="width" value="${pattern.width}" required>

            <label for="height">Pattern height:</label>
            <input type="number" class="form-control" id="height" name="height" value="${pattern.height}" required>
        </div>

        <div class="form-group">
            <label for="size">Pattern size:</label>
            <input type="text" class="form-control" id="size" name="size" value="${pattern.size}" required>
        </div>

        <div class="form-group">
            <label for="number">Number of colors:</label>
            <input type="number" class="form-control" id="number" name="number" value="${pattern.numberOfColors}" required>
        </div>

        <div class="form-group">
            <label for="number">Keywords:</label>
            <input type="text" class="form-control" id="keywords" name="keywords" value="${pattern.keywords}" required>
        </div>

        <div class="form-group">
            <label for="features">Features:</label>
            <input type="text" class="form-control" id="features" name="features" value="${pattern.features}" required>
        </div>

        <div class="form-group">
            <label for="example">Stitched example available?</label>
            <input type="text" class="form-control" id="example" name="example" value="${pattern.stitchedExample}" required>
        </div>

        <div class="form-group">
            <label for="image">Image file name:</label>
            <input type="text" class="form-control" id="image" name="image" value="${pattern.image}" required>
        </div>

        <div class="form-group">
            <label for="url">Pattern URL</label>
            <input type="text" class="form-control" id="url" name="url" value="${pattern.url}" required>
        </div>

        <div class="form-group">
            <label for="designer">Pattern designer:</label>
            <select id="designer" class="form-control" name="designer" required>
                <c:forEach var="designer" items="${designers}">
                    <option value="${designer.id}">${designer.name}</option>
                </c:forEach>
            </select>
        </div>



        <button type="submit">Add / Update</button>
        <button type="reset">Clear</button>
    </form>
    </c:when>
    <c:otherwise>
        <h2>You must be an admin to view this page.</h2>
        <p><a href="index.jsp">Go back!</a></p>
    </c:otherwise>
    </c:choose>
</div>
</body>
</html>
