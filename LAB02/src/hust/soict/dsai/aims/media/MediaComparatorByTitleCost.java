package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		int a = o1.getTitle().compareTo(o2.getTitle());
		if (a != 0)
			return a;
		else {
			return Float.compare(o2.getCost(), o1.getCost());

		}

	}

}
