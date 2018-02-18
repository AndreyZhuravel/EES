package com.ees.dao;

import com.ees.entity.Query;
import com.ees.services.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDaoImpl implements QueryDao {

    private static final String FIND_BY_LOGIN_TEST = "" +
            "SELECT table_users.id_users, table_users.login, table_salesinfo.leadid, table_address.* " +
            "FROM table_address " +
            "join table_salesinfo ON table_salesinfo.id_salesinfo = table_address.id_table_salesinfo " +
            "left join table_users ON table_salesinfo.id_users = table_users.id_users " +
            "where table_users.login =?";

    //Implementation of methods for get all data from table_address in db_ees_test

    public Query selectOneQueryData(String login) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = DBConnector.getConnection();

            stmt = conn.prepareStatement(FIND_BY_LOGIN_TEST);
            stmt.setString(1, String.valueOf(login));

            System.out.println("test sql method invokation");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Query query = Query.createQuery(rs);

                return query;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println("FindByLogin method was successfully executed");

        }
        return null;
    }

    public static Query executeQuery(String login) {
        return new QueryDaoImpl().selectOneQueryData(login);
    }
}
