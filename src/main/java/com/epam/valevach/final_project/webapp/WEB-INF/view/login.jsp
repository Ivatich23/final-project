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
<fmt:message bundle="${res}" key="singUp" var="singUp"/>
<fmt:message bundle="${res}" key="enterLogin" var="enterLogin"/>
<fmt:message bundle="${res}" key="enterPassword" var="enterPassword"/>
<fmt:message bundle="${res}" key="save" var="save"/>
<fmt:message bundle="${res}" key="logOff" var="logOff"/>
<fmt:message bundle="${res}" key="loginError" var="loginError"/>
<h2>${singUp}</h2>
<br><br>
 <form method="post" action="/login">

        <dl>
         <c:if test="${errorLogin.equals('This login is incorrect,try again')}">
                            <p> <c:out value="${loginError}"/><p>
                 </c:if>
        <dt>${enterLogin}: </dt>
            <dd><input type="text" name="login"  min="1" max="999999"
              required placeholder=""/></dd>
        </dl>

         <dl>
             <dt>${enterPassword}: </dt>
             <dd><input type="number" name="password"  min="1" max="99999999"
               required placeholder=""/></dd>
                </dl>
        <button type="submit">${save}</button>
        <br><br>
        <c:if test="${user.getUserRole()!=null}">
                    <a href="/singOut"> ${logOff}</a>
         </c:if>
        <br><br>
    </form>

</body>
</html>