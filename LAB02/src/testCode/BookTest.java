package testCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class BookTest {
	public static void main(String args[]) {
		Book book = new Book(1, "C", "Nguoi giau", 1000000f);
		DigitalVideoDisc dvd = new DigitalVideoDisc("A", "Animation", "Roger Allers", 87, 19.95f);
		List<Track> track = new ArrayList<Track>();
		track.add(new Track("Bai1", 1000));
		CompactDisc cd = new CompactDisc(1, "A", "Nhac vang", 100f, "TuanAnh", 1000, "No name", track);
		CompactDisc cd1 = new CompactDisc(1, "B", "Nhac vang", 1000000f, "TuanAnh", 1000, "No name", track);
		List<Media> mediae = new ArrayList<Media>();
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		mediae.add(cd1);
		// sort
		Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);
		for (Media media : mediae) {
			System.out.println(media.toString());
		}
		System.out.println("Sort by cost");
		// sort
		Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);
		for (Media media : mediae) {
			System.out.println(media.toString());
		}

	}
}
