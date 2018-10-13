package commusic;

import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import commusic.output.OutputController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommusicTest {

	@Autowired
	private OutputController controller;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void contextLoads() throws Exception {
	}

}
