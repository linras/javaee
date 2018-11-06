package aformela.shop.domain;

public class Bird {

	private String name;
	private boolean female;
	private double price;
	private String  dateOfBirth;
	private int countOfColors;
	
	
	public Bird() {
		super();
	}

	private int id; 
	public Bird(String name, String dateOfBirth, boolean isFemale, double weight, int countOfColors) {
		super();
		this.name = name;
		this.female = isFemale;
		this.price = weight;
		this.dateOfBirth = dateOfBirth;
		this.countOfColors = countOfColors;
	}

	public Bird(int id, String name, String dateOfBirth, boolean isFemale, double weight, int countOfColors) {
		super();
		this.id = id;
		this.name = name;
		this.female = isFemale;
		this.price = weight;
		this.dateOfBirth = dateOfBirth;
		this.countOfColors = countOfColors;
	}
	public Bird(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFemale() {
		return female;
	}
	public void setFemale(boolean isFemale) {
		this.female = isFemale;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double weight) {
		this.price = weight;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCountOfColors() {
		return countOfColors;
	}

	public void setCountOfColors(int countOfColors) {
		this.countOfColors = countOfColors;
	}

	@Override
	public String toString() {
		return "Bird [name=" + name + ", female=" + female + ", price=" + price + ", dateOfBirth=" + dateOfBirth
				+ ", countOfColors=" + countOfColors + "]";
	}
	
}
