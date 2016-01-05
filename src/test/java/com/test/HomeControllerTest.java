package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.controllers.HomeController;

public class HomeControllerTest {
	@InjectMocks
	HomeController controller;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testHomePage() throws Exception{
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
	}
}
