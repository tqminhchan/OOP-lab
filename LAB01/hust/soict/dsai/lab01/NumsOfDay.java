package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

// 6.4
public class NumsOfDay {

	/**
	 * Kiểm tra xem tháng này là tháng mấy
	 * 
	 * @return trả về tháng thứ bn
	 */
	public static int getMonth(String month[][], String input) {
		for (int i = 0; i < month.length; i++) {
			// Không duyệt số lượng ngày trong mảng
			for (int j = 0; j < month[i].length - 1; j++) {
				// nếu tồn tại sẽ trả về tháng đó
				if (month[i][j].equals(input))
					return i + 1;
			}
		}
		// không tồn tại sẽ trả về 0
		return 0;
	}

	/**
	 * Kiểm tra xem là năm có thoả mãn không
	 * 
	 * @param year năm để kiểm tra
	 * @return true thì nó valid và ngược lại
	 */
	public static boolean checkValidYear(String year) {
		// Nếu lớn hơn 0 trả về true
		if (Integer.parseInt(year) > 0)
			return true;
		return false;
	}

	public static void main(String args[]) {
		// Khai báo mảng ngày tháng cuối cùng là số ngày trong tháng
		String month[][] = { { "January", "Jan.", "Jan", "1", "31" }, { "February", "Feb.", "February", "28" },
				{ "March", "Mar.", "Mar", "3", "31" }, { "April", "Apr.", "Apr", "4", "30" }, { "May", "5", "31" },
				{ "June", "Jun", "6", "30" }, { "July", "Jul", "7", "31" }, { "August", "Aug.", "Aug", "8", "31" },
				{ "September", "Sep.", "Sep", "9", "30" }, { "October", "Oct.", "Oct", "10", "31" },
				{ "November", "Nov.", "Nov", "11", "30" }, { "December", "Dec.", "Dec", "12", "31" } };
		int monthOfYear;
		String monthInput, yearInput;
		// Kiểm tra đầu vào tháng
		do {
			monthInput = JOptionPane.showInputDialog(null, "Please enter month", "Input the month",
					JOptionPane.INFORMATION_MESSAGE);
			// nhập không hợp lệ sẽ bắt nhập lại
		} while (getMonth(month, monthInput) == 0);
		// Kiểm tra đầu vào năm
		do {
			yearInput = JOptionPane.showInputDialog(null, "Please enter year", "Input the year",
					JOptionPane.INFORMATION_MESSAGE);
			// nhập không hợp lệ sẽ bắt nhập lại
		} while (!checkValidYear(yearInput));
		monthOfYear = getMonth(month, monthInput);
		/*
		 * Nếu là tháng 2 + năm nhuận trả về 29 và ngược lại trả về 28 Không phải là
		 * tháng 2 thì lấy số ngày từ mảng month
		 */
		if (monthInput.equals("2")) {
			if (Integer.parseInt(yearInput) % 4 == 0)
				JOptionPane.showMessageDialog(null, "Nums of day: " + 29);
			else
				JOptionPane.showMessageDialog(null, "Nums of day: " + 28);
		} else {
			JOptionPane.showMessageDialog(null,
					"Nums of day: " + month[monthOfYear - 1][month[monthOfYear - 1].length - 1]);
		}

	}

}
