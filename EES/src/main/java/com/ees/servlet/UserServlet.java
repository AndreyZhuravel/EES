package com.ees.servlet;

import com.ees.dao.UserDao;
import com.ees.dao.UserDaoImpl;
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

public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        doPost(request, response);
    }

    //Method for check if user present in database or not, if yes = 1, if no = 0.
    public int checkUser(String login) {
        int check = 0;

        UserDao daotest = new UserDaoImpl();
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

            // Invoke method for check if this user present in db_ees_test
            if (checkUser(login) == 0)

            {
                PrintWriter out = response.getWriter();
                System.out.println("User is not found in database");
                html = "User is not found";
                out.println(html);
            }

            // If password is empty get some information from db_ees_test
            else {
                if (pass.equals("")) {

                    User user = UserDaoImpl.getByLogin(login); /* call findByLogin method*/

                    PrintWriter out = response.getWriter();

                    html = "Id_users:" + user.getId_users()
                            + ",Role:" + user.getRole()
                            + ",Privilege:" + user.getPrivilege();

                    out.println(html);

                } else {
                    User user = UserDaoImpl.getByLogin(login); /* call findByLogin method*/

                    if ((login.equals(user.getLogin())) && (pass.equals(user.getPass()))) {
                        System.out.println(user.getLogin());

                        if (user.getRole().equals("root")) {
                            System.out.println("Admin authorization");
                            html = "777"; /* Successfull user entering*/
                        }
                        else {
                            System.out.println("Successfull user authorization");
                            html = "100"; /* Successfull user entering*/
                        }

                    } else {
                        System.out.println("Login or password for this user is incorrect");
                        html = "Authorization denied. Login or password is incorrect";
                        }

                    PrintWriter out = response.getWriter();
                    out.println(html);
                }
            }

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }

    }
}