package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims.AimsMain;
import hust.soict.dsai.aims.media.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookController extends OptionBase {
	Stage stage;

	BookController(Stage stage) {
		super(stage);
	}

	@FXML
	private TextField category;

	@FXML
	private TextField cost;

	@FXML
	private TextField title;

	@FXML
	void addBookToStoreBtn(ActionEvent event) {
		float DVDCost;
		// if cost or length is not number will not add
		try {
			DVDCost = Float.parseFloat(cost.getText());
			Book book = new Book(title.getText(), category.getText(), DVDCost);
			title.setText("");
			category.setText("");
			cost.setText("");
			AimsMain.store.addMedia(book);
		} catch (Exception e) {

		}
	}
}
