package tweets.data;

import java.util.ArrayList;

import tweets.model.Tweet;

/**
 * esta classe é o engine de filtragem.
 * pede ao parser novos tweets, filtra-os usando field filters.
 * 
 * Uso: 1º Construir uma instancia com o ficheiro fonte de tweets como argumento
 * 		2º adicionar os filtros com o metodo addFilter
 * 		3º filtrar com o filterOne ou com o FilterAll
 */
public class Filter {

	/**
	 * Instancia de parser associada ao construtor
	 */
	Parser ps;

	/**
	 * Constroi uma arraylist de filtros a serem usados nas pesquisas
	 */
	private ArrayList<FieldFilter> filterAL  = new ArrayList<FieldFilter>();

	/**
	 * Construtoi um filtro para trabalhar com o ficheiro especificado
	 * constroi um parser associado a este filtro.
	 */
	public Filter(String twtFile){
		ps = new Parser(twtFile);
	}

	/**
	 * Adiciona filtros à lista de filtros Arraylist
	 */
	public void addFilter(FieldFilter f){
		filterAL.add(f);
	}
	
	/**
	 * O metodo Parser.parseTweet() devolve o proximo Tweet
	 * É feito um for para validar se esse tweet contem todas as HashTags.
	 * Retorna o tweet se sim, null se não encontrada correspondencia. 
	 * Nota: pressupoe que recebe null se o ficheiro chegar ao fim.
	 */
	public Tweet filterOne(){
		Tweet tw = null ;
		boolean match = false;
		int matchCount = 0;

		while ( match == false || tw == null ){
			tw = ps.parseTweet();
			matchCount = 0;
			for(int i=0; i<filterAL.size(); i++){	
				if ( tw.hasHashTag(filterAL.get(i)) ) matchCount++;
				else break;
			}
			if (matchCount == filterAL.size()) 	match = true;
		}
		if (match) return tw;
		else return null;
	}
	
	/**
	 * Filtra todos os elementos do ficheiro fonte e retorna um array de tweets
	 */
	public Tweet[] filterAll(){
		ArrayList<Tweet> tweets  = new ArrayList<Tweet>(500);
		Tweet tw = filterOne();
		while (tw != null) 
			tweets.add(tw);
		return (Tweet[]) tweets.toArray();
	}

//	public HashTags getHashTags(String s){
//		return Parser.getHashTags(s);
//	}


}
