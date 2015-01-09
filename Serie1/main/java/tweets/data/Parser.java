package tweets.data;

import tweets.backend.FileLoader;
import tweets.model.HashTags;
import tweets.model.Tweet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fa on 26/10/14.
 */


public class Parser {

    private String filename;
    private SchemeParser parser;
    private FileLoader fl;

    private static final HashMap<String, SchemeParser> EXTENTION_TO_PARSER;

    static {
        EXTENTION_TO_PARSER = new HashMap<String, SchemeParser>();
        EXTENTION_TO_PARSER.put(".twt",new TweetParser());
        EXTENTION_TO_PARSER.put(".tag",new HashTagParser() );
    }

    public Parser(String filename) {
        this.filename=filename;
        this.parser = EXTENTION_TO_PARSER.get(filename.split(".")[1]);

        try {
            this.fl = new FileLoader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

    }

    public Tweet parseTweet() {

        if (!(this.parser instanceof TweetParser))
            return null;

        return (Tweet) parseOne();
    }

    public HashTags parseHashTag() {

        if (!(this.parser instanceof HashTagParser))
            return null;

        ArrayList<String> tags = new ArrayList<String>();

        String line = null;
        while ((line= (String) parseOne())!=null)
            tags.add(line);

        return (HashTags) new HashTags((String[]) tags.toArray());
    }

    private Object parseOne() {

        String line = fl.nextLine();

        if (line ==null)
            return null;

        return parser.parseOne(line);
    }

}
