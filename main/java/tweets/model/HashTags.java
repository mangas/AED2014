package tweets.model;

/**
 * Created by fa on 26/10/14.
 */
public class HashTags {

    private  String[] hashtags;

    public HashTags(String[] hashtags) {
        this.hashtags=hashtags;
    }

    public String[] getHashtags() {
        return this.hashtags;
    }

    public boolean contains(String hashtag) {

        boolean found = false;

        for (String s : hashtags)
            if (s.equalsIgnoreCase(hashtag)) {
                found = true;
                break;
            }

        return found;
    }

    public boolean equals(HashTags tags) {

        for (String s : tags.getHashtags())
            if (!contains(s))
                return false;

        return true;
    }

}
