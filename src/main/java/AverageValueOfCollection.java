import java.util.Collection;
import java.util.concurrent.Callable;

public class AverageValueOfCollection implements Callable<Float> {
    final Collection<Integer> intCollection;

    public AverageValueOfCollection(Collection<Integer> collectionInteger) {
        intCollection = collectionInteger;
    }
    @Override
    public Float call() {
        int sum = 0;
        for (int item : intCollection) {
            sum += item;
        }
        return sum / (float)intCollection.size();
    }
}
