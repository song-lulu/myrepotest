package com.sll.dao;

import com.sll.entity.User;

import java.util.Date;
import java.util.List;

public interface UserDao {

    void del(Integer id);
    List<User> getAll();
    User getOne(Integer id);
    void toupdate(User user);
    void add(User user);

}
