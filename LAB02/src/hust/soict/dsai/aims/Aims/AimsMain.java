package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.screen.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.AddCompactDiscToStoreScreen;
import hust.soict.dsai.aims.screen.AddDigitalVideoDiscToStoreScreen;
import hust.soict.dsai.aims.screen.CartScreen;
import hust.soict.dsai.aims.screen.StoreScreenV2;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AimsMain extends Application {
	public static Store store;
	public static Cart cart;
	public static Scene bookScene, dvdScene, cdScene, storeScreen, cartScreen;
	public static Stage stages = new Stage();

	@Override
	public void start(Stage stage) throws Exception {
		bookScene = new AddBookToStoreScreen().getBookScreen(stage);
		dvdScene = new AddDigitalVideoDiscToStoreScreen().getDVDScreen(stage);
		cdScene = new AddCompactDiscToStoreScreen().getCDScreen(stage);
		storeScreen = new StoreScreenV2().getStoreScreen(stage);
		cartScreen = new CartScreen().getCartScreen(stage);
		stage.setScene(storeScreen);
		stages = stage;
		stage.show();
	}

	public static void main(String args[]) {
		store = new Store();
		cart = new Cart();
		launch();
	}

}
