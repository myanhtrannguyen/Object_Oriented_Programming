package hust.soict.dsai.aims.disc;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	private static int nbDigitalVideoDisc = 0;
	public int getID(){
		return id;
	}
	public int getNBDigitalVideoDisc() {
		return nbDigitalVideoDisc;
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
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDisc += 1;
		this.id = nbDigitalVideoDisc;
		
	}
	public String toString() {
		if (category == null) {
			category = "Unknown";
		}
		if (director == null) {
			director = "Unknown";
		}
		return "DVD - " + title + " - " + category + " - " + director + " - [" + length + " mins]: $" + cost;
	}
	
	//Method to check if the title matches
	public boolean isMatch(String title) {
		return this.title.equalsIgnoreCase(title);
	}
}
