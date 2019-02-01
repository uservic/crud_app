<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<c:set var="regTrue" value="New User Registration"/>
<c:set var="regFalse" value="${userTo.login} Profile"/>

<div style="margin-left: 30px">
<table>
    <tr>
        <td>
            <h2> ${register ? regTrue : regFalse}&nbsp;&nbsp;&nbsp; </h2>
        </td>
        <td>

        </td>
    </tr>
</table>
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
            <td><input type="submit" value="Save"></td>
        </tr>
    </table>
    <br>
</form:form>
</div>

<jsp:include page="fragments/footer.jsp"/>

</body>

</html>