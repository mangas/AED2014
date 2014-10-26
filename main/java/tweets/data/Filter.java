package tweets.data;

import java.util.ArrayList;

import tweets.model.Tweet;

/**
 * Created by fa on 26/10/14.
 * esta classe é o engine de filtragem.
 * pede ao parser novos tweets, filtra-os usando field filters.
 */
public class Filter {
	
	String twtFile;
	//private Parser parsedObg = new Parser();
	
	
	private ArrayList<FieldFilter> filterAL  = new ArrayList<FieldFilter>();
	
	/**
	 * Construtor sem filtros
	 */
	public Filter(String twtFile){
		this.twtFile=twtFile;
	}
	
	/**
	 * Adiciona filtros à lista de filtros Arraylist
	 */
	public void addFilter(FieldFilter f){
		filterAL.add(f);
	}
	
	public Tweet findOne(){
		Parser ps = new Parser(twtFile);
		Tweet tw;
		while (true){
			tw= findSingle(ps);
			if (tw!= null)	return tw;
			break;
			}
		return null;
	}
	
	
	private Tweet findSingle(Parser ps){
		Tweet tw = ps.parseTweet();
		for(int i=0; i<filterAL.size(); i++){	
			if ( ! tw.hasHashtags(filterAL.get(i)) ) return null;
		}
		return tw;
		
	}

	public HashTags getHashTags(String s){
		return Parser.getHashTags(s);
	}
	
	
}
