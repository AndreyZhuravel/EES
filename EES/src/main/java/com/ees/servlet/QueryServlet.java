package com.ees.servlet;

import com.ees.dao.QueryDao;
import com.ees.dao.QueryDaoImpl;
import com.ees.entity.Query;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryServlet extends HttpServlet {

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
            String html = "";

            QueryDao query = new QueryDaoImpl();
            Query q = query.getAllDataFromTableAddress(login); /* call findall method*/

            PrintWriter out = response.getWriter();

            html = "Id_users:" + q.getId_users()
                    + ",Login:" + q.getLogin()
                    + ",LeadId:" + q.getLeadid();

            out.println(html);

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }

    }
}


