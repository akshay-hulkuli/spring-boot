<html>
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet"/>
    <title>
        Login Page
    </title>
</head>
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
<script src="webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>