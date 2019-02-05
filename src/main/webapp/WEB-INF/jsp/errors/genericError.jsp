<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Generic Error</title>
</head>
<body>

<div class="container">
    <h2>Oops, something happened...</h2>
    <h1>${exception.message}</h1>
    <h3>Debug Information:</h3>
    Requested URL= ${url}<br><br>
    Exception= ${exception.message}<br><br>
</div>

</body>
</html>
