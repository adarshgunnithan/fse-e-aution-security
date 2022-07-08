package com.cts.eaution.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.eaution.entities.User;

public interface UserDao extends CrudRepository<User, Long>{
User  findByEmailAndPassword(String userId, String password);
}
