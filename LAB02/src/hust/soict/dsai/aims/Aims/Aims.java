package hust.soict.dsai.aims.Aims;

import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static String readStr() {
		Scanner scanIn = new Scanner(System.in);
		return scanIn.next();
	}

	public static int readInt() {
		Scanner scanIn = new Scanner(System.in);
		return scanIn.nextInt();
	}

	public static float readFloat() {
		Scanner scanIn = new Scanner(System.in);
		return scanIn.nextFloat();
	}

	public static void showCurrentCartMenu(Store store, Cart cart) {
		int choose;
		boolean exit = false;
		while (!exit) {
			cartMenu();
			choose = readInt();
			switch (choose) {
			case 1:
				ShowMenuFunction.filterMediaInCast(cart);
				break;
			case 2:
				ShowMenuFunction.sortMediaInCast(cart);
				System.out.println(cart);
				break;
			case 3:
				System.out.println("Enter title of media you want to remove");
				Media media = cart.findMediaByTitle(readStr());
				if (media == null)
					System.out.println("This meida doesn't exist");
				else
					cart.removeMedia(media);
				break;
			case 4:
				ShowMenuFunction.playAMedia(cart);
				break;
			case 5:
				System.out.println("Order is created");
				cart.setEmtpyCart();
				break;
			case 0:
				exit = true;
				break;
			}
		}

	}

	public static void showMenuStore(Store store, Cart cart) {
		int choose;
		Media media;
		boolean exit = false;
		while (!exit) {
			storeMenu();
			choose = readInt();
			switch (choose) {
			case 1:
				System.out.println("Enter your titel that you want to see");
				media = store.findMediaByTitle(readStr());
				if (media != null) {
					showMediaDetailMenu(media, cart);
				} else
					System.out.println("This media doesn't exits");
				break;
			case 2:
				ShowMenuFunction.addMediaToCart(store, cart);
				break;
			case 3:
				ShowMenuFunction.playAMedia(store);
				break;
			case 4:
				showCurrentCartMenu(store, cart);
				break;
			case 0:
				exit = true;
				break;
			}
		}
	}

	public static void showMediaDetailMenu(Media media, Cart cart) {
		int choose;
		boolean exit = false;
		while (!exit) {
			mediaDetailsMenu();
			choose = readInt();
			switch (choose) {
			case 1:
				try {
					cart.addMedia(media);
				} catch (Exception e) {

				}
				break;
			case 2:
				if (media.getCategory().equals("Book"))
					System.out.println("This book doesn't have play fuction");
				else
					try {
						media.play();
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}

				break;
			case 0:
				exit = true;
				break;
			}
		}
	}

	public static void main(String args[]) {
		int choose1;
		boolean exit = false;
		Store store = new Store();
		Cart cart = new Cart();
		while (!exit) {
			showMenu();
			choose1 = readInt();
			switch (choose1) {
			case 1:
				showMenuStore(store, cart);
				System.out.println(cart);
				break;
			case 2:
				ShowMenuFunction.updateStore(store);
				System.out.println(store);
				break;
			case 3:
				showCurrentCartMenu(store, cart);
				break;
			case 0:
				exit = true;
				break;
			}

		}

	}
}
