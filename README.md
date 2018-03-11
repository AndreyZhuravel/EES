# EES
EES Project:

Important ! Functionality in development status now !

-----------
Need:
1)	IDE IntellijIdea
2)	Maven (apache-maven-3.5.2)
3)	Tomcat7 (apache-tomcat-8.5.23) + JDBC driver
4)	Postgre (+PG Admin 4)
5)	SDK: 1.8.0_144

-----------
Go:
1. Launch service driver postgresql (if it not start automatically), for example: postgresql-x64-10 - PostgreSQL Server 10
2. Launch POSTGRESQL
2. Restore db_ees_test (!) from from github directory with name "SQL" to POSTRGESQL
3. Launch Tomcat
4. Install EES project in IDEA from github directory with name "EES" => result: EES.war
5. Locate EES.war into Tomcat webapps
6. Startpage: localhost:8080/EES/

-----------
Simple user steps:
1. Enter login: andrey, pass: root and click "Login" - you enter like an Admin User, but you can't see a results of sql query, 
when click buttons on next page, because in DB not present data for login = "andrey" (for now - it's correct). At the top of page 
you can see role and prvilege for this user.

2. Update page (or just move to Move to startpage: localhost:8080/EES/). 
Enter login: ivan, pass: 1234567 and click "Login" - you enter like an User "ivan":
For this user you can see a results of sql query, when click buttons "Show me all errors..." 
or "Show me short info...". For button "show me details..." you have to enter leadid (for example = 8818008) and you can see a 
details of leadid. 
Also on this page you can click "add\update\delete user" - but you have some alert and you can't move from this page to admin page.

3. Update page (or just move to Move to startpage: localhost:8080/EES/).
Try to click "add\update\delete user" from startpage:
- if you enter admin Login & Pass (see p.1 = andrey\root) = you valid admin security checking and move to admin page.
- if you enter some user Login & Pass (see p.2 = ivan\1234567) = you not valid admin security checking and you do not move to admin page.

4. When you login in admin page you can see fields for user management system and 3 buttons (Add\Delete\Update).
- for "Add" button (means add new user) - you have to fill user login\pass fields and two drop-down fields(role and privilege).
- for "Delete" button (means delete user) - you have to fill only user login field.
- for "Update" button (means update user)- you have to fill user login\pass fields and two drop-down fields(role and privilege).

Thank you !
 


