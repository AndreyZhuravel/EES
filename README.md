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
3. Restore db_ees_test (!) from from github directory with name "SQL" to POSTRGESQL
4. Launch Tomcat
5. Install EES project in IDEA from github directory with name "EES" => result: EES.war
6. Locate EES.war into Tomcat webapps
7. Startpage: localhost:8080/EES/

-----------
Simple user steps:
1. Enter login: andrey, pass: root and click "Login" - you enter like an Admin User. 
When you click buttons ("Show me short info...". or button "show me details...") on next page, 
you can't see a results of sql query, because in DB not present data for 
login = "andrey" (for now - it's correct). 

2. At the top of page you can see role and prvilege for this user.

3. Update page (or just move to startpage: localhost:8080/EES/). 
Enter login: ivan, pass: 1234567 and click "Login" - you enter like an User "ivan":
When you click buttons "Show me all errors..." or "Show me short info..." you can see a results of sql query. 
For button "show me details..." you have to enter leadid (for example = 8818008) and you can see a 
details of leadid. 

4.If you click "add\update\delete user" on this page you get message - you can't move from this page to User Management page.

5. Update page (or just move to Move to startpage: localhost:8080/EES/).
Try to click "add\update\delete user" (User Management page) from startpage:
- if you enter admin Login & Pass (see p.1 = andrey\root) = you valid admin security checking and move to User Management page.
- if you enter some user Login & Pass (see p.2 = ivan\1234567) = you not valid admin security checking and you do not move to User Management pagea.

6. When you login in User Management page you can see some fields for user management and 3 buttons (Add\Delete\Update).
- for "Add" button (means add new user) - you have to fill user login\pass fields and two drop-down fields(role and privilege).
- for "Delete" button (means delete user) - you have to fill only user login field.
- for "Update" button (means update user)- you have to fill user login\pass fields and two drop-down fields(role and privilege).

Thank you !
 


