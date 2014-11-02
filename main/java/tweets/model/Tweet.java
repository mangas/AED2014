package tweets.model;

import tweets.data.FieldFilter;

/**
 * Created by fa on 26/10/14.
 */
public class Tweet {

    private long seconds;
    private HashTags hashtags;
    private long uid;
    private long id;

    public long getSeconds() {
        return seconds;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public HashTags getHashtags() {
        return hashtags;
    }

    public void setHashtags(HashTags hashtags) {
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

	public boolean hasHashTag(FieldFilter fieldFilter) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEndOfFile() {
		// TODO Auto-generated method stub
		return false;
	}


}
