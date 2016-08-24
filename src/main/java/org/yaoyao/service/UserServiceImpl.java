package org.yaoyao.service;

import org.yaoyao.dao.UserDao;
import org.yaoyao.entity.User;

import javax.annotation.Resource;

public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userMapper;

    public boolean addUser(User user) {
        return userMapper.insert(user) == 1 ? true : false;
    }

    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
