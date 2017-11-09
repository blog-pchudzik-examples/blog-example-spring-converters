package com.pchudzik.blog.example.springconverter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = Controller.class)
@RunWith(SpringRunner.class)
public class ControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void should_parse_id_from_plain_string() throws Exception {
		//given
		final String emptyId = "00000000-0000-0000-0000-000000000000";

		//when
		mockMvc.perform(MockMvcRequestBuilders.get("/find-id/" + emptyId))

				//then
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", equalTo(emptyId)));
	}

	@Test
	public void should_parse_uuid_from_string() throws Exception {
		//given
		final String emptyId = "00000000-0000-0000-0000-000000000000";

		//when
		mockMvc.perform(MockMvcRequestBuilders.get("/find-uuid/" + emptyId))

				//then
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", equalTo(emptyId)));
	}
}