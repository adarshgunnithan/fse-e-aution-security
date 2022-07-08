package com.cts.eaution.service;

import com.cts.eaution.vo.UserVO;

public interface UserService {
	public UserVO saveUser(UserVO userVO);
	public UserVO findByUseridAndPassword(String userid, String password);

}
