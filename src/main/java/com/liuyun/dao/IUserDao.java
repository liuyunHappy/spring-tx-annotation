package com.liuyun.dao;

import java.util.List;

import com.liuyun.domain.User;

public interface IUserDao {
    long count() throws Exception;

    int deleteById(Integer id) throws Exception;

    int insert(User user) throws Exception;
    
    int update(User user) throws Exception;

    List<User> findAll() throws Exception;

    User findById(Integer id) throws Exception;
}