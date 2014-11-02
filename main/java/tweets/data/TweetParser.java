package tweets.data;

import tweets.model.HashTags;
import tweets.model.Tweet;

/**
 * Created by fa on 26/10/14.
 */

public class TweetParser extends AbstractParser<Tweet> {

    @Override
    public Tweet parseOne(String line) {

        HashTags ht = new HashTags();

        String[] fields = line.split(":");



        for (int i=0;i<fields.length;i++) {
            System.out.println(fields[i]);
        }


        return null;
    }
}
