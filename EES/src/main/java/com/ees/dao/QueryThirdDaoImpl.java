package com.ees.dao;

import com.ees.entity.QueryThird;
import com.ees.services.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryThirdDaoImpl implements QueryThirdDao {

    private static final String THIRD_QUERY = "" +
            "SELECT u.login AS LOGIN, \n" +
            "s.leadid AS LEADID,\n" +
            "a.pos AS POS, \n" +
            "a.address_reg AS ADDRESS_REG, \n" +
            "a.address_fact AS ADDRESS_FACT, \n" +
            "a.shop AS SHOP, \n" +
            "a.region AS REGION, \n" +
            "a.status AS STATUS, \n" +
            "a.condition AS CONDITION\n" +
            "FROM table_salesinfo s\n" +
            "INNER JOIN table_address a ON s.id_salesinfo=a.id_table_salesinfo\n" +
            "LEFT JOIN table_users u\n" +
            "ON s.id_users = u.id_users\n" +
            "WHERE u.login = ? and s.leadid = ?::integer";

    //Implementation of methods for get all data from table_address in db_ees_test

    public QueryThird selectThirdQueryData(String login, String lead) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = DBConnector.getConnection();

            stmt = conn.prepareStatement(THIRD_QUERY);
            stmt.setString(1, String.valueOf(login));
            stmt.setString(2, String.valueOf(lead));

            System.out.println("Successfully call sql method for getting detail information about errors in address database");
            ResultSet rs = stmt.executeQuery();

//            if (rs.next() == false) {
//                System.out.println("ResultSet of SQL#3 is an empty");
//            }
//            else {
                while (rs.next()) {
                    QueryThird queryThird = QueryThird.createThirdQuery(rs);

                    return queryThird;
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


    public static QueryThird executeQuery(String login, String lead) {
        return new QueryThirdDaoImpl().selectThirdQueryData(login, lead);
    }
}
