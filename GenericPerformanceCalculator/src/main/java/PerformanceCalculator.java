import sun.rmi.runtime.Log;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Function;
import java.util.logging.Logger;

public class PerformanceCalculator {
	private static final Logger log = Logger.getLogger("Performance");

	public static <T, R> R calculate(T input, Function<T, R> fn) {
		Instant start = Instant.now();
		R result = fn.apply(input);
		Instant end = Instant.now();
		Duration dur = Duration.between(start, end);
		log.info(dur.toString());
		return  result;
	}
}
