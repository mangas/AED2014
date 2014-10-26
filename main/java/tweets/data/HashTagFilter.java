package tweets.data;

import tweets.model.Tweet;

/**
 * Created by fa on 26/10/14.
 */
public class HashTagFilter extends AbstractFieldFilter {

    private String[] hashtags;

    public HashTagFilter(String[] hashtags) {
        this.hashtags=hashtags;
    }

    @Override
    public boolean filter(Tweet t) {

        for (int i=0;i<this.hashtags.length;i++) {
            boolean found=false;

            for (String s : t.getHashtags())
                if (s.equalsIgnoreCase(hashtags[i]))
                    found=true;

            if (!found) return false;
        }

        return true;
    }
}
