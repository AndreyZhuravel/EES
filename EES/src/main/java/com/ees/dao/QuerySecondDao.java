package com.ees.dao;

import com.ees.entity.QuerySecond;

import java.util.List;

public interface QuerySecondDao {

    public List<QuerySecond> selectSecondQueryData(String login);
}
