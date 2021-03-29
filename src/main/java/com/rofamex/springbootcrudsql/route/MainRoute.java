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
import com.rofamex.springbootcrudsql.model.Zipcode;

public class MainRoute {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOG = LoggerFactory.getLogger(MainRoute.class);

	public MainRoute() {
		selectAllZipcodes();
	}

	private void selectAllZipcodes() {
		String sql = "SELECT * FROM zipcode";
		List<Zipcode> zipcodes = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zipcode.class));

		zipcodes.forEach(System.out::println);
	}

}
