package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims.AimsMain;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DVDController extends OptionBase {
	Stage stage;

	DVDController(Stage stage) {
		super(stage);
	}

	@FXML
	private TextField category;

	@FXML
	private TextField cost;

	@FXML
	private TextField director;

	@FXML
	private TextField length;

	@FXML
	private TextField title;

	@FXML
	void addDVDToStorebtn(ActionEvent event) {
		float DVDCost;
		int len;
		// if cost or length is not number will not add
		try {
			DVDCost = Float.parseFloat(cost.getText());
			len = Integer.parseInt(length.getText());
			DigitalVideoDisc dvd = new DigitalVideoDisc(title.getText(), category.getText(), DVDCost,
					director.getText(), len);
			// set empty for input
			title.setText("");
			category.setText("");
			cost.setText("");
			director.setText("");
			length.setText("");
			AimsMain.store.addMedia(dvd);
		} catch (Exception e) {

		}

	}

}
