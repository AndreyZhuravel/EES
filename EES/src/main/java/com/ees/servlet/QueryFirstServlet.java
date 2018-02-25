package com.ees.servlet;

import com.ees.dao.QueryFirstDaoImpl;
import com.ees.dao.QueryFirstDaoImpl;
import com.ees.entity.QueryFirst;
import com.ees.entity.QueryFirst;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryFirstServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException

    {
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/WEB-INF/views/jsp/welcome.jsp");
        dispatcher.forward(request, response);
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

            QueryFirst q = QueryFirstDaoImpl.executeQuery(login); /* call findall method*/

            PrintWriter out = response.getWriter();

            html = "Id_users:" + q.getId_users()
                    + ",Login:" + q.getLogin()
                    + ",LeadId:" + q.getLeadid()
                    + ",Id_table_address:" + q.getId_table_address()
                    + ",Pos:" + q.getPos()
                    + ",Address_reg:" + q.getAddress_reg()
                    + ",Address_fact:" + q.getAddress_fact()
                    + ",Shop:" + q.getShop()
                    + ",Region:" + q.getRegion()
                    + ",Status:" + q.getStatus()
                    + ",Condition:" + q.getCondition()
                    + ",Id_table_sales_info:" + q.getId_table_salesinfo();

            System.out.println(html);

            out.println(html);

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }

    }
}


