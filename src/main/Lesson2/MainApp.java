import Sorting.BubbleSort;
import Sorting.InsertionSort;
import Sorting.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        final int BOUND = 10_000;
        ArrayList<Integer> array = new ArrayList<>(BOUND);
        Random random = new Random();
        for (int i = 0; i < BOUND; i++) {
            array.add(random.nextInt(BOUND));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> tasks = Arrays.asList(
                measureTime(InsertionSort::sort, "Insertion sort", new ArrayList<>(array)),
                measureTime(BubbleSort::sort, "Bubble sort", new ArrayList<>(array)),
                measureTime(SelectionSort::sort, "Selection sort", new ArrayList<>(array))
        );

        for (Runnable task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);

    }

    private static <E extends Comparable<E>> Runnable measureTime(Function<ArrayList<E>, ArrayList<E>> action, String actionName, ArrayList<E> arrayList) {
        return () -> {
            long startTime = System.currentTimeMillis();
            new Runnable() {
                @Override
                public void run() {
                    action.apply(arrayList);
                }
            }.run();
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            System.out.printf("%s took time: %d ms\n",
                    actionName,
                    duration);
        };
    }
}
