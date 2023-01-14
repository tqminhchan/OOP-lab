package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		int a = Float.compare(o2.getCost(), o1.getCost());
		if (a != 0)
			return a;
		else
			return o1.getTitle().compareTo(o2.getTitle());
	}

}
