package com.ees.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SampleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usermessage = "TEST successfull"; //message I will recieve
        String text = request.getParameter("text");
        PrintWriter out = response.getWriter();
        out.println(usermessage + " " + text);


//    {
//        response.setContentType("text/html");
//
//        PrintWriter out = response.getWriter();
//        String name = request.getParameter("name");
//        {"\n" +
//                "        \"id_users\": \"1\",\n" +
//                "        \"login\": \"andrey\",\n" +
//                "        \"pass\": abcdefg12345,\n" +
//                "        \"role\": admin\n" +
//                "        \"privilege\": grantall\n"});
//
//        out.println(html);
//}


    }
}