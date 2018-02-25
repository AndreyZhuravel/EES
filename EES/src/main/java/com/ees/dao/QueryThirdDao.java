package com.ees.dao;

import com.ees.entity.QueryThird;

public interface QueryThirdDao {

    public QueryThird selectThirdQueryData(String login, String lead);
}
