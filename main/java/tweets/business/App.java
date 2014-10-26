package tweets.business;

import java.io.FileNotFoundException;

import tweets.backend.FileLoader;

/**
 * Created by fa on 26/10/14.
 */
public class App {
	
	private FileLoader hashTagsFile;
	private FileLoader tweetsFile;
	
	public void funcionalidade1(String hashtagfile){		
		
		try {
			hashTagsFile = new FileLoader(hashtagfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		
		
	}
	
	public void funcionalidade2(int n, long initDate, long endDate, String hf){
		
		System.out.println("f2 "+ n +" " + initDate +" "+ endDate +" "+ hf);
		
	}
	
	public void funcionalidade3(int k, long date){
		System.out.println("f3 "+ k+" " + date);
		
	}
	
	public void funcionalidade4(int n, long date, String hf){
		System.out.println("f4 "+ n+" " + date+" " + hf);	
	}
	
	public App(String twFile){		
		try {
			hashTagsFile = new FileLoader(twFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
