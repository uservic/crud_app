<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">

<jsp:include page="fragments/header.jsp"/>

<body>

<h2><u>Home Page</u></h2>

<c:if test="${not empty param.message}" >
    <span style ="color:green">${param.message} </span>
</c:if>
<br/>
<br/>
<sec:authorize access="isAnonymous()">
    <table>
        <tr>
            <td>
                <a href="<c:url value="/user/register" />" >Register</a> |
            </td>
            <td>
                <a href="<c:url value="/login" />" style="color:blue">Sign in</a>
            </td>
        </tr>
    </table>
</sec:authorize>

</body>

<jsp:include page="fragments/footer.jsp"/>

</html>