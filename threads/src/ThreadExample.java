
public class ThreadExample {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " Starts !!!");
		Numbers t1 = new Numbers(1, 100);
		Numbers t2 = new Numbers(300, 900);
		Numbers t3 = new Numbers(1200, 1400);
		
		t1.start();
		t2.start();
		t3.start();
		
		someTask();
	}

	private static void someTask() {
		System.out.println("main calls some task");
		System.out.println("main runs on priorty : " + Thread.currentThread().getPriority());
		System.out.println("Main completes!!!");
	}

}
