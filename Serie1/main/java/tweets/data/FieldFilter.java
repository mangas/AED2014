package tweets.data;

import tweets.model.Tweet;

/**
 * Created by fa on 26/10/14.
 */
public interface FieldFilter {

    public boolean filter(Tweet t);
}
