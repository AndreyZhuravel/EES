<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>Administration Home Page</title>

</head>

<style type="text/css">
			#div_result .widget h3 a { text-decoration:none;}
</style>

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
    Administration Profile Page
</p>

<p> Admin Login
    <input type="login" id="login" value=""/>
</p>

<p> User Login
    <input id="loginnew" value=""/>
	User Password
    <input id="passnew" value=""/>
</p>
<p>
User Role
<select id = "selRole">
   <option value = "root">root</option>
   <option value = "admin">admin</option>
   <option value = "areamanager">areamanager</option>
   <option value = "svmanager">svmanager</option>
   <option value = "expert">expert</option>
   <option value = "agent">agent</option>
</select>

User Privilege
<select id = "selPriv">
   <option value = "full">full</option>
   <option value = "read">read</option>
   <option value = "write">write</option>
</select>
</p>

    <h3>
    <div id="div_result">
    </div>
    </h3>

<p>
    <button id="button_adduser">Add User</button>
    <button id="button_deleteuser">Delete User</button>
	<button id="button_updateuser">Update User</button>
</p>

</body>
</html>