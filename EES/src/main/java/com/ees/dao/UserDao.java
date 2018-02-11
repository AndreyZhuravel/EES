package com.ees.dao;

import com.ees.entity.User;

import java.util.List;

//Calling different methods for User Entity from UserDaoImpl class

public interface UserDao {

    public List<User> findAll();

    public User findByLogin(String login);

    public User findById(int id_users);

    public int insert(User user);

    public int update(User user);

    public int delete(int id_users);

}
