package com.rofamex.springbootcrudsql.route;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.BeanProperty;
import com.rofamex.springbootcrudsql.model.User;

@Component
public class MainRoute {
	private static final Logger LOG = LoggerFactory.getLogger(MainRoute.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MainRoute() {
		selectAllUsers();
	}

	private void selectAllUsers() {
		String sql = "Select * from user";
		List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));

		users.forEach(System.out::println);
	}

}
