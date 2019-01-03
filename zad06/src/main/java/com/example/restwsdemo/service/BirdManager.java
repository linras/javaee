package com.example.restwsdemo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Singleton;

import com.example.restwsdemo.domain.Bird;

@Singleton
public class BirdManager {
	
	private List<Bird> db = Collections.synchronizedList(new ArrayList<>());
	public static int id =1;

	public void addBird(Bird bird) {
		bird.setId(id++);
		db.add(bird);
	}

	public void deleteBird(Bird bird){
		db.remove(bird);
 	}
	
	public void deleteBird(Integer id){
		for(Bird b : db) {
			if(id.intValue()==b.getId())
				db.remove(b);
		}
 	}
	
	public Bird getBird(Integer id) {
		for(Bird b : db) {
			if(id.intValue()==b.getId())
				return b;
		}
		return null;
	}
	
	public List<Bird> getAllBirds(){
		return db;
	}
	
	public void deleteAllBirds(){
		db.clear();
	}

}
