// Start Servlet Call:
     $(document).ready(function() {
         $("#button_showuserinfo").click(function() {

         if (document.getElementById("login").value == null || document.getElementById("login").value === "" || document.getElementById("pass").value !== "") {
            alert( 'Please input login. Password must be empty' );

         } else {
           servletCallAccess();
         }

         });

         $("#button_checkuseraccess").click(function() {

         if (document.getElementById("pass").value == null || document.getElementById("pass").value === "" || document.getElementById("login").value == null || document.getElementById("login").value === "") {
           alert( 'Please input login or password' );
         } else {
           servletCallAccess();
         }

         });
     });

function servletCallAccess(){
     var userObj = {
     "login":document.getElementById("login").value,
     "pass":document.getElementById("pass").value,
     };

    var userJson = JSON.stringify(userObj);
    var url = "SampleServlet";

$.ajax
({
    url: url,
    method: "post",
    data: userJson,
    contentType: "application/json",
    success: function(result)
    {
    $('#div_result').html('Here is your result : <strong>' + result + '</strong>');
    }
});
};
// End Servlet Call:

