package com.cts.eaution;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cts.eaution.controller.SecurityController;
import com.cts.eaution.exception.SecurityException;
import com.cts.eaution.service.SecurityTokenGenerator;
import com.cts.eaution.service.UserService;
import com.cts.eaution.vo.Role;
import com.cts.eaution.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(SecurityController.class)
public class SecurityControllerTest {
	
	private UserVO user = null;
	
	Map<String,String> tokenMap = null;
	
	@Autowired
	private transient MockMvc mvc;
	
	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZWxsZXIxOUBnbWFpbC5jb20iLCJyb2xlcyI6eyJzdWIiOiJzZWxsZXIxOUBnbWFpbC5jb20iLCJzY29wZXMiOiJTRUxMRVIiLCJ1c2VyRW1haWwiOiJzZWxsZXIxOUBnbWFpbC5jb20iLCJ1c2VySUQiOjF9LCJpYXQiOjE2NjUwMTc1NjAsImV4cCI6MTY2NTA0NzU2MX0.5uCw-8yQy9CjP-z9tfiuW2GlVARawTHNGi1humMpiMU";

	
	@MockBean
	UserService mockUserService;
	
	@MockBean
	SecurityTokenGenerator mockTokenGenerator;
	
	@BeforeEach
	void setUp() {
		System.out.println();
		user = new UserVO();
		user.setEmail("buyer1@gmail.com");
		user.setPassword("xxxx");
		user.setRole(Role.BUYER);
		
		
		tokenMap=new HashMap<>();
		tokenMap.put("token", token);
		tokenMap.put("message", "User successfully logged in ");
		
	}

	@Test
	void loginTest() throws JsonProcessingException, Exception, SecurityException {
		System.out.println();
		
		when(mockUserService.findByUseridAndPassword(user.getEmail(),user.getPassword())).thenReturn(user);
		when(mockTokenGenerator.generateToken(user)).thenReturn(tokenMap);

		mvc.perform(post("/api/v1/auth/login")
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(user))).andExpect(status().isOk());
		
		verify(mockUserService, times(1)).findByUseridAndPassword(Mockito.any(String.class),Mockito.any(String.class));
		verify(mockTokenGenerator, times(1)).generateToken(Mockito.any(UserVO.class));
	}
	
	private static String jsonToString(final Object obj) throws JsonProcessingException {
		// TODO Auto-generated method stub
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			result = jsonContent;
		} catch (JsonProcessingException e) {
			// TODO: handle exception
			result = "Json Processing error";
		}
		return result;
	}
}
