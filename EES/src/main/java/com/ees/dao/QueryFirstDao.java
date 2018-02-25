package com.ees.dao;

import com.ees.entity.Query;

public interface QueryFirstDao {

    //Call Method for QueryFirst Entity from QueryFirstDaoImpl class for get all data from table_address in db_ees_test
    public Query selectOneQueryData(String login);

}
