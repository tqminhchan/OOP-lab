package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

// 6.6.5
public class AddMaix {

	public static void main(String args[]) {
		int nums;
		int arr[], arr1[];
		String results = "Chuỗi số 1 : \n";
		double sumOfArr = 0, avg;
		// Nhận giá trị vào
		nums = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Enter nums of product:  ", "", JOptionPane.INFORMATION_MESSAGE));

		// Khởi tạo mảng có nums phần tử
		arr = new int[nums];
		arr1 = new int[nums];

		for (int i = 0; i < nums; i++) {
			// Đọc dữ liệu vào
			arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter arr[" + (i + 1) + "]: ", "",
					JOptionPane.INFORMATION_MESSAGE));
			// Thêm dữ liệu cho đầu ra
			results += arr[i] + " ";
		}

		results += "\nDãy số 2 : \n";

		for (int i = 0; i < nums; i++) {
			// Đọc dữ liệu vào
			arr1[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter arr1g[" + (i + 1) + "]: ", "",
					JOptionPane.INFORMATION_MESSAGE));
			// Thêm dữ liệu cho đầu ra
			results += arr1[i] + " ";
		}

		results += "\nSau khi cộng : \n";
		for (int i = 0; i < nums; i++) {
			// Thêm dữ liệu cho đầu ra
			results += (arr1[i] + arr[i]) + " ";

		}
		JOptionPane.showMessageDialog(null, results, "", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);

	}

}
