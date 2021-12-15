package com.wendy.service.impl;

import com.wendy.mapper.UserMapper;
import com.wendy.pojo.User;
import com.wendy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(User login_user) {
        return userMapper.findUser(login_user);
    }
}
