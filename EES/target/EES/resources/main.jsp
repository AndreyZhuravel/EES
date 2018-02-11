<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>

    <title>Home Page</title>

</head>

<script src="resources/jquery.1.10.2.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="resources/myscript.js" charset="UTF-8"></script>

<p>
    User Profile Page
</p>

<p> Login
    <input type="login" id="login" value="" enabled>
</p>

<p>
    <button id="button_getsqlone">Simple SQL #1</button>
</p>

<p>
    <button id="button_getsqltwo">Simple SQL #2</button>
</p>

<p>
    <button id="button_getsqlthree">Simple SQL #3</button>
</p>

<div id="div_result">

</div>
</body>
</html>