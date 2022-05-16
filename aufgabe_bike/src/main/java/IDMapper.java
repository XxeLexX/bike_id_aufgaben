import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple13;

/**
 * DIY MapFunction:
 * get IDs via the first field
 */
public class IDMapper implements MapFunction<Tuple13<String, String, String, String, String, String, String, String, String, String, String, String, String>, Tuple1<String>> {

    @Override
    public Tuple1<String> map(Tuple13<String, String, String, String, String, String, String, String, String, String, String, String, String> tempTuple) {
        return new Tuple1<>(tempTuple.f0);
    }
}
