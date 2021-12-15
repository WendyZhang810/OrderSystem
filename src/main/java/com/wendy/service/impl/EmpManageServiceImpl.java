package com.wendy.service.impl;

import com.wendy.mapper.UserMapper;
import com.wendy.pojo.User;
import com.wendy.service.EmpManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpManageServiceImpl implements EmpManageService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllEmp() {
        return userMapper.findUsers();
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void alterUser(User user) {
        userMapper.alterUser(user);
    }

    @Override
    public void delUser(int parseInt) {
        userMapper.delUserById(parseInt);
    }

}
