package fundamentals.concurrency.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFutureExample {

    public static void futureExample1() {
        ExecutorService es = null;
        try {
            es = Executors.newFixedThreadPool(2);
            System.out.println(Thread.currentThread().getName() + " Begin");


            Future<String> f = es.submit(() -> {
                int max = (int)2e9;
                for (int i = 0; i < max; i++);
                return "Finished counting till " + max;
            });

            // future.get() method will wait indefinitely until response is received
            System.out.println(f.get());


            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.shutdown();
        }
    }

    public static void futureExample2() {
        ExecutorService es = null;
        try {
            es = Executors.newFixedThreadPool(2);
            System.out.println(Thread.currentThread().getName() + " Begin");


            Future<?> f = es.submit(() -> {
                for (int i = 0; i < 1e1; ++i) {
                    System.out.println("Doing task...1." + i);
                }
            });

            // future.get() method will wait indefinitely until response is received
            // By default, if task returns nothing, future.get() will have value as null
            System.out.println(f.get());


            System.out.println(Thread.currentThread().getName() + " End");
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            // fail-safe
            es.shutdown();
        }
    }

    public static void main(String[] args) {
        futureExample1();
    }
}
