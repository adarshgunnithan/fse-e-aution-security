package com.cts.eaution.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.eaution.dao.UserDao;
import com.cts.eaution.entities.User;
import com.cts.eaution.exception.ExceptionCodes;
import com.cts.eaution.exception.SecurityException;
import com.cts.eaution.service.UserService;
import com.cts.eaution.vo.UserVO;
/**
 * @author aadi
 *Implementation of user service
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public UserVO saveUser(UserVO userVO) throws SecurityException {
		UserVO responseUserVO = null;
		User userEntity= null;
		
		User validationUser=userDao.findByEmail(userVO.getEmail());
		if(validationUser == null) {
			userEntity= new User();
			BeanUtils.copyProperties(userVO, userEntity);
			userEntity =	userDao.save(userEntity);
			responseUserVO= new UserVO();
			BeanUtils.copyProperties(userEntity, responseUserVO);
		}else {
			throw new SecurityException(ExceptionCodes.USER_ID_ALREADY_EXISTS, "Email id is already registered, Please try with new user");
		}
		
		return responseUserVO;
	}

	@Override
	public UserVO findByUseridAndPassword(String userid, String password) {
		// TODO Auto-generated method stub
		User user=userDao.findByEmailAndPassword(userid, password);
		UserVO userVO = null;
		if(user !=null) {
		 userVO = new UserVO();
		BeanUtils.copyProperties(user, userVO);
		}
		return userVO;
	}

	

}
