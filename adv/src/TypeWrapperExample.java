
public class TypeWrapperExample {

	public static void main(String[] args) {
		int x = 10; // primitive type
		Integer iX = x ; // boxing, wrap primitive to object
		
		int y = iX ; // unboxing
		
		double d = 1.2;
		
		Double iD = d;
		
		System.out.println(Integer.toHexString(16));
		
	}

}
