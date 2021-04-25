package fundamentals.concurrency.collections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CopyOnWriteArrayListExample {

    public static void copyOnWriteArrayListExample() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            // CopyOnWriteArrayList will copy the entire list internally
            // The reference to old list, however, will not change
            // This is LIKE an Immutable List with the difference that the old reference is kept.
            List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3));

            // Example 1
            for(Integer item: list) {
                System.out.print(item + " ");
                // Adding elements to list will not affect the current iterator of 'list'
                list.add(4);
            }
            System.out.println();
            // However, the 'list' currently contains [1,2,3,4,4,4]
            System.out.println(list);


            // Example 2
            List<Integer> list2 = new CopyOnWriteArrayList<>();
            es.execute(() -> {
                // Keeps modifying the list
                for (int elem = 1; elem <= 1000_000; ++elem)
                    list2.add(elem);
            });
            es.execute(() -> {
                // Gets a list iterator and prints lis2.size()
                for (Integer val: list2);
                System.out.println(list.size());
            });

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        copyOnWriteArrayListExample();
    }
}
