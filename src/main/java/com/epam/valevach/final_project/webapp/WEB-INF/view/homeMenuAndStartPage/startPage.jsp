
<!DOCTYPE html>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<body>
 <p> <c:out value="${message}"/><p>
   <c:if test="${language.equals('ru')}">
       <p><fmt:setLocale value="ru"/></p>
   </c:if>
   <c:if test="${language.equals('en')}">
       <p><fmt:setLocale value="en"/></p>
   </c:if>
   <fmt:setBundle basename="resources" var="res"/>
   <fmt:message bundle="${res}" key="ChooseLanguage" var="ChooseLanguage"/>
   <fmt:message bundle="${res}" key="english" var="english"/>
   <fmt:message bundle="${res}" key="russian" var="russian"/>
   <fmt:message bundle="${res}" key="singIn" var="singIn"/>
   <fmt:message bundle="${res}" key="singUp" var="singUp"/>
   <fmt:message bundle="${res}" key="homePage" var="homePage"/>
   <fmt:message bundle="${res}" key="logOff" var="logOff"/>
<form method="get" action="/reg">
<a href="/homeMenu">${homePage}</a>
 <br><br>
   <c:if test="${user.getUserRole()!=null}">
    <a href="/singOut"> ${logOff}</a>
   </c:if>
    <br><br>
  <c:if test="${user.getUserRole()==null}">
    <a href="/reg"> ${singIn}</a>
  </c:if>
  <br><br>
 <c:if test="${user.getUserRole()==null}">
     <a href="/login">${singUp}</a>
  </c:if>
<br><br>

</body>
</html>