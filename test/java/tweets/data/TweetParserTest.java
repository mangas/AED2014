<<<<<<< HEAD
package tweets.data;

import org.junit.Test;
import tweets.model.Tweet;

import static org.junit.Assert.assertEquals;

/**
 * Created by fa on 02/11/14.
 */

public class TweetParserTest {


    @Test
    public static void parseTweetTest() {
        final String tweet1 = "{\"created_at\": \"2014-07-06T18:08:28\", \"hashtags\": [\"worldcup\"], \"id\": 485847765772021760, \"uid\": 34191594}"
        final String tweet2 = "{\"created_at\": \"2014-07-06T18:08:28\", \"hashtags\": [\"Schweinsteiger\", \"Neuer\"], \"id\": 485847766384775168, \"uid\": 2566075189}";

        Tweet tw = new TweetParser().parseOne(tweet1);



        Tweet tw2 = new TweetParser().parseOne(tweet2);
    }
}
=======
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
    public void tweetParsing() {
        TweetParser tp = new TweetParser();
        final String TWEET_LINE = "{\"created_at\": \"2014-07-06T18:08:21\", \"hashtags\": [\"WorldCup\"], \"id\": 485847737653813248, \"uid\": 2563200427}";

        Tweet tw = tp.parseOne(TWEET_LINE);

        assertEquals(ConvertDate.getInstant("2014-07-06T18:08:21"),tw.getSeconds());
        assertEquals("2563200427",tw.getUid());
        assertEquals("485847737653813248",tw.getId());
        assertArrayEquals(new String[] {"WorldCup"}, tw.getHashtags().getHashtags());


    }
}
>>>>>>> FETCH_HEAD
