<%@include file="common/header.jspf"%>
<body>
<div class="container">
    <h1>Welcome to the login page</h1>
    <pre>${error}</pre>
    <form method="post">
        Name: <input type="text" name="name" placeholder="Enter your user name"/>
        Password: <input type="password" name="password" placeholder="Enter your password"/>
        <input type="submit"/>
    </form>
</div>
<%@include file="common/footer.jspf"%>
</body>
</html>