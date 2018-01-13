// Start Servlet Call:
     $(document).ready(function() {
         $("#button_getmyinfo").click(function() {

         if (document.getElementById("login").value == null || document.getElementById("login").value === "") {
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

if (document.getElementById('pass')) {
      var userObj = {
           "login":document.getElementById("login").value,
           "pass":document.getElementById("pass").value,
           };
     }else {
     var userObj = {
          "login":document.getElementById("login").value,
          "pass":"",
     }
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

    if ((result) == 100) {
    var temp = document.getElementById("login").value;
    storeValue('Temp', temp);

    $.get('main.html', function(result)
    {
//    console.log(result);

    $('#contentbar').html(result);
    getStoredValue(temp);
    document.getElementById("login").value = temp;

    }
    );
    }
    else {

        if(result.indexOf(",") == -1) // Checking for comma in result
        {
        $('#div_result').html('<strong>' + result + '</strong>');

        }
        else {

          var fields = result.split(","); // RESULT
          var Id_users = fields[0] + '<br>';
          var Role = fields[1] + '<br>';
          var Privilege = fields[2] + '<br>';
          result = Id_users + Role + Privilege;
          $('#div_result').html('<strong>' + result + '</strong>');
            }
        }
    }
});
};

function buttonClick(temp) {
    temp = temp;
    storeValue('myPageMode', temp);
}

function storeValue(key, value) {
    if (localStorage) {
        localStorage.setItem(key, value);
    } else {
        $.cookies.set(key, value);
    }
};

function getStoredValue(key) {
    if (localStorage) {
        return localStorage.getItem(key);
    } else {
        return $.cookies.get(key);
    }
};
// End Servlet Call:



//// Start Servlet Call:
//     $(document).ready(function()
//
////         $("#button_getmyinfo").click(function() {
////
////         if (document.getElementById("login").value == null || document.getElementById("login").value === "" || document.getElementById("pass").value !== "") {
////            alert( 'Please input login. Password must be empty' );
////
////         } else {
////           servletGetData();
////         }
////
////         });
//
//         $("#button_checkuseraccess").click(function() {
//
//         if (document.getElementById("pass").value == null || document.getElementById("pass").value === "" || document.getElementById("login").value == null || document.getElementById("login").value === "") {
//           alert( 'Please input login or password' );
//         } else {
//           servletCallAccess();
//         }
//
//         });
//     });
//
//
///////////
//function servletCallAccess(){
//     var userObj = {
//     "login":document.getElementById("login").value,
//     "pass":document.getElementById("pass").value,
//     };
//
//var userJson = JSON.stringify(userObj);
//var url = "SampleServlet";
//
//$.ajax
//({
//    url: url,
//    method: "post",
//    data: userJson,
//    contentType: "application/json",
//    success: function(result)
//    {
////    data = JSON.parse(result);
////    document.getElementById("div_result").innerHTML =
////    result.getId_users[1] + " " + result.getPass[1];
//
////    if(result.indexOf(",") == -1) // Checking for comma in result
////    {
////    $('#div_result').html('<strong>' + result + '</strong>');
////    }
////    else {
////
////      var fields = result.split(","); // RESULT
////      var Id_users = fields[0] + '<br>';
////      var Pass = fields[1] + '<br>';
////      var Role = fields[2] + '<br>';
////      var Privilege = fields[3] + '<br>';
////      result = Id_users + Pass + Role + Privilege;
//    if
//    ((result) == 100) {
//    window.location.replace('main.html');
//    }
//
//    else {
//    $('#div_result').html('<strong>' + result + '</strong>');
//
//    }
//    }
//});
//};
//
///////////
//function servletGetData(){
//     var userObj = {
//     "login":document.getElementById("login").value,
//     };
//
//var userJson = JSON.stringify(userObj);
//var url = "SampleServlet";
//
//$.ajax
//({
//    url: url,
//    method: "post",
//    data: userJson,
//    contentType: "application/json",
//    success: function(result)
//    {
//      var fields = result.split(","); // RESULT
//      var Id_users = fields[0] + '<br>';
//      var Pass = fields[1] + '<br>';
//      var Role = fields[2] + '<br>';
//      var Privilege = fields[3] + '<br>';
//      result = Id_users + Pass + Role + Privilege;
//        $('#div_result').html('<strong>' + result + '</strong>');
//
//    }
//});
//};
