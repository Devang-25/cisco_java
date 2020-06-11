import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		Future<Integer> f1  = service.submit(new NumbersCallable(1, 100));
		Future<Integer> f2  = service.submit(new NumbersCallable(100, 500));
		Future<Integer> f3  = service.submit(new NumbersCallable(1, 50));
		
		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
		} catch ( Exception e) {
			e.printStackTrace();
		} 
		
		service.shutdown();
		
	}

}
