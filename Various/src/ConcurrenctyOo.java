import java.util.concurrent.*;

public class ConcurrenctyOo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Hey thread! Introduce yourself! :)");
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hey! My name is! What? My name is! Who? My name is! " + threadName);
        };
        task.run();

        Thread thread = new Thread(task);
        thread.start();
        System.out.println();

        System.out.println("Whoa, whoa. Slow down a bit!");
        Runnable task2 = () -> {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("I wont slow down! Because, THIS IS - " + threadName.toUpperCase() + "!!");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("You will, because i'm the LAW! \n\t - " + threadName + ": Ok, ok, chill out bro...");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };
        task2.run();
        System.out.println();

        System.out.println("Hey, hey! Have you heard about this new guy on the block? He's calling himself Executor!");
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> {
            System.out.println("Hell! I'm " + Thread.currentThread().getName() + "!");
            System.out.println("AND I WONT STOOOOOOOOOOOOOO");
        });
        try {
            es.shutdown();
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.print("P! \n\t Until you stop me explicitly!");
        } finally {
            if (!es.isTerminated()) {
                System.out.println("SHit man. Stop already! I'm shutting you down, n199a!");
            }
            es.shutdownNow();
            System.out.println("Deal with it!");
        }

        System.out.println();
        System.out.println("But you are stupid!");
        Callable<Integer> cTask = () -> {
            System.out.println("No, i'm not!");
            TimeUnit.SECONDS.sleep(1);
            return 21;
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(cTask);
        executor.shutdown();
        System.out.println("What's Nine + Ten?");
        Integer result = future.get();
        System.out.println(result);
        System.out.println("You are STUPID!");
    }
}
