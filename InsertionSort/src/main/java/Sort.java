import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
	public <T> List<T> insertionSort(List<T> in, Comparator<T> compare) {
		for (int i = 1; i < in.size(); i++) {
			int j = i;
			while (j > 0 && compare.compare(in.get(j), in.get(j-1)) < 0) {
				T buff = in.get(j);
				in.set(j, in.get(j-1));
				in.set(j-1, buff);
				j--;
			}
		}
		return in;
	}

	public <T> List<T> builtInSort(List<T> in, Comparator<T> compare) {
		Collections.sort(in, compare);
		return in;
	}
}
