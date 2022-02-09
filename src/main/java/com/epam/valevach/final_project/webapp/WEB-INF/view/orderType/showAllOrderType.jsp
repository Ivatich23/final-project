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
<fmt:message bundle="${res}" key="ordersTypeList" var="ordersTypeList"/>
<fmt:message bundle="${res}" key="orderTypeId" var="orderTypeId"/>
<fmt:message bundle="${res}" key="newOrderType" var="newOrderType"/>
<fmt:message bundle="${res}" key="typeOfOrder" var="typeOfOrder"/>
<fmt:message bundle="${res}" key="update" var="update"/>
<fmt:message bundle="${res}" key="delete" var="delete"/>
<fmt:message bundle="${res}" key="logOff" var="logOff"/>
<fmt:message bundle="${res}" key="enterDetails" var="enterDetails"/>
<fmt:message bundle="${res}" key="save" var="save"/>
<html>
<body>
<link href="/static/css/tableStyle.css" rel="stylesheet" type="text/css">
<h2> ${ordersTypeList} </h2>
<c:url var = "createButton" value = "/updateOrderType">
<c:param name = "action" value = "new"/>
</c:url>
<table class="table">
    <tr>
        <th>${orderTypeId}</th>
        <th>${typeOfOrder}</th>
       <c:if test="${user.getUserRole().equals('admin')}">
                   <p> <th>${update}</th></p>
               </c:if>
               <c:if test="${user.getUserRole().equals('admin')}">
                           <p> <th>${delete}</th></p>
               </c:if>
    </tr>
    <c:forEach var="order" items = "${orderTypeServ.showAllOrderType()}">
     <c:url var = "updateButton" value = "/updateOrderType">
                <c:param name = "action" value = "update"/>
                <c:param name = "id" value = "${order.getOrderTypeId()}"/>
            </c:url>
            <c:url var = "deleteButton" value = "/updateOrderType" >
            <c:param name = "action" value = "delete"/>
            <c:param name = "id" value = "${order.getOrderTypeId()}"/>
            </c:url>
        <tr>
            <td>${order.getOrderTypeId()}</td>
            <td>${order.getTypeOfOrder()}</td>
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
    <input type  = "button" value = "${newOrderType}"
         onClick = "window.location.href = '${createButton}'"/>
</table>
</body>
</html>