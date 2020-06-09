import java.util.function.Consumer;

class DummyConsumer implements Consumer<String> {
	@Override
	public void accept(String t) {
			System.out.println(t);
	}
}

public class AnonymousExample {
	
	public static void doTask(String[] elems, Consumer<String> cons) {
		for(String o : elems) {
			cons.accept(o);
		}
	}
	
	public static void main(String[] args) {
		String[] names = {"Clooney", "Brad","Angelina","Lee"};
		 
		doTask(names, new DummyConsumer());
		
		// Anonymous class
		doTask(names, new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		System.out.println("With Lambda !!!");
		// t will be of type String ==> type interface
		doTask(names, t -> System.out.println(t));
	}

}
