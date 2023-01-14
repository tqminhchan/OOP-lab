package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

// 2.2.6

public class LinearEquation {

	/**
	 * Giai pt ax + b = 0
	 */
	public static void firstDegreeEquation() {
		String strNum1, strNum2;
		double a, b;

		// ax + b = 0
		// get num from keyboard
		strNum1 = JOptionPane.showInputDialog(null, "20204939 - nctanh please input a: ", "Input the number",
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "20204939 - nctanh please input b: ", "Input the number",
				JOptionPane.INFORMATION_MESSAGE);
		// convert to double
		a = Double.parseDouble(strNum1);
		b = Double.parseDouble(strNum2);
		// check a
		if (a == 0)
			/*
			 * if b == 0 => pt vo so nghiem if b != 0 => pt vo nghiem
			 */
			if (b != 0)
				JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT vo nghiem", "ax + b = 0 ",
						JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT vo so nghiem", "ax + b = 0 ",
						JOptionPane.INFORMATION_MESSAGE);
		else
			// show result
			JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT co nghiem x = " + (-b / a), "ax + b = 0 ",
					JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * Giải hệ pt 2 ẩn 𝑎11𝑥1+𝑎12𝑥2=𝑏1 𝑎21𝑥1+𝑎22𝑥2=𝑏2
	 */
	public static void theSystemfirstDegreeEquation() {

		String num, expression = "𝑎11𝑥1+𝑎12𝑥2=𝑏1 𝑎21𝑥1+𝑎22𝑥2=𝑏2";
		double a[][] = new double[2][2]; // initialize an array with 4 numbers of a
		double b[] = new double[2]; // initialize an array with 2 numbers of b
		double D, Dx, Dy;

		// get data of array a from user
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				// get num from keyboard
				num = JOptionPane.showInputDialog(null, "20204939 - nctanh Enter a" + (i + 1) + "" + (j + 1) + ":",
						expression, JOptionPane.INFORMATION_MESSAGE);
				// convert to double
				a[i][j] = Double.parseDouble(num);
			}
		}

		// get data of array b from user
		for (int j = 0; j < 2; j++) {
			// get num from keyboard
			num = JOptionPane.showInputDialog(null, "20204939 - nctanh Enter b" + (j + 1) + ":", expression,
					JOptionPane.INFORMATION_MESSAGE);
			// convert to double
			b[j] = Double.parseDouble(num);
		}

		/**
		 * Giải hệ pt 2 ẩn 𝑎11𝑥1+𝑎12𝑥2=𝑏1 𝑎21𝑥1+𝑎22𝑥2=𝑏2
		 */

		// D = a11*a22 - a21*a12;
		D = a[0][0] * a[1][1] - a[1][0] * a[0][1];

		// Dx = b1*a22 - b2*a12
		Dx = b[0] * a[1][1] - b[1] * a[0][1];

		// Dy = a11*b2 - a21*b1
		Dy = a[0][0] * b[1] - a[1][0] * b[0];

		// Nếu D = Dx = Dy = 0 thì hệ có vô số nghiệm
		// D = 0, Dx != 0 hoặc Dy !=0 hệ vô nghiệm
		// D != 0 hệ có nghiệm

		if (D == Dx && Dx == Dy && Dx == 0)
			JOptionPane.showMessageDialog(null, "20204939 - nctanh - Hệ có vô số nghiệm", expression,
					JOptionPane.INFORMATION_MESSAGE);
		else if (D == 0 && (Dx != 0 || Dy != 0))
			JOptionPane.showMessageDialog(null, "20204939 - nctanh - Hệ  vô  nghiệm", expression,
					JOptionPane.INFORMATION_MESSAGE);
		else {
			// x = Dx / D
			// y = Dy / D
			JOptionPane.showMessageDialog(null, "20204939 - nctanh - Hệ có nghiệm x = " + (Dx / D) + " y = " + (Dy / D),
					expression, JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * Giải phương trình bậc 2 ax^2 + bx + c = 0
	 */
	public static void seconDegreeEquation() {
		String strNum1, strNum2, strNum3;
		double a, b, c, delta, x1, x2;
		String expression = "ax^2 + bx + c = 0";

		// Giải phương trình bậc 2 ax^2 + bx + c = 0
		// get num from keyboard
		strNum1 = JOptionPane.showInputDialog(null, "20204939 - nctanh please input a: ", expression,
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, "20204939 - nctanh please input b: ", expression,
				JOptionPane.INFORMATION_MESSAGE);
		strNum3 = JOptionPane.showInputDialog(null, "20204939 - nctanh please input c: ", expression,
				JOptionPane.INFORMATION_MESSAGE);

		// convert to double
		a = Double.parseDouble(strNum1);
		b = Double.parseDouble(strNum2);
		c = Double.parseDouble(strNum3);

		/*
		 * Nếu a == 0 + Nếu b == 0 và c != 0 => vô nghiệm + Nếu b == 0 và c == 0 pt vô
		 * số nghiệm + Nếu b != 0 thì pt có nghiệm -c / b
		 */
		if (a == 0) {
			if (b == 0)
				if (c != 0)
					JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT vô nghiệm", expression,
							JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT vô số nghiệm", expression,
							JOptionPane.INFORMATION_MESSAGE);
			else
				// show result
				JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT co nghiem x = " + (-c / b), expression,
						JOptionPane.INFORMATION_MESSAGE);
		} else {
			/*
			 * Nếu a != 0 => delta = b^2 - 4ac + delta < 0 -> pt vô nghiệm + delta == 0 ->
			 * pt có nghiệm duy nhất x = -b/2a + delta > 0 -> pt có 2 nghiệm phân biệt x1 =
			 * ( -b - sqrt(delta) ) / 2a x2 = ( -b + sqrt(delta) ) / 2a
			 */
			// caculate delta
			delta = b * b - 4 * a * c;
			if (delta < 0)
				// show result
				JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT vô nghiệm", expression,
						JOptionPane.INFORMATION_MESSAGE);
			else if (delta == 0)
				// show result
				JOptionPane.showMessageDialog(null, "20204939 - nctanh - PT có nghiệm duy nhất x = " + (-b / (2 / a)),
						expression, JOptionPane.INFORMATION_MESSAGE);
			else {
				// caculate x1 and x2
				x1 = (-b - Math.sqrt(delta)) / (2 * a);
				x2 = (-b + Math.sqrt(delta)) / (2 * a);
				// show result
				JOptionPane.showMessageDialog(null,
						"20204939 - nctanh - PT có 2 nghiệm phân biệt x1 = " + x1 + " x2 = " + x2, expression,
						JOptionPane.INFORMATION_MESSAGE);

			}

		}

	}

	public static void main(String args[]) {
		boolean exit = false;
		int choose;
		String strNum2;
		String context = " Enter number :\n";
		context += "1. Giải phương trình bậc 1\n";
		context += "2. Giải hệ phương trình bậc 1\n";
		context += "3. Giải phương trình bậc 2\n";
		context += "4. Thoát\n";

		// if exit == fasle thực hiện lặp ngược lại sẽ kết thúc
		do {
			// get num from keyboard
			strNum2 = JOptionPane.showInputDialog(null, "20204939 - nctanh \n" + context, "Input the second number",
					JOptionPane.INFORMATION_MESSAGE);
			// convert to int
			choose = Integer.parseInt(strNum2);
			/*
			 * choose == 1 Giải phương trình bậc 1 choose == 2 Giải hệ phương trình bậc 1
			 * choose == 3 Giải phương trình bậc 2 choose == 4 Thoát
			 */
			switch (choose) {
			case 1:
				firstDegreeEquation();
				break;
			case 2:
				theSystemfirstDegreeEquation();
				break;
			case 3:
				seconDegreeEquation();
				break;
			case 4:
				exit = true;
				break;
			}

		} while (!exit);

		System.exit(0);
	}

}
