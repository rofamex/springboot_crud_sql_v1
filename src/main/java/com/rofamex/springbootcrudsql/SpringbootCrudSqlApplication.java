package com.rofamex.springbootcrudsql;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rofamex.springbootcrudsql.model.Customer;
import com.rofamex.springbootcrudsql.model.Zipcode;
import com.rofamex.springbootcrudsql.rowmapper.UserRowMapper;

@SpringBootApplication
public class SpringbootCrudSqlApplication implements CommandLineRunner {
	private static final Logger LOG = LoggerFactory.getLogger(SpringbootCrudSqlApplication.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		selectAllCustomer();
	}

	private void selectAllZipcodes() {
		String sql = "SELECT * FROM dbo.zipcode";
		List<Zipcode> zipcodes = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zipcode.class));

		zipcodes.forEach(zipcode -> {
			LOG.info("zipcode = {}", zipcode.getAddress());
		});
	}

	private void selectAllCustomer() {
		String sql = "SELECT * FROM dbo.customer";
		List<Customer> customers = jdbcTemplate.query(sql, new UserRowMapper());

		customers.forEach(customer -> {
			LOG.info("name = {}, age = {}", customer.getName(), customer.getAge());
		});
	}

}
