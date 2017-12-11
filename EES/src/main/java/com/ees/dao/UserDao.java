package com.ees.dao;

import com.ees.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public User findById(int id_users);

    public User findByLogin(String login);

    public int insert(User user);

    public int update(User user);

    public int delete(int id_users);

}
