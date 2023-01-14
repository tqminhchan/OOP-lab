package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

// 6.3
public class Triangle {
	public static void main(String args[]) {
		String strNum1;
		int num, length, mid, right, left;
		String arr[];

		// get number from keyboard and convert
		strNum1 = JOptionPane.showInputDialog(null, "Please input the n : ", "", JOptionPane.INFORMATION_MESSAGE);
		num = Integer.parseInt(strNum1);

		// Tính độ dài và mid index
		length = (num - 1) * 2 + 1;
		mid = length / 2;

		// Khai báo mảng có num phần tử
		arr = new String[length];

		// Khởi tạo giá trị ban đầu cho mảng
		for (int i = 0; i < length; i++)
			arr[i] = " ";

		// Khởi tạo giá trị ở giữa bằng *
		arr[mid] = "*";

		right = left = mid;

		// Lặp n lần
		for (int i = 0; i < num; i++) {
			// in dòng
			for (int j = 0; j < length; j++) {
				System.out.print(arr[j]);
			}
			System.out.print("\n");
			if (left != 0)
				// gán sao
				arr[++right] = arr[--left] = "*";
		}

		System.exit(0);
	}

}
