package com.rofamex.springbootcrudsql.model;

import java.time.LocalDateTime;

public class User {
	private String name;
	private int age;
	private LocalDateTime created_date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", created_date=" + created_date + "]";
	}

}
