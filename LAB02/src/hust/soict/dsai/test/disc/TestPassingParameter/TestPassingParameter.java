package hust.soict.dsai.test.disc.TestPassingParameter;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	private DigitalVideoDisc dvd;
	private DigitalVideoDisc dvd1;

	public TestPassingParameter(DigitalVideoDisc dvd, DigitalVideoDisc dvd1) {
		super();
		this.dvd = dvd;
		this.dvd1 = dvd1;
	}

	public static void main(String args[]) {
		// Create new dvd objects
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		// swap
		swap(jungleDVD, cinderellaDVD);
		// show
		System.out.println("Jungle dvd title " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title " + cinderellaDVD.getTitle());
		// change title
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
//		System.out.println("Jungle dvd title " + jungleDVD.getTitle());

		// New swap
		TestPassingParameter newSwap = swap1(jungleDVD, cinderellaDVD);
		jungleDVD = newSwap.dvd;
		cinderellaDVD = newSwap.dvd1;
		// In ra
		System.out.println("New swap");
		System.out.println("Jungle dvd title " + jungleDVD.getTitle());
		System.out.println("Cinderella dvd title " + cinderellaDVD.getTitle());

	}

	public static TestPassingParameter swap1(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		return new TestPassingParameter(o2, o1);
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}

	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}

}
