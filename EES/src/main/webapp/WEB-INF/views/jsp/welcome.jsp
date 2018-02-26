<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>EES Login Page</title>

    <style>
        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        /* Set a style for all buttons */
        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
        button:hover {
            opacity: 0.8;
        }
        /* Extra styles for the cancel button */
        .cancelbtn {
            width: auto;
            padding: 10px 18px;
            background-color: #f44336;
        }
        /* Center the image and position the close button */
        .imgcontainer {
            text-align: center;
            margin: 24px 0 12px 0;
            position: relative;
        }
        img.avatar {
            float: left;
            margin: 0 [x] [y] 0;
            width: 30%;
        }
        .container {
            padding: 16px;
        }
        span.psw {
            float: right;
            padding-top: 16px;
        }
        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            padding-top: 60px;
        }
        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 0% auto 15% auto; /* 0% from the top, 15% from the bottom and centered */
            border: 1px solid #888;
            width: 60%; /* Could be more or less, depending on screen size */
        }
        /* The Close Button (x) */
        .close {
            position: absolute;
            right: 25px;
            top: 0;
            color: #000;
            font-size: 35px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: red;
            cursor: pointer;
        }
        /* Add Zoom Animation */
        .animate {
            -webkit-animation: animatezoom 0.6s;
            animation: animatezoom 0.6s
        }
        @-webkit-keyframes animatezoom {
            from {-webkit-transform: scale(0)}
            to {-webkit-transform: scale(1)}
        }
        @keyframes animatezoom {
            from {transform: scale(0)}
            to {transform: scale(1)}
        }
        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
               display: block;
               float: none;
            }
            .cancelbtn {
               width: 100%;
            }
        }
        </style>


    <style type="text/css">
			#div_role_result {position: relative;left: 50px;}

			html, #page { padding:0; margin:0;}
			body { margin:0; padding:0; width:100%; color:#959595; font:normal 12px/2.0em Sans-Serif;}
			h1, h2, h3, h4, h5, h6 {color:darkblue;}
			#page { background:#eee;}
			#header, #footer, #top-nav, #content, #content #contentbar, #content #sidebar { margin:0; padding:0;}
			/* Logo */
			#logo { padding:10px; width:auto; float:left;}
			#logo h1 a, h1 a:hover { color:darkblue; text-decoration:none;}
			#logo h1 span { color:#d3d3f9;}
			/* Header - * Цвет за Cool logo */
			#header { background:#eee; }
			#header-inner { margin:0 auto; padding:10px; width:970px;background:#fff;}
			/* Feature */
			.feature { background:#eee;padding:0;}
			.feature-inner { margin:auto;padding:10px;width:970px;background:#000000; }
			.feature-inner h1 {color:#FFFFFF;font-size:24px;}
			/* Menu */
			#top-nav { margin:0 auto; padding:0px 0 0; height:37px; float:right;}
			#top-nav ul { list-style:none; padding:0; height:37px; float:left;}
			#top-nav ul li { margin:0; padding:0 0 0 8px; float:left;}
			#top-nav ul li a { display:block; margin:0; padding:8px 20px; color:#000000; text-decoration:none;}
			#top-nav ul li.active a, #top-nav ul li a:hover { color:#d3d3f9;}
			/* Content */
			#content-inner { margin:0 auto; padding:10px; width:970px;background:#fff;}
			#content #contentbar { margin:0; padding:0; float:right; width:760px;}
			#content #contentbar .article { margin:0 0 24px; padding:0 20px 0 15px; color:#0B0B61;}
			#content #sidebar { padding:0; float:left; width:200px;}
			#content #sidebar .widget { margin:0 0 12px; padding:8px 8px 8px 13px;line-height:1.4em;}
			#content #sidebar .widget h3 a { text-decoration:none;}
			#content #sidebar .widget ul { margin:0; padding:0; list-style:none; color:#959595;}
			#content #sidebar .widget ul li { margin:0;}
			#content #sidebar .widget ul li { padding:4px 0; width:185px;}
			#content #sidebar .widget ul li a { color:#000000; text-decoration:none; margin-left:-16px; padding:4px 8px 4px 16px;}
			#content #sidebar .widget ul li a:hover { color:#d3d3f9; font-weight:bold; text-decoration:none;}
			/* Footerblurb */
			#footerblurb { background:#eee;color:blue;}
			#footerblurb-inner { margin:0 auto; width:970px; padding:10px;background:#d3d3f9;border-bottom-right-radius:15px;border-bottom-left-radius:15px;}
			#footerblurb .column { margin:0; text-align:justify; float:left;width:250px;padding:0 24px;}
			/* Footer © Copyright */
			#footer { background:#eee;}
			#footer-inner { margin:auto; text-align:center; padding:12px; width:970px;}
			#footer a {color:black;text-decoration:none;}
			/* Clear both sides to assist with div alignment  */
			.clr { clear:both; padding:0; margin:0; width:100%; font-size:0px; line-height:0px;}
		</style>

    <!---This code block generates text********
            <script type="text/javascript">
                /* =============================
                This script generates sample text for the body content.
                You can remove this script and any reference to it.
                 ============================= */
                var bodyText=["The smaller your reality, the more convinced you are that you know everything.", "If the facts don't fit the theory, change the facts.", "The past has no power over the present moment.", "This, too, will pass.", "</p><p>You will not be punished for your anger, you will be punished by your anger.", "Peace comes from within. Do not seek it without.", "<h2>Heading</h2><p>The most important moment of your life is now. The most important person in your life is the one you are with now, and the most important activity in your life is the one you are involved with now."]
                function generateText(sentenceCount){
                    for (var i=0; i<sentenceCount; i++)
                    document.write(bodyText[Math.floor(Math.random()*7)]+" ")
                }
            </script>
    --->
    <!--
    <script>
            // Get the modal
            var modal = document.getElementById('id01');
            // When the user clicks anywhere outside of the modal, close it
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
    </script>
    -->

</head>
<body>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="resources/myscript.js" charset="UTF-8"></script>

<div id="page">

    <header id="header">
        <div id="header-inner">
            <div id="logo">

                <!--
                <h1><a href="#">Be<span>Simple</span></a></h1>
                -->
                <img src="resources/java.png" class="avatar">

				<div id="div_role_result">
				</div>

            </div>
            <div id="top-nav">
                <ul>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Help</a></li>
                </ul>
            </div>
            <div class="clr"></div>
        </div>
    </header>
    <div class="feature">
        <div class="feature-inner">
            <h1>EES Project</h1>
        </div>
    </div>

    <div id="content">
        <div id="content-inner">


            <main id="contentbar">

                <div class="article">
                    <br>
                    <p> Login
                        <input type="login" id="login" value=""/>
                        Password
                        <input type="pass" id="pass" value=""/>
                    </p>
					<br>
                    <p>
                        <button id="button_checkuseraccess">Login</button>
                    </p>


                    <div id="div_result">
                    </div>

                </div>

            </main>

            <nav id="sidebar">
                <div class="widget">
                    <h3>Navigation</h3>
                    <ul>
                        <li><h3><a href="#" id="button_admin">Add\Update\Delete User</a></li></h3>
                        <li><a href="#">Example Link1</a></li>
                        <li><a href="#">Example Link2</a></li>
						<li><a href="#">Example Link3</a></li>
                    </ul>
                </div>
            </nav>

            <div class="clr"></div>
        </div>
    </div>

    <div id="footerblurb">
        <div id="footerblurb-inner">
            <!--
                                <div class="column">
                                    <h2><span>Heading</span></h2>
                                    <p><script>generateText(2)</script></p>
                                </div>
                                <div class="column">
                                    <h2><span>Heading</span></h2>
                                    <p><script>generateText(2)</script></p>
                                </div>
                                <div class="column">
                                    <h2><span>Heading</span></h2>
                                    <p><script>generateText(2)</script></p>
                                </div>
            -->
            <div class="clr"></div>
        </div>
    </div>

    <!--
        <button onclick="document.getElementById('id01').style.display='block'"
                style="position:absolute;
                bottom:50%;
                right:50%;
                width: 100px; height: 50px;">Login</button>
        <div id="id01" class="modal">
            <form class="modal-content animate">
                <!--
                action="/action_page.php">
            <div class="imgcontainer">
                <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                <img src="resources/java.png" alt="User" class="avatar">
            </div>
            <div class="container">
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
                <!--
                  <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </form>
    </div>
    -->

    <footer id="footer">

        <div id="footer-inner">
            <p>&copy; Copyright <a href="#">EES Project</a> &#124; <a href="#">Terms of Use</a> &#124; <a href="#">Privacy Policy</a></p>
            <div class="clr"></div>
        </div>
    </footer>
</div>
</body>
</html>