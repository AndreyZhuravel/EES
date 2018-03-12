//Calling functions
     $(document).ready(function() {

 //These buttons present on main_agent.jsp \ main_admin.jsp

        $("#button_admin").click(function() {

		var passfield =  document.getElementById('pass');
		if (typeof(passfield) != 'undefined' && passfield != null)
		{

         if (document.getElementById("pass").value == null || document.getElementById("pass").value === "" || document.getElementById("login").value == null || document.getElementById("login").value === "") {
           alert( 'Please input login or password' );
         } else {
			  var admin = "admin";
			  CallUserServlet(admin);
         }
		}else
		{
			result =  "You can't call User Management from this page";
			$('#div_result').html('<strong>' + result + '</strong>');
		}
		});

         $("#button_getsqlone").click(function() {
             QueryFirstServlet();
         });

         $("#button_getsqltwo").click(function() {
             QuerySecondServlet();
         });

         $("#button_getsqlthree").click(function() {
             QueryThirdServlet();
         });

		 $("#button_adduser").click(function() {
             AddUser();
         });

         $("#button_updateuser").click(function() {
             UpdateUser();
         });

         $("#button_deleteuser").click(function() {
             DeleteUser();
         });
//---------------------------------------------------------
//         $("#button_getsqluser").click(function() {
//
//         if (document.getElementById("login").value == null || document.getElementById("login").value === "") {
//            alert( 'Please input login. Password must be empty' );
//
//         } else {
//           CallUserServlet();
//         }
//
//         });

//---------------------------------------------------------
//This button present on welcome.jsp and check user login and password
         $("#button_checkuseraccess").click(function() {

         if (document.getElementById("pass").value == null || document.getElementById("pass").value === "" || document.getElementById("login").value == null || document.getElementById("login").value === "") {
           alert( 'Please input login or password' );
         } else {
			  var admin = "agent";
           CallUserServlet(admin);
         }

         });
     });

//---------------------------------------------------------
//This function call UserServlet
function CallUserServlet(val){
	var admin = val;

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
		if (admin == "admin") {
		result = "You have no rights to User Management system";
		$('#div_result').html('<strong>' + result + '</strong>');
		}
	else
	{
    var temp = document.getElementById("login").value;
    storeValue('Temp', temp);
    $.get('resources/main_agent.jsp', function(result)

    {
    $('#contentbar').html(result);
    getStoredValue(temp);
    document.getElementById("login").value = temp;
	});
    }
    }

    else
	{
    if ((result) == 777) {
		if (admin == "admin") {
		var temp = document.getElementById("login").value;
        storeValue('Temp', temp);
        $.get('resources/main_admin.jsp', function(result)

        {
        $('#contentbar').html(result);
        getStoredValue(temp);
        document.getElementById("login").value = temp;
    });
	}

	else
	{
		var temp = document.getElementById("login").value;
        storeValue('Temp', temp);
        $.get('resources/main_agent.jsp', function(result)

        {
        $('#contentbar').html(result);
        getStoredValue(temp);
        document.getElementById("login").value = temp;
        });
    }
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
          $('#div_role_result').html('<strong>' + result + '</strong>');
            }
        }
	}
	}
});
};

//---------------------------------------------------------
//This 3 functions below save user login in local storage
//and save it when we move from welcome.jsp to main_agent.jsp \ main_admin.jsp

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

//---------------------------------------------------------
//This function call QueryFirstServlet.
function QueryFirstServlet(){

    var userObj = {
          "login":document.getElementById("login").value,
    }

    var userJson = JSON.stringify(userObj);
    var url = "QueryFirstServlet";

$.ajax
({
    url: url,
    method: "post",
    data: userJson,
    contentType: "application/json",
    success: function(result)
    {
    if ((result) == 101) {
    result =  "Please input login";
    $('#div_result').html('<strong>' + result + '</strong>');
    }
    else {
    if ((result) == 111) {
    result =  "This information was not found in database";
    $('#div_result').html('<strong>' + result + '</strong>');
    }
    else {
//        var rows = result.split(";");
          var fields = result.split(","); // RESULT
          var Id_users = fields[0] + '<br>';
          var login = fields[1] + '<br>';
          var leadid = fields[2] + '<br>';

//        var id_table_address = fields[3] + '<br>';
//        var pos = fields[4] + '<br>';
//        var address_reg = fields[5] + '<br>';
//        var address_fact = fields[6] + '<br>';
//        var shop = fields[7] + '<br>';
//        var region = fields[8] + '<br>';
//        var status = fields[9] + '<br>';
//        var condition = fields[10] + '<br>';
//        var id_table_salesinfo = fields[11] + '<br>';

          result = Id_users + login + leadid;

//          + id_table_address + pos + address_reg
//              + address_fact + shop + region + status + condition + id_table_salesinfo;

          $('#div_result').html('<strong>' + result + '</strong>');
              }
            }
        }

    });
};

//---------------------------------------------------------
//This function call QuerySecondServlet.
function QuerySecondServlet(){

    var userObj = {
        "login":document.getElementById("login").value,
    }

    var userJson = JSON.stringify(userObj);
    var url = "QuerySecondServlet";

    $.ajax
    ({
            url: url,
            method: "post",
            data: userJson,
            contentType: "application/json",
            success: function(result)
            {
            if ((result) == 102)
            {
            result =  "Please input login";
            $('#div_result').html('<strong>' + result + '</strong>');
            }
            else {
            if ((result) == 111) {
            result =  "This information was not found in database";
            $('#div_result').html('<strong>' + result + '</strong>');
            }
            else
            {
                var fields = result.split(";"); // RESULT
				var size = fields.length;
                var leadid = fields[0] + '<br>';
                var is_mist_adr = fields[1] + '<br>';
                var is_mist_shop = fields[2] + '<br>';
                var is_mist_phone = fields[3] + '<br>';

				var myArray    = new Array();
				myArray[0] = fields[0];
				myArray[1] = fields[1];
				myArray[2] = fields[2];
				myArray[3] = fields[3];

				var myTable= "<table><tr><td style='width: 20px; color: red;'>Lead Id #</td>";
				myTable+= "<td style='width: 20px; color: red; text-align: left;'>Lead Id</td>";
				myTable+= "<td style='width: 20px; color: red; text-align: left;'>Address Mistakes</td>";
				myTable+= "<td style='width: 20px; color: red; text-align: left;'>Shop Mistakes</td>";
				myTable+= "<td style='width: 20px; color: red; text-align: left;'>Phones Mistakes</td>";

                for (var i=0; i < size-1; i++) {

//	var detailArray    = new Array();
//	detailArray = myArray[i].split(";");
//	myTable+="<th style='width: 100px;'>" + detailArray[i].substring(touch[i].indexOf(":") + 2)+ "</th>";
//	myTable+="<th style='width: 100px;'>" + detailArray[i] + "</th>";
//	myTable+="<th style='width: 100px;'>" + detailArray[i+1] + "</th>";
//	myTable+="<th style='width: 100px;'>" + detailArray[i+2] + "</th>";
//	myTable+="<th style='width: 100px;'>" + detailArray[i+3] + "</th>";

    myTable+="<tr><td style='width: 100px;'>#" + i + " is:</td>";
	myTable+="<td style='width: 100px;'>" + myArray[i] + "</th>";
  }
   myTable+="</table>";
   $('#div_result').html(myTable);

// result = leadid + is_mist_adr + is_mist_shop + is_mist_phone;
// $('#div_result').html(result);

                }
            }
        }
    });
};

//---------------------------------------------------------
//This function must call QueryThirdServlet.
function QueryThirdServlet(){

    var userObj = {
        "login":document.getElementById("login").value,
        "lead":document.getElementById("lead").value,
    }

    var userJson = JSON.stringify(userObj);
    var url = "QueryThirdServlet";

    $.ajax
    ({
            url: url,
            method: "post",
            data: userJson,
            contentType: "application/json",
            success: function(result)
            {
            if ((result) == 103) {
            result =  "Please input login and leadid";
            $('#div_result').html('<strong>' + result + '</strong>');
            }
            else {
            if ((result) == 111) {
            result =  "This information was not found in database";
            $('#div_result').html('<strong>' + result + '</strong>');
            }
            else {
                var rows = result.split(";");
                var fields = result.split(","); // RESULT
                var login = fields[0] + '<br>';
                var leadid = fields[1] + '<br>';
                var pos = fields[2] + '<br>';
                var address_reg = fields[3] + '<br>';
                var address_fact = fields[4] + '<br>';
                var shop = fields[5] + '<br>';
                var region = fields[6] + '<br>';
                var status = fields[7] + '<br>';
                var condition = fields[8] + '<br>';
                result =  login + leadid + pos + address_reg
                    + address_fact + shop + region + status + condition;
                $('#div_result').html('<strong>' + result + '</strong>');
                }
            }
            }
    });
};

//---------------------------------------------------------
function AddUser(){

         if (document.getElementById("passnew").value == null || document.getElementById("passnew").value === "" || document.getElementById("loginnew").value == null || document.getElementById("loginnew").value === "") {
           alert( 'Please input login or password' );
         }
		 else {

var userObj =
	{
          "login":document.getElementById("loginnew").value,
          "pass": document.getElementById("passnew").value,
		  "role": document.getElementById("selRole").value,
		  "privilege": document.getElementById("selPriv").value
    }

    var userJson = JSON.stringify(userObj);
    var url = "AddUserServlet";

$.ajax
({
    url: url,
    method: "post",
    data: userJson,
    contentType: "application/json",
    success: function(result)
    {
    $('#div_result').html('<strong>' + result + '</strong>');
	}
});

		}
};

//---------------------------------------------------------
function DeleteUser(){

    if (confirm("Are you sure?") == true) { //pressed OK

	var userObj =
	{
          "login":document.getElementById("loginnew").value
    }
    var userJson = JSON.stringify(userObj);
    var url = "DeleteUserServlet";

$.ajax
({
    url: url,
    method: "post",
    data: userJson,
    contentType: "application/json",
    success: function(result)
    {
    $('#div_result').html('<strong>' + result + '</strong>');
	}
});


	 } else {
         var result = "Operation was canceled"; //pressed Cancel
		 $('#div_result').html('<strong>' + result + '</strong>');
	 }
};
//---------------------------------------------------------
function UpdateUser(){

var userObj =
	{
          "login":document.getElementById("loginnew").value,
          "pass": document.getElementById("passnew").value,
		  "role": document.getElementById("selRole").value,
		  "privilege": document.getElementById("selPriv").value
    }

    var userJson = JSON.stringify(userObj);
    console.log(userObj);
    var url = "UpdateUserServlet";

$.ajax
({
    url: url,
    method: "post",
    data: userJson,
    contentType: "application/json",
    success: function(result)
    {
    $('#div_result').html('<strong>' + result + '</strong>');
	}
});
};

//---------------------------------------------------------
function myPassBoxFunction() {
var x = document.getElementById("pass");
    if (x.type === "password") {
        x.type = "text";
    } else {
    x.type = "password";
            }
};
//---------------------------------------------------------
