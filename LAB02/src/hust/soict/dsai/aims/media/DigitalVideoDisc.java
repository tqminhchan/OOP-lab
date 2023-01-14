package hust.soict.dsai.aims.media;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
		super(title, category, cost, director, length);
	}

	// add method play
	@Override
	public void play() throws PlayerException {

		if (this.getLength() > 0) {
			JDialog dialog = new JDialog();
			dialog.setSize(300, 200);

			// create Label
			JLabel text = new JLabel("NCTA - Title : " + this.getTitle() + " Length : " + this.getLength());
			text.setFont(new Font("Arial", Font.PLAIN, 14));
			text.setForeground(Color.BLUE);
			text.setHorizontalAlignment(SwingConstants.CENTER);
			dialog.add(text);
			dialog.setTitle("NCTA - Play DVD");
			dialog.setVisible(true);
		} else
			throw new PlayerException("ERROR : DVD length is non-positive");
	}

}
