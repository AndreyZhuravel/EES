package com.ees.servlet;

import com.ees.dao.UserDao;
import com.ees.dao.UserDaoTestImpl;
import com.ees.entity.User;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SampleServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        doPost(request, response);
    }

    public int checkUser(String login) {
        int check = 0;
        UserDao daotest = new UserDaoTestImpl();
        List<User> users = daotest.findAll();

        for (User user : users) {
            if (login.equals(user.getLogin())) {
                check = 1;
                break;
            }
            else{
                check = 0;
            }
        }
        return check;
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StringBuffer sb = new StringBuffer();
        String line = null;

        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null)
            sb.append(line);

        try {
            JSONObject jsonObject = new JSONObject(sb.toString());

            String login = jsonObject.getString("login");
            String pass = jsonObject.getString("pass");
            String html = "";

            // Invoke method for check if this user contains in our database
            if (checkUser(login) == 0)

            {
                PrintWriter out = response.getWriter();
                html = "User is not find";
                out.println(html);
            }

            // If pass is empty show only information from database
            else {
                if (pass.equals("")) {
                    UserDao dao = new UserDaoTestImpl();
                    User user = dao.findByLogin(login); /* call findByLogin method*/

                    PrintWriter out = response.getWriter();
                    html = html + "<p><div>"
                            + user.getId_users() + "</div>" + "<p><div>"
                            + user.getPass() + "</div>" + "<p><div>"
                            + user.getRole() + "</div>" + "<p><div>"
                            + user.getPrivilege() + "</div></p>";
                    out.println(html);

                } else {

                    UserDao dao = new UserDaoTestImpl();
                    User user = dao.findByLogin(login); /* call findByLogin method*/

                    if ((login.equals(user.getLogin())) && (pass.equals(user.getPass()))) {
                        html = "Authorization successfull !";
                    } else {
                        html = "Authorization denied. Login or password is incorrect";
                    }

                    PrintWriter out = response.getWriter();
                    out.println(html);
                }
            }

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }

//        String greetings = "Hello " + login;
//        response.setContentType("text/plain");
//        response.getWriter().write(greetings);

    }

//        String usermessage = "TEST successfull"; //message I will recieve
//        String text = request.getParameter("text");
//        PrintWriter out = response.getWriter();
//        out.println(usermessage + " " + text);

}