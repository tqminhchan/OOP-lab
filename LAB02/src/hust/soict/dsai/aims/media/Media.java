package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.aims.exception.PlayerException;

public abstract class Media {
	public static int autoIncre = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	// add setter and getter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	// constructer
	public Media(String title, String category, float cost) {
		this.id = ++autoIncre;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media media = (Media) obj;
			return this.title.equals(media.title);
		}
		return false;

	}

	public void play() throws PlayerException {
	};

	@Override
	public String toString() {

		return "Media - " + this.title + " - " + this.category + " - " + this.cost + " $";
	}

}
