<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${language.equals('ru')}">
    <p><fmt:setLocale value="ru"/></p>
</c:if>
<c:if test="${language.equals('en')}">
    <p><fmt:setLocale value="en"/></p>
</c:if>

<fmt:setBundle basename="resources" var="res"/>
<fmt:message bundle="${res}" key="enterDetails" var="enterDetails"/>
<fmt:message bundle="${res}" key="id" var="id"/>
<fmt:message bundle="${res}" key="position" var="position"/>
<fmt:message bundle="${res}" key="departmentName" var="departmentName"/>
<fmt:message bundle="${res}" key="save" var="save"/>
<body>

<h2>${enterDetails}</h2>
 <form method="post" action="/updateDep">
 <dd><input type="hidden" name="action" value="new"  /></dd>
        <dl>
            <dt>${departmentName}: </dt>
            <dd><input type="text" name="depName" maxlength="15"
              required placeholder=""/></dd>
        </dl>
        <dl>
            <dt>${position}: </dt>
            <dd><input type="text" name="depPosition" maxlength="15"
              required placeholder=""/></dd>
        </dl>

        <button type="submit">${save}</button>
    </form>

</body>
</html>