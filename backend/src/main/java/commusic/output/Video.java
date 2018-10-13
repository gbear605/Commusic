package commusic.output;

public class Video {
	
    private int id;

	private final String videoId;
	private final String service;

	public Video(String videoId, String service) {
		this.videoId = videoId;
		this.service = service;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (videoId == null) {
			if (other.videoId != null)
				return false;
		} else if (!videoId.equals(other.videoId))
			return false;
		return true;
	}

	public String getVideoId() {
		return videoId;
	}

	public String getService() {
		return service;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
