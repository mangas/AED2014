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
<<<<<<< HEAD

        for (int i=0;i<this.hashtags.length;i++) {
            boolean found=false;

            for (String s : t.getHashtags().getHashtags())
                if (s.equalsIgnoreCase(hashtags[i]))
                    found=true;

            if (!found) return false;
        }

        return true;
=======
        return this.hashtags.containsTags(t.getHashtags());
>>>>>>> FETCH_HEAD
    }
}
