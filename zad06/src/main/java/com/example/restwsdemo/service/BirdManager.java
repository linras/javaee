package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.Bird;

@Singleton
public class BirdManager {
	
	private List<Bird> db = Collections.synchronizedList(new ArrayList<>());

	public void addBird(Bird bird) {
		db.add(bird);
	}

	public void deletePerson(Bird bird){
		db.remove(bird);
 	}
	
	public Bird getBird(Integer id) {
		return new Bird("Piszczel");
	}
	
	public List<Bird> getAllBirds(){
		return db;
	}
	
	public void deleteAllBirds(){
		db.clear();
	}

}
