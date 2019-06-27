import java.util.Collection;
import java.util.concurrent.Callable;

public class MaximumNumberOfCollection implements Callable<Float> {
    final Collection<Integer> intCollection;

    public MaximumNumberOfCollection(Collection<Integer> collectionInteger) {
        intCollection = collectionInteger;
    }

    @Override
    public Float call() {
        float maximumValue = (int) intCollection.toArray()[0];
        for (int item : intCollection) {
            maximumValue = item > maximumValue ? item : maximumValue;
        }
        return maximumValue;
    }
}
