package com.ees;

import java.util.List;

public interface UserDao {

    public List<EntityUser> findAll();

    public EntityUser findById(int id_users);

    public EntityUser findByLogin(String login);

    public int insert(EntityUser user);

    public int update(EntityUser user);

    public int delete(int id_users);

}
