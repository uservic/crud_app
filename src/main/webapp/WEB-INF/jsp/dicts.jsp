<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<h2>Dictionaries</h2>
<a href="<c:url value="/admin/createDict" />" style="color:green">Add Dictionary</a>
<br>
<br>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Discriminator</th>
        <th>Name</th>
        <th>Ext_id</th>
    </tr>
    <c:forEach items="${dicts}" var="dict">
        <tr>
            <td>${dict.classSimpleName}</td>
            <td>${dict.name}</td>
            <td>${dict.ext_id}</td>
            <%--<td><a href="<c:url value="/admin/deleteDict/${dict.id}" />" style="color:darkred">delete</a></td>--%>
            <td><spring:url value="/admin/deleteDict/${dict.id}" >delete</spring:url></td>
            <td><a href="<c:url value="/admin/updateDict?id=${dict.id}" />" style="color:blue">update</a></td>
        </tr>
    </c:forEach>
</table>

<br>
</body>

<jsp:include page="fragments/footer.jsp"/>

</html>