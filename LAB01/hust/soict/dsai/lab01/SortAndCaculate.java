package hust.soict.dsai.lab01;

import java.util.Arrays;

import javax.swing.JOptionPane;

// 6.5
public class SortAndCaculate {
	public static void main(String args[]) {
		int nums;
		int arr[];
		String results = "Chuỗi số trước khi sắp xếp : \n";
		double sumOfArr = 0, avg;
		// Nhận giá trị vào
		nums = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Enter nums of product:  ", "", JOptionPane.INFORMATION_MESSAGE));

		// Khởi tạo mảng có nums phần tử
		arr = new int[nums];

		for (int i = 0; i < nums; i++) {
			// Đọc dữ liệu vào
			arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter arr[" + (i + 1) + "]: ", "",
					JOptionPane.INFORMATION_MESSAGE));
			// Thêm dữ liệu cho đầu ra
			results += arr[i] + " ";
		}
		results += "\nDãy số sau khi sắp xếp : \n";
		// Sắp xếp
		Arrays.sort(arr);

		for (int i = 0; i < nums; i++) {
			// Thêm dữ liệu cho đầu ra
			results += arr[i] + " ";
			sumOfArr += arr[i];
		}
		// tính trung bình
		avg = sumOfArr / nums;

		results += "\nSum: " + sumOfArr + "\nAvg: " + avg;

		JOptionPane.showMessageDialog(null, results, "", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);

	}

}
