<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<h2>Users</h2>
<a href="<c:url value="/admin/createUser" />" style="color:green">Add User</a>
<br>
<br>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role.authority}</td>
            <td>
                <%--<a href="<c:url value="/admin/deleteUser/${user.id}" />" style="color:darkred">delete</a>--%>
                <spring:url value="/admin/deleteUser/${user.id}" var="deleteUser"/>
                <input type="submit" class="button" name="deleteButton" value="${deleteUser}"/>
            </td>
            <td><a href="<c:url value="/admin/updateUser?id=${user.id}" />" style="color:blue">update</a></td>
        </tr>
    </c:forEach>
</table>

<br>
</body>

<jsp:include page="fragments/footer.jsp"/>

</html>