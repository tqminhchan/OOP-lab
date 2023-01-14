package hust.soict.dsai.aims.Aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store.Store;

public class ShowMenuFunction {
	public static void menuAddMedia() {
		System.out.println("Add media: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add DVD");
		System.out.println("2. Add CD");
		System.out.println("3. Add Book");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void menuFilterMedia() {
		System.out.println("Filter media: ");
		System.out.println("--------------------------------");
		System.out.println("1. Find by Id");
		System.out.println("2. Find by Title");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void menuSortMedia() {
		System.out.println("Filter media: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by Title");
		System.out.println("2. Sort by Cost");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void showMenuAddMedia(Store store) {
		int choose;
		Media media;
		Track track;
		menuAddMedia();

		choose = Aims.readInt();
		Scanner scanIn = new Scanner(System.in);
		switch (choose) {
		case 1:
			media = new DigitalVideoDisc(scanIn.next(), scanIn.next(), scanIn.nextFloat(), scanIn.next(),
					scanIn.nextInt());
			store.addMedia(media);
			break;
		case 2:
			CompactDisc cd = new CompactDisc(scanIn.next(), scanIn.next(), scanIn.nextFloat(), scanIn.next(),
					scanIn.nextInt(), scanIn.next(), new ArrayList<Track>());
			track = new Track(scanIn.next(), scanIn.nextInt());
			cd.addTrack(track);
			track = new Track(scanIn.next(), scanIn.nextInt());
			cd.addTrack(track);
			store.addMedia(cd);
			break;
		case 3:
			List<String> authors = new ArrayList<String>();
			Book book = new Book(scanIn.next(), scanIn.next(), scanIn.nextFloat(), authors);
			book.addAuther(scanIn.next());
			store.addMedia(book);
			break;
		}

	}

	public static void addMediaToCart(Store store, Cart cart) {
		String title;
		Media media;
		System.out.println("____Store____");
		store.printStore();
		System.out.println("________******_______");
		System.out.println("Enter title you want to add");
		title = Aims.readStr();
		media = store.findMediaByTitle(title);
		if (media != null) {
			try {
				cart.addMedia(media);
			} catch (Exception e) {

			}

		} else
			System.out.println("Media which name is " + title + " doesn't exist");
		if (media.getCategory().equals("DVD"))
			System.out.println("Number of DVDs in current cart : " + cart.countDVDInCast());
	}

	public static void updateStore(Store store) {
		int choose;
		boolean exit = false;
		while (!exit) {
			System.out.println("Update Sotre: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add media");
			System.out.println("2. Remove media");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			choose = Aims.readInt();
			switch (choose) {
			case 1:
				showMenuAddMedia(store);
				break;
			case 2:
				System.out.println("Enter the title you want to remove");
				store.removeMediaByTitle(Aims.readStr());
				break;
			case 0:
				exit = true;
				break;
			}
		}

	}

	public static void playAMedia(Store store) {
		String title;
		Media media;
		System.out.println("Enter title of media you want to play");
		title = Aims.readStr();
		media = store.findMediaByTitle(title);
		if (media == null)
			System.out.println("Media which name is " + title + " doesn't exist");
		else if (media.getCategory().equals("Book"))
			System.out.println("This book doesn't have play fuction");
		else
			try {
				media.play();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
	}

	public static void playAMedia(Cart cart) {
		String title;
		Media media;
		System.out.println("Enter title of media you want to play");
		title = Aims.readStr();
		media = cart.findMediaByTitle(title);
		if (media == null)
			System.out.println("Media which name is " + title + " doesn't exist");
		else if (media.getCategory().equals("Book"))
			System.out.println("This book doesn't have play fuction");
		else
			try {
				media.play();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

	}

	public static void filterMediaInCast(Cart cart) {
		int choose;
		Media media = null;
		menuFilterMedia();
		choose = Aims.readInt();
		switch (choose) {
		case 1:
			System.out.println("Enter ID of media you want to see");
			media = cart.findMediaById(Aims.readInt());
			break;
		case 2:
			System.out.println("Enter title of media you want to see");
			media = cart.findMediaByTitle(Aims.readStr());
			break;
		}
		if (media == null)
			System.out.println("Media doesn't exist");
		else
			System.out.println(media);

	}

	public static void sortMediaInCast(Cart cart) {
		int choose;
		menuSortMedia();
		choose = Aims.readInt();
		switch (choose) {
		case 1:
			cart.sortByTitle();
			break;
		case 2:
			cart.sortByCost();
			break;
		}

	}

}
