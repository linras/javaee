package com.example.servletdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	private String nazwa;
	
	public ReadFile(String s) {
		this.nazwa = s;
	}
	
	public String read() throws FileNotFoundException {
		String s ="";
		File plik = new File(nazwa);
		Scanner odczyt = new Scanner(new File(nazwa));
		while(odczyt.hasNext()) {
			s = s + odczyt.nextLine();
		}
		return s;
	}
}
