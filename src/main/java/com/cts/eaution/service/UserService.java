package com.cts.eaution.service;

import com.cts.eaution.vo.UserVO;

/**
 * @author aadi
 * API for user services
 *
 */
public interface UserService {
	/**
	 * API for save user
	 * @param userVO
	 * @return
	 */
	public UserVO saveUser(UserVO userVO);
	/**
	 * API to get user by userid and password for authentication
	 * @param userid
	 * @param password
	 * @return
	 */
	public UserVO findByUseridAndPassword(String userid, String password);

}
