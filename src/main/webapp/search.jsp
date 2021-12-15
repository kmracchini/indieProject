<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Search Patterns" />
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
        <h2>Search for a pattern</h2>
        <p>You can find patterns listed by designer <a href="allPatterns">here</a></p>
        <form action="search" class="form-inline" method="get">
            <div class="form-group">
                <select name="type" class="form-control">
                    <option value="size">Size</option>
                    <option value="keywords">Keywords</option>
                    <option value="colorsMax"># of colors (max)</option>
                    <option value="colorsMin"># of colors (min)</option>
                </select>
            </div>

            <input class="form-control" type="text" name="searchTerm" id="searchTerm" placeholder="Search value" required><br>
            <button type="submit" name="submit" id="submit" value="search" class="btn btn-primary mx-2">Search Patterns</button>
        </form>

        <c:if test="${patterns == null}">
            <h3>Search usage</h3>
            <ul>
                <li>Size parameters (in stitches):</li>
                <ul>
                    <li>Small:  Less than 50w x 50h </li>
                    <li>Medium: Less than 100w x 100h</li>
                    <li>Large: Larger than 100w x 100h</li>
                </ul>
                <li>Keywords: in beta. Try looking for halloween patterns!</li>
                <li>Number of colors (max) searches for patterns with <em>at most</em> that number of colors. Number of colors (min) searches for patterns with <em>at least</em> that number of patterns. Both searches are inclusive. If you search for 5 (max) you will see patterns with five or fewer colors used.  </li>
            </ul>
        </c:if>

        <p></p>

        <c:if test="${patterns != null}">
            <h3>Patterns:</h3>
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
                        <td>${pattern.width} x ${pattern.height}</td>
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
        </c:if>
    </div>
    </div>
</body>
</html>
