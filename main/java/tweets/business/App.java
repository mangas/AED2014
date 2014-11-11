package tweets.business;

import tweets.data.Filter;
import tweets.data.TweetHashFilter;
import tweets.data.TweetTimeIntervalFilter;
import tweets.model.HashCount;
import tweets.model.HashTags;
import tweets.model.Tweet;
import tweets.utils.Sort;

/**
 * Created by fa on 26/10/14.
 */
public class App {

    //Offset = 10 seconds
    private static final long OFFSET = 10;
    private static final int DEFAULT_SIZE = 100;
    private String tweetFile;


    /**
     * Uses the filter to get all the tweets and create an array of HashCount object
     * that hold the current count for each HashTag
     *
     * @param hashs Hashtags in use
     * @param f filter for getting the tweets
     * @return HashCount[] with current counting for each HashTag
     *
     * TODO: Improve time and iterations needed to find the correct HashCount in the array
     */
    private HashCount[] loadCount(HashTags hashs,Filter f) {
        HashCount[] result = new HashCount[hashs.getHashtags().length];
        for (int i=0;i< hashs.getHashtags().length;i++)
            result[i] = new HashCount(hashs.getHashtags()[i]);



        Tweet t = f.filterOne();

        while (t!=null) {
            for (String s: t.getHashtags().getHashtags())
                for (HashCount hc : result)
                    if (hc.getHash().equalsIgnoreCase(s)) {
                        hc.inc();
                        break;
                    }
        }

        return result;
    }

    /**
     * Same as loadCount for the cases where we don't have a hashtag list which was used for initializing the
     * result list
     *
     * @param f filter to be used
     * @return Current Count
     */
    private HashCount[] loadCount(Filter f) {
        HashCount[] result = new HashCount[DEFAULT_SIZE];
        int nResults=0;

        Tweet t = f.filterOne();

        while (t!=null) {
            for (String s: t.getHashtags().getHashtags())
                for (int i=0;i<nResults;i++) {
                    if (result[i].getHash().equalsIgnoreCase(s)) {
                        result[i].inc();
                        break;
                    }

                    if (i==nResults-1) {
                        if (nResults+1>= result.length) {
                            HashCount[] aux = new HashCount[result.length+DEFAULT_SIZE];
                            System.arraycopy(result,0,aux,0,nResults);
                        }
                        result[nResults++]=new HashCount(s);

                    }
                }
        }

        return result;
    }


    private HashCount[] loadAndSort(HashTags hashs,Filter f, int n) {
        HashCount[] result = new HashCount[n];

        HashCount[] count = loadCount(hashs,f);

        int size = count.length-1;

        for (int i=0;i<n;i++) {
            Sort.maxHeapify(count, i, size);
            result[i]=count[i];
        }

        return result;
    }

	public HashCount funcionalidade1(String hf){
        HashTags hashTags = new Filter(hf).getHashTags();

        Filter f = new Filter(this.tweetFile);
        f.addFilter(new TweetHashFilter(hashTags));

        return loadAndSort(hashTags,f,1)[0];
	}
	
	public HashCount[] funcionalidade2(int n, long initDate, long endDate, String hf){
        HashTags hashTags = new Filter(hf).getHashTags();

        Filter f = new Filter(this.tweetFile);
        f.addFilter(new TweetTimeIntervalFilter(initDate,endDate));


        return loadAndSort(hashTags,f,n);
	}
	
	public HashCount[] funcionalidade3(int k, long date){

        Filter f = new Filter (this.tweetFile);
        f.addFilter(new TweetTimeIntervalFilter(date-OFFSET, date+OFFSET));

        return loadAndSort(null, f, k);
		
	}
	
	public HashCount[] funcionalidade4(int n, long date, String hf){
        HashTags hashTags = new Filter(hf).getHashTags();

	    Filter f = new Filter (this.tweetFile);
        f.addFilter(new TweetHashFilter(hashTags));
        f.addFilter(new TweetTimeIntervalFilter(date-OFFSET, date+OFFSET));

        return loadAndSort(hashTags, f, n);
	}
	
	public App(String twFile){		

        this.tweetFile = twFile;
	}


}

