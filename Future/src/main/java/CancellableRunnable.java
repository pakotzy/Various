import java.util.concurrent.atomic.AtomicBoolean;

public class CancellableRunnable implements Runnable {
	private AtomicBoolean canceled = new AtomicBoolean(false);

	@Override
	public void run() {
		canceled.
		while (!canceled.get()) {
			int i = 0;
			while (true) {
				System.out.println(i);
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("execute sleep - interrupted");
				}
			}
		}
	}

	public void cancel() {
		canceled.set(true);
	}
}
