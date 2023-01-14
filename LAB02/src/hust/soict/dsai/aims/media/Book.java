package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	// constructer
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	// add author
	public void addAuther(String authorName) {
		// check if not exits
		if (!authors.contains(authorName)) {
			authors.add(authorName);
			System.out.println("add " + authorName);
		} else
			System.out.println(authorName + " exists");
	}

	// remove author
	public void removeAuther(String authorName) throws Exception {
		// check if exits
		if (authors.contains(authorName)) {
			authors.remove(authorName);
			System.out.println("remove " + authorName);
		} else
			throw new Exception("Author is not exist");
	}

	@Override
	public String toString() {

		return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + "Authors: " + this.authors + " Cost: "
				+ this.getCost();
	}

}
