/*
 * Copyright (c) 2019, wenwenliuyun@163.com All Rights Reserved. 
 */    
  
package com.liuyun.service;

import java.util.List;

import com.liuyun.domain.User;

/** 
 * Function: TODO <br>
 *
 * @author liuyun
 * @version 
 * @since 2019年8月29日下午7:42:38
 */
public interface IUserService {
    long count() throws Exception;

    int deleteById(Integer id) throws Exception;

    int insert(User record) throws Exception;
    
    int update(Integer id, User record) throws Exception;

    List<User> findAll() throws Exception;

    User findById(Integer id) throws Exception;
}
  