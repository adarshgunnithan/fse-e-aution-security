package com.cts.eaution.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.eaution.service.SecurityTokenGenerator;
import com.cts.eaution.service.UserService;
import com.cts.eaution.vo.UserVO;

@RestController
@RequestMapping("api/v1/auth")
public class SecurityController {
	@Autowired
	UserService userServiceImpl;
	@Autowired
	SecurityTokenGenerator jwtSecurityTokenGeneratorImpl;
	
	@PostMapping("/login")
	public ResponseEntity<?> login (@RequestBody UserVO userVO){
		ResponseEntity<?> responseEntity =null;
		String userEmailId=userVO.getEmail();
		String password=userVO.getPassword();
		
		UserVO userResponseVO=userServiceImpl.findByUseridAndPassword(userEmailId, password);
		Map<String, String> map = jwtSecurityTokenGeneratorImpl.generateToken(userResponseVO);
		responseEntity = new ResponseEntity<>(map,HttpStatus.OK);
		return responseEntity;
	}
	


}
