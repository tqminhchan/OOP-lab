package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
	public static void main(String[] args) {
		// Create a new cart
		Store store = new Store();

		// Create new dvd objects
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

		// Create new dvd objects
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

		// Create new dvd objects
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "George Lucas", 18.99f);

		// store DVD
		store.addDVD(dvd1, dvd2, dvd3);
		System.out.println("Before delete");
		store.printStore();
		// remove DVD1
		store.removeDVD(dvd1);
		System.out.println("After delete");
		store.printStore();

	}
}
