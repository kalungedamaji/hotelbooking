package com.m3bi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m3bi.model.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	public User findByName(String name);
}
