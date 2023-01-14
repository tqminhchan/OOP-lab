package hust.soict.dsai.garbage;

import java.util.Random;

public class GarbageCreator {
	public static void main(String args[]) {
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 100000; i++)
			s += r.nextInt() + "hihihi";
		System.out.println(System.currentTimeMillis() - start);

	}
}
