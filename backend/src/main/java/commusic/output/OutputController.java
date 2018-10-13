package commusic.output;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class OutputController {

	private final OutputService service;

	public OutputController(OutputService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/output", method = RequestMethod.GET)
	public Video[] get() {
		return service.getVideos();
	}
	
	@RequestMapping(value = "/output", method = RequestMethod.POST)
	public ResponseEntity<?> addVideo(@RequestBody Video video, UriComponentsBuilder ucBuilder) {
		service.addVideo(video);
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/output/{num}").buildAndExpand(service.getVideos().length).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/output/{num}", method = RequestMethod.GET)
	public Video getOne(@PathVariable("num") int num) {
		return service.get(num);
	}
	
	@RequestMapping(value = "/output/{num}", method = RequestMethod.DELETE)
	public void deleteVideo(@PathVariable("num") int num) {
		service.delete(num);
	}
}