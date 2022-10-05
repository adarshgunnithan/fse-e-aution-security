package com.cts.eaution.dao;

import org.springframework.data.repository.CrudRepository;

import com.cts.eaution.entities.User;

/**
 * @author aadi
 *API for user dao
 */
public interface UserDao extends CrudRepository<User, Long>{
/**
 * API to login using email and password
 * user id is email
 * @param userId
 * @param password
 * @return
 */
User  findByEmailAndPassword(String userId, String password);

/**
 * API to get user by email id
 * @param emailId
 * @return
 */
User findByEmail(String emailId);
}
