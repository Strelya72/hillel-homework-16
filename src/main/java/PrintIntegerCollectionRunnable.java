import java.util.Collection;

public class PrintIntegerCollectionRunnable implements Runnable {
    final Collection<Integer> intCollection;

    public PrintIntegerCollectionRunnable(Collection<Integer> collectionInteger) {
        intCollection = collectionInteger;
    }

    @Override
    public void run() {
        for (int item : intCollection) {
            System.out.println(item);
        }
    }
}
