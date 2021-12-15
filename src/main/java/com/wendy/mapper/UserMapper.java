package com.wendy.mapper;

import com.wendy.pojo.User;

import java.util.List;

public interface UserMapper {
    public User findUser(User user);

    public List<User> findUsers();

    public void addUser(User user);

    public void delUserById(int userId);

    public void alterUser(User user);


}
