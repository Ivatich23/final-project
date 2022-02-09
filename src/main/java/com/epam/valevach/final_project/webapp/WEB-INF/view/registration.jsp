<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<c:if test="${language.equals('ru')}">
    <p><fmt:setLocale value="ru"/></p>
</c:if>
<c:if test="${language.equals('en')}">
    <p><fmt:setLocale value="en"/></p>
</c:if>
<fmt:setBundle basename="resources" var="res"/>
<fmt:message bundle="${res}" key="singIn" var="singIn"/>
<fmt:message bundle="${res}" key="enterLogin" var="enterLogin"/>
<fmt:message bundle="${res}" key="enterPassword" var="enterPassword"/>
<fmt:message bundle="${res}" key="save" var="save"/>
<fmt:message bundle="${res}" key="invalidLogin" var="invalidLogin"/>
<h2><c:if test="${error.equals('invalid login,try again')}">
    <p>${invalidLogin}</p>
</c:if></h2>
<h2>${singIn}</h2>

 <form method="post" action="/reg">
        <dl>
            <dt>${enterLogin}: </dt>
            <dd><input type="text" name="login"  /></dd>
        </dl>
         <dl>
             <dt>${enterPassword}: </dt>
             <dd><input type="text" name="password"   /></dd>
                </dl>
        <button type="submit">${save}</button>
    </form>



</body>
</html>