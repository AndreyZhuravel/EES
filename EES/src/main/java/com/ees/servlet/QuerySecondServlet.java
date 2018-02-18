package com.ees.servlet;

import com.ees.dao.QuerySecondDaoImpl;
import com.ees.entity.QuerySecond;
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

            List<QuerySecond> list = QuerySecondDaoImpl.executeQuery(login); /* call findall method*/

            PrintWriter out = response.getWriter();

            Iterator<QuerySecond> iqs = list.listIterator();
            while (iqs.hasNext()) {
                QuerySecond q = iqs.next();
                html = html + "LeadId:" + q.getLeadid()
                        + ",Is_mist_adr:" + q.getIs_mist_adr()
                        + ",Is_mist_shop:" + q.getIs_mist_shop()
                        + ",Is_mist_phone:" + q.getIs_mist_phone() + ";";
            }

            System.out.println(html);

            out.println(html);

        } catch (JSONException e) {
            //throw new IOException("Error parsing JSON request string");
        }

    }
}


