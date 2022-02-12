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
 <dd><input type="hidden" name="action" value="new"  /></dd>
        <dl>
            <dt>${departmentId}: </dt>
            <dd><input type="number" name="depId" min="1" max="99"
              required placeholder=""  /></dd>
        </dl>
        <dl>
            <dt>${workerName}: </dt>
            <dd><input type="text" name="empName" maxlength="15"
             required placeholder=""/></dd>
        </dl>
        <dl>
            <dt>${workerSurName}: </dt>
            <dd><input type="text" name="surName" maxlength="15"
              required placeholder=""/></dd>
        </dl>
         <dl>
         <dt>${position}: </dt>
           <dd><input type="text" name="position" maxlength="15"
            required placeholder=""/></dd>
         </dl>
           <dl>
         <dt>${salary}: </dt>
           <dd><input type="number" name="salary" min="1" max="9999999"
           required placeholder=""/></dd>
          </dl>
        <button type="submit">${save}</button>
    </form>

</body>
</html>