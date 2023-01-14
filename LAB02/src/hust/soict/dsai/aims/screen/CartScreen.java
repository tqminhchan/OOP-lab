package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart.Cart;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen extends JFrame {
	private Cart cart;

	public Scene getCartScreen(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
		CartScreenController controller = new CartScreenController(stage);
		loader.setController(controller);
		Parent root = loader.load();
		return new Scene(root);
	}

}
