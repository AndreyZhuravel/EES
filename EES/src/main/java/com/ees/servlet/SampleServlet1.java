//package com.ees.servlet;
//import com.ees.dao.ConnectionPool;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import java.io.*;
//import java.sql.*;
//
///**
// * EmployeeInfo returns employee data presented in an HTML table
// * that is dynamically created with help from the
// * ResultSetMetaData object. This servlet utilizes the
// * ConnectionPool class to manage a pool of database connections.
// */
//public class SampleServlet1 extends HttpServlet
//{
//    ConnectionPool connectionPool = null;
//
//    /**
//     * Creates a connection pool.
//     */
//    public void init() throws ServletException
//    {
//        String jdbcDriver = "org.postgresql.Driver";
//        String dbURL ="jdbc:postgresql://localhost:5432/db_ees_test";
//
//        try
//        {
////instantiate the connection pool object by passing the
////jdbc driver, database URL, username, and password
//            connectionPool = new ConnectionPool(jdbcDriver, dbURL,
//                    "postgres", "root");
//
////specify the initial number of connections to establish
//            connectionPool.setInitialConnections(5);
//
////specify number of incremental connections to create if
////pool is exhausted of available connections
//            connectionPool.setIncrementalConnections(5);
//
////specify absolute maximum number of connections to create
//            connectionPool.setMaxConnections(20);
//
////specify a database table that can be used to validate the
////database connections (this is optional)
//            connectionPool.setTestTable("table_users");
//            connectionPool.createPool(); //create the connection pool
//        }
//        catch(Exception e)
//        {
//            System.out.println("Error: " + e);
//        }
//    }
//
//    /**
//     * Dynamically constructs an HTML table from a ResultSet object
//     * containing employee information.
//     */
//    public void doGet(HttpServletRequest request,
//                      HttpServletResponse response) throws ServletException,
//            IOException
//    {
//        Connection dbConn = null;
//
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//
//        try
//        {
////get free connection from pool
//            dbConn = connectionPool.getConnection();
//
//            Statement stmt = dbConn.createStatement();
//
////create ResultSet containing employee information
//            String sql = "SELECT * FROM table_users ORDER BY id_users";
//            ResultSet rs = stmt.executeQuery(sql);
//
////get ResultSetMetaData object from ResultSet
//            ResultSetMetaData rsMeta = rs.getMetaData();
//
////get number of columns in ResultSet
//            int cols = rsMeta.getColumnCount();
//
//            out.println("<TABLE BORDER=\"1\">"); //begin dynamic table
//
////create header row containing column titles
//            out.println("<TR>");
//
//            for (int i = 1; i <= cols; i++)
//            {
//                out.println("<TH>" + rsMeta.getColumnLabel(i) +"</TH>");
//            }
//            out.println("</TR>");
//
////create a row for each row in result set
//            while (rs.next())
//            {
//                out.println("<TR>");
//                for (int i = 1; i <= cols; i++)
//                {
//                    out.println("<TD>" + rs.getString(i) + "</TD>");
//                }
//                out.println("</TR>");
//            }
//
//            out.println("</TABLE>"); //end dynamic table
//
//            out.close();
//        }
//
//
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//        finally
//        {
//        //return connection to pool (always within a finally block)
//            connectionPool.returnConnection(dbConn);
//        }
//    }
//}
