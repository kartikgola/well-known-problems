/*
 * Author: Kartik Gola
 * Date: 1/15/22, 10:22 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

package dbconnectionpool;/*
 * Author: Kartik Gola
 * Date: 1/15/22, 10:21 PM
 * Copyright (c) 2021 | https://kartikgola.com
 */

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// dummy dbconnectionpool.Connection class
class Connection {
    int id;
    Connection(int id) throws InterruptedException { this.id = id; Thread.sleep(100); }
    public String toString() { return "dbconnectionpool.Connection{" + id + "}"; }
}

abstract class DbConnectionPool {

    protected final int maxConnections;
    protected final BlockingQueue<Connection> blockingQueue;

    protected DbConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.blockingQueue = new LinkedBlockingQueue<>(maxConnections);
    }

    protected abstract void createConnection();

    public Connection getConnection() {
        Connection connection = null;
        try {
            createConnection();
            connection = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void putConnection(Connection connection) {
        try {
            if (connection == null)
                return;
            blockingQueue.put(connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SlowDbConnectionPool extends DbConnectionPool {

    protected int connectionId = 0;

    public SlowDbConnectionPool(int maxConnections) {
        super(maxConnections);
    }

    // Slow connection that requires intrinsic lock and blocks all other thread
    // that are trying to create a connection
    @Override
    protected synchronized void createConnection() {
        try {
            if (connectionId >= maxConnections)
                return;
            blockingQueue.put(new Connection(connectionId++));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FastDbConnectionPool extends DbConnectionPool {

    protected int connectionId = 0;
    protected final AtomicInteger atomicConnectionId = new AtomicInteger(0);

    public FastDbConnectionPool(int maxConnections) {
        super(maxConnections);
    }

    // Fast connection pool that doesn't use intrinsic lock to block other threads
    // This allows simultaneous creation of connections by checking atomic connection ID
    @Override
    protected void createConnection() {
        try {
            synchronized (this) {
                if (++connectionId > maxConnections)
                    return;
            }
            blockingQueue.put(new Connection(atomicConnectionId.getAndIncrement()));

//            // Second version using AtomicInteger
//            if (atomicConnectionId.incrementAndGet() > maxConnections)
//                return;
//            blockingQueue.put(new dbconnectionpool.Connection(atomicConnectionId.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DbConnectionPoolApp {

    public static void testPool(DbConnectionPool pool) {
        ExecutorService consumerService = Executors.newFixedThreadPool(4);
        long startTime = System.currentTimeMillis();
        try {
            for (int i = 0; i < 1000; ++i) {
                consumerService.execute(() -> {
                    Connection connection = null;
                    try {
                        connection = pool.getConnection();

                        // do something with acquired connection
                        Thread.sleep(1);
                        System.out.print(Thread.currentThread() + " used " + connection + "\r");

                        pool.putConnection(connection);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                    }
                });
            }
            consumerService.shutdown();
            consumerService.awaitTermination(20, TimeUnit.SECONDS);
            System.out.println("Time taken = " + (System.currentTimeMillis() - startTime));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            consumerService.shutdown();
        }
    }

    public static void main(String[] args) {
        testPool(new SlowDbConnectionPool(100));
        testPool(new FastDbConnectionPool(100));
    }
}