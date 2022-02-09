
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
<fmt:message bundle="${res}" key="workersList" var="workersList"/>
<fmt:message bundle="${res}" key="ordersList" var="ordersList"/>
<fmt:message bundle="${res}" key="departmentList" var="departmentList"/>
<fmt:message bundle="${res}" key="ordersTypeList" var="ordersTypeList"/>
<fmt:message bundle="${res}" key="usersList" var="usersList"/>
<fmt:message bundle="${res}" key="logOff" var="logOff"/>
 <p> <c:out value="${message}"/><p>
<a href="/updateEmp"> ${workersList}</a>
<br><br>
<a href="/updateOrder">${ordersList}</a>
<br><br>
<a href="/updateDep">${departmentList}</a>
<br><br>
 <c:if test="${user.getUserRole().equals('admin')}">
     <a href="/updateOrderType">${ordersTypeList}</a>
</c:if>
<br><br>
 <c:if test="${user.getUserRole().equals('admin')}">
     <a href="/updateUsers"> ${usersList}</a>
</c:if>
 <br><br>
 <c:if test="${user.getUserRole()!=null}">
             <a href="/singOut"> ${logOff}</a>
  </c:if>


</body>
</html>