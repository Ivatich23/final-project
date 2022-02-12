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
<fmt:message bundle="${res}" key="ordersTypeList" var="ordersTypeList"/>
<fmt:message bundle="${res}" key="orderTypeId" var="orderTypeId"/>
<fmt:message bundle="${res}" key="typeOfOrder" var="typeOfOrder"/>
<fmt:message bundle="${res}" key="RESTORATION" var="RESTORATION"/>
<fmt:message bundle="${res}" key="INSTALLATION" var="INSTALLATION"/>
<fmt:message bundle="${res}" key="PRINT" var="PRINT"/>
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="logOff" var="logOff"/>
<fmt:message bundle="${res}" key="enterDetails" var="enterDetails"/>
<fmt:message bundle="${res}" key="save" var="save"/>

<body>

<h2>${enterDetails}</h2>
 <form method="post" action="/updateOrderType">

             <dd><input type="hidden" name="id" value="${newOrderType.getOrderTypeId()}" maxlength="15"
             required placeholder="" /></dd>

       <dl>

               <dl>
                   <dt>${typeOfOrder}: </dt>
                   <dd><select name ="typeOfOrder">
                                   <option value ="RESTORATION">${RESTORATION}</option>
                                   <option  value ="INSTALLATION">${INSTALLATION}</option>
                                   <option  value ="PRINT">${PRINT}</option>
                                   </select></dd>
               </dl>


        <button type="submit">${save}</button>
    </form>

</body>
</html>