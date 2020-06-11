import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolExample {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(new Numbers(1, 40));
		service.submit(new Numbers(100, 120));
		service.submit(new Numbers(200, 230));
		service.submit(new Numbers(80, 100));

		service.shutdown();
	}

}
