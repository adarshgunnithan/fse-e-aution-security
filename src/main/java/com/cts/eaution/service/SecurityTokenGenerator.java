package com.cts.eaution.service;

import java.util.Map;

import com.cts.eaution.vo.UserVO;

/**
 * @author aadi
 *API to generate token for user
 */
public interface SecurityTokenGenerator {
	/**
	 * Generate token for user
	 * @param user
	 * @return
	 */
	public Map<String, String> generateToken(UserVO user) ;

}
