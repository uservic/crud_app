<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">
    <br>
    <h2>Dictionaries</h2>
    <a class="btn btn-outline-success btn-sm" href="<c:url value="/admin/createDict"/>"
       role="button">Add User</a>
    <br>
    <br>

    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Discriminator</th>
            <th scope="col">Name</th>
            <th scope="col">Ext_id</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dicts}" var="dict">
            <tr>
                <td>${dict.classSimpleName}</td>
                <td>${dict.name}</td>
                <td>${dict.ext_id}</td>
                <td>
                    <spring:url value="/admin/deleteDict/${dict.id}" var="deleteDict"/>
                    <spring:url value="/admin/updateDict?id=${dict.id}" var="updateDict"/>

                    <form class="form-inline" method="post" action="${deleteDict}">
                        <button class="btn btn-danger btn-sm" type="submit">Delete</button>
                        <a class="btn btn-warning btn-sm" href="${updateDict}" role="button">Update</a>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</body>

<jsp:include page="fragments/footer.jsp"/>

</html>