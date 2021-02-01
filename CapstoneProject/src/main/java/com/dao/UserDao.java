package com.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.UserData;

@Repository
public interface UserDao extends CrudRepository<UserData, Integer>{

	boolean existsByUsername(String username);
	UserData findByUsername(String username);
}
