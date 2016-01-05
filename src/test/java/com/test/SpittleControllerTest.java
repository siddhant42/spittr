package com.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.controllers.SpittleController;
import com.data.Spittle;
import com.data.SpittleRepository;

public class SpittleControllerTest {
	@InjectMocks
	SpittleController controller;
	@Mock
	SpittleRepository mockRepository ;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		
		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
		.thenReturn(expectedSpittles);
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
				.build();
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("spittles"))
		.andExpect(model().attributeExists("spittle1"))
		.andExpect(model().attribute("spittle1",
				hasItems(expectedSpittles.toArray())));;
	}
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i=0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}
}
