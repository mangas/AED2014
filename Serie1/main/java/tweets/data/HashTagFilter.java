package tweets.data;

import tweets.model.HashTags;
import tweets.model.Tweet;

/**
 * Created by fa on 26/10/14.
 */
public class HashTagFilter extends AbstractFieldFilter {

    private HashTags hashtags;

    public HashTagFilter(HashTags hashtags) {
        this.hashtags=hashtags;
    }

    @Override
    public boolean filter(Tweet t) {

        return true;

    }
}
