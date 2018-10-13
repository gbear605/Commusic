package commusic;

import org.junit.runner.RunWith;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import commusic.output.OutputService;
import commusic.output.Video;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OutputServiceTest {

	@Test
	public void testOutputVideoURLExampleTest() {
		assertEquals(new Video("M7lc1UVf-VE", "youtube"), new OutputService().getNextVideo());
	}
}