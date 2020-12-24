package com.sll.dao;

import com.sll.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate template;

    @Override
    public void del(Integer id) {

        template.update("delete from user where id=?",id);

    }

    @Override
    public List<User> getAll() {

        return template.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String gender = rs.getString(4);
                String date = rs.getString(5);
                Date birth = null;
                if (date != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        birth = sdf.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                User user = new User(id, name, age, gender, birth);
                return user;
            }
        });
    }

    @Override
    public User getOne(Integer id) {
        User user = template.queryForObject("select * from user where id=?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String gender = rs.getString(4);
                String date = rs.getString(5);
                Date birth = null;
                if (date != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        birth = sdf.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                user.setGender(gender);
                user.setBirth(birth);
                return user;
            }
        }, id);
        return user;
    }

    @Override
    public void toupdate(User user) {

        template.update("update user set name=?,age=?,gender=?,birth=? where id=?",user.getName(),user.getAge(),user.getGender(),user.getBirth(),user.getId());

    }

    @Override
    public void add(User user) {
        template.update("insert into user(name,age,gender,birth) values(?,?,?,?)",user.getName(),user.getAge(),user.getGender(),user.getBirth());
    }
}
