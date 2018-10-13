package commusic.output;

import java.util.LinkedList;

import org.springframework.stereotype.Service;

@Service
public class OutputService {
	
	//new Video("M7lc1UVf-VE", "youtube")
	LinkedList<Video> videos = new LinkedList<Video>();
	
	public Video[] getVideos() {
		Video[] videosArray = new Video[videos.size()];
		return videos.toArray(videosArray);
	}
	
	public Video get(int num) {
		return videos.get(num);
	}
	
	public void addVideo(Video video) {
		videos.add(video);
	}

	public void delete(int num) {
		videos.remove(num);
	}
}