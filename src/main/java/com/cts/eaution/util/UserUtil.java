package com.cts.eaution.util;

import java.util.Date;

import com.cts.eaution.entities.Role;
import com.cts.eaution.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserUtil {
public static void main(String[] args) {
	UserVO userVO = new UserVO();
	userVO.setId(1l);
	userVO.setEmail("adarsh@gmail.com");
//	userVO.setCreatedDate(new Date());
//	userVO.setModifiedDate(new Date());
	userVO.setPassword("pass");
	userVO.setRole(Role.BUYER);
	
	//UserDetailsVO userDetails =  new UserDetailsVO();
	///userDetails.setAddress("dummy address");
	userVO.setUserDetails(null);
	
	 ObjectMapper Obj = new ObjectMapper();
	  try {
		String jsonStr = Obj.writeValueAsString(userVO);
		System.out.println(jsonStr);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
