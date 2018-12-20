package aformela.shop.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Button {
	private String nazwa;
	private double price;
	private Date data;
	private String dziurki;
	//private List<String> uwagi = new ArrayList<String>();
	private String[] uwagi;
	
	public Button() {
		super();
	}

	public Button(String nazwa, double price, String data, String dziurki) throws ParseException {
		super();
		this.data=new SimpleDateFormat("yyyy-mm-dd").parse(data);  
//		this.kon=new SimpleDateFormat("yyyy-mm-dd").parse(kon);  
		this.nazwa = nazwa;
		//this.data = data;
		this.dziurki = dziurki;
		this.price = price;
	}

	public Button(String nazwa, double price, String data, String dziurki, String[] uwagi) throws ParseException {
		super();
		this.data=new SimpleDateFormat("yyyy-mm-dd").parse(data);  
		this.nazwa = nazwa;
		//this.data = data;
		this.dziurki = dziurki;
		this.uwagi = uwagi;
		this.price = price;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String s = "Button [name=" + nazwa + ", date=" + this.getData() + ", holes=" + dziurki + ", uwagi= ";
			if(uwagi != null) {
				for(int i=0; i<uwagi.length; i++) {
					s += uwagi[i]+",\t";
				}
			}
		s+= "]";
		return s;
	}
	
	public String uwagiToString() {
		String s = "";
		for(int i=0; i<uwagi.length; i++)
	    	s += uwagi[i]+"\n";
		return s;
	}

	

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getData() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		 
        //to convert Date to String, use format method of SimpleDateFormat class.
        String strDate = dateFormat.format(this.data);
		return strDate;
	}

	public void setData(String data) throws ParseException {
		this.data=new SimpleDateFormat("yyyy-mm-dd").parse(data); 
	}

	public String getDziurki() {
		return dziurki;
	}

	public void setDziurki(String dziurki) {
		this.dziurki = dziurki;
	}

	public String[] getUwagi() {
		return uwagi;
	}

	public void setUwagi(String[] uwagi) {
		this.uwagi = uwagi;
	}

	/*public List<String> getUwagi() {
		return uwagi;
	}

	public void setUwagi(List<String> uwagi) {
		this.uwagi = uwagi;
	}*/
	
	
}