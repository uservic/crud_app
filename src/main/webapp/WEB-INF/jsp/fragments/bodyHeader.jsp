<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:url value="/" var="homePath"/>

<nav class="navbar navbar-expand-md navbar-light bg-light">
    <a class="navbar-brand" href="${homePath}"><h2 style="color:red">Internship Application</h2></a>

    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li class="nav-item dropdown">
                    <button class="btn btn-primary btn-sm dropdown-toggle" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Edit tables
                    </button>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${homePath}admin/users">Users</a>
                        <a class="dropdown-item" href="${homePath}admin/dicts">Dictionaries</a>
                    </div>
                </li>
            </sec:authorize>
        </ul>
    </div>
</nav>

