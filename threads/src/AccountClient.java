
public class AccountClient {

	public static void main(String[] args) {
		Account acc = new Account(5000);
		
		TransactionThread t1 = new TransactionThread(acc, TransactionType.CREDIT, "Smitha", 2500);
		TransactionThread t2 = new TransactionThread(acc, TransactionType.CREDIT, "\tKarthik", 300);
		TransactionThread t3 = new TransactionThread(acc, TransactionType.DEBIT, "\t\tDanny", 6000);
		
		
		t3.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t1.start();
		t2.start();
		// Barrier
		try {
			t1.join(); // caller thread [ main ] has to wait for t1 to finish
			t2.join(); // caller thread [ main ] has to wait for t2 to finish
			t3.join(); // caller thread  [ main ] has to wait for t3 to finish
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		// How many threads are running ?? main, t1, t2, t3
		System.out.println("Final Balance : " + acc.getBalance()); // to print only when t1,t2, t3 finish
		
	}

}
