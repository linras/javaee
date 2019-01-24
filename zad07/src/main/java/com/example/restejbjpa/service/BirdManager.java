package com.example.restejbjpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.restejbjpa.domain.Bird;
import com.example.restejbjpa.domain.Book;
import com.example.restejbjpa.domain.Owner;
import com.example.restejbjpa.domain.Person;
import com.example.restejbjpa.domain.Tail;
import com.example.restejbjpa.domain.Toy;


@Singleton
public class BirdManager {
	//private List<Bird> db = Collections.synchronizedList(new ArrayList<>());
	public static Long id =(long) 1;
	@PersistenceContext
	EntityManager em;
	
	public void addBird(Bird bird){	
		//bird.setId(id++);
		em.persist(bird);
	}
	
	public Bird getBird(Long id){
		Bird retrieved = em.find(Bird.class, id);
		return retrieved;
	}
	
	public void addToy(Toy toy){	
		//bird.setId(id++);
		em.persist(toy);
	}
	
	public Toy getToy(Long id){
		Toy retrieved = em.find(Toy.class, id);
		return retrieved;
	}
	
	public void addTail(Tail tail){	
		//bird.setId(id++);
		em.persist(tail);
	}
	
	public Tail getTail(Long id){
		Tail retrieved = em.find(Tail.class, id);
		return retrieved;
	}
	
	public void addOwner(Owner owner){	
		//bird.setId(id++);
		em.persist(owner);
	}
	
	public Owner getOwner(Long id){
		Owner retrieved = em.find(Owner.class, id);
		return retrieved;
	}

//	public List<Person> getAuthorsOfBook(Long id){
//		Book retrieved = em.find(Book.class, id);
//		List<Person> result = new ArrayList<>(retrieved.getAuthors());
//		return result;
//	}
		
//	@SuppressWarnings("unchecked")
//	public List<Object[]> getBookOfAuthrByAuthorName(String firstName){		
//		return em.createNamedQuery("bookAuthor.findByAthorFirstName").setParameter("firstName", firstName).getResultList();
//	}
	
	@SuppressWarnings("unchecked")
	public List<Bird> getAllBirds(){
		return em.createNamedQuery("bird.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Toy> getAllToys(){
		return em.createNamedQuery("toy.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tail> getAllTails(){
		return em.createNamedQuery("tail.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Owner> getAllOwners(){
		return em.createNamedQuery("owner.findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> findByCountOfColors(int count){
		return em.createNamedQuery("bird.findByCountOfColors").setParameter("countOfColors", count).getResultList();
	}
	
	//znajduje wlasciciela, ktory ma najbardziej kolorowego ptaka
	public Owner findMostColorfullOwner(){
		List<Owner> owners = new ArrayList<>();  
		owners = getAllOwners();
		int max = 0;
		Long id = (long) 1;
		for(Owner o : owners) {
			for(Bird b: o.getBirds()) {
				if(b.getCountOfColors()>max) {
					max = b.getCountOfColors();
					id = o.getId();
				}
			}
		}
		return em.find(Owner.class, id);
	}
	
	//znajduje wlasciciela, ktory ma najwiecej ptasich zabawek
		public Owner findManyToys(){
			List<Owner> owners = new ArrayList<>();  
			owners = getAllOwners();
			int max = 0, local = 0;
			Long id = (long) 1;
			for(Owner o : owners) {
				local = 0;
				for(Bird b: o.getBirds()) {
					local += b.getToys().size();
				}
				if(local>max) {
					id = o.getId();
					max = local;
				}
			}
			return em.find(Owner.class, id);
		}
		
		//znajduje wszystkich wlascicieli, ktorzy maja wiecej niz n zabawek
		public List<Owner> findManyToys(int n){
			List<Owner> many = new ArrayList<>(); 
			List<Owner> owners = new ArrayList<>();  
			owners = getAllOwners();
			for(Owner o : owners) {
				int count = 0;
				for(Bird b: o.getBirds()) {
					count += b.getToys().size();
				}
				if(count>n) {
					many.add(o);
				}
			}
			return many;
		}
	
	public void deletAllBirds(){
		em.createNamedQuery("bird.delete.all").executeUpdate();
	}

	public void deletAllToys(){
		em.createNamedQuery("toy.delete.all").executeUpdate();
	}
	
	public void deletAllTails(){
		em.createNamedQuery("tail.deleteAll").executeUpdate();
	}
	
	public void deletAllOwners(){
		em.createNamedQuery("owner.deleteAll").executeUpdate();
	}
	
}
