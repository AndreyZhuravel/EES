//Main call functions
     $(document).ready(function() {

         $("#button_getsqlfour").click(function() {
             QueryThirdServlet();
         });

         $("#button_getsqlthree").click(function() {
             QuerySecondServlet();
         });

         //This button present on main.jsp
         $("#button_getsqltwo").click(function() {
             QueryOneServlet();
         });

         //This button present on main.jsp
         $("#button_getsqlone").click(function() {

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
//This function must call QueryServlet.
function QueryOneServlet(){

    var userObj = {
          "login":document.getElementById("login").value,
    }

    var userJson = JSON.stringify(userObj);
    var url = "QueryOneServlet";

$.ajax
({
    url: url,
    method: "post",
    data: userJson,
    contentType: "application/json",
    success: function(result)
    {
          var rows = result.split(";");
          var fields = result.split(","); // RESULT
          var Id_users = fields[0] + '<br>';
          var login = fields[1] + '<br>';
          var leadid = fields[2] + '<br>';
          var id_table_address = fields[3] + '<br>';
          var pos = fields[4] + '<br>';
          var address_reg = fields[5] + '<br>';
          var address_fact = fields[6] + '<br>';
          var shop = fields[7] + '<br>';
          var region = fields[8] + '<br>';
          var status = fields[9] + '<br>';
          var condition = fields[10] + '<br>';
          var id_table_salesinfo = fields[11] + '<br>';
          result = Id_users + login + leadid + id_table_address + pos + address_reg
              + address_fact + shop + region + status + condition + id_table_salesinfo;
          $('#div_result').html('<strong>' + result + '</strong>');
            }
        }
    );
};

/////////////////////////////////////////
//This function must call QuerySecondServlet.
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
//            var rows = result.split(";");
//            var index;
//            for (index = 0; index < rows.length; ++index)
//            {
//            console.log(rows[index])
           var fields = result.split(";"); // RESULT
           var leadid = fields[0] + '<br>';
           var is_mist_adr = fields[1] + '<br>';
           var is_mist_shop = fields[2] + '<br>';
           var is_mist_phone = fields[3] + '<br>';
           result = leadid + is_mist_adr + is_mist_shop + is_mist_phone;
           $('#div_result').html('<strong>' + result + '</strong>');
            }

//                var fields = result.split(","); // RESULT
//                var leadid = fields[0] + '<br>';
//                var is_mist_adr = fields[1] + '<br>';
//                var is_mist_shop = fields[2] + '<br>';
//                var is_mist_phone = fields[3] + '<br>';
//                result = leadid + is_mist_adr + is_mist_shop + is_mist_phone;
//                $('#div_result').html('<strong>' + result + '</strong>');


        }
    );
};

/////////////////////////////////////////
//This function must call QueryServlet.
function QueryThirdServlet(){

    var userObj = {
        "login":document.getElementById("login").value,
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
    );
};