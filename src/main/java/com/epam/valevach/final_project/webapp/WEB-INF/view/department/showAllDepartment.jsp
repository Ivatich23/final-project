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
<fmt:message bundle="${res}" key="departmentList" var="departmentList"/>
<fmt:message bundle="${res}" key="departmentId" var="departmentId"/>
<fmt:message bundle="${res}" key="position" var="position"/>
<fmt:message bundle="${res}" key="departmentName" var="departmentName"/>
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="newDepartment" var="newDepartment"/>
<html>
<body>
<p> <c:out value="${error}"/><p>
<link href="/static/css/tableStyle.css" rel="stylesheet" type="text/css">
<h2> ${departmentList} </h2>
 <c:url var = "createButton" value = "/updateDep">
 <c:param name = "action" value = "newDep"/>
</c:url>
<table class="table">
    <tr>
        <th>${departmentId}</th>
        <th>${position}</th>
        <th>${departmentName}</th>
        <c:if test="${user.getUserRole().equals('admin')}">
            <p> <th>${update}</th></p>
        </c:if>
        <c:if test="${user.getUserRole().equals('admin')}">
                    <p> <th>${delete}</th></p>
        </c:if>
    </tr>
    <c:forEach var="dep" items = "${depService.showAllDepartments()}">
        <c:url var = "updateButton" value = "/updateDep">
            <c:param name = "action" value = "update"/>
            <c:param name = "depId" value = "${dep.getDepId()}"/>
        </c:url>
        <c:url var = "deleteButton" value = "/updateDep" >
        <c:param name = "action" value = "delete"/>
        <c:param name = "depId" value = "${dep.getDepId()}"/>
        </c:url>
        <tr>
            <td>${dep.getDepId()}</td>
             <td>${dep.getDepPosition()}</d>
             <td>${dep.getDepName()}</td>
             <c:if test="${user.getUserRole().equals('admin')}">
                         <td>
                             <input type  = "button" value = "${update}"
                             onClick = "window.location.href = '${updateButton}'"/>
                         </td>
             </c:if>
             <c:if test="${user.getUserRole().equals('admin')}">
                         <td>
                         <input type  = "button" value = "${delete}"
                         onClick = "window.location.href = '${deleteButton}'"/>
                         </td>
             </c:if>
        </tr>
    </c:forEach>
     <input type  = "button" value = "${newDepartment}"
     onClick = "window.location.href = '${createButton}'"/>
</table>
</body>
</html>