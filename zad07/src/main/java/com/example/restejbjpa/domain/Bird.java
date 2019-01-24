package com.example.restejbjpa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "bird.all", query = "Select b from Bird b"),
	@NamedQuery(name = "bird.delete.all", query = "Delete from Bird "),
	//@NamedQuery(name = "bird.deleteId", query = "Delete b from Bird b where b.id = :id "),
	@NamedQuery(name = "bird.findByCountOfColors", query = "Select b from Bird b where b.countOfColors = :countOfColors")//,
//	@NamedQuery(name = "birdOwner.findByAthorFirstName",
//	query = "Select a.firstName, a.lastName, b.title, b.yop from Book b JOIN b.authors a where a.firstName = :name")
	})
@XmlRootElement
public class Bird {

	private Long id;
	private String name;
	private boolean female;
	private double price;
	private String  dateOfBirth;
	private int countOfColors;
	private List<Toy> toys = new ArrayList<Toy>();
    private List<Owner> owners = new ArrayList<Owner>();
    private Tail tail;
	
	
	public Bird() {
		super();
	}

	public Bird(String name, String dateOfBirth, boolean isFemale, double weight, int countOfColors) {
		super();
		this.name = name;
		this.female = isFemale;
		this.price = weight;
		this.dateOfBirth = dateOfBirth;
		this.countOfColors = countOfColors;
	}

	public Bird(Long id, String name, String dateOfBirth, boolean isFemale, double weight, int countOfColors) {
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	public int getCountOfColors() {
		return countOfColors;
	}

	public void setCountOfColors(int countOfColors) {
		this.countOfColors = countOfColors;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }
	
    @OneToOne(fetch = FetchType.EAGER)
    public Tail getTail() {
        return tail;
    }
    
    public void setTail(Tail tail) {
        this.tail = tail;
    }
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Owner> getOwners() {
		return owners;
	}
    
    public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		//result = prime * result + countOfColors;
		//result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bird [name=" + name + ", female=" + female + ", price=" + price + ", dateOfBirth=" + dateOfBirth
				+ ", countOfColors=" + countOfColors + "]";
	}
	
}