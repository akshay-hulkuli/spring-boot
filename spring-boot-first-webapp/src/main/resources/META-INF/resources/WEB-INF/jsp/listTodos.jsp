<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Welcome Page
    </title>
</head>
<body>
<div>
    <h1>Welcome ${name}</h1>
    <hr>
    <h3>Welcome to the Todo list page</h3>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Id done?</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>