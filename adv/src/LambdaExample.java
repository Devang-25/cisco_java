
interface Computation {
	int compute(int x, int y);
}

public class LambdaExample {

	public static void main(String[] args) {
		// Anonymous class
		Computation add = new Computation() {
			@Override
			public int compute(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(add.compute(4, 5));
		// lambda expression for subtract, multiply
		Computation sub = (x, y) -> {
				return x - y;
			};
				
		System.out.println(sub.compute(14, 5));	 // 9
		
		Computation mul = (x,y) -> x * y;
		
		System.out.println(mul.compute(4, 5));	 // 20
	}

}
