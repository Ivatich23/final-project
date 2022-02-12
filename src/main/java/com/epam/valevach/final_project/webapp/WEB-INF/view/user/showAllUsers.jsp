<!DOCTYPE html>
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
<fmt:message bundle="${res}" key="IncorrectUserRole" var="IncorrectUserRole"/>

<html>
<body>
    <c:if test="${message.equals('Incorrect input userRole')}">
        <p> <c:out value="${IncorrectUserRole}"/><p>
    </c:if>

<link href="/static/css/tableStyle.css" rel="stylesheet" type="text/css">
<h2> ${usersList} </h2>

<table class="table">
    <tr>
        <th>${userNumber}</th>
        <th>${login}</th>
        <th>${role}</th>
       <c:if test="${user.getUserRole().equals('admin')}">
                   <p> <th>${update}</th></p>
               </c:if>
               <c:if test="${user.getUserRole().equals('admin')}">
                           <p> <th>${delete}</th></p>
               </c:if>
    </tr>
    <c:forEach var="user" items = "${userServ.showAllUsersInfo()}">
        <c:url var = "updateButton" value = "/updateUsers">
            <c:param name = "action" value = "update"/>
            <c:param name = "userId" value = "${user.getId()}"/>
        </c:url>
        <c:url var = "deleteButton" value = "/updateUsers" >
        <c:param name = "action" value = "delete"/>
        <c:param name = "userId" value = "${user.getId()}"/>
        </c:url>
        <tr>
            <td>${user.getId()}</td>
             <td>${user.getLogin()}</d>
             <td>${user.getUserRole()}</td>
            <td>
            <input type  = "button" value = "${update}"
            onClick = "window.location.href = '${updateButton}'"/>
            </td>
             <td>
             <input type  = "button" value = "${delete}"
             onClick = "window.location.href = '${deleteButton}'"/>
              </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>