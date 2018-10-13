package commusic.output;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OutputController {

	private final OutputService service;

	public OutputController(OutputService service) {
		this.service = service;
	}

	@RequestMapping("/output")
	public Video output() {
		return service.getNextVideo();
	}
}