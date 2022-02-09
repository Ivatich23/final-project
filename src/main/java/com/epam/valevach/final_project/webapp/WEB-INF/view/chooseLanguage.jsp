<!DOCTYPE html>
<html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<a> Выберите язык
Choose language</a>
<form method="get" action="/lang">
     <select name ="language">
        <option value ="ru">русский</option>
        <option  value ="en">english</option>
        </select>
         <button type="submit">Сохранить
         Save</button>
    </form>
</body>
</html>