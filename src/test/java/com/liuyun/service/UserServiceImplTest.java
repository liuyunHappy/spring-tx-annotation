/*
 * Copyright (c) 2019, wenwenliuyun@163.com All Rights Reserved. 
 */

package com.liuyun.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuyun.config.SpringConfiguration;
import com.liuyun.domain.User;
import com.liuyun.service.IUserService;

/**
 * Function: UserServiceImpl的测试类 <br>
 *
 * @author liuyun
 * @version
 * @since 2019年8月29日下午9:58:34
 */
@RunWith(SpringJUnit4ClassRunner.class) // spring和junit整合的运行器
@ContextConfiguration(classes=SpringConfiguration.class) // 指定spring配置文件的位置
public class UserServiceImplTest {
	@Autowired
	private IUserService userService;

	// 对象id
	private Integer id;

	@Before
	public void setUp() throws Exception {
		if (id == null) {
			List<User> list = userService.findAll();
			if (list != null && !list.isEmpty()) {
				User user = list.get(list.size() - 1);
				id = user.getId();
			}
		}
		System.out.println("特测试前：id=" + id);
	}

	@Test
	public void testCount() throws Exception {
		long count = userService.count();
		System.out.println("testCount" + " : " + count);
	}

	@Test
	public void testInsert() throws Exception {
		User user = new User();
		Date date = new Date();
		user.setUsername("Test" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		user.setBirthday(date);
		user.setSex("1");
		user.setAddress("suzhou");
		int count = userService.insert(user);
		System.out.println("testInsert" + " : " + count);
	}

	@Test
	public void testFindById() throws Exception {
		User user = userService.findById(id);
		System.out.println("testFindById" + " : " + user);
	}

	@Test
	public void testUpdate() throws Exception {
		User user = new User();
		Date date = new Date();
		user.setUsername("Test" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		user.setBirthday(date);
		user.setSex("1");
		user.setAddress("suzhou");
		int count = userService.update(id, user);
		System.out.println("testUpdate" + " : " + count);
	}

	@Test
	public void testFindAll() throws Exception {
		List<User> users = userService.findAll();
		System.out.println("testFindAll" + " : " + users);
	}

	@Test
	public void testDeleteById() throws Exception {
		int count = userService.deleteById(id);
		System.out.println("testDeleteById" + " : " + count);
	}
}
