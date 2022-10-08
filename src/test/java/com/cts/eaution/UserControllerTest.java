package com.cts.eaution;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

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

import com.cts.eaution.controller.UserController;
import com.cts.eaution.exception.SecurityException;
import com.cts.eaution.service.UserService;
import com.cts.eaution.vo.Role;
import com.cts.eaution.vo.UserDetailVO;
import com.cts.eaution.vo.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {
	@MockBean
	UserService mockUserService;
	static int a;

	private UserVO buyer = null;
	@Autowired
	private transient MockMvc mvc;

	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzZWxsZXIxOUBnbWFpbC5jb20iLCJyb2xlcyI6eyJzdWIiOiJzZWxsZXIxOUBnbWFpbC5jb20iLCJzY29wZXMiOiJTRUxMRVIiLCJ1c2VyRW1haWwiOiJzZWxsZXIxOUBnbWFpbC5jb20iLCJ1c2VySUQiOjF9LCJpYXQiOjE2NjUwMTc1NjAsImV4cCI6MTY2NTA0NzU2MX0.5uCw-8yQy9CjP-z9tfiuW2GlVARawTHNGi1humMpiMU";

	@BeforeEach
	void setUp() {

		buyer = new UserVO();
		UserDetailVO userDetails = new UserDetailVO();

		buyer.setEmail("buyer1@gmail.com");
		buyer.setPhoneNumber("9999999999");
		buyer.setCreatedDate(new Date());
		buyer.setPassword("xxxx");
		buyer.setRole(Role.BUYER);
		buyer.setUserDetails(userDetails);

		userDetails.setFirstName("Johnny");
		userDetails.setLastName("Konei");

		buyer.setUserDetails(userDetails);

	}

	@Test
	void saveUserTest() throws SecurityException, JsonProcessingException, Exception {
		System.out.println(a);
		when(mockUserService.saveUser(buyer)).thenReturn(buyer);

		mvc.perform(post("/api/v1/user/").header("authorization", "Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(buyer))).andExpect(status().isCreated());
		verify(mockUserService, times(1)).saveUser(Mockito.any(UserVO.class));
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
