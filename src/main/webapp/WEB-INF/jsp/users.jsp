<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="container">

    <br>
    <h2>Users</h2>
    <a class="btn btn-outline-success btn-sm" href="<c:url value="/admin/createUser"/>"
       role="button">Add User</a>
    <br>
    <br>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#ID</th>
            <th scope="col">Login</th>
            <th scope="col">Password</th>
            <th scope="col">Role</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.role.authority}</td>
                <td>
                    <spring:url value="/admin/deleteUser/${user.id}" var="deleteUser"/>
                    <spring:url value="/admin/updateUser?id=${user.id}" var="updateUser"/>

                    <form class="form-inline" method="post" action="${deleteUser}">
                        <button class="btn btn-danger btn-sm" type="submit">Delete</button>
                        <a class="btn btn-warning btn-sm" href="${updateUser}" role="button">Update</a>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<br>
</body>

<jsp:include page="fragments/footer.jsp"/>

</html>