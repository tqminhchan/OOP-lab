package hust.soict.dsai.lab01;

import java.util.Scanner;

// 6.2
public class InputFromKeyboard {
	public static void main(String args[]) {
		// khởi tạo
		Scanner keyboard = new Scanner(System.in);

		// // đọc dữ liệu
		System.out.println("What's your name? ");
		String strName = keyboard.nextLine();

		// // đọc dữ liệu
		System.out.println("How old are you ?");
		int age = keyboard.nextInt();

		// đọc dữ liệu
		System.out.println("How tall are you (m)?");
		double dheight = keyboard.nextDouble();

		// hiển thị kết quả
		System.out.println("Mrs/Ms. " + strName + ", " + age + " years old. " + "Your height is " + dheight + ".");

		keyboard.close();

	}

}
