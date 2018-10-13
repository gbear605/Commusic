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
		OutputService service = new OutputService();
		
		service.addVideo(new Video("M7lc1UVf-VE", "youtube"));
		service.addVideo(new Video("other-id", "youtube"));
		
		assertEquals(new Video("M7lc1UVf-VE", "youtube"), service.get(0));
		assertEquals(new Video("other-id", "youtube"), service.get(1));
		
		service.delete(0);
		
		assertEquals(new Video("other-id", "youtube"), service.get(0));
	}
}