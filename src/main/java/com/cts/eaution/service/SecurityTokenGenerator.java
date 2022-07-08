package com.cts.eaution.service;

import java.util.Map;

import com.cts.eaution.vo.UserVO;

public interface SecurityTokenGenerator {
	public Map<String, String> generateToken(UserVO user) ;

}
