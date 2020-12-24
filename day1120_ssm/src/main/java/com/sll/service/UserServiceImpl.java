package com.sll.service;

import com.sll.dao.UserDao;
import com.sll.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public int update(User user) {
        return dao.update(user);
    }

    @Override
    public User getOne(Integer id) {
        return dao.getOne(id);
    }

    @Override
    public int add(User user) {
        return dao.add(user);
    }
}
