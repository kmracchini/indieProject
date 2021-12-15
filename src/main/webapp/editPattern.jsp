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
<div class="container">
<c:choose>
    <c:when test="${user.isAdmin == 1}">

        <div class="mx-5 px-5">
        <h2 class="mt-3">Add/Edit Pattern</h2>
        <form id="editPatternForm" method="post" action="editPattern" class="needs-validation" novalidate>
            <input type="hidden" id="id" name="id" value="${pattern.id}">

            <div class="form-group">
                <label for="name">Pattern name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${pattern.name}"
                       maxlength="30" required>
                <div class="invalid-feedback">Enter the name of the pattern - max 30 characters</div>
            </div>

            <div class="form-row">
                <div class="form-group col-6">
                    <label for="width">Pattern width:</label>
                    <input type="number" class="form-control" id="width" name="width" value="${pattern.width}" required>
                    <div class="invalid-feedback">Enter the pattern width in stitches</div>
                </div>
                <div class="form-group col-6">
                    <label for="height">Pattern height:</label>
                    <input type="number" class="form-control" id="height" name="height" value="${pattern.height}" required>
                    <div class="invalid-feedback">Enter the pattern height in stitches</div>
                </div>
            </div>

            <div class="form-row">
            <div class="form-group col-6">
                <label for="size">Pattern size:</label>
                <input type="text" class="form-control" id="size" name="size" value="${pattern.size}"
                       maxlength="6" required>
                <div class="invalid-feedback">Enter the pattern size: small, medium or large</div>
            </div>

            <div class="form-group col-6">
                <label for="number">Number of colors:</label>
                <input type="number" class="form-control" id="number" name="number" value="${pattern.numberOfColors}" required>
                <div class="invalid-feedback">Enter the number of colors used in the pattern</div>
            </div>
            </div>

            <div class="form-group">
                <label for="keywords">Keywords:</label>
                <input type="text" class="form-control" id="keywords" name="keywords" value="${pattern.keywords}"
                       maxlength="50" required>
                <div class="invalid-feedback">Enter search keywords for the pattern - max 50 characters</div>
            </div>

            <div class="form-group">
                <label for="features">Features:</label>
                <input type="text" class="form-control" id="features" name="features" value="${pattern.features}"
                       maxlength="50" required>
                <div class="invalid-feedback">Enter pattern features: full stitches, backstitching, etc. </div>
            </div>

            <div class="form-row">
            <div class="form-group col-3">
                <label for="example">Stitched example available?</label>
                <input type="text" class="form-control" id="example" name="example" value="${pattern.stitchedExample}"
                       maxlength="5" required>
                <div class="invalid-feedback">Enter if there is a stitched example of the pattern on the designer's website</div>
            </div>

            <div class="form-group col-9">
                <label for="image">Image file name:</label>
                <input type="text" class="form-control" id="image" name="image" value="${pattern.image}"
                       maxlength="40" required>
                <div class="invalid-feedback">Enter the image file name - max 40 characters</div>
            </div>
            </div>

            <div class="form-group">
                <label for="url">Pattern URL</label>
                <input type="text" class="form-control" id="url" name="url" value="${pattern.url}"
                       maxlength="100" required>
                <div class="invalid-feedback">Enter the URL for the pattern - max 100 characters</div>
            </div>

            <div class="form-group">
                <label for="designer">Pattern designer:</label>
                <select id="designer" class="form-control" name="designer" required>
                    <c:forEach var="designer" items="${designers}">
                        <option value="${designer.id}">${designer.name}</option>
                    </c:forEach>
                </select>
                <div class="invalid-feedback">You must select a pattern designer</div>
            </div>

            <input type="submit" class="btn btn-primary" value="Add / Update">
            <input type="reset" class="btn btn-light" value="Clear">
        </form>
        </div>
    </c:when>
    <c:otherwise>
        <h2 class="mt-3">You must be an admin to view this page.</h2>
        <p><a href="index.jsp">Go back!</a></p>
    </c:otherwise>
</c:choose>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
