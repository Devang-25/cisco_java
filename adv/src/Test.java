import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) {
		System.out.println("Hello !!");
		try {
			doTask();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Bye!!!");
	}

	private static void doTask() throws FileNotFoundException {
		doAnotherTask();
	}

	private static void doAnotherTask() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("a.txt");
	}

}
