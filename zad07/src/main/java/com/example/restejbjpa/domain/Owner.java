package com.example.restejbjpa.domain;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
	@NamedQuery(name = "owner.findAll", query = "Select o from Owner o"),
	@NamedQuery(name = "owner.deletAll", query = "Delete from Owner "),
	@NamedQuery(name = "owner.findById", query = "Select o from Owner o where o.id = :id")
})
@XmlRootElement
public class Owner {

    private Long id;
    private String name;

    private List<Bird> birds = new ArrayList<Bird>();

    public Owner() {
		super();
	}
    
    public Owner(String name) {
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

    //@Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    //@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Bird> getBirds() {
        return birds;
    }

    public void setBirds(List<Bird> birds) {
        this.birds = birds;
    }

	
    
}