import java.util.concurrent.Callable;

public class NumbersCallable implements Callable<Integer> {
	private int start;
	private int end;
	
	public NumbersCallable(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = start; i <= end ; i++) {
			sum += i;
		}
		return sum;
	}

}
