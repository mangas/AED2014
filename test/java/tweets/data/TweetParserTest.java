package tweets.data;

import org.junit.Test;
import tweets.model.Tweet;
import tweets.utils.ConvertDate;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by z003crvk on 27-10-2014.
 */
public class TweetParserTest {

    @Test
    public void parseOne() {
        TweetParser tp = new TweetParser();
        final String TWEET_LINE = "{\"created_at\": \"2014-07-06T18:08:21\", \"hashtags\": [\"WorldCup\"], \"id\": 485847737653813248, \"uid\": 2563200427}";

        Tweet tw = tp.parseOne(TWEET_LINE);

        assertEquals(ConvertDate.getInstant("2014-07-06T18:08:21"),tw.getSeconds());
        assertEquals("2563200427",tw.getUid());
        assertEquals("485847737653813248",tw.getId());
        assertArrayEquals(new String[] {"WorldCup"}, tw.getHashtags().getHashtags());


    }
}
