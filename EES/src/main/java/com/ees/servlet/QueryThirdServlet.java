package com.ees.servlet;

import com.ees.dao.QueryThirdDaoImpl;
import com.ees.entity.QueryThird;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryThirdServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        doPost(request, response);
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
            String lead = jsonObject.getString("lead");
            String html = "";

            // Invoke method for check if user fill field login and field lead
            if (login.equals("") || lead.equals(""))

            {
                PrintWriter out = response.getWriter();
                System.out.println("Need login and lead for this sql request");
                html = "103";
                out.println(html);
            }
            else {
                QueryThird q = QueryThirdDaoImpl.executeQuery(login, lead); /* call findall method*/

                PrintWriter out = response.getWriter();

                html = "Login:" + q.getLogin()
                        + ",LeadId:" + q.getLeadid()
                        + ",Pos:" + q.getPos()
                        + ",Address_reg:" + q.getAddress_reg()
                        + ",Address_fact:" + q.getAddress_fact()
                        + ",Shop:" + q.getShop()
                        + ",Region:" + q.getRegion()
                        + ",Status:" + q.getStatus()
                        + ",Condition:" + q.getCondition();

                System.out.println(html);

                out.println(html);
            }

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }

    }
}


