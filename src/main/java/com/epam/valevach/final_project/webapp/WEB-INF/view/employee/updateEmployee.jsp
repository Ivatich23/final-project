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
<fmt:message bundle="${res}" key="newWorker" var="newWorker"/>
<fmt:message bundle="${res}" key="workerId" var="workerId"/>
<fmt:message bundle="${res}" key="position" var="position"/>
<fmt:message bundle="${res}" key="departmentId" var="departmentId"/>
<fmt:message bundle="${res}" key="workerName" var="workerName"/>
<fmt:message bundle="${res}" key="workerSurName" var="workerSurName"/>
<fmt:message bundle="${res}" key="salary" var="salary"/>
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="save" var="save"/>
<body>

<h2>${enterDetails}</h2>

 <form method="post" action="/updateEmp">

             <dd><input type="hidden" name="id" value="${newEmp.getId()}"  /></dd>

       <dl>
                   <dt>${departmentId}: </dt>
                   <dd><input type="number" name="depId" value="${newEmp.getDepId()}"
                     required placeholder="${newEmp.getDepId()}"/></dd>
               </dl>
               <dl>
                   <dt>${workerName}: </dt>
                   <dd><input type="text" name="empName" value="${newEmp.getEmpName()}" maxlength="15"
                     required placeholder="${newEmp.getEmpName()}"/></dd>
               </dl>
               <dl>
                   <dt>${workerSurName}: </dt>
                   <dd><input type="text" name="surName" value="${newEmp.getSurName()}" maxlength="15"
                    required placeholder="${newEmp.getSurName()}"/></dd>
               </dl>
                <dl>
                <dt>${ position}: </dt>
                  <dd><input type="text" name="position" value="${newEmp.getPosition()}" maxlength="15"
                     required placeholder="${newEmp.getPosition()}"/></dd>
                </dl>
                  <dl>
                <dt>${salary}: </dt>
                  <dd><input type="number" name="salary" value="${newEmp.getSalary()}"
                     required placeholder="${newEmp.getSalary()}"/></dd>
                 </dl>

        <button type="submit">${save}</button>
    </form>

</body>
</html>