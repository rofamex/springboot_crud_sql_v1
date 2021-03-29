package com.rofamex.springbootcrudsql.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rofamex.springbootcrudsql.model.Customer;

public class UserRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer user = new Customer();
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));

		return user;

	}
}