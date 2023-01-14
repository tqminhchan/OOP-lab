package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.Aims.AimsMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class OptionBase {
	Stage stage;

	OptionBase(Stage stage) {
		this.stage = stage;
	}

	@FXML
	void addBookBtn(ActionEvent event) {
		AimsMain.stages.setScene(AimsMain.bookScene);
	}

	@FXML
	void addDVDBtn(ActionEvent event) {
		stage.setScene(AimsMain.dvdScene);
	}

	@FXML
	void addCDBtn(ActionEvent event) {
		stage.setScene(AimsMain.cdScene);
	}

	@FXML
	void viewStoreBtn(ActionEvent event) {
		stage.setScene(AimsMain.storeScreen);
	}

	@FXML
	void viewCartBtn(ActionEvent event) {
		stage.setScene(AimsMain.cartScreen);
	}

}
