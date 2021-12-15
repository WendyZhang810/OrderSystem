package com.wendy.service;

import com.wendy.pojo.User;

import java.util.List;

public interface EmpManageService {

    public List<User> getAllEmp();

    void addUser(User user);

    void alterUser(User user);

    void delUser(int parseInt);
}
