package tweets.model;

/**
 * Created by fa on 11/11/14.
 */
public class HashCount {
    private final String hash;
    private int count = 0;

    public HashCount(String hashTag) {
        hash = hashTag;
    }

    public void inc() {
        this.count++;
    }

    public String getHash() {
        return this.hash;
    }

    public int getCount() {
        return count;
    }
}
