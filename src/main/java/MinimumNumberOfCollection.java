import java.util.Collection;
import java.util.concurrent.Callable;

public class MinimumNumberOfCollection implements Callable<Float> {
    final Collection<Integer> intCollection;

    public MinimumNumberOfCollection(Collection<Integer> collectionInteger) {
        intCollection = collectionInteger;
    }
    @Override
    public Float call() {
        float minimumValue = (int) intCollection.toArray()[0];
        for (int item : intCollection) {
            minimumValue = item < minimumValue ? item : minimumValue;
        }
        return minimumValue;
    }
}
