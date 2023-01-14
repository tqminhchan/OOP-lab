package testCode;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class ClassMember {
	public static void main(String[] args) {
		// Create a new cart
		Cart anOrder = new Cart();

		// Create new dvd objects
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

		// Create new dvd objects
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

		// Create new dvd objects
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "George Lucas", 18.99f);

		anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);
		anOrder.getItemsOrdered();

	}

}
