package commusic.output;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class OutputService {
	
	int nextId = 0;
	
	LinkedList<Video> videos = new LinkedList<Video>();
	
	public Video[] getVideos() {
		Video[] videosArray = new Video[videos.size()];
		return videos.toArray(videosArray);
	}
	
	public Video getById(int id) {
		for(Video video: videos) {
			if(video.getId() == id) {
				return video;
			}
		}
		return null;
	}
	
	public Video getNext() {
		return videos.getFirst();
	}
	
	public Video addVideo(Video video) {
		video.setId(nextId);
		nextId++;
		videos.add(video);
		
		return video;
	}

	public Video deleteById(int id) {
		Video v = getById(id);
		videos.remove(v);
		return v;
	}

	public int length() {
		return videos.size();
	}
}