package com.example.restejbjpa.domain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
	@NamedQuery(name = "tail.findAll", query = "Select t from Tail t"),
	@NamedQuery(name = "tail.deleteAll", query = "Delete from Tail"),
	@NamedQuery(name = "tail.findById", query = "Select t from Tail t where t.id = :id")
})
@Entity
@XmlRootElement
public class Tail {

    private Long id;
    private String name;
    private String description;
    private Bird bird;

    

	public Tail() {
    	super();
    }
    
    public Tail(String name, String descr) {
    	super();
		this.name = name;
		this.description = descr;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @OneToOne(fetch = FetchType.EAGER)
    public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}
}