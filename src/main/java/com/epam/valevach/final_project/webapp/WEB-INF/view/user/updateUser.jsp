<!DOCTYPE html>
<html>
<body>
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
<fmt:message bundle="${res}" key="usersList" var="usersList"/>
<fmt:message bundle="${res}" key="userNumber" var="userNumber"/>
<fmt:message bundle="${res}" key="login" var="login"/>
<fmt:message bundle="${res}" key="role" var="role"/>
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="logOff" var="logOff"/>
<fmt:message bundle="${res}" key="enterDetails" var="enterDetails"/>
<fmt:message bundle="${res}" key="save" var="save"/>
<h2>${enterDetails}</h2>

 <form method="post" action="/updateUsers">


             <dd><input type="hidden" name="id" value="${newUser.getId()}"  /></dd>
        <dl>
            <dt>${role}: </dt>
            <dd><input type="number" name="role" value="${newUser.getRole()}"  min="1" max="9999"
              required placeholder=""/></dd>
        </dl>


        <button type="submit">${save}</button>
    </form>

</body>
</html>