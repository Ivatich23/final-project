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
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="logOff" var="logOff"/>
<fmt:message bundle="${res}" key="enterDetails" var="enterDetails"/>
<fmt:message bundle="${res}" key="save" var="save"/>

<body>

<h2>${enterDetails}</h2>
 <form method="post" action="/updateOrder">

             <dd><input type="hidden" name="id" value="${newOrder.getOrderId()}"  /></dd>
                <p> <c:out value="${message}"/><p>
               <dl>
                   <dt>${workerId}: </dt>
                   <dd><input type="number" name="employeeId" value="${newOrder.getEmployeeId()}" min="1" max="99"
                    required placeholder=""/></dd>
               </dl>
               <dl>
                   <dt>${orderNumber}: </dt>
                   <dd><select name ="orderTypeId">
                         <option value ="1">PRINT</option>
                         <option  value ="2">RESTORATION</option>
                         <option  value ="4">INSTALLATION</option>
                        </select></dd>
               </dl>
                <dl>
                <dt>${productionTime}: </dt>
                  <dd><input type="number" name="productionType" value="${newOrder.getProductionType()}"
                   required placeholder=""/></dd>
                </dl>
                  <dl>
                <dt>${price}: </dt>
                  <dd><input type="number" name="price" value="${newOrder.getPrice()}"
                   required placeholder=""/></dd>
                 </dl>

        <button type="submit">${save}</button>
    </form>

</body>
</html>