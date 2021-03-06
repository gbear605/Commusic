package commusic;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OutputControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(post("/output").content("{\"videoId\":\"M7lc1UVf-VE\",\"service\":\"youtube\",\"id\":0}")
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
		this.mockMvc.perform(get("/output")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().json("[{\"videoId\":\"M7lc1UVf-VE\",\"service\":\"youtube\",\"id\":0}]", false));
		this.mockMvc.perform(get("/output/0")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().json("{\"videoId\":\"M7lc1UVf-VE\",\"service\":\"youtube\",\"id\":0}", false));
		this.mockMvc.perform(get("/output/1")).andDo(print()).andExpect(status().isNotFound());
	}
}
