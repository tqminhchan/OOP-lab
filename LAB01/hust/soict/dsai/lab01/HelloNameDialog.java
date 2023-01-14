package hust.soict.dsai.lab01;

import javax.swing.JOptionPane;

public class HelloNameDialog {
	// 2.2.3
	public static void main(String args[]) {
		String results;
		results = JOptionPane.showInputDialog("Please enter your name");
		JOptionPane.showMessageDialog(null, "Hi " + results + "!");
		System.exit(0);
	}
}
