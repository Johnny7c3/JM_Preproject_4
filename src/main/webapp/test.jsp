<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Работа с пользователями</title>
    <style>
        .your-form-selector {
            display: inline-block;
        }
    </style>
</head>
<body>

<form class="your-form-selector" method="post" action="/add">
    <table width="100%" cellspacing="0" cellpadding="4">
        <tr>
            <tr></td>
            <td>Добавление пользователя:</td>
        </tr>
        <tr>
            <td align="right" width="100">Email:</td>
            <td><input type="email" name="email" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Имя:</td>
            <td><input type="text" name="name" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Фамилия:</td>
            <td><input type="text" name="surname" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Пароль:</td>
            <td><input type="password" name="password" maxlength="50" size="20" required placeholder></td>
        </tr>
        <tr>
            <td align="right" width="100">Дата рождения:</td>
            <td><input type="date" name="birthday" required placeholder></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Добавить пользователя"></td>
        </tr>
        </tr>
    </table>
</form>
</br>

<p><b>Список зарегистрированных пользователей:</b></p>
<table border="" width="600" cellspacing="1" cellpadding="4">
    <tr>
        <td>ID</td>
        <td>Email</td>
        <td>Имя</td>
        <td>Фамилия</td>
        <td>Пароль</td>
        <td>День рождения</td>
        <td>Удалить/Изменить</td>
    </tr>
    <c:forEach var="list" items="${users}">
        <tr>
            <td>${list.id}</td>
            <td>${list.email}</td>
            <td>${list.name}</td>
            <td>${list.surname}</td>
            <td>${list.password}</td>
            <td>${list.birthday}</td>
            <td>
                <form method="post" action="/delete">
                    <input type="hidden" name="id" value=${list.id}>
                    <input type="submit" value="Delete">
                </form>
                <form method="get" action="/edit">
                    <input type="hidden" name="id" value=${list.id}>
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>



















