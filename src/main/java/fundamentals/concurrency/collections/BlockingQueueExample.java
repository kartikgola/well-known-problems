package fundamentals.concurrency.collections;

import java.util.Arrays;
import java.util.concurrent.*;

public class BlockingQueueExample {

    private static BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(2);

    public static void blockingQueueExample1() {
        ExecutorService es = Executors.newFixedThreadPool(2);
        try {
            bq.offer(10);
            bq.offer(20);
            es.submit(() -> {
                double max = 1e7;
                System.out.println("Heavy task started");
                for (int task = 1; task <= max; ++task)
                    System.out.print(Math.round((task/max) * 100.0) + "%\r");
                System.out.println("Finished heavy task. Polling = " + bq.poll());
            });

            // This line will wait 10s for BQ to accept the integer
            // While waiting, if the thread is interrupted, it will throw InterruptedException
            System.out.println("BQ offer = " + bq.offer(30, 10, TimeUnit.SECONDS));
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        blockingQueueExample1();
    }
}
