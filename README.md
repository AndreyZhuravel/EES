# EES
EES Project:
1. Launch POSTGRESQL
2. Restore db_ees file from from github directory with name "SQL" to POSTRGESQL
3. Launch Tomcat
4. Install EES project in IDEA from github directory with name "EES" => result: EES.war
5. Locate EES.war into Tomcat webapps
6. For test startpage: localhost:8080/EES/
7. For test DAO => localhost:8080/EES/UserDaoServlet (testing FindAll method = collect all records from db_ees (table_users))
For testing other DAO methods please see UserDaoServlet.class (//comment lines).

