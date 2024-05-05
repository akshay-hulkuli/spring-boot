<%@ include file="common/header.jspf"%>
<body>
<%@ include  file="common/navigation.jspf" %>
<div class="container">
    <h1>Welcome to the Todo list page</h1>
    <hr>
    <table class="table">
        <thead class="table-header">
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Id done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a></td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">UPDATE</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add Todo</a>
</div>

<%@include file="common/footer.jspf"%>
</body>
</html>