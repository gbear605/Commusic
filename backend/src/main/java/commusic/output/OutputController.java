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
	
	@RequestMapping(value = "/output/next", method = RequestMethod.GET)
	public ResponseEntity<?> getNext() {
		if(service.length() > 0) {
			return new ResponseEntity<Video>(service.getNext(), HttpStatus.OK);
		}
		return new ResponseEntity<Video>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/output", method = RequestMethod.POST)
	public ResponseEntity<?> addVideo(@RequestBody Video video, UriComponentsBuilder ucBuilder) {
		Video addedVideo = service.addVideo(video);
		
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/output/{id}").buildAndExpand(addedVideo.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

	@RequestMapping(value = "/output/{id}", method = RequestMethod.GET)
	public ResponseEntity<Video> getOne(@PathVariable("id") int num) {
		Video v = service.getById(num);
		if(v == null) {
			return new ResponseEntity<Video>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Video>(v, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/output/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Video> deleteVideo(@PathVariable("id") int num) {
		Video v = service.deleteById(num);
		if(v == null) {
			return new ResponseEntity<Video>(HttpStatus.GONE);
		}
		return new ResponseEntity<Video>(v, HttpStatus.OK);
	}
}