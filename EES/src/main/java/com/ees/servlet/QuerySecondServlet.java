package com.ees.servlet;

import com.ees.dao.QuerySecondDaoImpl;
import com.ees.entity.QuerySecond;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class QuerySecondServlet extends HttpServlet {

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

            // Invoke method for check if user fill field login
            if (login.equals(""))

            {
                PrintWriter out = response.getWriter();
                System.out.println("Need login and lead for this sql request");
                html = "102";
                out.println(html);
            }
            else {

                List<QuerySecond> list = QuerySecondDaoImpl.executeQuery(login); /* call findall method*/
                if ((list == null) || list.isEmpty()) {
                    PrintWriter out = response.getWriter();
                    System.out.println("ResultSet of SQL#1 is an empty");
                    html = "111";
                    out.println(html);
                } else {
                    PrintWriter out = response.getWriter();
                    Iterator<QuerySecond> iqs = list.listIterator();

                    while (iqs.hasNext()) {
                        QuerySecond q = iqs.next();
                        System.out.println(q);
                        html = html + "LeadId:" + q.getLeadid()
                                + ",Is_mist_adr:" + q.getIs_mist_adr()
                                + ",Is_mist_shop:" + q.getIs_mist_shop()
                                + ",Is_mist_phone:" + q.getIs_mist_phone() + ";";
                    }
                    System.out.println(html);

                    out.println(html);
                }
            }

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }

    }
}


