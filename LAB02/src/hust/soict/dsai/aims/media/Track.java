package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	// constructer
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	// getter and setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	// add method play
	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track track = (Track) obj;
			return this.title.equals(track.title) && this.length == track.length;
		}
		return false;

	}

	@Override
	public String toString() {

		return " Title : " + this.getTitle() + " Length : " + this.getLength();
	}

}
