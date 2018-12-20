package aformela.shop.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import aformela.shop.domain.Bird;
import aformela.shop.domain.Button;
import aformela.shop.domain.Survey;

public class StorageService {
	
	private List<Bird> db = new ArrayList<Bird>();
	private List<Bird> trolley = new ArrayList<Bird>();
	private List<Survey> surveys = new ArrayList<Survey>();
	private List<Button> buttons = new ArrayList<Button>();
	//private List<Survey> sessSur = new ArrayList<Survey>();
	boolean first =false;
	boolean second =false;
	boolean third =false;
	
	public boolean getZgody(String s) {
		if(s.equals("first"))
			return first;
		if(s.equals("second"))
			return second;
		if(s.equals("third"))
			return third;
		return false;
	}

	public void setZgody(String s) {
		if(s.equals("first"))
			first = true;
		if(s.equals("second"))
			second=true;
		if(s.equals("third"))
			third=true;
	}

	public void add(Bird bird){
		Bird newBird = new Bird(bird.getName() ,  bird.getDateOfBirth(),  bird.isFemale(), bird.getPrice(), bird.getCountOfColors());
		db.add(newBird);
	}
	
	public void addToTrolley(Bird bird) {
		Bird newBird = new Bird(bird.getName() ,  bird.getDateOfBirth(),  bird.isFemale(), bird.getPrice(), bird.getCountOfColors());
		trolley.add(newBird);
	}
	
	public void addSur(Survey sur) {
		Survey newSur = new Survey(sur.getPocz(), sur.getKon(), sur.getCzestotliwosc(), sur.getUwagi());
		surveys.add(newSur);
		//surveys.add(sur);
	}
	
	public void addButton(Button button) throws ParseException{
		Button newB = new Button(button.getNazwa(), button.getPrice(), button.getData(), button.getDziurki(), button.getUwagi());
		buttons.add(newB);
	}
	
	/*public void addYourSur(Survey sur) {
		Survey newSur = new Survey(sur.getPocz(), sur.getKon(), sur.getCzestotliwosc(), sur.getUwagi());
		sessSur.add(newSur);
	}*/
	
	public void addExamples(){
		Bird newBird = new Bird("Staszek" ,  "2015-11-11",  false, 12.5, 4);
		db.add(newBird);
		newBird = new Bird("Piszczel" ,  "2014-11-03",  true, 12.5, 3);
		db.add(newBird);
		newBird = new Bird("Trufel" ,  "2018-02-03",  false, 24.0, 5);
		db.add(newBird);
	}
	
	public void addSomeSurveys(){
		String[] tab = {"good", "very good", "not bad"};
		Survey s = new Survey("2018-12-12" ,  "2015-11-11",  "daily" );
		surveys.add(s);
		s = new Survey("2018-12-12" ,  "2015-11-11",  "every week" , tab);
		surveys.add(s);
		s = new Survey("2018-12-12" ,  "2015-11-11",  "daily", tab );
		surveys.add(s);
	}
	
	public void addSomeButtons() throws ParseException{
		String[] tab = {"good", "very good", "not bad"};
		Button b = new Button("Guzik1", 23.50, "2018-12-12" ,"3" );
		buttons.add(b);
		b = new Button("Guzik2", 23.50, "2018-12-12" ,"3" , tab);
		buttons.add(b);
		b = new Button("Guzik3", 23.50, "2018-12-12" ,"3" , tab);
		buttons.add(b);
	}
	
	public List<Bird> getAllBirds(){
		return db;
	}
	
	public List<Bird> getTrolley(){
		return trolley;
	}
	
	public List<Survey> getSurveys(){
		return surveys;
	}
	
	public List<Button> getButtons(){
		return buttons;
	}
	
	/*public List<Survey> getYourSurveys(){
		return sessSur;
	}*/

	public void addBird(Bird bird) {
		// TODO Auto-generated method stub
		
	}

	public void disposeBird(Bird birdToShow, Bird birdToDispose) {
		// TODO Auto-generated method stub
		
	}

}
