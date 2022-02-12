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
<fmt:message bundle="${res}" key="workersList" var="workersList"/>
<fmt:message bundle="${res}" key="newWorker" var="newWorker"/>
<fmt:message bundle="${res}" key="workerId" var="workerId"/>
<fmt:message bundle="${res}" key="position" var="position"/>
<fmt:message bundle="${res}" key="departmentName" var="departmentName"/>
<fmt:message bundle="${res}" key="workerName" var="workerName"/>
<fmt:message bundle="${res}" key="workerSurName" var="workerSurName"/>
<fmt:message bundle="${res}" key="salary" var="salary"/>
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="invalidInput" var="invalidInput"/>
<fmt:message bundle="${res}" key="deleteEmployeeError" var="deleteEmployeeError"/>
<html>
<body>
<link href="/static/css/tableStyle.css" rel="stylesheet" type="text/css">
<h2> ${workersList} </h2>
 <c:if test="${deleteEmployeeError1.equals('delete orders')}">
    <p>${deleteEmployeeError}</p>
  </c:if>
 <c:if test="${error.equals('invalid input,try again')}">
    <p>${invalidInput}</p>
  </c:if>
    <c:if test="${user.getUserRole().equals('admin')}">
          <c:url var = "createButton" value = "/updateEmp">
          <c:param name = "action" value = "new"/>
           </c:url>
     </c:if>

<table class="table">
    <tr>
        <th>${workerId}</th>
        <th>${position}</th>
        <th>${workerName}</th>
        <th>${workerSurName}</th>
        <th>${salary}</th>
        <th>${departmentName}</th>
       <c:if test="${user.getUserRole().equals('admin')}">
                   <p> <th>${update}</th></p>
               </c:if>
               <c:if test="${user.getUserRole().equals('admin')}">
                           <p> <th>${delete}</th></p>
               </c:if>
    </tr>
    <c:forEach var="emp" items = "${empService.sowAllEmployee()}">
     <c:url var = "updateButton" value = "/updateEmp">
                <c:param name = "action" value = "update"/>
                <c:param name = "id" value = "${emp.getId()}"/>
            </c:url>
            <c:url var = "deleteButton" value = "/updateEmp" >
            <c:param name = "action" value = "delete"/>
            <c:param name = "id" value = "${emp.getId()}"/>
            </c:url>
        <tr>
            <td>${emp.getId()}</td>
             <td>${emp.getPosition()}</td>
             <td>${emp.getEmpName()}</td>
             <td>${emp.getSurName()}</td>
             <td>${emp.getSalary()}</td>
              <td>${emp.getDepId()}</td>
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
    <c:if test="${user.getUserRole().equals('admin')}">
                        <input type  = "button" value = "${newWorker}"
                         onClick = "window.location.href = '${createButton}'"/>
                </c:if>

</table>
</body>
</html>