<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>

<div class="container">
    <h1>${exception.message}</h1>
    <h3>Debug Information:</h3>

    Requested URL= ${url}<br><br>

    Exception= ${exception.message}<br><br>
</div>

</body>
</html>
