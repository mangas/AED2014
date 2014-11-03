package tweets.data;

import tweets.model.Tweet;

import java.util.ArrayList;

/**
 * esta classe � o engine de filtragem.
 * pede ao parser novos tweets, filtra-os usando field filters.
 * 
 * Uso: 1� Construir uma instancia com o ficheiro fonte de tweets como argumento
 * 		2� adicionar os filtros com o metodo addFilter
 * 		3� filtrar com o filterOne ou com o FilterAll
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
	 * Adiciona filtros � lista de filtros Arraylist
	 */
	public void addFilter(FieldFilter f){
		filterAL.add(f);
	}
	
	/**
	 * O metodo Parser.parseTweet() devolve o proximo Tweet
	 * � feito um for para validar se esse tweet contem todas as HashTags.
	 * Retorna o tweet se sim, null se n�o encontrada correspondencia. 
	 * Nota: pressupoe que recebe null se o ficheiro chegar ao fim.
     *
     **/


    /*

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
	*/

    /**
     * Helper method to encapsulate the filtering process itself
     *
     * @param t tweet to filter
     * @return wether tweet passes through filters
     */
    private boolean filter(Tweet t) {
        for (FieldFilter f : filterAL)
            if (!f.filter(t))
                return false;

        return true;
    }

    /**
     * Always returns a filtered tweet if there is one
     *
     * @return Tweet
     */
    public Tweet filterOne() {


        Tweet tw = null;

        do {
            tw = ps.parseTweet();
            //if there are no more tweets parseTweet would return null
            if (tw == null)
                return null;
        } while (!filter(tw));

        return tw;
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
