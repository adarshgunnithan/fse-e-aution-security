package com.cts.eaution.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eaution.exception.SecurityException;
import com.cts.eaution.service.UserService;
import com.cts.eaution.vo.UserVO;
/**
 * @author aadi
 *Controller for user operations
 */
@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	UserService userServiceImpl;
	
	/**
	 * For registering new user
	 * @param <T>
	 * @param userVO
	 * @return
	 * @throws SecurityException 
	 */
	@PostMapping
	public <T> ResponseEntity<?> registerUser(@Valid @RequestBody UserVO userVO) throws SecurityException {
		
		T responseUser=(T) userServiceImpl.saveUser(userVO);
		ResponseEntity<?>  response= new ResponseEntity<T>(responseUser, HttpStatus.CREATED);
		return response;
	}

}
