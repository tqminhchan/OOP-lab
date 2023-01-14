package hust.soict.dsai.aims.store.Store;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
	public ObservableList<Media> itemsInStore = FXCollections.observableArrayList();

	public ObservableList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media media) {
		if (!itemsInStore.contains(media)) {
			itemsInStore.add(media);
			System.out.println("Added successfully");
		} else
			System.out.println("The media exists");
	}

	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			System.out.println("Removed successfully");
		} else
			System.out.println("The media doen't exists");
	}

	public Media findMediaByTitle(String title) {
		for (Media mda : itemsInStore)
			if (mda.getTitle().equals(title))
				return mda;
		return null;
	}

	public void removeMediaByTitle(String title) {
		Media media = findMediaByTitle(title);
		if (media == null) {
			System.out.println("The media doen't exists");
		} else {
			itemsInStore.remove(media);
			System.out.println("Removed successfully");
		}
	}

	public void printStore() {
		for (Media mda : itemsInStore)
			System.out.println(mda);
	}

	@Override
	public String toString() {
		return "Store : " + itemsInStore;
	}

}
