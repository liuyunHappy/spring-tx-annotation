/*
 * Copyright (c) 2019, wenwenliuyun@163.com All Rights Reserved. 
 */

package com.liuyun.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import com.liuyun.dao.IUserDao;
import com.liuyun.domain.User;

/**
 * Function: TODO <br>
 *
 * @author liuyun
 * @version
 * @since 2019年8月29日下午7:41:04
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public long count() throws Exception {
		String sql = "select count(*) from user";
		Long count = jdbcTemplate.queryForObject(sql, new SingleColumnRowMapper<Long>(Long.class));
		return count;
	}

	@Override
	public int deleteById(Integer id) {
		String sql = "delete from user where id=?";
		int count = jdbcTemplate.update(sql, id);
		return count;
	}
  
	@Override
	public int insert(User user) {
		String sql = "insert into user (username,birthday,sex,address) value (?,?,?,?)";
		int count = jdbcTemplate.update(sql, user.getUsername(),
				user.getBirthday() == null ? null : new Date(user.getBirthday().getTime()), user.getSex(),
				user.getAddress());
		return count;
	}

	@Override
	public int update(User user) {
		String sql = "update user set username=?,birthday=?,sex=?,address=? where id=?";
		int count = jdbcTemplate.update(sql, user.getUsername(),
				user.getBirthday() == null ? null : new Date(user.getBirthday().getTime()), user.getSex(),
				user.getAddress(), user.getId());
		return count;
	}

	@Override
	public List<User> findAll() {
		String sql = "select id,username,birthday,sex,address from user";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return users;
	}

	@Override
	public User findById(Integer id) {
		String sql = "select id,username,birthday,sex,address from user where id=?";
		List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
		if (users == null || users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}
}
