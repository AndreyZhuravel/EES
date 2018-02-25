<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>Home Page</title>

</head>

<script src="resources/jquery.1.10.2.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="resources/myscript.js" charset="UTF-8"></script>

<script type="text/javascript">
  $(document).ready(function()
  {
     CallUserServlet()
  });
</script>


<p>
    User Profile Page

</p>

<p> Login
    <input type="login" id="login" value="" enabled>
    LeadId
    <input type="lead" id="lead" value="" enabled>
</p>

<div id="div_result">
</div>

<p>
    <button id="button_getsqltwo">Show me all my errors</button>
</p>

<p>
    <button id="button_getsqlone">Show me short info about errors in "Address" database</button>
</p>

<p>
    <button id="button_getsqlthree">Show me details about errors in "Address" database</button>
</p>

</body>
</html>