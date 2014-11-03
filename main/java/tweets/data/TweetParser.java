package tweets.data;

import tweets.model.HashTags;
import tweets.model.Tweet;


/**
 * Created by fa on 26/10/14.
 */

public class TweetParser extends AbstractParser<Tweet> {

    @Override
    public Tweet parseOne(String line) {



        String[] fields = line.split(":");

        String[] tags = fields[4].split("\"]")[0].trim().substring(2).split(",");

        for (int i=0;i<tags.length;i++)
            tags[i] = tags[i].replace("\"", "").trim();


        HashTags ht = new HashTags(tags);

        String date = fields[1].trim().substring(1).concat(":"+fields[2]).concat(":"+fields[3].split(",")[0]);
        date = date.substring(0,date.length()-1);
        long time = tweets.utils.ConvertDate.getInstant(date);

        String id = fields[5].split(",")[0].trim();

        String uid = fields[6].split("}")[0].trim();


        Tweet tw = new Tweet(time,ht,uid,id);


        return tw;
    }
}
