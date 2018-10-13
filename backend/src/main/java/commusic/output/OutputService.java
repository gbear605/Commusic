package commusic.output;

import org.springframework.stereotype.Service;

@Service
public class OutputService {

	public Video getNextVideo() {
		return new Video("M7lc1UVf-VE", "youtube");
	}
}