package com.sll.service;

import com.sll.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    void del(Integer id);
    List<User> getAll();
    User getOne(Integer id);
    void toupdate(User user);
    void add(User user);
}
