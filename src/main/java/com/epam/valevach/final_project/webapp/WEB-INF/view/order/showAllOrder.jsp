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
<fmt:message bundle="${res}" key="wrongEmployeeId" var="wrongEmployeeId"/>
<body>
<html>
<body>
<link href="/static/css/tableStyle.css" rel="stylesheet" type="text/css">
<h2> ${ordersList} </h2>
 <c:if test="${wrongEmployeeIdMess.equals('Wrong id')}">
    <p>${wrongEmployeeId}</p>
  </c:if>

       <c:url var = "createButton" value = "/updateOrder">
       <c:param name = "action" value = "new"/>
       </c:url>

<table class="table">
    <tr>
           <th>${orderNumber}</th>
           <th>${workerId}</th>
           <th>${orderTypeId}</th>
           <th>${price}</th>
           <th>${productionTime}</th>
           <c:if test="${user.getUserRole().equals('admin')}">
                       <p> <th>${update}</th></p>
                   </c:if>
                   <c:if test="${user.getUserRole().equals('admin')}">
                               <p> <th>${delete}</th></p>
                   </c:if>
       </tr>
    <c:forEach var="orders" items = "${orderServ.showAllOrders()}">
     <c:url var = "updateButton" value = "/updateOrder">
               <c:param name = "action" value = "update"/>
               <c:param name = "id" value = "${orders.getOrderId()}"/>
     </c:url>
     <c:url var = "deleteButton" value = "/updateOrder" >
               <c:param name = "action" value = "delete"/>
               <c:param name = "id" value = "${orders.getOrderId()}"/>
     </c:url>
        <tr>
                   <td>${orders.getOrderId()}</td>
                   <td>${orders.getEmployeeId()}</td>
                   <td>${orders.getTypeOfOrder()}</td>
                   <td>${orders.getPrice()}</td>
                   <td>${orders.getProductionType()}</td>
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
           <input type  = "button" value = "${newOrder}"
                onClick = "window.location.href = '${createButton}'"/>
     </c:if>
</table>
</body>
</html>