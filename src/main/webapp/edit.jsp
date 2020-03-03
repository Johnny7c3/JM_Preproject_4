<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserEdit</title>
</head>
<body>
<form class="your-form-selector" method="post" action="/edit">
    <table width="100%" cellspacing="0" cellpadding="4">
    <c:forEach var="list" items="${user}">
        <tr>
            <td></td>
            <td>Редактирование пользователя:</td>
        </tr>
        <tr>
            <td align="right" width="100">ID:</td>
            <td><p>${list.id}</p></td>
            <td><input type="hidden" name="id" value=${list.id} maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Email:</td>
            <td><input type="email" name="email" value=${list.email} maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Имя:</td>
            <td><input type="text" name="name" value=${list.name} maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Фамилия:</td>
            <td><input type="text" name="surname" value=${list.surname} maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td><input type="text" name="password" value=${list.password} maxlength="50" size="20"></td>
        </tr>
        <tr>
            <td align="right" width="100">Дата рождения:</td>
            <td><input type="date" name="birthday" value=${list.birthday}></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Подтвердить изменения"></td>
        </tr>
        </tr>
    </c:forEach>
    </table>
</form>
</body>
</html>
