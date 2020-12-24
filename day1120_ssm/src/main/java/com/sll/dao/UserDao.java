package com.sll.dao;

import com.sll.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    int delete(Integer id);

    int update(User user);

    User getOne(Integer id);

    int add(User user);

}
