package com.atex.blogping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AtexApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void checkEmployeeInfoWhenNameMissingNameThenFailure() throws Exception {
		MockHttpServletRequestBuilder createEmployee = post("/")
				.param("age", "20");

		mockMvc.perform(createEmployee)
				.andExpect(model().hasErrors());
	}

	@Test
	public void checkEmployeeInfoWhenNameTooShortThenFailure() throws Exception {
		MockHttpServletRequestBuilder createEmployee = post("/")
				.param("name", "s")
				.param("age", "23");


		mockMvc.perform(createEmployee)
				.andExpect(model().hasErrors());
	}

	@Test
	public void checkEmployeeInfoWhenAgeMissingThenFailure() throws Exception {
		MockHttpServletRequestBuilder createEmployee = post("/")
				.param("name", "Sandy");

		mockMvc.perform(createEmployee)
				.andExpect(model().hasErrors());
	}

	@Test
	public void checkEmployeeInfoWhenAgeTooYoungThenFailure() throws Exception {
		MockHttpServletRequestBuilder createEmployee = post("/")
				.param("age", "3")
				.param("name", "Sandy");

		mockMvc.perform(createEmployee)
				.andExpect(model().hasErrors());
	}

	@Test
	public void checkEmployeeInfoWhenValidRequestThenSuccess() throws Exception {
		MockHttpServletRequestBuilder createEmployee = post("/")
				.param("name", "Sandy")
				.param("age", "38");

		mockMvc.perform(createEmployee)
				.andExpect(model().hasNoErrors());
	}
}
