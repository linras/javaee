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
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
		@NamedQuery(name = "toy.findAll", query = "Select t from Toy t"),
		@NamedQuery(name = "toy.delete.all", query = "Delete from Toy "),
		@NamedQuery(name = "toy.findById", query = "Select t from Toy t where t.id = :id")
})
@Entity
@XmlRootElement
public class Toy {

	private Long id;
    private String name;
    @ManyToOne
    private Bird bird;
    
    public Toy() {
		super();
	}
	
    public Toy(String name) {
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

}