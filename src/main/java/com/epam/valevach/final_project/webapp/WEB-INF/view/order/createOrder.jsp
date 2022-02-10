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
<fmt:message bundle="${res}" key="ordersList" var="ordersList"/>
<fmt:message bundle="${res}" key="orderNumber" var="orderNumber"/>
<fmt:message bundle="${res}" key="workerId" var="workerId"/>
<fmt:message bundle="${res}" key="price" var="price"/>
<fmt:message bundle="${res}" key="orderTypeId" var="orderTypeId"/>
<fmt:message bundle="${res}" key="productionTime" var="productionTime"/>
<fmt:message bundle="${res}" key="newOrder" var="newOrder"/>
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="logOff" var="logOff"/>
<fmt:message bundle="${res}" key="save" var="save"/>
<fmt:message bundle="${res}" key="enterDetails" var="enterDetails"/>

<body>

<h2>${enterDetails}</h2>
<jsp:useBean id="order" class="com.epam.valevach.final_project.entity.Order" scope="request"/>
 <form method="post" action="/updateOrder">
 <dd><input type="hidden" name="action" value="new"  /></dd>
        <dl>
            <dt>${workerId}: </dt>
            <dd><input type="number" name="employeeId"
             required placeholder="employeeId"/></dd>
        </dl>
        <dl>
            <dt>${orderTypeId}: </dt>
                  <dd><select name ="orderTypeId">
                                     <option value ="1">PRINT</option>
                                     <option  value ="2">RESTORATION</option>
                                     <option  value ="4">INSTALLATION</option>
                                    </select></dd>
                           </dl>
        </dl>
         <dl>
         <dt>${productionTime}: </dt>
           <dd><input type="number" name="productionType"
             required placeholder="productionType"/></dd>
         </dl>
           <dl>
         <dt>${price}: </dt>
           <dd><input type="number" name="price"
             required placeholder="price"/></dd>
          </dl>
        <button type="submit">${save}</button>
    </form>

</body>
</html>