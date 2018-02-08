//Main call functions
     $(document).ready(function() {

         //This button present on main.jsp
         $("#button_getaddress").click(function() {
          TestAjaxController();

         });

         //This button present on main.jsp
         $("#button_getmyinfo").click(function() {

         if (document.getElementById("login").value == null || document.getElementById("login").value === "") {
            alert( 'Please input login. Password must be empty' );

         } else {
           CallUserServlet();
         }

         });

         //This button present on welcome.jsp and check user login and password
         $("#button_checkuseraccess").click(function() {

         if (document.getElementById("pass").value == null || document.getElementById("pass").value === "" || document.getElementById("login").value == null || document.getElementById("login").value === "") {
           alert( 'Please input login or password' );
         } else {
           CallUserServlet();
         }

         });
     });

/////////////////////////////////////////
//This function call UserServlet
function CallUserServlet(){

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
    var url = "UserServlet";

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

    $.get('resources/main.jsp', function(result)
    {

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

/////////////////////////////////////////
//This 3 functions below save user login in local storage
//and save it when we move from welcome.jsp to main.jsp

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

/////////////////////////////////////////
//This function must call web.controller.AjaxController, but it does not work.

function TestAjaxController() {

		var search = {}
		search["username"] = document.getElementById("login").value;

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/api/getSearchResult",
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}

		function enableSearchButton(flag) {
    		$("#btn-search").prop("disabled", flag);
    	}

    	function display(data) {
    		var json = "<h4>Ajax Response</h4><pre>"
    				+ JSON.stringify(data, null, 4) + "</pre>";
    		$('#feedback').html(json);
    	}
/////////////////////////////////////////