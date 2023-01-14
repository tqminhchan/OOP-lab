package hust.soict.dsai.aims.screen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreScreenV2 {
	public Scene getStoreScreen(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Store.fxml"));
		StoreController controller = new StoreController(stage);
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}

}
