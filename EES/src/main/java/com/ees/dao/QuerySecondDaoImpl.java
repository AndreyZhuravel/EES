package com.ees.dao;

import com.ees.entity.QuerySecond;
import com.ees.services.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuerySecondDaoImpl implements QuerySecondDao {

    private static final String SECOND_QUERY = "" +
            "SELECT table_salesinfo.leadid,\n" +
            "case when table_address.id_table_salesinfo is not null then 1 else 0 end as is_mist_adr, " +
            "case when table_shops.id_table_salesinfo is not null then 1 else 0 end as is_mist_shop, " +
            "case when table_phone.id_table_salesinfo is not null then 1 else 0 end as is_mist_phone " +
            "FROM table_salesinfo " +
            "left join table_address ON table_salesinfo.id_salesinfo=table_address.id_table_salesinfo " +
            "left join table_shops ON table_salesinfo.id_salesinfo=table_shops.id_table_salesinfo " +
            "left join table_phone ON table_salesinfo.id_salesinfo=table_phone.id_table_salesinfo " +
            "left join table_users ON table_salesinfo.id_users = table_users.id_users " +
            "where table_users.login = ?";

    //Implementation of methods for get all data from table_address in db_ees_test

    public List<QuerySecond> selectSecondQueryData(String login) {

        List<QuerySecond> list = new ArrayList<QuerySecond>();

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = DBConnector.getConnection();

            stmt = conn.prepareStatement(SECOND_QUERY);
            stmt.setString(1, String.valueOf(login));

            System.out.println("Successfully call sql method for getting all infromation about all errors in all databases");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                QuerySecond querySecond = QuerySecond.createSecondQuery(rs);
                list.add(querySecond);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println("FindByLogin method was successfully executed");

        }
        return list;
    }

    public static List<QuerySecond> executeQuery(String login) {
        return new QuerySecondDaoImpl().selectSecondQueryData(login);
    }
}
