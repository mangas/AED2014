package tweets.model;

/**
 * Created by fa on 26/10/14.
 */
public class Tweet {

    private long time;
    private HashTags hashtags;
    private String uid;
    private String id;

    public Tweet(long time, HashTags hashtags, String uid, String id) {
        this.time = time;
        this.hashtags = hashtags;
        this.uid = uid;
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public HashTags getHashtags() {
        return hashtags;
    }

    public void setHashtags(HashTags hashtags) {
        this.hashtags = hashtags;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}
