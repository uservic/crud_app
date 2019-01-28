<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

<jsp:include page="fragments/header.jsp"/>

<body>
<c:set var="regTrue" value="New User Registration"/>
<c:set var="regFalse" value="${userTo.login} Profile"/>

<h2> ${register ? regTrue : regFalse} </h2>

<c:if test="${param.changed}" >
    <span style ="color:green">Profile changed.</span>
</c:if>
<br>
<br>

<form:form modelAttribute="userTo" method="post"
           action="${register ? 'register' : 'profile'}">
    <table>
        <tr>
            <td><form:label path="login">Login</form:label></td>
            <td><form:input path="login"/></td>
            <td><form:errors path="login" cssStyle="color: red" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password" cssStyle="color: red" /></td>
        </tr>
        <tr>
            <td><input type="button" value="Cancel" onclick="window.history.back()"></td>
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
</form:form>

<jsp:include page="fragments/footer.jsp"/>

</body>

</html>