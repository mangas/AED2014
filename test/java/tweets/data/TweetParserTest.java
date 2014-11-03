package tweets.data;

import org.junit.Test;
import tweets.model.Tweet;
import tweets.utils.ConvertDate;

import static org.junit.Assert.*;

/**
 * Created by z003crvk on 27-10-2014.
 */
public class TweetParserTest {

    @Test
    public void parseOne() {
        TweetParser tp = new TweetParser();
        final String TWEET_LINE = "{\"created_at\": \"2014-07-06T18:08:21\", \"hashtags\": [\"WorldCup\"], \"id\": 485847737653813248, \"uid\": 2563200427}";
        final String TWEET_LINE1 =  "{\"created_at\": \"2014-07-06T18:08:28\", \"hashtags\": [\"Schweinsteiger\", \"Neuer\"], \"id\": 485847766384775168, \"uid\": 2566075189}";

        Tweet tw = tp.parseOne(TWEET_LINE);
        assertEquals(ConvertDate.getInstant("2014-07-06T18:08:21"),tw.getTime());
        assertEquals("2563200427",tw.getUid());
        assertEquals("485847737653813248",tw.getId());
        assertArrayEquals(new String[]{"WorldCup"}, tw.getHashtags().getHashtags());
        assertTrue(tw.getHashtags().contains("worldcup"));

        tw = tp.parseOne(TWEET_LINE1);
        assertEquals(ConvertDate.getInstant("2014-07-06T18:08:28"),tw.getTime());
        assertEquals("2566075189",tw.getUid());
        assertEquals("485847766384775168",tw.getId());
        assertArrayEquals(new String[] {"Schweinsteiger","Neuer"}, tw.getHashtags().getHashtags());
        assertTrue(tw.getHashtags().contains("Schweinsteiger"));
        assertTrue(tw.getHashtags().contains("Neuer"));
        assertFalse(tw.getHashtags().contains("WorldCup"));

    }
}
