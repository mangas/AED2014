package tweets.model;

/**
 * Created by fa on 26/10/14.
 */
public class Tweet {

    private long seconds;
    private String[] hashtags;
    private long uid;
    private long id;

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public String[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(String[] hashtags) {
        this.hashtags = hashtags;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
