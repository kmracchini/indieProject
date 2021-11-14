<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Add or Edit a Pattern" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
<body>
<div class="container-fluid">
    <h2>Add/Edit Pattern</h2>
    <form id="editPatternForm" method="post" action="">
        <input type="hidden" id="id" name="id" value="${pattern.id}">

        <div class="form-group">
            <label for="name">Pattern name:</label>
            <input type="text" id="name" name="name">
        </div>

        <div class="form-group">
            <label for="width">Pattern width:</label>
            <input type="number" id="width" name="width">

            <label for="height">Pattern height:</label>
            <input type="number" id="height" name="height">
        </div>

        <div class="form-group">
            <label for="number">Number of colors:</label>
            <input type="number" id="number" name="number">
        </div>

        <div class="form-group">
            <label for="number">Keywords:</label>
            <input type="text" id="keywords" name="keywords">
        </div>

        <div class="form-group">
            <input type="radio" name="features" id="fullStitches" value="Full Stitches Only">
            <label for="fullStitches">Full Stitches Only</label>

            <input type="radio" name="features" id="fullAndBackStitches" value="Full Stitches, Backstitching">
            <label for="fullAndBackStitches">Full Stitches, Backstitching</label>

            <input type="radio" name="features" id="backStitchOnly" value="Backstitch Only">
            <label for="backStitchOnly">Backstitch only</label>
        </div>

        <div class="form-group">
            Stitched example available?
            <input type="radio" id="yes" name="stitchedExample" value="Yes">
            <label for="yes">Yes</label>
            <input type="radio" id="no" name="stitchedExample" value="No">
            <label for="no">No</label>
        </div>

        <div class="form-group">
            <label for="image">Image file name:</label>
            <input type="text" id="image" name="image">
        </div>

        <div class="form-group">
            <label for="url">Pattern URL</label>
            <input type="text" id="url" name="url">
        </div>

        <div class="form-group">
            <label for="designer">Pattern designer:</label>
            <select id="designer" name="designer">
                <c:forEach var="designer" items="${designers}">
                    <option value="${designer.id}">${designer.name}</option>
                </c:forEach>
            </select>
        </div>



        <button type="submit">Add / Update</button>
        <button type="reset">Clear</button>
    </form>
</div>
</body>
</html>
