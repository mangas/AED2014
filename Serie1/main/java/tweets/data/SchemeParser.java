package tweets.data;

/**
 * Created by fa on 26/10/14.
 */
public interface SchemeParser<T> {

    public T parseOne (String line);
}
