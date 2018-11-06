package aformela.shop.service;

import java.util.ArrayList;
import java.util.List;

import aformela.shop.domain.Bird;

public class StorageService {
	
	private List<Bird> db = new ArrayList<Bird>();
	private List<Bird> trolley = new ArrayList<Bird>();
	
	public void add(Bird bird){
		Bird newBird = new Bird(bird.getName() ,  bird.getDateOfBirth(),  bird.isFemale(), bird.getPrice(), bird.getCountOfColors());
		db.add(newBird);
	}
	
	public void addToTrolley(Bird bird) {
		Bird newBird = new Bird(bird.getName() ,  bird.getDateOfBirth(),  bird.isFemale(), bird.getPrice(), bird.getCountOfColors());
		trolley.add(newBird);
	}
	
	public void addExamples(){
		Bird newBird = new Bird("Staszek" ,  "2015-11-11",  false, 12.5, 4);
		db.add(newBird);
		newBird = new Bird("Piszczel" ,  "2014-11-03",  true, 12.5, 3);
		db.add(newBird);
		newBird = new Bird("Trufel" ,  "2018-02-03",  false, 24.0, 5);
		db.add(newBird);
	}
	
	public List<Bird> getAllBirds(){
		return db;
	}
	
	public List<Bird> getTrolley(){
		return trolley;
	}

	public void addBird(Bird bird) {
		// TODO Auto-generated method stub
		
	}

	public void disposeBird(Bird birdToShow, Bird birdToDispose) {
		// TODO Auto-generated method stub
		
	}

}
