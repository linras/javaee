package aformela.shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Survey {
	private String pocz;
	private String kon;
	private String czestotliwosc;
	private List<String> uwagi = new ArrayList<String>();
	
	public Survey() {
		super();
	}

	public Survey(String pocz, String kon, String czestotliwosc, List<String> uwagi) {
		super();
		this.pocz = pocz;
		this.kon = kon;
		this.czestotliwosc = czestotliwosc;
		this.uwagi = uwagi;
	}
	public Survey(String pocz, String kon, String czestotliwosc) {
		super();
		this.pocz = pocz;
		this.kon = kon;
		this.czestotliwosc = czestotliwosc;
	}

	@Override
	public String toString() {
		return "Survey [pocz=" + pocz + ", kon=" + kon + ", czestotliwosc=" + czestotliwosc + ", uwagi=" + uwagi + "]";
	}

	public String getPocz() {
		return pocz;
	}

	public void setPocz(String pocz) {
		this.pocz = pocz;
	}

	public String getKon() {
		return kon;
	}

	public void setKon(String kon) {
		this.kon = kon;
	}

	public String getCzestotliwosc() {
		return czestotliwosc;
	}

	public void setCzestotliwosc(String czestotliwosc) {
		this.czestotliwosc = czestotliwosc;
	}

	public List<String> getUwagi() {
		return uwagi;
	}

	public void setUwagi(List<String> uwagi) {
		this.uwagi = uwagi;
	}
	
	
}
