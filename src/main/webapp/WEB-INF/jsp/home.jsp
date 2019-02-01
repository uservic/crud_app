<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<div style="margin: 10px;"><h3>Welcome!</h3></div>

<c:if test="${not empty param.message}">
    <div style="margin-left: 30px;"><span style="color:green">${param.message} </span></div>
    <br>
</c:if>

<sec:authorize access="isAnonymous()">
    <nav class="navbar navbar-light bg-light">
        <form class="form-inline">
            <div class="btn-toolbar" role="toolbar">
                <div class="btn-group mr-2" role="group" aria-label="First group">
                    <a href="user/register" class="btn btn-sm btn-success" type="button">Register</a>
                </div>
                <div class="btn-group mr-2" role="group" aria-label="First group">
                    <a href="login" class="btn btn-sm align-middle btn-outline-secondary" type="submit">Sign In</a>
                </div>
            </div>
        </form>
    </nav>
</sec:authorize>

</body>

<jsp:include page="fragments/footer.jsp"/>

</html>