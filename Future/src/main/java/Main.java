import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	private static final ExecutorService executor = Executors.newCachedThreadPool();
	private static final Map<Integer, Map<CancellableRunnable, Future<?>>> futures = new HashMap<>();
	public static void main(String[] args) {
		run(0);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("main - interrupted");
		}
		run(0);
	}

	private static void run(int id) {
		Future<?> future = futures.get(id);
		if (future != null && future.cancel(true)) {
			System.out.println(future.isCancelled());
			return;
		} else {
			future = executor.submit(new CancellableRunnable());
			futures.put(id, future);
		}
	}
}
