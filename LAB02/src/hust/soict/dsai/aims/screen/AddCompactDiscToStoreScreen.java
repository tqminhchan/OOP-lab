package hust.soict.dsai.aims.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddCompactDiscToStoreScreen {
	public Scene getCDScreen(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("CD.fxml"));
		CDController controller = new CDController(stage);
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}
}
