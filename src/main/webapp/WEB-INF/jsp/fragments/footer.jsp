<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sec:authorize access="isAuthenticated()">
    <nav class="navbar navbar-light bg-light navbar-expand-md">
        <span class="navbar-brand mb-0" style="font-size: smaller">
            You are authenticated as <sec:authentication property="principal.role.name"/>
        </span>

        <form class="form-inline">
            <a href="<c:url value="/logout" />" class="btn btn-sm btn-danger " type="button">Logout</a>
        </form>
        <form class="form-inline">
            <a href="<c:url value="/user/profile"/>" class="btn btn-sm btn-primary" type="button">My
                profile</a>
        </form>

        <span class="navbar-brand mb-0" style="font-size: smaller; margin-left: 15px"  >
            <c:if test="${param.changed}">
                <span style="color:green">Profile changed.</span>
            </c:if>
        </span>
    </nav>
</sec:authorize>