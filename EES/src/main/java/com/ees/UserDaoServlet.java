package com.ees;

import java.io.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDaoServlet
 */
public class UserDaoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UserDaoServlet() {
        super();
    }

//    /**
//     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
//        StringBuffer stringBuf = new StringBuffer();

        try {
            PrintWriter out = response.getWriter();
            String html = "";

            UserDao dao = new UserDaoImpl();
            List<EntityUser> users = dao.findAll();

//          EntityUser user = dao.findById(3); /* test findByID*/
//          EntityUser user = dao.findByLogin("sheyla"); /* test findByLogin*/

//          /* insert*/
//            EntityUser user1 = new EntityUser(Statement.RETURN_GENERATED_KEYS, "mike","sdfjs", "agent", "read");
//            dao.insert(user1);
//          /* insert*/


//          /* update*/
//            EntityUser user = dao.findByLogin("sheyla");
//            user.setPass("7654321");
//            dao.update(user);
//          /* update*/


//          /* delete*/
//            EntityUser user2 = dao.findById(6);
//            dao.delete(6);
//          /* delete*/


          /* findAll*/
            for (EntityUser user : users) {
                html = html + "<p><div>"
                        + user.getLogin() + "</div>" + "<p><div>"
                        + user.getPass() + "</div>" + "<p><div>"
                        + user.getRole() + "</div>" + "<p><div>"
                        + user.getPrivilege() + "</div></p>";
            }

            /* findAll*/

//            /*  findByID*/
//            html = html + "<p><div>"
//                        + user.getLogin() + "</div>" + "<p><div>"
//                        + user.getPass() + "</div>" + "<p><div>"
//                        + user.getRole() + "</div>" + "<p><div>"
//                        + user.getPrivilege() + "</div></p>";
//            /*  findByID*/


//            /*  findByLogin*/
//            html = html + "<p><div>"
//                        + user.getLogin() + "</div>" + "<p><div>"
//                        + user.getPass() + "</div>" + "<p><div>"
//                        + user.getRole() + "</div>" + "<p><div>"
//                        + user.getPrivilege() + "</div></p>";
//            /*  findByLogin*/

            out.println(html);

//      request.setAttribute("table2", list);

        } finally {

        }

//        request.setAttribute("table", stringBuf.toString());
//        request.getRequestDispatcher("output.jsp").forward(request, response);
    }

//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//     */
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }



}