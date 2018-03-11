package com.ees;

import com.ees.dao.UserDao;
import com.ees.dao.UserDaoImpl;
import com.ees.entity.User;
import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class UserTest {

    @Test
    public void NumberOfUsersInDatabase() {

        UserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();

        System.out.println(users.size());
        //true, check size of in db_db_ees_test in table_users
        assertThat(users, hasSize(10));

        System.out.println("NumberOfUsersInDatabase test is OK");
    }

//    @Test
//    public void UpdateUser() {
//
//        int id_users = 7;
//        String login = "ivan";
//        String pass = "1234567";
//        String role = "agent";
//        String privilege = "read";;
//
//        User user = new User(id_users,login,pass,role,privilege);
//        UserDao dao = new UserDaoImpl();
//        dao.update(user);
//        System.out.println("Update user");
//    }

    @Test
    public void UserFieldsIsNotNull() {
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();

        //true, check not null
        for (User user : users) {
            assertThat(user.getId_users(), is(notNullValue()));
            assertThat(user.getLogin(), is(notNullValue()));
            assertThat(user.getPass(), is(notNullValue()));
            assertThat(user.getRole(), is(notNullValue()));
            assertThat(user.getPrivilege(), is(notNullValue()));
        }

        //true, check null
//        for (User user:users) {
//            assertThat(user.getLogin(), is(nullValue()));
//        }

        System.out.println("UserFieldsIsNotNull test is OK");
    }

    @Test
    public void UserPasswordLength() {

        UserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();

        for (User user : users) {
            assertThat(user.getPass().length(), lessThan(8));
        }

        System.out.println("UserPasswordLenght test is OK");

    }

    @Test
    public void UserPasswordContainsNumbers() {

        UserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();

        for (User user : users) {
            Pattern p = Pattern.compile("(([0-9]))");
//          Pattern p = Pattern.compile("(([a-zA-Z]))");
//          Pattern p = Pattern.compile("(([A-Z].*[0-9]))");
            Matcher m = p.matcher(user.getPass());
            boolean b = m.find();
            System.out.println(b);

        }
        System.out.println("UserPasswordLenght test is OK");
    }


    @Test
    public void UserLoginDuplicates() {

        UserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();

        int check = 0;

        for (int i = 0; i < users.size(); i++) {
            for (int k = i + 1; k < users.size(); k++) {
                if (users.get(i).getLogin().equals(users.get(k).getLogin())) {
                    System.out.println(users.get(i).getLogin());
                    check = 1;
                }
            }
        }
        if (check == 0) {
            System.out.println("No duplicates detected");
        }

        System.out.println("UserPasswordLenght test is OK");
    }
}

