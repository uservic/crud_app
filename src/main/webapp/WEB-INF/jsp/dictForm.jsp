<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">

<jsp:include page="fragments/headTag.jsp"/>

<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<c:set var="update" value="Update Dictionary: ${dictTo.classSimpleName}"/>

<div class="container">

    <br>
    <table>
        <tr>
            <td>
                <h2> ${create ? "Add New Dictionary" : update}&nbsp;&nbsp;&nbsp; </h2>
            </td>
        </tr>
    </table>
    <form:form modelAttribute="dictTo" method="post"
               action="createOrUpdateDict">
        <form:hidden path="id"/>
        <form:hidden path="ext_id"/>
        <table>
            <tr>
                <td><form:label path="dictionaryType">Dictionary Type</form:label></td>
                <td>
                    <form:select path="dictionaryType">
                        <form:options items="${dictTypes}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td><input type="button" value="Cancel" onclick="window.history.back()"></td>
                <td><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
    <br>
</div>
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>