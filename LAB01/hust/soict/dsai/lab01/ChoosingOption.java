package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

// 6.1
public class ChoosingOption {
	public static void main(String args[]) {
		// Thiết lập option chỉ có yes and no để cho người dùng sủ dụng
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", "Confirm",
				JOptionPane.YES_NO_OPTION);
		// Hiển thị kết quả người dùng đã chọn
		JOptionPane.showMessageDialog(null, "You're choosen: " + (option == JOptionPane.YES_OPTION ? "YES" : "NO"));
		System.exit(0);
	}

}
