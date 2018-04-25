import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortTest {
	private static List<Integer> toSort;
	private static List<Integer> sorted;
	private static Sort sort;

	@BeforeAll
	public static void setUp() {
		toSort = new ArrayList();
		toSort.addAll(Arrays.asList(1,100,2,5,6,8,123,900,777,12,15,7,10,23,67,3,0));
		sorted = new ArrayList<>();
		sorted.addAll(Arrays.asList(0,1,2,3,5,6,7,8,10,12,15,23,67,100,123,777,900));
		sort = new Sort();
	}

	@Test
	public void insertionSorting() {
		assertEquals(sorted, PerformanceCalculator.calculate(toSort, e -> sort.insertionSort(e,
				Comparator.comparingInt(s -> s))));
	}

	@Test
	public void builtInSorting() {
		assertEquals(sorted, PerformanceCalculator.calculate(toSort, e -> sort.builtInSort(e,
				Comparator.comparingInt(s -> s))));
	}
}
