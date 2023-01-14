package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class ShowTwoNumbers {
	// 2.2.4

	public static void main(String args[]) {
		String strNum1, strNum2;
		String strNotification = "You're have just entered: ";
		// get number from keyboard
		strNum1 = JOptionPane.showInputDialog(null, "20204939 - nctanh please input the first number: ",
				"Input the first number", JOptionPane.INFORMATION_MESSAGE);
		strNotification = strNum1 + " and ";
		strNum2 = JOptionPane.showInputDialog(null, "20204939 - nctanh please input the second number: ",
				"Input the second number", JOptionPane.INFORMATION_MESSAGE);

		strNotification += strNum2;

		// show
		JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	}

}
