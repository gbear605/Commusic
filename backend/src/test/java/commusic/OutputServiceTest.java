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
	public void basicAddDeleteTest() {
		OutputService service = new OutputService();
		
		int idFirst = service.addVideo(new Video("M7lc1UVf-VE", "youtube")).getId();
		int idSecond = service.addVideo(new Video("other-id", "youtube")).getId();
		
		assertEquals(new Video("M7lc1UVf-VE", "youtube"), service.getById(idFirst));
		assertEquals(new Video("M7lc1UVf-VE", "youtube"), service.getNext());
		assertEquals(new Video("other-id", "youtube"), service.getById(idSecond));
		
		service.deleteById(idFirst);
		
		assertEquals(null, service.getById(idFirst));
		assertEquals(new Video("other-id", "youtube"), service.getById(idSecond));
		assertEquals(new Video("other-id", "youtube"), service.getNext());
	}
}