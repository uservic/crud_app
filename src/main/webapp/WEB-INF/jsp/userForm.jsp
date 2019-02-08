<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<br>
<c:set var="update" value="Update ${userTo.login}'s Profile"/>

<div class="container">
    <table>
        <tr>
            <td>
                <h2> ${create ? "Add New User" : update}&nbsp;&nbsp;&nbsp; </h2>
            </td>
        </tr>
    </table>
    <form:form modelAttribute="userTo" method="post"
               action="${create ?'createUser':'updateUser'}">
        <form:hidden path="id"/>
        <table>
            <tr>
                <td><form:label path="login">Login</form:label></td>
                <td><form:input path="login"/></td>
                <td><form:errors path="login" cssStyle="color: red"/></td>
                <c:if test="${not empty errMsg}">
                    <span class="error message " style="color: red">${errMsg}</span>
                </c:if>
            </tr>
            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td>Role</td>
                <td>
                <form:select path="role">
                    <form:options items="${roles}" itemValue="name" itemLabel="name"/>
                </form:select>
                </td>
            </tr>
            <tr>
                <td><input type="button" value="Cancel" onclick="window.history.back()"></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
<br>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>