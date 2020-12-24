package com.sll.service;

import com.sll.dao.UserDao;
import com.sll.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public void del(Integer id) {
        dao.del(id);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public User getOne(Integer id) {
        return dao.getOne(id);
    }

    @Override
    public void toupdate(User user) {
        dao.toupdate(user);
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }
}
