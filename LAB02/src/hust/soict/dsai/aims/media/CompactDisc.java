package hust.soict.dsai.aims.media;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	// constructer
	public CompactDisc(String title, String category, float cost, String director, int length, String artist,
			List<Track> tracks) {
		super(title, category, cost, director, length);
		this.artist = artist;
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	// add
	public void addTrack(Track track) {
		// check if not exist
		if (!tracks.contains(track)) {
			tracks.add(track);
			System.out.println("Add succesfull");
		} else
			System.out.println("The track exist in system");
	}

	// remove
	public void removeTrack(Track track) {
		// check if exist
		if (tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Remove succesfull");
		} else
			System.out.println("The track doesn't exist in system");
	}

	// get length
	@Override
	public int getLength() {
		int len = 0;
		for (Track track : tracks) {
			len += track.getLength();
		}
		return len;
	}

	// add method play
	@Override
	public void play() throws PlayerException {
		int size = tracks.size();
		JPanel layout = new JPanel(new GridLayout(size, 1));
		if (this.getLength() < 0) {
			throw new PlayerException("ERROR : CD length is non-positive");
		}
		for (Track track : tracks) {
			if (track.getLength() > 0) {
				// create Label
				JLabel text = new JLabel("NCTA - Title : " + track.getTitle() + " Length : " + track.getLength());
				text.setFont(new Font("Arial", Font.PLAIN, 14));
				text.setForeground(Color.BLUE);
				text.setHorizontalAlignment(SwingConstants.CENTER);
				layout.add(text);
			} else
				throw new PlayerException("ERROR : Track length is non-positive");
		}
		JDialog dialog = new JDialog();
		dialog.setSize(300, 200);
		dialog.add(layout);
		dialog.setTitle("NCTA - Play CD");
		dialog.setVisible(true);
	}

	@Override
	public String toString() {

		return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
				+ this.getLength() + " : " + this.getCost() + " $ " + " Artist: " + this.getArtist() + " Tracks: "
				+ this.tracks;
	}

}
