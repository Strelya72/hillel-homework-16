import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        // Task1

        Collection<Integer> intCollection = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            intCollection.add((int) (Math.random() * 1001));
        }

        PrintIntegerCollectionRunnable printRunnable = new PrintIntegerCollectionRunnable(intCollection);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.shutdown();

        Future<?> result = executor.submit(printRunnable);

        try {
            result.get();
            System.out.println("Task 1 has completed");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error has occurred: " + e.getMessage());
        }

        // Task 2

        System.out.println("\n\n\nTask2");
        ExecutorService executor2 = Executors.newCachedThreadPool();
        executor2.shutdown();

        Collection<Callable<Float>> callables = new ArrayList<>();
        callables.add(new MinimumNumberOfCollection(intCollection));
        callables.add(new MaximumNumberOfCollection(intCollection));
        callables.add(new AverageValueOfCollection(intCollection));

        long start = System.nanoTime();
        try {
            List<Future<Float>> listResults = executor2.invokeAll(callables);
            // Minimum Value
            System.out.println(listResults.get(0).get());
            // Maximum Value
            System.out.println(listResults.get(1).get());
            // Average Value
            System.out.println(listResults.get(2).get());

            System.out.println("Task 2 has completed");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error has occurred: " + e.getMessage());
        }
        long finish = System.nanoTime();
        System.out.println("Time: " + (finish - start));


        // Task 3

        System.out.println("\n\n\nTask3");
        ExecutorService executor3 = Executors.newSingleThreadExecutor();
        ThreadSleep threadSleep = new ThreadSleep(1000L);
        result = executor3.submit(threadSleep);
        executor3.shutdown();
        start = System.nanoTime();

        try {
            result.get();
            System.out.println("Task 3 has completed");
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error has occurred: " + e.getMessage());
        }

        // Another Task 3
//        while (!result.isDone()) {
//            System.out.println("Waiting");
//        }

        System.out.println("Time: " + (System.nanoTime() - start));
    }

}
