package com.ees.dao;

import com.ees.entity.Query;

public interface QueryDao {

    //Call Method for Quert Entity from QueryDaoImpl class for get all data from table_address in db_ees_test
    public Query selectOneQueryData(String login);

}
