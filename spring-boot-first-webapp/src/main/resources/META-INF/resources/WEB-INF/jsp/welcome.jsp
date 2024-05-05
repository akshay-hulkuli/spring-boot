<%@include file="common/header.jspf"%>
<body>
<%@include file="common/navigation.jspf"%>
    <div class="container">
        <h1>Welcome to the home page</h1>
        <p>Your name: ${name}</p>
        <div><a href="list-todos">Manage your todos</a></div>
    </div>
</body>
<%@include file="common/footer.jspf"%>
</html>