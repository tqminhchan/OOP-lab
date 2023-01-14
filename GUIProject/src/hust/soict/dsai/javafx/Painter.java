package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Painter extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Painter.fxml"));
		fxmlLoader.setRoot(new BorderPane());
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		stage.setTitle("NCTA - Painter");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
