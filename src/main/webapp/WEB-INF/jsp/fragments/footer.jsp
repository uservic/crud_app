<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sec:authorize access="isAuthenticated()">
    You are authenticated!
    <a href="<c:url value="/logout" />">Logout</a>
</sec:authorize>