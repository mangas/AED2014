package tweets.data;

import java.util.ArrayList;

import tweets.model.Tweet;

/**
 * Created by fa on 26/10/14.
 * esta classe é o engine de filtragem.
 * pede ao parser novos tweets, filtra-os usando field filters.
 */
public class Filter {
	
	String twt;
	//private Parser parsedObg = new Parser();
	
	
	private ArrayList<FieldFilter> filterAL  = new ArrayList<FieldFilter>();
	
	/**
	 * Construtor sem filtros
	 */
	public Filter(String twt){
		this.twt=twt;
	}
	
	/**
	 * Adiciona filtros à lista de filtros Arraylist
	 */
	public void addFilter(FieldFilter f){
		filterAL.add(f);
	}
	
	public Tweet findSingle(){
		Parser ps = new Parser(twt);
		Tweet tw = ps.parseTweet();
		Boolean hasAllHashTags = false;
		for(int i=0; i<filterAL.size(); i++){	
			if ( ! tw.hasHashtags(filterAL.get(i)) ) break;
			hasAllHashTags = true;
		}
		if (hasAllHashTags) return tw;
		return null;
		
	}

	public HashTags getHashTags(String s){
		return Parser.getHashTags(s);
	}
	
	
}
