package tweets.data;

import tweets.model.HashTags;
import tweets.model.Tweet;

/**
 * Created by fa on 11/11/14.
 */
public class TweetHashFilter extends AbstractFieldFilter {

    private HashTags hashTags;

    public TweetHashFilter(HashTags hash) {
        this.hashTags=hash;
    }

    @Override
    public boolean filter(Tweet t) {
        return t.getHashtags().containsAny(this.hashTags);
    }
}
