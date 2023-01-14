package testCode;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class MethodOverloading {
	public static void main(String args[]) {
		// Create a new cart
		Cart anOrder = new Cart();

		// Create new dvd objects
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

		// Create new dvd objects
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Lion", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.removeMedia(dvd2);
		anOrder.addMedia(dvd2);
		System.out.println(anOrder.totalCost());
	}
}
