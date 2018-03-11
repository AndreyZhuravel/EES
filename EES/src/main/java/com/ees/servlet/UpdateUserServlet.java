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

public class UpdateUserServlet extends HttpServlet {
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
            String role = jsonObject.getString("role");
            String privilege = jsonObject.getString("privilege");
            String html = "";

            // Invoke method for check if this user present in db_ees_test
            if (checkUser(login) == 0)

            {
                PrintWriter out = response.getWriter();
                System.out.println("Update cancel.User with this name not found in database");
                html = "Update cancel.User with this name not found in database";
                out.println(html);
            }

            else {
                User user = UserDaoImpl.getByLogin(login);//get current user parameters

                User userupd = new User(user.getId_users(),login,pass,role,privilege); //update this user with new parameters

                UserDao dao = new UserDaoImpl();
                dao.update(userupd);

                PrintWriter out = response.getWriter();
                html = "Id_users:" + user.getId_users()
                        + ",Login:" + user.getLogin()
                        + ",Pass:" + user.getPass()
                        + ",Role:" + user.getRole()
                        + ",Privilege:" + user.getPrivilege()
                        + " was successfully updated";

                out.println(html);
            }

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }
    }
}
