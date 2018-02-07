import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class ConcurrencyLockSyncSema {
    public static void main(String[] args) {
        System.out.println("ReadWriteLock");
        readWriteLock();

        System.out.println();

        System.out.println("StampedLock");
        stampedLock();
    }

    static void readWriteLock() {
        StringBuilder sentence = new StringBuilder();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Runnable write = () -> {
            lock.writeLock().lock();
            try {
                ConcurrentUtils.sleep(1);
                sentence.append("My name is - " + Thread.currentThread().getName());
                System.out.println("Wrote!");
            } finally {
                lock.writeLock().unlock();
            }
        };

        Runnable read = () -> {
            lock.readLock().lock();
            try {
                System.out.println(sentence.toString());
            } finally {
                lock.readLock().unlock();
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(read);
        executor.submit(write);
        executor.submit(read);
        executor.submit(read);

        ConcurrentUtils.stop(executor);
    }

    static void stampedLock() {
        StringBuilder sb = new StringBuilder();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();

        Runnable read = () -> {
            long stamp = lock.tryOptimisticRead();
            try {
                while (1>0) {
                    if (lock.validate(stamp)) {
                        System.out.println(sb.toString());
                    } else {
                        System.out.println("Busy, writing!");
                        stamp = lock.tryOptimisticRead();
                    }
                    ConcurrentUtils.sleep(1);
                }
            } finally {
                lock.unlockRead(stamp);
            }
        };

        Runnable write = () -> {
            long stamp = lock.writeLock();
            try {
                ConcurrentUtils.sleep(1);
                sb.append("I'm writing because i CAN!");
            } finally {
                lock.unlockWrite(stamp);
            }
        };

        executor.submit(read);
        executor.submit(write);

        ConcurrentUtils.stop(executor);
    }
}
