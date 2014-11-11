package tweets.data;

import tweets.model.Tweet;

/**
 * Created by fa on 11/11/14.
 */
public class TweetTimeIntervalFilter extends AbstractFieldFilter {

    private long start;
    private long end;

    public TweetTimeIntervalFilter(long startTime, long endTime) {
        this.start=startTime;
        this.end = endTime;
    }

    @Override
    public boolean filter(Tweet t) {

        if (t.getTime()>this.end  || t.getTime()<this.start)
            return false;

        return true;
    }
}
