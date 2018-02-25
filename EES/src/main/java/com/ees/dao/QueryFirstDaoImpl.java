package com.ees.dao;

import com.ees.entity.QueryFirst;
import com.ees.services.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryFirstDaoImpl {

    private static final String FIND_BY_LOGIN_TEST = "" +
            "SELECT table_users.id_users, table_users.login, table_salesinfo.leadid " +
            "FROM table_address " +
            "join table_salesinfo ON table_salesinfo.id_salesinfo = table_address.id_table_salesinfo " +
            "left join table_users ON table_salesinfo.id_users = table_users.id_users " +
            "where table_users.login = ?";

    //Implementation of methods for get all data from table_address in db_ees_test

    public QueryFirst selectOneQueryData(String login) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = DBConnector.getConnection();

            stmt = conn.prepareStatement(FIND_BY_LOGIN_TEST);
            stmt.setString(1, String.valueOf(login));

            System.out.println("Successfully call sql method for getting short information about errors in address database");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                QueryFirst query = QueryFirst.createQuery(rs);

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

    public static QueryFirst executeQuery(String login) {
        return new QueryFirstDaoImpl().selectOneQueryData(login);
    }
}
